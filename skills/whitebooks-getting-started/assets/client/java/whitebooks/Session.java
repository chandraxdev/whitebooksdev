// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: JDK 17 java.net.http; com.fasterxml.jackson.core:jackson-databind:2.22.3 (com.fasterxml.jackson.databind).

package whitebooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/** The HTTP transport and the session flows the selected operations need. */
public final class Session {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final HttpClient HTTP = HttpClient.newHttpClient();
    private static final System.Logger LOG = System.getLogger("whitebooks");

    private Session() {}

    /** One HTTP request: method, path, query parameters, headers and an optional JSON body. */
    public record Call(String method, String path, Map<String, String> query, Map<String, String> headers, JsonNode body) {}

    /** Key, value, key, value ...; pairs whose value is null are left out. */
    public static Map<String, String> params(String... keyValues) {
        Map<String, String> out = new LinkedHashMap<>();
        for (int i = 0; i + 1 < keyValues.length; i += 2) {
            if (keyValues[i + 1] != null) {
                out.put(keyValues[i], keyValues[i + 1]);
            }
        }
        return out;
    }

    /** Sleep without swallowing an interrupt. */
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
            throw new WhiteBooksException("client", "INTERRUPTED", "interrupted while waiting", null, true);
        }
    }

    /** GSTIN shown as its two-digit state code, asterisks and the last character, so logs carry no full GSTIN. */
    public static String maskGstin(String gstin) {
        if (gstin.length() < 4) {
            return "***";
        }
        return gstin.substring(0, 2) + "*".repeat(gstin.length() - 3) + gstin.substring(gstin.length() - 1);
    }

    private static void log(Call call, String event, String correlationId, String detail) {
        String gstin = call.headers().get("gstin");
        String masked = gstin == null || gstin.isEmpty() ? "" : ",\"gstin\":\"" + maskGstin(gstin) + "\"";
        LOG.log(System.Logger.Level.INFO, "{\"event\":\"" + event + "\",\"correlationId\":\"" + correlationId + "\"," + detail + masked + "}");
    }

    /** One HTTP exchange with a deadline. Errors are typed; a timeout or network failure is unknown, never success. */
    public static JsonNode send(Config config, Call call) {
        StringBuilder target = new StringBuilder(config.baseUrl().replaceAll("/+$", "")).append(call.path());
        char separator = '?';
        for (Map.Entry<String, String> entry : call.query().entrySet()) {
            target.append(separator)
                .append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                .append('=')
                .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            separator = '&';
        }
        HttpRequest.Builder request = HttpRequest.newBuilder(URI.create(target.toString()))
            .timeout(Duration.ofMillis(config.timeoutMs()))
            .header("accept", "application/json");
        call.headers().forEach(request::header);
        HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.noBody();
        if (call.body() != null) {
            request.header("content-type", "application/json");
            publisher = HttpRequest.BodyPublishers.ofString(call.body().toString());
        }
        request.method(call.method(), publisher);
        String correlationId = UUID.randomUUID().toString();
        log(call, "request", correlationId, "\"method\":\"" + call.method() + "\",\"path\":\"" + call.path() + "\"");
        HttpResponse<String> response;
        try {
            response = HTTP.send(request.build(), HttpResponse.BodyHandlers.ofString());
        } catch (HttpTimeoutException err) {
            throw new WhiteBooksException(
                "client", "TIMEOUT", "request timed out after " + config.timeoutMs() + " ms", null, true);
        } catch (IOException err) {
            throw new WhiteBooksException("client", "NETWORK", "network failure", null, true);
        } catch (InterruptedException err) {
            Thread.currentThread().interrupt();
            throw new WhiteBooksException("client", "NETWORK", "interrupted", null, true);
        }
        log(call, "response", correlationId, "\"path\":\"" + call.path() + "\",\"status\":" + response.statusCode());
        WhiteBooksException failure = WhiteBooksException.parseFailure(response.statusCode(), response.body());
        if (failure != null) {
            failure.correlationId(correlationId);
            throw failure;
        }
        String text = response.body();
        if (text == null || text.isEmpty()) {
            return null;
        }
        try {
            return MAPPER.readTree(text);
        } catch (JsonProcessingException err) {
            throw new WhiteBooksException("client", "BAD_RESPONSE", "response is not JSON", response.statusCode(), true);
        }
    }

    /** Errors worth another try for a read: unknown outcomes and throttling. */
    public static boolean isRetryable(RuntimeException err) {
        if (!(err instanceof WhiteBooksException)) {
            return false;
        }
        WhiteBooksException failure = (WhiteBooksException) err;
        return failure.unknown || Integer.valueOf(429).equals(failure.httpStatus);
    }

    /** Capped jittered backoff: ceiling 0.5 s, 1 s, 2 s, then 4 s, with half of it random. */
    public static long backoffMs(int attempt) {
        long ceiling = Math.min(4000L, 500L << (attempt - 1));
        return ceiling / 2 + ThreadLocalRandom.current().nextLong(ceiling / 2 + 1);
    }

    /** Retry a GET (idempotent) up to 3 attempts. Never use this for a write: writes go through reconcileWrite. */
    public static <T> T withRetries(Supplier<T> run) {
        int maxAttempts = 3;
        for (int attempt = 1; ; attempt++) {
            try {
                return run.get();
            } catch (RuntimeException err) {
                if (attempt >= maxAttempts || !isRetryable(err)) {
                    throw err;
                }
                sleep(backoffMs(attempt));
            }
        }
    }

    /** Refresh or re-authenticate when the session is within 5 minutes of expiry. */
    public static final long REFRESH_MARGIN_S = 5L * 60;
    /** The spec does not document the token lifetime; sessions assume 6 hours (1 hour for the e-Invoice sandbox) unless the constructor says otherwise. */
    public static final long DEFAULT_LIFETIME_S = 6L * 60 * 60;
    /** WhiteBooks' published e-Invoice API flow: a token lasts 1 hour in the sandbox, 6 hours in production. */
    public static final long SANDBOX_LIFETIME_S = 60L * 60;

    private static String trimUrl(String url) {
        return url.trim().replaceAll("/+$", "").toLowerCase(java.util.Locale.ROOT);
    }

    static long einvoiceLifetimeS(Config config) {
        return trimUrl(config.baseUrl()).equals(trimUrl(Config.SANDBOX_URL)) ? SANDBOX_LIFETIME_S : DEFAULT_LIFETIME_S;
    }
    private static final long NANOS = 1_000_000_000L;

    /**
     * GST session: requestOtp() sends an OTP to the taxpayer, authenticate(otp) exchanges the OTP the end user types
     * into your own UI for a session, refresh() renews it, logout() ends it. Never hard-code or store an OTP.
     */
    public static final class Gst {
        private final Config config;
        private final String ipAddress;
        private final long lifetimeS;
        private String txn = "";
        private boolean signedIn;
        private long expiresAtNanos;

        public Gst(Config config) {
            this(config, DEFAULT_LIFETIME_S);
        }

        public Gst(Config config, long lifetimeS) {
            Config.requireArea(config, "gst");
            this.config = config;
            // Bound once for the life of this session.
            this.ipAddress = config.ipAddress();
            this.lifetimeS = lifetimeS;
        }

        public Config config() {
            return config;
        }

        public String ipAddress() {
            return ipAddress;
        }

        public synchronized String txn() {
            return txn;
        }

        private void take(JsonNode result) {
            String found = WhiteBooksException.textOf(WhiteBooksException.findKey(result, "txn", 4));
            if (!found.isEmpty()) {
                txn = found;
            }
        }

        /** Ask GSTN to send an OTP to the taxpayer. Keeps the transaction id the next calls need. */
        public synchronized void requestOtp() {
        JsonNode result = send(config, new Call(
            "GET", "/authentication/otprequest",
            params(
                "email", config.email()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", config.ipAddress(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        ));
            take(result);
            if (txn.isEmpty()) {
                throw new WhiteBooksException("client", "MISSING_TXN", "the OTP response carried no txn");
            }
        }

        /** Exchange the OTP the end user entered for a session. */
        public synchronized void authenticate(String otp) {
        JsonNode result = send(config, new Call(
            "GET", "/authentication/authtoken",
            params(
                "email", config.email(),
                "otp", otp
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", config.ipAddress(),
                "txn", this.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        ));
            take(result);
            signedIn = true;
            expiresAtNanos = System.nanoTime() + lifetimeS * NANOS;
        }

        /** Renew the session before it expires. */
        public synchronized void refresh() {
        JsonNode result = send(config, new Call(
            "GET", "/authentication/refreshtoken",
            params(
                "email", config.email()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", config.ipAddress(),
                "txn", this.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        ));
            take(result);
            expiresAtNanos = System.nanoTime() + lifetimeS * NANOS;
        }

        public synchronized void logout() {
        send(config, new Call(
            "GET", "/authentication/logout",
            params(
                "email", config.email()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", config.ipAddress(),
                "txn", this.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        ));
            signedIn = false;
            txn = "";
        }

        /** Run one call on this session, refreshing it first when it is within 5 minutes of expiry. */
        public JsonNode call(Supplier<Call> build) {
            synchronized (this) {
                if (!signedIn) {
                    throw new WhiteBooksException("client", "NOT_AUTHENTICATED", "call requestOtp() and authenticate(otp) first");
                }
                if (expiresAtNanos - System.nanoTime() <= REFRESH_MARGIN_S * NANOS) {
                    refresh();
                }
            }
            return send(config, build.get());
        }
    }

    /**
     * e-Invoice session: authenticate() signs in with the NIC user name and password from the environment.
     * The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
     */
    public static final class Einvoice {
        private final Config config;
        private final String ipAddress;
        private final long lifetimeS;
        private String authToken = "";
        private boolean signedIn;
        private long expiresAtNanos;

        public Einvoice(Config config) {
            this(config, einvoiceLifetimeS(config));
        }

        public Einvoice(Config config, long lifetimeS) {
            Config.requireArea(config, "einvoice");
            this.config = config;
            // Bound once for the life of this session.
            this.ipAddress = config.ipAddress();
            this.lifetimeS = lifetimeS;
        }

        public Config config() {
            return config;
        }

        public String ipAddress() {
            return ipAddress;
        }

        public synchronized String authToken() {
            return authToken;
        }

        /** Sign in. Concurrent callers take turns, so only one sign-in runs at a time. */
        public synchronized void authenticate() {
            signIn();
        }

        private void signIn() {
            JsonNode result = send(config, new Call(
                "GET", "/einvoice/authenticate",
                params(
                    "email", config.email()
                ),
                params(
                    "username", config.einvNicUsername(),
                    "password", config.einvNicPassword(),
                    "ip_address", config.ipAddress(),
                    "client_id", config.einvClientId(),
                    "client_secret", config.einvClientSecret(),
                    "gstin", config.einvGstin()
                ),
                null
            ));
            String token = WhiteBooksException.textOf(WhiteBooksException.findKey(result, "AuthToken", 4));
            if (token.isEmpty()) {
                throw new WhiteBooksException("client", "MISSING_TOKEN", "the sign-in response carried no AuthToken");
            }
            authToken = token;
            signedIn = true;
            expiresAtNanos = System.nanoTime() + lifetimeS * NANOS;
        }

        private synchronized void ensure() {
            if (!signedIn || expiresAtNanos - System.nanoTime() <= REFRESH_MARGIN_S * NANOS) {
                signIn();
            }
        }

        /** Run one call on this session; sign in first when needed and once more if the API says the session expired. */
        public JsonNode call(Supplier<Call> build) {
            ensure();
            try {
                return send(config, build.get());
            } catch (WhiteBooksException err) {
                if (!WhiteBooksException.isSessionExpired(err)) {
                    throw err;
                }
                authenticate();
                return send(config, build.get());
            }
        }
    }

    /**
     * e-Way Bill session: authenticate() signs in with the NIC user name and password from the environment.
     * The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
     */
    public static final class Ewaybill {
        private final Config config;
        private final String ipAddress;
        private final long lifetimeS;
        private boolean signedIn;
        private long expiresAtNanos;

        public Ewaybill(Config config) {
            this(config, DEFAULT_LIFETIME_S);
        }

        public Ewaybill(Config config, long lifetimeS) {
            Config.requireArea(config, "ewaybill");
            this.config = config;
            // Bound once for the life of this session.
            this.ipAddress = config.ipAddress();
            this.lifetimeS = lifetimeS;
        }

        public Config config() {
            return config;
        }

        public String ipAddress() {
            return ipAddress;
        }

        /** Sign in. Concurrent callers take turns, so only one sign-in runs at a time. */
        public synchronized void authenticate() {
            signIn();
        }

        private void signIn() {
            send(config, new Call(
                "GET", "/ewaybillapi/v1.03/authenticate",
                params(
                    "email", config.email(),
                    "username", config.ewbNicUsername(),
                    "password", config.ewbNicPassword()
                ),
                params(
                    "ip_address", config.ipAddress(),
                    "client_id", config.ewbClientId(),
                    "client_secret", config.ewbClientSecret(),
                    "gstin", config.ewbGstin()
                ),
                null
            ));
            signedIn = true;
            expiresAtNanos = System.nanoTime() + lifetimeS * NANOS;
        }

        private synchronized void ensure() {
            if (!signedIn || expiresAtNanos - System.nanoTime() <= REFRESH_MARGIN_S * NANOS) {
                signIn();
            }
        }

        /** Run one call on this session; sign in first when needed and once more if the API says the session expired. */
        public JsonNode call(Supplier<Call> build) {
            ensure();
            try {
                return send(config, build.get());
            } catch (WhiteBooksException err) {
                if (!WhiteBooksException.isSessionExpired(err)) {
                    throw err;
                }
                authenticate();
                return send(config, build.get());
            }
        }
    }
}
