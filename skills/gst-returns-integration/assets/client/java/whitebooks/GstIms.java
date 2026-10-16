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
import whitebooks.Reconcile.WriteOptions;
import whitebooks.Reconcile.Policy;
import whitebooks.GstGstr.GstrRetstatusArgs;
import static whitebooks.Session.params;
import static whitebooks.Reconcile.reconcileWrite;
import static whitebooks.GstGstr.gstrRetstatus;

/** gst operations of the "IMS" tag: one static method each. */
public final class GstIms {
    private GstIms() {}

    /** Arguments of GET /ims/getfile. Optional ones may be null. */
    public record ImsGetfileArgs(String gstin, String token) {}

    /**
     * Get IMS data
     * GET /ims/getfile
     */
    public static JsonNode imsGetfile(Session.Gst session, ImsGetfileArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/getfile",
            params(
                "gstin", args.gstin(),
                "token", args.token(),
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

    /** Arguments of GET /ims/invoices. Optional ones may be null. */
    public record ImsInvoicesArgs(String gstin, String section, String status) {}

    /**
     * Get IMS data
     * GET /ims/invoices
     */
    public static JsonNode imsInvoices(Session.Gst session, ImsInvoicesArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/invoices",
            params(
                "gstin", args.gstin(),
                "section", args.section(),
                "email", config.email(),
                "status", args.status()
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

    /** Arguments of GET /ims/invoicescount. Optional ones may be null. */
    public record ImsInvoicescountArgs(String gstin, String goodsType) {}

    /**
     * Get IMS Count data
     * GET /ims/invoicescount
     */
    public static JsonNode imsInvoicescount(Session.Gst session, ImsInvoicescountArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/invoicescount",
            params(
                "gstin", args.gstin(),
                "goodsType", args.goodsType(),
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

    /** Arguments of GET /ims/rejectedInvoices. Optional ones may be null. */
    public record ImsRejectedinvoicesArgs(String gstin, String retperiod, String section) {}

    /**
     * Get Added Back Liability Records
     * GET /ims/rejectedInvoices
     */
    public static JsonNode imsRejectedinvoices(Session.Gst session, ImsRejectedinvoicesArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/rejectedInvoices",
            params(
                "gstin", args.gstin(),
                "email", config.email(),
                "retperiod", args.retperiod(),
                "section", args.section()
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

    /** Arguments of GET /ims/status. Optional ones may be null. */
    public record ImsStatusArgs(String gstin, String intTranId) {}

    /**
     * Get IMS Status
     * GET /ims/status
     */
    public static JsonNode imsStatus(Session.Gst session, ImsStatusArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/status",
            params(
                "gstin", args.gstin(),
                "int_tran_id", args.intTranId(),
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

    /** Arguments of GET /ims/supplierInvoices. Optional ones may be null. */
    public record ImsSupplierinvoicesArgs(String gstin, String retperiod, String section, String rtnTyp) {}

    /**
     * Get Supplier IMS Invoices data
     * GET /ims/supplierInvoices
     */
    public static JsonNode imsSupplierinvoices(Session.Gst session, ImsSupplierinvoicesArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ims/supplierInvoices",
            params(
                "gstin", args.gstin(),
                "email", config.email(),
                "retperiod", args.retperiod(),
                "section", args.section(),
                "rtnTyp", args.rtnTyp()
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

    /** Arguments of PUT /ims/reset. Optional ones may be null. */
    public record ImsResetArgs(String retPeriod) {}

    /**
     * Reset IMS Data
     * PUT /ims/reset
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode imsReset(Session.Gst session, ImsResetArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/ims/reset",
            params(
                "email", config.email()
            ),
            params(
                "gstin", config.gstGstin(),
                "ret_period", args.retPeriod(),
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            body
        );
        Supplier<JsonNode> check = opts.reconcile() == null ? null : () -> gstrRetstatus(session, opts.reconcile());
        return reconcileWrite(() -> session.call(build), check, opts, new Policy(null, null));
    }

    public static JsonNode imsReset(Session.Gst session, ImsResetArgs args, JsonNode body) {
        return imsReset(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /ims/save. Optional ones may be null. */
    public record ImsSaveArgs(String retPeriod) {}

    /**
     * Save IMS Data
     * PUT /ims/save
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode imsSave(Session.Gst session, ImsSaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/ims/save",
            params(
                "email", config.email()
            ),
            params(
                "gstin", config.gstGstin(),
                "ret_period", args.retPeriod(),
                "gst_username", config.gstUsername(),
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", session.ipAddress(),
                "txn", session.txn(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            body
        );
        Supplier<JsonNode> check = opts.reconcile() == null ? null : () -> gstrRetstatus(session, opts.reconcile());
        return reconcileWrite(() -> session.call(build), check, opts, new Policy(null, null));
    }

    public static JsonNode imsSave(Session.Gst session, ImsSaveArgs args, JsonNode body) {
        return imsSave(session, args, body, WriteOptions.none());
    }
}
