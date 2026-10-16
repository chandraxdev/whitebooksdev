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

/** gst operations of the "GSTR2X" tag: one static method each. */
public final class GstGstr2x {
    private GstGstr2x() {}

    /** Arguments of GET /gstr2x/tdstcs. Optional ones may be null. */
    public record Gstr2xTdstcsArgs(String gstin, String retperiod, String fromtime, String rectype) {}

    /**
     * Get TDS
     * GET /gstr2x/tdstcs
     */
    public static JsonNode gstr2xTdstcs(Session.Gst session, Gstr2xTdstcsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr2x/tdstcs",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "fromtime", args.fromtime(),
                "rectype", args.rectype()
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

    /** Arguments of POST /gstr2x/retevcfile. Optional ones may be null. */
    public record Gstr2xRetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR2X data
     * POST /gstr2x/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr2xRetevcfile(Session.Gst session, Gstr2xRetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr2xRetevcfile (POST /gstr2x/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr2x/retevcfile",
            params(
                "email", config.email(),
                "pan", args.pan(),
                "evcotp", args.evcotp()
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

    public static JsonNode gstr2xRetevcfile(Session.Gst session, Gstr2xRetevcfileArgs args, JsonNode body) {
        return gstr2xRetevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr2x/retfile. Optional ones may be null. */
    public record Gstr2xRetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR2X data
     * POST /gstr2x/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr2xRetfile(Session.Gst session, Gstr2xRetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr2xRetfile (POST /gstr2x/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr2x/retfile",
            params(
                "email", config.email(),
                "pan", args.pan()
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

    public static JsonNode gstr2xRetfile(Session.Gst session, Gstr2xRetfileArgs args, JsonNode body) {
        return gstr2xRetfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr2x/retsave. Optional ones may be null. */
    public record Gstr2xRetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR2X data
     * PUT /gstr2x/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr2xRetsave(Session.Gst session, Gstr2xRetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr2x/retsave",
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

    public static JsonNode gstr2xRetsave(Session.Gst session, Gstr2xRetsaveArgs args, JsonNode body) {
        return gstr2xRetsave(session, args, body, WriteOptions.none());
    }
}
