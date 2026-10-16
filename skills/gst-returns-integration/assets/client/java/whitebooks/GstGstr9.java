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

/** gst operations of the "GSTR9" tag: one static method each. */
public final class GstGstr9 {
    private GstGstr9() {}

    /** Arguments of GET /gstr9/get8adetails. Optional ones may be null. */
    public record Gstr9Get8adetailsArgs(String gstin, String fy, String token, String retperiod, String docid) {}

    /**
     * Get GSTR9 8A Details
     * GET /gstr9/get8adetails
     */
    public static JsonNode gstr9Get8adetails(Session.Gst session, Gstr9Get8adetailsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr9/get8adetails",
            params(
                "gstin", args.gstin(),
                "fy", args.fy(),
                "token", args.token(),
                "docid", args.docid(),
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

    /** Arguments of GET /gstr9/getHsndetails. Optional ones may be null. */
    public record Gstr9GethsndetailsArgs(String gstin, String fy, String retperiod) {}

    /**
     * Get R1R1A HSN Details
     * GET /gstr9/getHsndetails
     */
    public static JsonNode gstr9Gethsndetails(Session.Gst session, Gstr9GethsndetailsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr9/getHsndetails",
            params(
                "gstin", args.gstin(),
                "fy", args.fy(),
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

    /** Arguments of GET /gstr9/getautocal. Optional ones may be null. */
    public record Gstr9GetautocalArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR9 Auto Calculated Details
     * GET /gstr9/getautocal
     */
    public static JsonNode gstr9Getautocal(Session.Gst session, Gstr9GetautocalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr9/getautocal",
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

    /** Arguments of GET /gstr9/getdet. Optional ones may be null. */
    public record Gstr9GetdetArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR9 Details
     * GET /gstr9/getdet
     */
    public static JsonNode gstr9Getdet(Session.Gst session, Gstr9GetdetArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr9/getdet",
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

    /** Arguments of POST /gstr9/retevcfile. Optional ones may be null. */
    public record Gstr9RetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR9 data
     * POST /gstr9/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr9Retevcfile(Session.Gst session, Gstr9RetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr9Retevcfile (POST /gstr9/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr9/retevcfile",
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

    public static JsonNode gstr9Retevcfile(Session.Gst session, Gstr9RetevcfileArgs args, JsonNode body) {
        return gstr9Retevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr9/retfile. Optional ones may be null. */
    public record Gstr9RetfileArgs(String retPeriod) {}

    /**
     * File GSTR9
     * POST /gstr9/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr9Retfile(Session.Gst session, Gstr9RetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr9Retfile (POST /gstr9/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr9/retfile",
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

    public static JsonNode gstr9Retfile(Session.Gst session, Gstr9RetfileArgs args, JsonNode body) {
        return gstr9Retfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr9/create8adetails. Optional ones may be null. */
    public record Gstr9Create8adetailsArgs(String retPeriod) {}

    /**
     * Create 8A Data API
     * PUT /gstr9/create8adetails
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr9Create8adetails(Session.Gst session, Gstr9Create8adetailsArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr9/create8adetails",
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

    public static JsonNode gstr9Create8adetails(Session.Gst session, Gstr9Create8adetailsArgs args, JsonNode body) {
        return gstr9Create8adetails(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr9/retsave. Optional ones may be null. */
    public record Gstr9RetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR9
     * PUT /gstr9/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr9Retsave(Session.Gst session, Gstr9RetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr9/retsave",
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

    public static JsonNode gstr9Retsave(Session.Gst session, Gstr9RetsaveArgs args, JsonNode body) {
        return gstr9Retsave(session, args, body, WriteOptions.none());
    }
}
