// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

package whitebooks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Shared by KitTest and the per-area smoke tests. */
final class KitSupport {
    private KitSupport() {}

    private static int failures = 0;

    static void check(String name, boolean ok) {
        System.out.println((ok ? "ok   " : "FAIL ") + name);
        if (!ok) {
            failures++;
        }
    }

    /** Ends the run: a non-zero exit when any check failed. */
    static void finish() {
        if (failures > 0) {
            System.out.println(failures + " check(s) failed");
            System.exit(1);
        }
    }

    /**
     * Never talk to a live API from a test (fail closed): checks run only when WB_BASE_URL is unset or an https URL on the sandbox
     * host. Returns null when the sandbox may be used, else the parsed host (or "unparsable"), never the raw value.
     */
    static String notSandbox() {
        String raw = System.getenv("WB_BASE_URL");
        if (raw == null || raw.trim().isEmpty()) {
            return null;
        }
        try {
            java.net.URI url = java.net.URI.create(raw.trim());
            java.net.URI sandbox = java.net.URI.create(Config.SANDBOX_URL);
            String host = url.getHost() == null ? "" : url.getHost().toLowerCase(java.util.Locale.ROOT);
            if ("https".equalsIgnoreCase(url.getScheme()) && !host.isEmpty()
                    && host.equals(sandbox.getHost().toLowerCase(java.util.Locale.ROOT)) && url.getPort() == sandbox.getPort()) {
                return null;
            }
            return host.isEmpty() ? "unparsable" : host;
        } catch (IllegalArgumentException e) {
            return "unparsable";
        }
    }

    /** Prints the refusal note when the sandbox gate is closed. */
    static void announceGate() {
        String refused = notSandbox();
        if (refused != null) {
            System.err.println("WB_BASE_URL is not the sandbox https URL (host: " + refused + "); the smoke tests run only against the sandbox, so none was run.");
        }
    }

    static boolean have(String[] names) {
        if (notSandbox() != null) {
            return false;
        }
        for (String n : names) {
            String v = System.getenv(n);
            if (v == null || v.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    static Map<String, String> env() {
        // Config.fromEnv wants every variable; the ones a smoke run does not use get a placeholder.
        Map<String, String> out = new HashMap<>();
        for (String n : List.of("WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EINV_CLIENT_ID", "WB_EINV_CLIENT_SECRET", "WB_EWB_CLIENT_ID", "WB_EWB_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN", "WB_EINV_GSTIN", "WB_EWB_GSTIN", "WB_IP_ADDRESS", "WB_GST_USERNAME", "WB_EINV_NIC_USERNAME", "WB_EINV_NIC_PASSWORD", "WB_EWB_NIC_USERNAME", "WB_EWB_NIC_PASSWORD")) {
            out.put(n, "x");
        }
        for (Map.Entry<String, String> e : System.getenv().entrySet()) {
            if (!e.getValue().isEmpty()) {
                out.put(e.getKey(), e.getValue());
            }
        }
        return out;
    }
}
