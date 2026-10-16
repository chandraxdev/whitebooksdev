// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3; uses Config, Session and WhiteBooksException from this package.

package whitebooks;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.function.Supplier;
import whitebooks.Session.Call;
import static whitebooks.Session.params;

/** gst operations of the "GSTR6A" tag: one static method each. */
public final class GstGstr6a {
    private GstGstr6a() {}

    /** Arguments of GET /gstr6a/b2b. Optional ones may be null. */
    public record Gstr6aB2bArgs(String gstin, String retperiod, String actionrequired, String ctin, String fromtime) {}

    /**
     * Get B2B Invoices
     * GET /gstr6a/b2b
     */
    public static JsonNode gstr6aB2b(Session.Gst session, Gstr6aB2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6a/b2b",
            params(
                "email", config.email(),
                "actionrequired", args.actionrequired(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "ctin", args.ctin(),
                "fromtime", args.fromtime()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }

    /** Arguments of GET /gstr6a/b2ba. Optional ones may be null. */
    public record Gstr6aB2baArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get B2BA Invoices
     * GET /gstr6a/b2ba
     */
    public static JsonNode gstr6aB2ba(Session.Gst session, Gstr6aB2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6a/b2ba",
            params(
                "email", config.email(),
                "actionrequired", args.actionrequired(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "ctin", args.ctin()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }

    /** Arguments of GET /gstr6a/cdn. Optional ones may be null. */
    public record Gstr6aCdnArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNR Invoices
     * GET /gstr6a/cdn
     */
    public static JsonNode gstr6aCdn(Session.Gst session, Gstr6aCdnArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6a/cdn",
            params(
                "email", config.email(),
                "actionrequired", args.actionrequired(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "ctin", args.ctin()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }

    /** Arguments of GET /gstr6a/cdna. Optional ones may be null. */
    public record Gstr6aCdnaArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNRA Invoices
     * GET /gstr6a/cdna
     */
    public static JsonNode gstr6aCdna(Session.Gst session, Gstr6aCdnaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6a/cdna",
            params(
                "actionrequired", args.actionrequired(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "ctin", args.ctin()
            ),
            params(
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }
}
