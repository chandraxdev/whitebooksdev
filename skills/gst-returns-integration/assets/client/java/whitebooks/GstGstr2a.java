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

/** gst operations of the "GSTR2A" tag: one static method each. */
public final class GstGstr2a {
    private GstGstr2a() {}

    /** Arguments of GET /gstr2a/amdhist. Optional ones may be null. */
    public record Gstr2aAmdhistArgs(String gstin, String portcode, String benumber, String bedate, String retperiod) {}

    /**
     * Get AMDHIST
     * GET /gstr2a/amdhist
     */
    public static JsonNode gstr2aAmdhist(Session.Gst session, Gstr2aAmdhistArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/amdhist",
            params(
                "gstin", args.gstin(),
                "portcode", args.portcode(),
                "benumber", args.benumber(),
                "bedate", args.bedate(),
                "email", config.email(),
                "retperiod", args.retperiod()
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

    /** Arguments of GET /gstr2a/b2b. Optional ones may be null. */
    public record Gstr2aB2bArgs(String gstin, String retperiod, String ctin, String fromtime) {}

    /**
     * Get B2B Invoices
     * GET /gstr2a/b2b
     */
    public static JsonNode gstr2aB2b(Session.Gst session, Gstr2aB2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/b2b",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr2a/b2ba. Optional ones may be null. */
    public record Gstr2aB2baArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get B2BA Invoices
     * GET /gstr2a/b2ba
     */
    public static JsonNode gstr2aB2ba(Session.Gst session, Gstr2aB2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/b2ba",
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

    /** Arguments of GET /gstr2a/cdn. Optional ones may be null. */
    public record Gstr2aCdnArgs(String gstin, String retperiod, String ctin, String fromtime) {}

    /**
     * CDN Invoice
     * GET /gstr2a/cdn
     */
    public static JsonNode gstr2aCdn(Session.Gst session, Gstr2aCdnArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/cdn",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr2a/cdna. Optional ones may be null. */
    public record Gstr2aCdnaArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get CDNA Invoices
     * GET /gstr2a/cdna
     */
    public static JsonNode gstr2aCdna(Session.Gst session, Gstr2aCdnaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/cdna",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "ctin", args.ctin(),
                "email", config.email()
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

    /** Arguments of GET /gstr2a/ecom. Optional ones may be null. */
    public record Gstr2aEcomArgs(String gstin, String retperiod, String ctin, String fromtime) {}

    /**
     * Get ECOM Invoices
     * GET /gstr2a/ecom
     */
    public static JsonNode gstr2aEcom(Session.Gst session, Gstr2aEcomArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/ecom",
            params(
                "email", config.email(),
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

    /** Arguments of GET /gstr2a/ecoma. Optional ones may be null. */
    public record Gstr2aEcomaArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get ECOMA Invoices
     * GET /gstr2a/ecoma
     */
    public static JsonNode gstr2aEcoma(Session.Gst session, Gstr2aEcomaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/ecoma",
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

    /** Arguments of GET /gstr2a/impg. Optional ones may be null. */
    public record Gstr2aImpgArgs(String gstin, String retperiod, String fromtime) {}

    /**
     * Get IMPG
     * GET /gstr2a/impg
     */
    public static JsonNode gstr2aImpg(Session.Gst session, Gstr2aImpgArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/impg",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "fromtime", args.fromtime(),
                "email", config.email()
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

    /** Arguments of GET /gstr2a/impgsez. Optional ones may be null. */
    public record Gstr2aImpgsezArgs(String gstin, String retperiod, String fromtime) {}

    /**
     * Get IMPGSEZ
     * GET /gstr2a/impgsez
     */
    public static JsonNode gstr2aImpgsez(Session.Gst session, Gstr2aImpgsezArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/impgsez",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "fromtime", args.fromtime(),
                "email", config.email()
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

    /** Arguments of GET /gstr2a/isd. Optional ones may be null. */
    public record Gstr2aIsdArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get ISD Details
     * GET /gstr2a/isd
     */
    public static JsonNode gstr2aIsd(Session.Gst session, Gstr2aIsdArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/isd",
            params(
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

    /** Arguments of GET /gstr2a/tcs. Optional ones may be null. */
    public record Gstr2aTcsArgs(String gstin, String retperiod) {}

    /**
     * Get TCS
     * GET /gstr2a/tcs
     */
    public static JsonNode gstr2aTcs(Session.Gst session, Gstr2aTcsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/tcs",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email()
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

    /** Arguments of GET /gstr2a/tds. Optional ones may be null. */
    public record Gstr2aTdsArgs(String gstin, String retperiod) {}

    /**
     * Get TDS Credit
     * GET /gstr2a/tds
     */
    public static JsonNode gstr2aTds(Session.Gst session, Gstr2aTdsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2a/tds",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email()
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
