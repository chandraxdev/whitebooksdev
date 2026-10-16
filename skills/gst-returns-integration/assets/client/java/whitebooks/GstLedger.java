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

/** gst operations of the "Ledger" tag: one static method each. */
public final class GstLedger {
    private GstLedger() {}

    /** Arguments of GET /ledgers/bal. Optional ones may be null. */
    public record LedgersBalArgs(String gstin, String retperiod) {}

    /**
     * Get Cash ITC Balance
     * GET /ledgers/bal
     */
    public static JsonNode ledgersBal(Session.Gst session, LedgersBalArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/bal",
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

    /** Arguments of GET /ledgers/cashdtl. Optional ones may be null. */
    public record LedgersCashdtlArgs(String gstin, String frdt, String todt) {}

    /**
     * Cash Ledger Details
     * GET /ledgers/cashdtl
     */
    public static JsonNode ledgersCashdtl(Session.Gst session, LedgersCashdtlArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/cashdtl",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/itc. Optional ones may be null. */
    public record LedgersItcArgs(String gstin, String frdt, String todt) {}

    /**
     * ITC Ledger Details
     * GET /ledgers/itc
     */
    public static JsonNode ledgersItc(Session.Gst session, LedgersItcArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/itc",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/itcblocktrandetls. Optional ones may be null. */
    public record LedgersItcblocktrandetlsArgs(String gstin, String frdt, String todt) {}

    /**
     * Get Block Unblock
     * GET /ledgers/itcblocktrandetls
     */
    public static JsonNode ledgersItcblocktrandetls(Session.Gst session, LedgersItcblocktrandetlsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/itcblocktrandetls",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/negliabstmt. Optional ones may be null. */
    public record LedgersNegliabstmtArgs(String gstin, String frdt, String todt) {}

    /**
     * Get NegativeLiability Details of GSTR3B
     * GET /ledgers/negliabstmt
     */
    public static JsonNode ledgersNegliabstmt(Session.Gst session, LedgersNegliabstmtArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/negliabstmt",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/rcmldg. Optional ones may be null. */
    public record LedgersRcmldgArgs(String gstin, String frdt, String todt) {}

    /**
     * Get RCM Statement
     * GET /ledgers/rcmldg
     */
    public static JsonNode ledgersRcmldg(Session.Gst session, LedgersRcmldgArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/rcmldg",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/revrclmdtl. Optional ones may be null. */
    public record LedgersRevrclmdtlArgs(String gstin, String frdt, String todt) {}

    /**
     * Get Credit Reversal and Re-claimed Details
     * GET /ledgers/revrclmdtl
     */
    public static JsonNode ledgersRevrclmdtl(Session.Gst session, LedgersRevrclmdtlArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/revrclmdtl",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/tax. Optional ones may be null. */
    public record LedgersTaxArgs(String gstin, String frdt, String todt) {}

    /**
     * Get Liability Ledger Details
     * GET /ledgers/tax
     */
    public static JsonNode ledgersTax(Session.Gst session, LedgersTaxArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/tax",
            params(
                "gstin", args.gstin(),
                "frdt", args.frdt(),
                "todt", args.todt(),
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

    /** Arguments of GET /ledgers/taxpayable. Optional ones may be null. */
    public record LedgersTaxpayableArgs(String gstin, String retperiod, String rettype) {}

    /**
     * Get RetLiab Balance
     * GET /ledgers/taxpayable
     */
    public static JsonNode ledgersTaxpayable(Session.Gst session, LedgersTaxpayableArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ledgers/taxpayable",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "rettype", args.rettype(),
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

    /** Arguments of POST /ledgers/utlcsh. Optional ones may be null. */
    public record LedgersUtlcshArgs(String retPeriod) {}

    /**
     * Utilize Cash
     * POST /ledgers/utlcsh
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode ledgersUtlcsh(Session.Gst session, LedgersUtlcshArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("ledgersUtlcsh (POST /ledgers/utlcsh)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/ledgers/utlcsh",
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

    public static JsonNode ledgersUtlcsh(Session.Gst session, LedgersUtlcshArgs args, JsonNode body) {
        return ledgersUtlcsh(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /ledgers/utlitc. Optional ones may be null. */
    public record LedgersUtlitcArgs(String retPeriod) {}

    /**
     * Utilize ITC
     * POST /ledgers/utlitc
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode ledgersUtlitc(Session.Gst session, LedgersUtlitcArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("ledgersUtlitc (POST /ledgers/utlitc)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/ledgers/utlitc",
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

    public static JsonNode ledgersUtlitc(Session.Gst session, LedgersUtlitcArgs args, JsonNode body) {
        return ledgersUtlitc(session, args, body, WriteOptions.none());
    }
}
