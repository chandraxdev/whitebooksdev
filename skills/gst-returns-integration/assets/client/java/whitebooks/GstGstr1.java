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

/** gst operations of the "GSTR1" tag: one static method each. */
public final class GstGstr1 {
    private GstGstr1() {}

    /** Arguments of GET /gstr1/at. Optional ones may be null. */
    public record Gstr1AtArgs(String gstin, String retperiod) {}

    /**
     * Get AT
     * GET /gstr1/at
     */
    public static JsonNode gstr1At(Session.Gst session, Gstr1AtArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/at",
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

    /** Arguments of GET /gstr1/ata. Optional ones may be null. */
    public record Gstr1AtaArgs(String gstin, String retperiod) {}

    /**
     * Get ATA
     * GET /gstr1/ata
     */
    public static JsonNode gstr1Ata(Session.Gst session, Gstr1AtaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/ata",
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

    /** Arguments of GET /gstr1/b2b. Optional ones may be null. */
    public record Gstr1B2bArgs(String gstin, String retperiod, String actionrequired, String ctin, String fromtime) {}

    /**
     * Get B2B Invoices
     * GET /gstr1/b2b
     */
    public static JsonNode gstr1B2b(Session.Gst session, Gstr1B2bArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2b",
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

    /** Arguments of GET /gstr1/b2ba. Optional ones may be null. */
    public record Gstr1B2baArgs(String gstin, String retperiod, String actionrequired, String ctin) {}

    /**
     * Get B2BA Invoices
     * GET /gstr1/b2ba
     */
    public static JsonNode gstr1B2ba(Session.Gst session, Gstr1B2baArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2ba",
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

    /** Arguments of GET /gstr1/b2cl. Optional ones may be null. */
    public record Gstr1B2clArgs(String gstin, String retperiod, String statecd) {}

    /**
     * Get B2CL Invoices
     * GET /gstr1/b2cl
     */
    public static JsonNode gstr1B2cl(Session.Gst session, Gstr1B2clArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2cl",
            params(
                "statecd", args.statecd(),
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

    /** Arguments of GET /gstr1/b2cla. Optional ones may be null. */
    public record Gstr1B2claArgs(String gstin, String retperiod, String statecd) {}

    /**
     * Get B2CLA Invoices
     * GET /gstr1/b2cla
     */
    public static JsonNode gstr1B2cla(Session.Gst session, Gstr1B2claArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2cla",
            params(
                "statecd", args.statecd(),
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

    /** Arguments of GET /gstr1/b2cs. Optional ones may be null. */
    public record Gstr1B2csArgs(String gstin, String retperiod) {}

    /**
     * Get B2CS Invoices
     * GET /gstr1/b2cs
     */
    public static JsonNode gstr1B2cs(Session.Gst session, Gstr1B2csArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2cs",
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

    /** Arguments of GET /gstr1/b2csa. Optional ones may be null. */
    public record Gstr1B2csaArgs(String gstin, String retperiod) {}

    /**
     * Get B2CSA Invoices
     * GET /gstr1/b2csa
     */
    public static JsonNode gstr1B2csa(Session.Gst session, Gstr1B2csaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/b2csa",
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

    /** Arguments of GET /gstr1/cdnr. Optional ones may be null. */
    public record Gstr1CdnrArgs(String gstin, String retperiod, String actionrequired) {}

    /**
     * Get CDNR Invoices
     * GET /gstr1/cdnr
     */
    public static JsonNode gstr1Cdnr(Session.Gst session, Gstr1CdnrArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/cdnr",
            params(
                "email", config.email(),
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1/cdnra. Optional ones may be null. */
    public record Gstr1CdnraArgs(String gstin, String retperiod, String actionrequired) {}

    /**
     * Get CDNRA Invoices
     * GET /gstr1/cdnra
     */
    public static JsonNode gstr1Cdnra(Session.Gst session, Gstr1CdnraArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/cdnra",
            params(
                "actionrequired", args.actionrequired(),
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

    /** Arguments of GET /gstr1/cdnur. Optional ones may be null. */
    public record Gstr1CdnurArgs(String gstin, String retperiod) {}

    /**
     * API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
     * GET /gstr1/cdnur
     */
    public static JsonNode gstr1Cdnur(Session.Gst session, Gstr1CdnurArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/cdnur",
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

    /** Arguments of GET /gstr1/cdnura. Optional ones may be null. */
    public record Gstr1CdnuraArgs(String gstin, String retperiod) {}

    /**
     * API call for getting all amended Credit/ Debit Notes issued to un-registered persons for a return period.
     * GET /gstr1/cdnura
     */
    public static JsonNode gstr1Cdnura(Session.Gst session, Gstr1CdnuraArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/cdnura",
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

    /** Arguments of GET /gstr1/dociss. Optional ones may be null. */
    public record Gstr1DocissArgs(String gstin, String retperiod) {}

    /**
     * Get GSTR1 Document Issued
     * GET /gstr1/dociss
     */
    public static JsonNode gstr1Dociss(Session.Gst session, Gstr1DocissArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/dociss",
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

    /** Arguments of GET /gstr1/ecom. Optional ones may be null. */
    public record Gstr1EcomArgs(String gstin, String retperiod, String rtin, String subsection, String fromtime) {}

    /**
     * Get ECOM Invoices
     * GET /gstr1/ecom
     */
    public static JsonNode gstr1Ecom(Session.Gst session, Gstr1EcomArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/ecom",
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

    /** Arguments of GET /gstr1/ecoma. Optional ones may be null. */
    public record Gstr1EcomaArgs(String gstin, String retperiod, String rtin, String subsection, String fromtime) {}

    /**
     * Get ECOMA Invoices
     * GET /gstr1/ecoma
     */
    public static JsonNode gstr1Ecoma(Session.Gst session, Gstr1EcomaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/ecoma",
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

    /** Arguments of GET /gstr1/einvoice. Optional ones may be null. */
    public record Gstr1EinvoiceArgs(String gstin, String retperiod, String sec, String fromtime) {}

    /**
     * Get E-Invoices
     * GET /gstr1/einvoice
     */
    public static JsonNode gstr1Einvoice(Session.Gst session, Gstr1EinvoiceArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/einvoice",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "sec", args.sec(),
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

    /** Arguments of GET /gstr1/exp. Optional ones may be null. */
    public record Gstr1ExpArgs(String gstin, String retperiod) {}

    /**
     * Get EXP
     * GET /gstr1/exp
     */
    public static JsonNode gstr1Exp(Session.Gst session, Gstr1ExpArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/exp",
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

    /** Arguments of GET /gstr1/expa. Optional ones may be null. */
    public record Gstr1ExpaArgs(String gstin, String retperiod) {}

    /**
     * Get EXPA
     * GET /gstr1/expa
     */
    public static JsonNode gstr1Expa(Session.Gst session, Gstr1ExpaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/expa",
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

    /** Arguments of GET /gstr1/hsnsum. Optional ones may be null. */
    public record Gstr1HsnsumArgs(String gstin, String retperiod) {}

    /**
     * Get HSN Summary details
     * GET /gstr1/hsnsum
     */
    public static JsonNode gstr1Hsnsum(Session.Gst session, Gstr1HsnsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/hsnsum",
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

    /** Arguments of GET /gstr1/nil. Optional ones may be null. */
    public record Gstr1NilArgs(String gstin, String retperiod) {}

    /**
     * Get Nil Rated Supplies
     * GET /gstr1/nil
     */
    public static JsonNode gstr1Nil(Session.Gst session, Gstr1NilArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/nil",
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

    /** Arguments of GET /gstr1/retsum. Optional ones may be null. */
    public record Gstr1RetsumArgs(String gstin, String retperiod, String smrytyp) {}

    /**
     * Get GSTR1 Summary
     * GET /gstr1/retsum
     */
    public static JsonNode gstr1Retsum(Session.Gst session, Gstr1RetsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/retsum",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "email", config.email(),
                "smrytyp", args.smrytyp()
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

    /** Arguments of GET /gstr1/supeco. Optional ones may be null. */
    public record Gstr1SupecoArgs(String gstin, String retperiod, String subsection, String fromtime) {}

    /**
     * Get Supplier ECO invoices
     * GET /gstr1/supeco
     */
    public static JsonNode gstr1Supeco(Session.Gst session, Gstr1SupecoArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/supeco",
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

    /** Arguments of GET /gstr1/supecoa. Optional ones may be null. */
    public record Gstr1SupecoaArgs(String gstin, String retperiod, String subsection, String fromtime) {}

    /**
     * Get Supplier ECOA invoices
     * GET /gstr1/supecoa
     */
    public static JsonNode gstr1Supecoa(Session.Gst session, Gstr1SupecoaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/supecoa",
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

    /** Arguments of GET /gstr1/txp. Optional ones may be null. */
    public record Gstr1TxpArgs(String gstin, String retperiod) {}

    /**
     * Get TXP
     * GET /gstr1/txp
     */
    public static JsonNode gstr1Txp(Session.Gst session, Gstr1TxpArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/txp",
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

    /** Arguments of GET /gstr1/txpa. Optional ones may be null. */
    public record Gstr1TxpaArgs(String gstin, String retperiod) {}

    /**
     * Get TXPA
     * GET /gstr1/txpa
     */
    public static JsonNode gstr1Txpa(Session.Gst session, Gstr1TxpaArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/txpa",
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

    /** Arguments of GET /gstr1/validatehsnsum. Optional ones may be null. */
    public record Gstr1ValidatehsnsumArgs(String gstin, String retperiod) {}

    /**
     * Validate the HSN Summary details
     * GET /gstr1/validatehsnsum
     */
    public static JsonNode gstr1Validatehsnsum(Session.Gst session, Gstr1ValidatehsnsumArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr1/validatehsnsum",
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

    /** Arguments of POST /gstr1/reset. Optional ones may be null. */
    public record Gstr1ResetArgs(String retPeriod) {}

    /**
     * Reset GSTR1 Data
     * POST /gstr1/reset
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr1Reset(Session.Gst session, Gstr1ResetArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1/reset",
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

    public static JsonNode gstr1Reset(Session.Gst session, Gstr1ResetArgs args, JsonNode body) {
        return gstr1Reset(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr1/retevcfile. Optional ones may be null. */
    public record Gstr1RetevcfileArgs(String retPeriod, String pan, String evcotp) {}

    /**
     * File GSTR1 data
     * POST /gstr1/retevcfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr1Retevcfile(Session.Gst session, Gstr1RetevcfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr1Retevcfile (POST /gstr1/retevcfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1/retevcfile",
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

    public static JsonNode gstr1Retevcfile(Session.Gst session, Gstr1RetevcfileArgs args, JsonNode body) {
        return gstr1Retevcfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /gstr1/retfile. Optional ones may be null. */
    public record Gstr1RetfileArgs(String retPeriod, String pan) {}

    /**
     * File GSTR1 data
     * POST /gstr1/retfile
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode gstr1Retfile(Session.Gst session, Gstr1RetfileArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        requireIrreversibleConfirmed("gstr1Retfile (POST /gstr1/retfile)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/gstr1/retfile",
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

    public static JsonNode gstr1Retfile(Session.Gst session, Gstr1RetfileArgs args, JsonNode body) {
        return gstr1Retfile(session, args, body, WriteOptions.none());
    }

    /** Arguments of PUT /gstr1/retsave. Optional ones may be null. */
    public record Gstr1RetsaveArgs(String retPeriod) {}

    /**
     * Save GSTR1 data
     * PUT /gstr1/retsave
     * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode gstr1Retsave(Session.Gst session, Gstr1RetsaveArgs args, Gstr1SaveRequest request, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        JsonNode body = request.toJson();
        Supplier<Call> build = () -> new Call(
            "PUT", "/gstr1/retsave",
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

    public static JsonNode gstr1Retsave(Session.Gst session, Gstr1RetsaveArgs args, Gstr1SaveRequest request) {
        return gstr1Retsave(session, args, request, WriteOptions.none());
    }
}
