// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (JDK 17 standard library only).

package whitebooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Settings read from the environment. baseUrl defaults to the sandbox; use PRODUCTION_URL only for live traffic. */
public record Config(String baseUrl, String gstClientId, String gstClientSecret, String einvClientId, String einvClientSecret, String ewbClientId, String ewbClientSecret, String email, String gstGstin, String einvGstin, String ewbGstin, String ipAddress, String gstUsername, String einvNicUsername, String einvNicPassword, String ewbNicUsername, String ewbNicPassword, long timeoutMs) {
    public static final String SANDBOX_URL = "https://apisandbox.whitebooks.in";
    public static final String PRODUCTION_URL = "https://api.whitebooks.in";

    /** A required environment variable is missing for the area being used. */
    public static final class ConfigException extends IllegalStateException {
        private static final long serialVersionUID = 1L;

        ConfigException(String message) {
            super(message);
        }
    }

    /** Read the configuration from the process environment; every secret comes from the environment, never from source. Nothing is checked here: see requireArea. */
    public static Config fromEnv() {
        return fromEnv(System.getenv());
    }

    public static Config fromEnv(Map<String, String> env) {
        String baseUrl = env.getOrDefault("WB_BASE_URL", "").trim();
        if (baseUrl.isEmpty()) {
            baseUrl = SANDBOX_URL;
        }
        String gstClientId = env.getOrDefault("WB_GST_CLIENT_ID", "");
        String gstClientSecret = env.getOrDefault("WB_GST_CLIENT_SECRET", "");
        String einvClientId = env.getOrDefault("WB_EINV_CLIENT_ID", "");
        String einvClientSecret = env.getOrDefault("WB_EINV_CLIENT_SECRET", "");
        String ewbClientId = env.getOrDefault("WB_EWB_CLIENT_ID", "");
        String ewbClientSecret = env.getOrDefault("WB_EWB_CLIENT_SECRET", "");
        String email = env.getOrDefault("WB_EMAIL", "");
        String gstGstin = env.getOrDefault("WB_GST_GSTIN", "");
        String einvGstin = env.getOrDefault("WB_EINV_GSTIN", "");
        String ewbGstin = env.getOrDefault("WB_EWB_GSTIN", "");
        String ipAddress = env.getOrDefault("WB_IP_ADDRESS", "");
        String gstUsername = env.getOrDefault("WB_GST_USERNAME", "");
        String einvNicUsername = env.getOrDefault("WB_EINV_NIC_USERNAME", "");
        String einvNicPassword = env.getOrDefault("WB_EINV_NIC_PASSWORD", "");
        String ewbNicUsername = env.getOrDefault("WB_EWB_NIC_USERNAME", "");
        String ewbNicPassword = env.getOrDefault("WB_EWB_NIC_PASSWORD", "");
        return new Config(baseUrl, gstClientId, gstClientSecret, einvClientId, einvClientSecret, ewbClientId, ewbClientSecret, email, gstGstin, einvGstin, ewbGstin, ipAddress, gstUsername, einvNicUsername, einvNicPassword, ewbNicUsername, ewbNicPassword, 30_000L);
    }

    /** Throw a ConfigException naming the environment variables this area still needs. It runs before any network call. */
    public static void requireArea(Config config, String area) {
        List<String> missing = new ArrayList<>();
        switch (area) {
            case "public" -> {
                need(config.gstClientId(), "WB_GST_CLIENT_ID", missing);
                need(config.gstClientSecret(), "WB_GST_CLIENT_SECRET", missing);
                need(config.email(), "WB_EMAIL", missing);
            }
            case "gst" -> {
                need(config.gstClientId(), "WB_GST_CLIENT_ID", missing);
                need(config.gstClientSecret(), "WB_GST_CLIENT_SECRET", missing);
                need(config.email(), "WB_EMAIL", missing);
                need(config.gstGstin(), "WB_GST_GSTIN", missing);
                need(config.ipAddress(), "WB_IP_ADDRESS", missing);
                need(config.gstUsername(), "WB_GST_USERNAME", missing);
            }
            case "einvoice" -> {
                need(config.einvClientId(), "WB_EINV_CLIENT_ID", missing);
                need(config.einvClientSecret(), "WB_EINV_CLIENT_SECRET", missing);
                need(config.email(), "WB_EMAIL", missing);
                need(config.einvGstin(), "WB_EINV_GSTIN", missing);
                need(config.ipAddress(), "WB_IP_ADDRESS", missing);
                need(config.einvNicUsername(), "WB_EINV_NIC_USERNAME", missing);
                need(config.einvNicPassword(), "WB_EINV_NIC_PASSWORD", missing);
            }
            case "ewaybill" -> {
                need(config.ewbClientId(), "WB_EWB_CLIENT_ID", missing);
                need(config.ewbClientSecret(), "WB_EWB_CLIENT_SECRET", missing);
                need(config.email(), "WB_EMAIL", missing);
                need(config.ewbGstin(), "WB_EWB_GSTIN", missing);
                need(config.ipAddress(), "WB_IP_ADDRESS", missing);
                need(config.ewbNicUsername(), "WB_EWB_NIC_USERNAME", missing);
                need(config.ewbNicPassword(), "WB_EWB_NIC_PASSWORD", missing);
            }
            default -> throw new IllegalArgumentException("unknown area " + area);
        }
        if (!missing.isEmpty()) {
            throw new ConfigException("missing environment variables for " + area + ": " + String.join(", ", missing));
        }
    }

    private static void need(String value, String name, List<String> missing) {
        if (value == null || value.isEmpty()) {
            missing.add(name);
        }
    }

    /** The two-digit state code is the first two characters of the GSTIN. */
    public static String stateCode(String gstin) {
        return gstin.length() < 2 ? gstin : gstin.substring(0, 2);
    }
}
