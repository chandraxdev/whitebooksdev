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

/** gst operations of the "GSTR8" tag: one static method each. */
public final class GstGstr8 {
    private GstGstr8() {}

    /** Arguments of GET /gstr8/checksum. Optional ones may be null. */
    public record Gstr8ChecksumArgs(String gstin, String retperiod, String fromtime, String rettype) {}

    /**
     * Get Checksum
     * GET /gstr8/checksum
     */
    public static JsonNode gstr8Checksum(Session.Gst session, Gstr8ChecksumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr8/checksum",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "fromtime", args.fromtime(),
                "rettype", args.rettype()
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

    /** Arguments of GET /gstr8/eid. Optional ones may be null. */
    public record Gstr8EidArgs(String gstin, String retperiod, String fromtime, String rettype) {}

    /**
     * Get EID
     * GET /gstr8/eid
     */
    public static JsonNode gstr8Eid(Session.Gst session, Gstr8EidArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr8/eid",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "fromtime", args.fromtime(),
                "rettype", args.rettype()
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

    /** Arguments of GET /gstr8/retsum. Optional ones may be null. */
    public record Gstr8RetsumArgs(String gstin, String retperiod, String fnl) {}

    /**
     * Get GSTR8 Summary
     * GET /gstr8/retsum
     */
    public static JsonNode gstr8Retsum(Session.Gst session, Gstr8RetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr8/retsum",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "fnl", args.fnl()
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

    /** Arguments of GET /gstr8/tcs. Optional ones may be null. */
    public record Gstr8TcsArgs(String gstin, String retperiod, String fromtime, String rettype) {}

    /**
     * Get TCS Invoices
     * GET /gstr8/tcs
     */
    public static JsonNode gstr8Tcs(Session.Gst session, Gstr8TcsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr8/tcs",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "fromtime", args.fromtime(),
                "rettype", args.rettype()
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

    /** Arguments of POST /gstr8/retevcfile. Optional ones may be null. */
    public record Gstr8RetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR8 data
     * POST /gstr8/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr8Retevcfile(Session.Gst session, Gstr8RetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr8Retevcfile (POST /gstr8/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr8/retevcfile",
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

    public static JsonNode gstr8Retevcfile(Session.Gst session, Gstr8RetevcfileArgs args, JsonNode body) {
        return gstr8Retevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr8/retfile. Optional ones may be null. */
    public record Gstr8RetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR8 data
     * POST /gstr8/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr8Retfile(Session.Gst session, Gstr8RetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr8Retfile (POST /gstr8/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr8/retfile",
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

    public static JsonNode gstr8Retfile(Session.Gst session, Gstr8RetfileArgs args, JsonNode body) {
        return gstr8Retfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr8/retsave. Optional ones may be null. */
    public record Gstr8RetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR8 data
     * PUT /gstr8/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr8Retsave(Session.Gst session, Gstr8RetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr8/retsave",
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

    public static JsonNode gstr8Retsave(Session.Gst session, Gstr8RetsaveArgs args, JsonNode body) {
        return gstr8Retsave(session, args, body, WriteOptions.none());
    }
}
