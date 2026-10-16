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

/** gst operations of the "GSTR4A" tag: one static method each. */
public final class GstGstr4a {
    private GstGstr4a() {}

    /** Arguments of GET /gstr4a/b2b. Optional ones may be null. */
    public record Gstr4aB2bArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get B2B Invoices
     * GET /gstr4a/b2b
     */
    public static JsonNode gstr4aB2b(Session.Gst session, Gstr4aB2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4a/b2b",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr4a/b2ba. Optional ones may be null. */
    public record Gstr4aB2baArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get B2BA Invoices
     * GET /gstr4a/b2ba
     */
    public static JsonNode gstr4aB2ba(Session.Gst session, Gstr4aB2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4a/b2ba",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr4a/cdnr. Optional ones may be null. */
    public record Gstr4aCdnrArgs(String gstin, String retperiod, String ctin) {}

    /**
     * CDNR Invoice
     * GET /gstr4a/cdnr
     */
    public static JsonNode gstr4aCdnr(Session.Gst session, Gstr4aCdnrArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4a/cdnr",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr4a/cdnra. Optional ones may be null. */
    public record Gstr4aCdnraArgs(String gstin, String retperiod, String ctin) {}

    /**
     * CDNRA Invoice
     * GET /gstr4a/cdnra
     */
    public static JsonNode gstr4aCdnra(Session.Gst session, Gstr4aCdnraArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4a/cdnra",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr4a/tds. Optional ones may be null. */
    public record Gstr4aTdsArgs(String gstin, String retperiod, String ctin) {}

    /**
     * TDS Details
     * GET /gstr4a/tds
     */
    public static JsonNode gstr4aTds(Session.Gst session, Gstr4aTdsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4a/tds",
            params(
                "email", config.email(),
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
}
