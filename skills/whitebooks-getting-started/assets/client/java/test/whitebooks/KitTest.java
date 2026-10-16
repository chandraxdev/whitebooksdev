// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3. Run: javac -cp <jackson jars> -d out whitebooks/*.java test/whitebooks/*.java; java -cp out:<jackson jars> whitebooks.KitTest

package whitebooks;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import whitebooks.Session.Call;

/** Generated core tests: error parsing and session expiry against recorded response bodies. It needs no area. The sandbox checks are in <Area>SmokeTest. */
public final class KitTest {
    private KitTest() {}

    private static final String GATEWAY_MISSING_PARAM = "{\"status_cd\":\"0\",\"status_desc\":\"WB_ERR_9101 : Missing mandatory parameters : otp\"}";
    private static final String GATEWAY_UNEXPECTED = "{\"status_cd\":\"0\",\"status_desc\":\"WB_ERR_9000 : Unexpected error\"}";
    private static final String GSTN_REJECTED = "{\"status_cd\":\"0\",\"status_desc\":\"Failure\",\"error\":{\"message\":\"Invalid OTP\",\"error_cd\":\"AUTH4033\"}}";
    private static final String NIC_REJECTED = "{\"Status\":\"0\",\"ErrorDetails\":[{\"ErrorCode\":\"2150\",\"ErrorMessage\":\"Duplicate IRN\"}]}";
    private static final String NIC_SESSION_EXPIRED = "{\"Status\":\"0\",\"ErrorDetails\":[{\"ErrorCode\":\"1005\",\"ErrorMessage\":\"Invalid Token\"}]}";
    private static final String SUCCESS = "{\"status_cd\":\"1\",\"status_desc\":\"Success\",\"data\":{}}";
    private static final String BAD_GATEWAY_HTML = "<html><body>502 Bad Gateway</body></html>";

    private static void check(String name, boolean ok) {
        KitSupport.check(name, ok);
    }

    private static void errors() {
        WhiteBooksException gateway = WhiteBooksException.parseFailure(200, GATEWAY_MISSING_PARAM);
        check("a WhiteBooks gateway error becomes source whitebooks with its WB_ERR code", gateway != null && gateway.source.equals("whitebooks") && gateway.code.equals("WB_ERR_9101") && !gateway.unknown);
        WhiteBooksException unexpected = WhiteBooksException.parseFailure(200, GATEWAY_UNEXPECTED);
        check("WB_ERR_9000 is an unknown outcome, never a plain failure", unexpected != null && unexpected.unknown);
        WhiteBooksException gstn = WhiteBooksException.parseFailure(200, GSTN_REJECTED);
        check("a GSTN rejection keeps error_cd as the code", gstn != null && gstn.source.equals("gstn") && gstn.code.equals("AUTH4033") && gstn.getMessage().equals("Invalid OTP"));
        WhiteBooksException nic = WhiteBooksException.parseFailure(200, NIC_REJECTED);
        check("a NIC rejection keeps ErrorCode and ErrorMessage", nic != null && nic.source.equals("nic") && nic.code.equals("2150") && nic.getMessage().equals("Duplicate IRN"));
        check("a success body is not an error", WhiteBooksException.parseFailure(200, SUCCESS) == null);
        WhiteBooksException html = WhiteBooksException.parseFailure(502, BAD_GATEWAY_HTML);
        check("a non-JSON 5xx is an unknown HTTP failure", html != null && html.source.equals("http") && html.code.equals("HTTP_502") && html.unknown);
        WhiteBooksException expired = WhiteBooksException.parseFailure(200, NIC_SESSION_EXPIRED);
        check("only the NIC token errors count as an expired session", WhiteBooksException.isSessionExpired(expired) && !WhiteBooksException.isSessionExpired(nic) && !WhiteBooksException.isSessionExpired(new IllegalStateException("boom")));
    }

    /** The call is built here, so this test needs no operation file of any area. */
    private static JsonNode read(Session.Einvoice s) {
        return s.call(() -> new Call("GET", "/einvoice/type/GETEWAYBILLIRN/version/V1_03", Map.of(), Map.of(), null));
    }

    /** A local server that counts sign-ins and reads and answers reads from a queue before falling back to success. */
    private static final class Fake implements AutoCloseable {
        final AtomicInteger auth = new AtomicInteger();
        final AtomicInteger reads = new AtomicInteger();
        final HttpServer server;

        Fake(List<String> queue) throws IOException {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            server.createContext("/", exchange -> {
                String path = exchange.getRequestURI().getPath();
                String body;
                if (path.equals("/einvoice/authenticate")) {
                    body = "{\"Status\":1,\"Data\":{\"AuthToken\":\"tok-" + auth.incrementAndGet() + "\"}}";
                } else if (path.equals("/einvoice/type/GETEWAYBILLIRN/version/V1_03")) {
                    int n = reads.getAndIncrement();
                    body = n < queue.size() ? queue.get(n) : "{\"Status\":1,\"Data\":{}}";
                } else {
                    body = "{}";
                }
                byte[] data = body.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().add("content-type", "application/json");
                exchange.sendResponseHeaders(200, data.length);
                exchange.getResponseBody().write(data);
                exchange.close();
            });
            server.start();
        }

        Session.Einvoice session(long lifetimeS) {
            Map<String, String> env = new java.util.HashMap<>(KitSupport.env());
            env.put("WB_BASE_URL", "http://127.0.0.1:" + server.getAddress().getPort());
            return new Session.Einvoice(Config.fromEnv(env), lifetimeS);
        }

        @Override
        public void close() {
            server.stop(0);
        }
    }

    private static void sessions() throws IOException {
        try (Fake fake = new Fake(List.of())) {
            Session.Einvoice s = fake.session(Session.DEFAULT_LIFETIME_S);
            read(s);
            read(s);
            check("the session signs in once and reuses the token while it is fresh", fake.auth.get() == 1 && fake.reads.get() == 2);
        }
        try (Fake fake = new Fake(List.of())) {
            Session.Einvoice s = fake.session(1);
            read(s);
            read(s);
            check("a session within five minutes of expiry signs in again before the call", fake.auth.get() == 2);
        }
        try (Fake fake = new Fake(List.of(NIC_SESSION_EXPIRED))) {
            Session.Einvoice s = fake.session(Session.DEFAULT_LIFETIME_S);
            JsonNode result = read(s);
            check("an expired-token reply signs in again and repeats the call once", fake.auth.get() == 2 && fake.reads.get() == 2 && result.get("Status").asInt() == 1);
        }
    }

    public static void main(String[] argv) throws Exception {
        errors();
        sessions();
        KitSupport.finish();
    }
}
