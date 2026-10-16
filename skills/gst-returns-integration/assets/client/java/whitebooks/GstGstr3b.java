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

/** gst operations of the "GSTR3B" tag: one static method each. */
public final class GstGstr3b {
    private GstGstr3b() {}

    /** Arguments of GET /gstr3b/autoliab. Optional ones may be null. */
    public record Gstr3bAutoliabArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR1 auto calculated liability details
     * GET /gstr3b/autoliab
     */
    public static JsonNode gstr3bAutoliab(Session.Gst session, Gstr3bAutoliabArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/autoliab",
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

    /** Arguments of GET /gstr3b/closingbal. Optional ones may be null. */
    public record Gstr3bClosingbalArgs(String gstin) {}

    /**
     * Get ITC Reversal Balance
     * GET /gstr3b/closingbal
     */
    public static JsonNode gstr3bClosingbal(Session.Gst session, Gstr3bClosingbalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/closingbal",
            params(
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr3b/openingbal. Optional ones may be null. */
    public record Gstr3bOpeningbalArgs(String gstin) {}

    /**
     * Get Opening Balance For Credit Reversal and Re-claimed Details
     * GET /gstr3b/openingbal
     */
    public static JsonNode gstr3bOpeningbal(Session.Gst session, Gstr3bOpeningbalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/openingbal",
            params(
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr3b/rcmclosingbal. Optional ones may be null. */
    public record Gstr3bRcmclosingbalArgs(String retPeriod, String gstin) {}

    /**
     * Get latest closing balance
     * GET /gstr3b/rcmclosingbal
     */
    public static JsonNode gstr3bRcmclosingbal(Session.Gst session, Gstr3bRcmclosingbalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/rcmclosingbal",
            params(
                "gstin", args.gstin(),
                "email", config.email()
            ),
            params(
                "ret_period", args.retPeriod(),
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

    /** Arguments of GET /gstr3b/rcmopeningbal. Optional ones may be null. */
    public record Gstr3bRcmopeningbalArgs(String retPeriod, String gstin) {}

    /**
     * Get RCM opening balance
     * GET /gstr3b/rcmopeningbal
     */
    public static JsonNode gstr3bRcmopeningbal(Session.Gst session, Gstr3bRcmopeningbalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/rcmopeningbal",
            params(
                "gstin", args.gstin(),
                "email", config.email()
            ),
            params(
                "ret_period", args.retPeriod(),
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

    /** Arguments of GET /gstr3b/retsum. Optional ones may be null. */
    public record Gstr3bRetsumArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR3B Summary
     * GET /gstr3b/retsum
     */
    public static JsonNode gstr3bRetsum(Session.Gst session, Gstr3bRetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/retsum",
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

    /** Arguments of GET /gstr3b/syscalcintrst. Optional ones may be null. */
    public record Gstr3bSyscalcintrstArgs(String gstin, String retperiod) {}

    /**
     * Get system calculated interest
     * GET /gstr3b/syscalcintrst
     */
    public static JsonNode gstr3bSyscalcintrst(Session.Gst session, Gstr3bSyscalcintrstArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr3b/syscalcintrst",
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

    /** Arguments of POST /gstr3b/cmpint. Optional ones may be null. */
    public record Gstr3bCmpintArgs(String retPeriod) {}

    /**
     * Recompute System Calulated Interest
     * POST /gstr3b/cmpint
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr3bCmpint(Session.Gst session, Gstr3bCmpintArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr3b/cmpint",
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

    public static JsonNode gstr3bCmpint(Session.Gst session, Gstr3bCmpintArgs args, JsonNode body) {
        return gstr3bCmpint(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr3b/retevcfile. Optional ones may be null. */
    public record Gstr3bRetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR3B data
     * POST /gstr3b/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr3bRetevcfile(Session.Gst session, Gstr3bRetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr3bRetevcfile (POST /gstr3b/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr3b/retevcfile",
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

    public static JsonNode gstr3bRetevcfile(Session.Gst session, Gstr3bRetevcfileArgs args, JsonNode body) {
        return gstr3bRetevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr3b/retfile. Optional ones may be null. */
    public record Gstr3bRetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR3B data
     * POST /gstr3b/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr3bRetfile(Session.Gst session, Gstr3bRetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr3bRetfile (POST /gstr3b/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr3b/retfile",
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

    public static JsonNode gstr3bRetfile(Session.Gst session, Gstr3bRetfileArgs args, JsonNode body) {
        return gstr3bRetfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr3b/savercmopnbal. Optional ones may be null. */
    public record Gstr3bSavercmopnbalArgs(String retPeriod) {}

    /**
     * Submit RCM opening balance
     * POST /gstr3b/savercmopnbal
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr3bSavercmopnbal(Session.Gst session, Gstr3bSavercmopnbalArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr3b/savercmopnbal",
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

    public static JsonNode gstr3bSavercmopnbal(Session.Gst session, Gstr3bSavercmopnbalArgs args, JsonNode body) {
        return gstr3bSavercmopnbal(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr3b/validateautocalculatedata. Optional ones may be null. */
    public record Gstr3bValidateautocalculatedataArgs(String retPeriod) {}

    /**
     * validate GSTR3B against auto calculated values
     * POST /gstr3b/validateautocalculatedata
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     */
    public static JsonNode gstr3bValidateautocalculatedata(Session.Gst session, Gstr3bValidateautocalculatedataArgs args, JsonNode body) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr3b/validateautocalculatedata",
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

    /** Arguments of PUT /gstr3b/liabilitybreakup. Optional ones may be null. */
    public record Gstr3bLiabilitybreakupArgs(String retPeriod) {}

    /**
     * Save past liability breakup GSTR3B Data
     * PUT /gstr3b/liabilitybreakup
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr3bLiabilitybreakup(Session.Gst session, Gstr3bLiabilitybreakupArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr3b/liabilitybreakup",
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

    public static JsonNode gstr3bLiabilitybreakup(Session.Gst session, Gstr3bLiabilitybreakupArgs args, JsonNode body) {
        return gstr3bLiabilitybreakup(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr3b/retoffset. Optional ones may be null. */
    public record Gstr3bRetoffsetArgs(String retPeriod) {}

    /**
     * Offset Liability GSTR3B Data
     * PUT /gstr3b/retoffset
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr3bRetoffset(Session.Gst session, Gstr3bRetoffsetArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr3bRetoffset (PUT /gstr3b/retoffset)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr3b/retoffset",
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

    public static JsonNode gstr3bRetoffset(Session.Gst session, Gstr3bRetoffsetArgs args, JsonNode body) {
        return gstr3bRetoffset(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr3b/retsave. Optional ones may be null. */
    public record Gstr3bRetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR3B data
     * PUT /gstr3b/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr3bRetsave(Session.Gst session, Gstr3bRetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr3b/retsave",
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

    public static JsonNode gstr3bRetsave(Session.Gst session, Gstr3bRetsaveArgs args, JsonNode body) {
        return gstr3bRetsave(session, args, body, WriteOptions.none());
    }
}
