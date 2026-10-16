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

/** gst operations of the "GSTR6" tag: one static method each. */
public final class GstGstr6 {
    private GstGstr6() {}

    /** Arguments of GET /gstr6/b2b. Optional ones may be null. */
    public record Gstr6B2bArgs(String gstin, String retperiod, String actionrequired, String ctin, String fromtime) {}

    /**
     * Get B2B Invoices
     * GET /gstr6/b2b
     */
    public static JsonNode gstr6B2b(Session.Gst session, Gstr6B2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/b2b",
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

    /** Arguments of GET /gstr6/b2ba. Optional ones may be null. */
    public record Gstr6B2baArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get B2BA Invoices
     * GET /gstr6/b2ba
     */
    public static JsonNode gstr6B2ba(Session.Gst session, Gstr6B2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/b2ba",
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

    /** Arguments of GET /gstr6/cdn. Optional ones may be null. */
    public record Gstr6CdnArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNR Invoices
     * GET /gstr6/cdn
     */
    public static JsonNode gstr6Cdn(Session.Gst session, Gstr6CdnArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/cdn",
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

    /** Arguments of GET /gstr6/cdna. Optional ones may be null. */
    public record Gstr6CdnaArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNRA Invoices
     * GET /gstr6/cdna
     */
    public static JsonNode gstr6Cdna(Session.Gst session, Gstr6CdnaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/cdna",
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

    /** Arguments of GET /gstr6/isd. Optional ones may be null. */
    public record Gstr6IsdArgs(String gstin, String retperiod) {}

    /**
     * Get ISD Details
     * GET /gstr6/isd
     */
    public static JsonNode gstr6Isd(Session.Gst session, Gstr6IsdArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/isd",
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

    /** Arguments of GET /gstr6/isda. Optional ones may be null. */
    public record Gstr6IsdaArgs(String gstin, String retperiod, String ctin) {}

    /**
     * Get Amendment ISD Details
     * GET /gstr6/isda
     */
    public static JsonNode gstr6Isda(Session.Gst session, Gstr6IsdaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/isda",
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

    /** Arguments of GET /gstr6/itc. Optional ones may be null. */
    public record Gstr6ItcArgs(String gstin, String retperiod) {}

    /**
     * Get ITC Details
     * GET /gstr6/itc
     */
    public static JsonNode gstr6Itc(Session.Gst session, Gstr6ItcArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/itc",
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

    /** Arguments of GET /gstr6/latefee. Optional ones may be null. */
    public record Gstr6LatefeeArgs(String gstin, String retperiod) {}

    /**
     * Get Late Fee
     * GET /gstr6/latefee
     */
    public static JsonNode gstr6Latefee(Session.Gst session, Gstr6LatefeeArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/latefee",
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

    /** Arguments of GET /gstr6/retsum. Optional ones may be null. */
    public record Gstr6RetsumArgs(String gstin, String retperiod, String fnl) {}

    /**
     * Get GSTR6 Summary
     * GET /gstr6/retsum
     */
    public static JsonNode gstr6Retsum(Session.Gst session, Gstr6RetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr6/retsum",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
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

    /** Arguments of POST /gstr6/retcal. Optional ones may be null. */
    public record Gstr6RetcalArgs(String retPeriod) {}

    /**
     * GSTR6 Calculate R6
     * POST /gstr6/retcal
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     */
    public static JsonNode gstr6Retcal(Session.Gst session, Gstr6RetcalArgs args, JsonNode body) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr6/retcal",
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

    /** Arguments of POST /gstr6/retevcfile. Optional ones may be null. */
    public record Gstr6RetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR6 data
     * POST /gstr6/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr6Retevcfile(Session.Gst session, Gstr6RetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr6Retevcfile (POST /gstr6/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr6/retevcfile",
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

    public static JsonNode gstr6Retevcfile(Session.Gst session, Gstr6RetevcfileArgs args, JsonNode body) {
        return gstr6Retevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr6/retfile. Optional ones may be null. */
    public record Gstr6RetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR6 data
     * POST /gstr6/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr6Retfile(Session.Gst session, Gstr6RetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr6Retfile (POST /gstr6/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr6/retfile",
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

    public static JsonNode gstr6Retfile(Session.Gst session, Gstr6RetfileArgs args, JsonNode body) {
        return gstr6Retfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr6/retsubmit. Optional ones may be null. */
    public record Gstr6RetsubmitArgs(String retPeriod) {}

    /**
     * Submit GSTR6 data
     * POST /gstr6/retsubmit
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr6Retsubmit(Session.Gst session, Gstr6RetsubmitArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr6Retsubmit (POST /gstr6/retsubmit)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr6/retsubmit",
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

    public static JsonNode gstr6Retsubmit(Session.Gst session, Gstr6RetsubmitArgs args, JsonNode body) {
        return gstr6Retsubmit(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr6/savecrossitcdetails. Optional ones may be null. */
    public record Gstr6SavecrossitcdetailsArgs(String retPeriod) {}

    /**
     * Save GSTR6 Cross ITC details
     * POST /gstr6/savecrossitcdetails
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr6Savecrossitcdetails(Session.Gst session, Gstr6SavecrossitcdetailsArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr6/savecrossitcdetails",
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

    public static JsonNode gstr6Savecrossitcdetails(Session.Gst session, Gstr6SavecrossitcdetailsArgs args, JsonNode body) {
        return gstr6Savecrossitcdetails(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr6/retoffsetlatefee. Optional ones may be null. */
    public record Gstr6RetoffsetlatefeeArgs(String retPeriod) {}

    /**
     * Offset Liability GSTR6 Late fee
     * PUT /gstr6/retoffsetlatefee
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr6Retoffsetlatefee(Session.Gst session, Gstr6RetoffsetlatefeeArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr6Retoffsetlatefee (PUT /gstr6/retoffsetlatefee)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr6/retoffsetlatefee",
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

    public static JsonNode gstr6Retoffsetlatefee(Session.Gst session, Gstr6RetoffsetlatefeeArgs args, JsonNode body) {
        return gstr6Retoffsetlatefee(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr6/retsave. Optional ones may be null. */
    public record Gstr6RetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR6 data
     * PUT /gstr6/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr6Retsave(Session.Gst session, Gstr6RetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr6/retsave",
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

    public static JsonNode gstr6Retsave(Session.Gst session, Gstr6RetsaveArgs args, JsonNode body) {
        return gstr6Retsave(session, args, body, WriteOptions.none());
    }
}
