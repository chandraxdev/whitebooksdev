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
import static whitebooks.Reconcile.requireIrreversibleConfirmed;
import static whitebooks.GstGstr.gstrRetstatus;

/** gst operations of the "Payment" tag: one static method each. */
public final class GstPayment {
    private GstPayment() {}

    /** Arguments of GET /payment/chllnlst. Optional ones may be null. */
    public record PaymentChllnlstArgs(String gstin, String fromdate, String todate) {}

    /**
     * Get Challan History
     * GET /payment/chllnlst
     */
    public static JsonNode paymentChllnlst(Session.Gst session, PaymentChllnlstArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/payment/chllnlst",
            params(
                "gstin", args.gstin(),
                "fromdate", args.fromdate(),
                "todate", args.todate(),
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

    /** Arguments of GET /payment/chllnsum. Optional ones may be null. */
    public record PaymentChllnsumArgs(String gstin, String cpin) {}

    /**
     * Get Challan Summary
     * GET /payment/chllnsum
     */
    public static JsonNode paymentChllnsum(Session.Gst session, PaymentChllnsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/payment/chllnsum",
            params(
                "gstin", args.gstin(),
                "cpin", args.cpin(),
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

    /** Arguments of POST /payment/generateChallan. Optional ones may be null. */
    public record PaymentGeneratechallanArgs(String retPeriod) {}

    /**
     * Generate Challan
     * POST /payment/generateChallan
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode paymentGeneratechallan(Session.Gst session, PaymentGeneratechallanArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("paymentGeneratechallan (POST /payment/generateChallan)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/payment/generateChallan",
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

    public static JsonNode paymentGeneratechallan(Session.Gst session, PaymentGeneratechallanArgs args, JsonNode body) {
        return paymentGeneratechallan(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /payment/validatechlnrsn. Optional ones may be null. */
    public record PaymentValidatechlnrsnArgs(String retPeriod) {}

    /**
     * Validate Challan Reason
     * POST /payment/validatechlnrsn
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     */
    public static JsonNode paymentValidatechlnrsn(Session.Gst session, PaymentValidatechlnrsnArgs args, JsonNode body) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/payment/validatechlnrsn",
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
        return Session.withRetries(() -> session.call(build));
    }
}
