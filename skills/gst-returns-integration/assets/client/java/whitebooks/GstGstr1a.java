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

/** gst operations of the "GSTR1A" tag: one static method each. */
public final class GstGstr1a {
    private GstGstr1a() {}

    /** Arguments of GET /gstr1a/at. Optional ones may be null. */
    public record Gstr1aAtArgs(String gstin, String retperiod) {}

    /**
     * Get AT
     * GET /gstr1a/at
     */
    public static JsonNode gstr1aAt(Session.Gst session, Gstr1aAtArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/at",
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

    /** Arguments of GET /gstr1a/ata. Optional ones may be null. */
    public record Gstr1aAtaArgs(String gstin, String retperiod) {}

    /**
     * Get ATA
     * GET /gstr1a/ata
     */
    public static JsonNode gstr1aAta(Session.Gst session, Gstr1aAtaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/ata",
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

    /** Arguments of GET /gstr1a/b2b. Optional ones may be null. */
    public record Gstr1aB2bArgs(String gstin, String retperiod, String fromtime, String actionrequired, String ctin) {}

    /**
     * Get B2B Invoices
     * GET /gstr1a/b2b
     */
    public static JsonNode gstr1aB2b(Session.Gst session, Gstr1aB2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2b",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "fromtime", args.fromtime(),
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1a/b2ba. Optional ones may be null. */
    public record Gstr1aB2baArgs(String gstin, String retperiod, String actionrequired, String ctin, String fromtime) {}

    /**
     * Get B2BA Invoices
     * GET /gstr1a/b2ba
     */
    public static JsonNode gstr1aB2ba(Session.Gst session, Gstr1aB2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2ba",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1a/b2cl. Optional ones may be null. */
    public record Gstr1aB2clArgs(String gstin, String retperiod) {}

    /**
     * Get B2CL Invoices
     * GET /gstr1a/b2cl
     */
    public static JsonNode gstr1aB2cl(Session.Gst session, Gstr1aB2clArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2cl",
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

    /** Arguments of GET /gstr1a/b2cla. Optional ones may be null. */
    public record Gstr1aB2claArgs(String gstin, String retperiod) {}

    /**
     * Get B2CLA Invoices
     * GET /gstr1a/b2cla
     */
    public static JsonNode gstr1aB2cla(Session.Gst session, Gstr1aB2claArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2cla",
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

    /** Arguments of GET /gstr1a/b2cs. Optional ones may be null. */
    public record Gstr1aB2csArgs(String gstin, String retperiod) {}

    /**
     * Get B2CS Invoices
     * GET /gstr1a/b2cs
     */
    public static JsonNode gstr1aB2cs(Session.Gst session, Gstr1aB2csArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2cs",
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

    /** Arguments of GET /gstr1a/b2csa. Optional ones may be null. */
    public record Gstr1aB2csaArgs(String gstin, String retperiod) {}

    /**
     * Get B2CSA Invoices
     * GET /gstr1a/b2csa
     */
    public static JsonNode gstr1aB2csa(Session.Gst session, Gstr1aB2csaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/b2csa",
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

    /** Arguments of GET /gstr1a/cdnr. Optional ones may be null. */
    public record Gstr1aCdnrArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNR Invoices
     * GET /gstr1a/cdnr
     */
    public static JsonNode gstr1aCdnr(Session.Gst session, Gstr1aCdnrArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/cdnr",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1a/cdnra. Optional ones may be null. */
    public record Gstr1aCdnraArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get CDNRA Invoices
     * GET /gstr1a/cdnra
     */
    public static JsonNode gstr1aCdnra(Session.Gst session, Gstr1aCdnraArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/cdnra",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1a/cdnur. Optional ones may be null. */
    public record Gstr1aCdnurArgs(String gstin, String retperiod) {}

    /**
     * API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
     * GET /gstr1a/cdnur
     */
    public static JsonNode gstr1aCdnur(Session.Gst session, Gstr1aCdnurArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/cdnur",
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

    /** Arguments of GET /gstr1a/cdnura. Optional ones may be null. */
    public record Gstr1aCdnuraArgs(String gstin, String retperiod) {}

    /**
     * API call for getting all amended Credit/ Debit Notes issued to un-registered persons for a return period.
     * GET /gstr1a/cdnura
     */
    public static JsonNode gstr1aCdnura(Session.Gst session, Gstr1aCdnuraArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/cdnura",
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

    /** Arguments of GET /gstr1a/dociss. Optional ones may be null. */
    public record Gstr1aDocissArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR1A Document Issued
     * GET /gstr1a/dociss
     */
    public static JsonNode gstr1aDociss(Session.Gst session, Gstr1aDocissArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/dociss",
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

    /** Arguments of GET /gstr1a/ecom. Optional ones may be null. */
    public record Gstr1aEcomArgs(String gstin, String retperiod, String rtin, String subsection, String fromtime) {}

    /**
     * Get ECOM Invoices
     * GET /gstr1a/ecom
     */
    public static JsonNode gstr1aEcom(Session.Gst session, Gstr1aEcomArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/ecom",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "rtin", args.rtin(),
                "subsection", args.subsection(),
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

    /** Arguments of GET /gstr1a/ecoma. Optional ones may be null. */
    public record Gstr1aEcomaArgs(String gstin, String retperiod, String rtin, String subsection) {}

    /**
     * Get ECOMA Invoices
     * GET /gstr1a/ecoma
     */
    public static JsonNode gstr1aEcoma(Session.Gst session, Gstr1aEcomaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/ecoma",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "rtin", args.rtin(),
                "subsection", args.subsection()
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

    /** Arguments of GET /gstr1a/exp. Optional ones may be null. */
    public record Gstr1aExpArgs(String gstin, String retperiod) {}

    /**
     * Get EXP
     * GET /gstr1a/exp
     */
    public static JsonNode gstr1aExp(Session.Gst session, Gstr1aExpArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/exp",
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

    /** Arguments of GET /gstr1a/expa. Optional ones may be null. */
    public record Gstr1aExpaArgs(String gstin, String retperiod) {}

    /**
     * Get EXPA
     * GET /gstr1a/expa
     */
    public static JsonNode gstr1aExpa(Session.Gst session, Gstr1aExpaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/expa",
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

    /** Arguments of GET /gstr1a/hsnsum. Optional ones may be null. */
    public record Gstr1aHsnsumArgs(String gstin, String retperiod) {}

    /**
     * Get HSN Summary details
     * GET /gstr1a/hsnsum
     */
    public static JsonNode gstr1aHsnsum(Session.Gst session, Gstr1aHsnsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/hsnsum",
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

    /** Arguments of GET /gstr1a/nil. Optional ones may be null. */
    public record Gstr1aNilArgs(String gstin, String retperiod) {}

    /**
     * Get Nil Rated Supplies
     * GET /gstr1a/nil
     */
    public static JsonNode gstr1aNil(Session.Gst session, Gstr1aNilArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/nil",
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

    /** Arguments of GET /gstr1a/proceedfile. Optional ones may be null. */
    public record Gstr1aProceedfileArgs(String gstin, String retperiod, String isNil) {}

    /**
     * Proceed To File
     * GET /gstr1a/proceedfile
     */
    public static JsonNode gstr1aProceedfile(Session.Gst session, Gstr1aProceedfileArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/proceedfile",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "isNil", args.isNil()
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

    /** Arguments of GET /gstr1a/retsum. Optional ones may be null. */
    public record Gstr1aRetsumArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR1A Summary
     * GET /gstr1a/retsum
     */
    public static JsonNode gstr1aRetsum(Session.Gst session, Gstr1aRetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/retsum",
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

    /** Arguments of GET /gstr1a/supeco. Optional ones may be null. */
    public record Gstr1aSupecoArgs(String gstin, String retperiod, String subsection, String fromtime) {}

    /**
     * Get Supplier ECO invoices
     * GET /gstr1a/supeco
     */
    public static JsonNode gstr1aSupeco(Session.Gst session, Gstr1aSupecoArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/supeco",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "subsection", args.subsection(),
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

    /** Arguments of GET /gstr1a/supecoa. Optional ones may be null. */
    public record Gstr1aSupecoaArgs(String gstin, String retperiod, String subsection) {}

    /**
     * Get Supplier ECOA invoices
     * GET /gstr1a/supecoa
     */
    public static JsonNode gstr1aSupecoa(Session.Gst session, Gstr1aSupecoaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/supecoa",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "subsection", args.subsection()
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

    /** Arguments of GET /gstr1a/txp. Optional ones may be null. */
    public record Gstr1aTxpArgs(String gstin, String retperiod) {}

    /**
     * Get TXP
     * GET /gstr1a/txp
     */
    public static JsonNode gstr1aTxp(Session.Gst session, Gstr1aTxpArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/txp",
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

    /** Arguments of GET /gstr1a/txpa. Optional ones may be null. */
    public record Gstr1aTxpaArgs(String gstin, String retperiod) {}

    /**
     * Get TXPA
     * GET /gstr1a/txpa
     */
    public static JsonNode gstr1aTxpa(Session.Gst session, Gstr1aTxpaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1a/txpa",
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

    /** Arguments of POST /gstr1a/reset. Optional ones may be null. */
    public record Gstr1aResetArgs(String retPeriod) {}

    /**
     * Reset GSTR1A Data
     * POST /gstr1a/reset
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr1aReset(Session.Gst session, Gstr1aResetArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1a/reset",
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

    public static JsonNode gstr1aReset(Session.Gst session, Gstr1aResetArgs args, JsonNode body) {
        return gstr1aReset(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr1a/retevcfile. Optional ones may be null. */
    public record Gstr1aRetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR1A data
     * POST /gstr1a/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr1aRetevcfile(Session.Gst session, Gstr1aRetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr1aRetevcfile (POST /gstr1a/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1a/retevcfile",
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

    public static JsonNode gstr1aRetevcfile(Session.Gst session, Gstr1aRetevcfileArgs args, JsonNode body) {
        return gstr1aRetevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr1a/retfile. Optional ones may be null. */
    public record Gstr1aRetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR1A data
     * POST /gstr1a/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr1aRetfile(Session.Gst session, Gstr1aRetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr1aRetfile (POST /gstr1a/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1a/retfile",
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

    public static JsonNode gstr1aRetfile(Session.Gst session, Gstr1aRetfileArgs args, JsonNode body) {
        return gstr1aRetfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr1a/retsave. Optional ones may be null. */
    public record Gstr1aRetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR1A data
     * PUT /gstr1a/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr1aRetsave(Session.Gst session, Gstr1aRetsaveArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr1a/retsave",
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

    public static JsonNode gstr1aRetsave(Session.Gst session, Gstr1aRetsaveArgs args, JsonNode body) {
        return gstr1aRetsave(session, args, body, WriteOptions.none());
    }
}
