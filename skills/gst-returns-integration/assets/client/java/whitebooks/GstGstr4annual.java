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

/** gst operations of the "GSTR4Annual" tag: one static method each. */
public final class GstGstr4annual {
    private GstGstr4annual() {}

    /** Arguments of GET /gstr4annual/autopop. Optional ones may be null. */
    public record Gstr4annualAutopopArgs(String gstin, String retperiod) {}

    /**
     * Get autopopulated data for table 4A/4B of GSTR4 Annual form
     * GET /gstr4annual/autopop
     */
    public static JsonNode gstr4annualAutopop(Session.Gst session, Gstr4annualAutopopArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/autopop",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr4annual/getsum. Optional ones may be null. */
    public record Gstr4annualGetsumArgs(String gstin, String retperiod) {}

    /**
     * Get summary Invoices
     * GET /gstr4annual/getsum
     */
    public static JsonNode gstr4annualGetsum(Session.Gst session, Gstr4annualGetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/getsum",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr4annual/tdscmp. Optional ones may be null. */
    public record Gstr4annualTdscmpArgs(String gstin, String retperiod) {}

    /**
     * Get tdscmp Invoices
     * GET /gstr4annual/tdscmp
     */
    public static JsonNode gstr4annualTdscmp(Session.Gst session, Gstr4annualTdscmpArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/tdscmp",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr4annual/txios. Optional ones may be null. */
    public record Gstr4annualTxiosArgs(String gstin, String retperiod) {}

    /**
     * Get txios Invoices
     * GET /gstr4annual/txios
     */
    public static JsonNode gstr4annualTxios(Session.Gst session, Gstr4annualTxiosArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/txios",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr4annual/validateliability. Optional ones may be null. */
    public record Gstr4annualValidateliabilityArgs(String gstin, String retperiod) {}

    /**
     * Get validate the liability provided in table 6 for GSTR4 Annual form
     * GET /gstr4annual/validateliability
     */
    public static JsonNode gstr4annualValidateliability(Session.Gst session, Gstr4annualValidateliabilityArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/validateliability",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of GET /gstr4annual/validateturnover. Optional ones may be null. */
    public record Gstr4annualValidateturnoverArgs(String gstin, String retperiod) {}

    /**
     * Get validate turnover for GSTR4 Annual form
     * GET /gstr4annual/validateturnover
     */
    public static JsonNode gstr4annualValidateturnover(Session.Gst session, Gstr4annualValidateturnoverArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr4annual/validateturnover",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
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

    /** Arguments of POST /gstr4annual/retevcfile. Optional ones may be null. */
    public record Gstr4annualRetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR4 Annual data
     * POST /gstr4annual/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr4annualRetevcfile(Session.Gst session, Gstr4annualRetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr4annualRetevcfile (POST /gstr4annual/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr4annual/retevcfile",
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

    public static JsonNode gstr4annualRetevcfile(Session.Gst session, Gstr4annualRetevcfileArgs args, JsonNode body) {
        return gstr4annualRetevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr4annual/retfile. Optional ones may be null. */
    public record Gstr4annualRetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR4Annual data
     * POST /gstr4annual/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr4annualRetfile(Session.Gst session, Gstr4annualRetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr4annualRetfile (POST /gstr4annual/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr4annual/retfile",
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

    public static JsonNode gstr4annualRetfile(Session.Gst session, Gstr4annualRetfileArgs args, JsonNode body) {
        return gstr4annualRetfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr4annual/retsave. Optional ones may be null. */
    public record Gstr4annualRetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR4Annual data
     * PUT /gstr4annual/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr4annualRetsave(Session.Gst session, Gstr4annualRetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr4annual/retsave",
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

    public static JsonNode gstr4annualRetsave(Session.Gst session, Gstr4annualRetsaveArgs args, JsonNode body) {
        return gstr4annualRetsave(session, args, body, WriteOptions.none());
    }
}
