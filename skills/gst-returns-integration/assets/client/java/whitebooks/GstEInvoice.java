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

/** gst operations of the "e-Invoice" tag: one static method each. */
public final class GstEInvoice {
    private GstEInvoice() {}

    /** Arguments of GET /gst/einvoice/filedtl. Optional ones may be null. */
    public record GstEinvoiceFiledtlArgs(String gstin, String rtnprd, String token) {}

    /**
     * Get file URL
     * GET /gst/einvoice/filedtl
     */
    public static JsonNode gstEinvoiceFiledtl(Session.Gst session, GstEinvoiceFiledtlArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gst/einvoice/filedtl",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "rtnprd", args.rtnprd(),
                "token", args.token()
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

    /** Arguments of GET /gst/einvoice/hsnsum. Optional ones may be null. */
    public record GstEinvoiceHsnsumArgs(String gstin, String retPeriod) {}

    /**
     * Get E-Invice HSN Summary
     * GET /gst/einvoice/hsnsum
     */
    public static JsonNode gstEinvoiceHsnsum(Session.Gst session, GstEinvoiceHsnsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gst/einvoice/hsnsum",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "ret_period", args.retPeriod()
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

    /** Arguments of GET /gst/einvoice/irndtl. Optional ones may be null. */
    public record GstEinvoiceIrndtlArgs(String gstin, String irn) {}

    /**
     * Get Json for IRN
     * GET /gst/einvoice/irndtl
     */
    public static JsonNode gstEinvoiceIrndtl(Session.Gst session, GstEinvoiceIrndtlArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gst/einvoice/irndtl",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "irn", args.irn()
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

    /** Arguments of GET /gst/einvoice/irnjsons. Optional ones may be null. */
    public record GstEinvoiceIrnjsonsArgs(String gstin, String suptyp, String rtnprd, String rstinflag) {}

    /**
     * Get list of IRN Jsons
     * GET /gst/einvoice/irnjsons
     */
    public static JsonNode gstEinvoiceIrnjsons(Session.Gst session, GstEinvoiceIrnjsonsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gst/einvoice/irnjsons",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "rstinflag", args.rstinflag(),
                "suptyp", args.suptyp(),
                "rtnprd", args.rtnprd()
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

    /** Arguments of GET /gst/einvoice/irnlist. Optional ones may be null. */
    public record GstEinvoiceIrnlistArgs(String gstin, String suptyp, String rtnprd, String rstinflag) {}

    /**
     * Get list of IRNs
     * GET /gst/einvoice/irnlist
     */
    public static JsonNode gstEinvoiceIrnlist(Session.Gst session, GstEinvoiceIrnlistArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gst/einvoice/irnlist",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "rstinflag", args.rstinflag(),
                "suptyp", args.suptyp(),
                "rtnprd", args.rtnprd()
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
