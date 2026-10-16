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
import static whitebooks.GstGstr.gstrRetstatus;

/** gst operations of the "ALL" tag: one static method each. */
public final class GstAll {
    private GstAll() {}

    /** Arguments of GET /all/docdwld. Optional ones may be null. */
    public record AllDocdwldArgs(String gstin, String retperiod, String id) {}

    /**
     * Document Download
     * GET /all/docdwld
     */
    public static JsonNode allDocdwld(Session.Gst session, AllDocdwldArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/docdwld",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "id", args.id(),
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

    /** Arguments of GET /all/filedet. Optional ones may be null. */
    public record AllFiledetArgs(String gstin, String returnperiod, String token) {}

    /**
     * Get File Details
     * GET /all/filedet
     */
    public static JsonNode allFiledet(Session.Gst session, AllFiledetArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/filedet",
            params(
                "gstin", args.gstin(),
                "returnperiod", args.returnperiod(),
                "token", args.token(),
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

    /** Arguments of GET /all/getmasters. Optional ones may be null. */
    public record AllGetmastersArgs(String retPeriod, String gstin) {}

    /**
     * Get User Masters
     * GET /all/getmasters
     */
    public static JsonNode allGetmasters(Session.Gst session, AllGetmastersArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/getmasters",
            params(
                "email", config.email(),
                "gstin", args.gstin()
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

    /** Arguments of GET /all/getpref. Optional ones may be null. */
    public record AllGetprefArgs(String gstin, String fy) {}

    /**
     * Get Preference
     * GET /all/getpref
     */
    public static JsonNode allGetpref(Session.Gst session, AllGetprefArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/getpref",
            params(
                "gstin", args.gstin(),
                "fy", args.fy(),
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

    /** Arguments of GET /all/largefile. Optional ones may be null. */
    public record AllLargefileArgs(String url, String ek, String gstin, String returnperiod) {}

    /**
     * Get Large File Details
     * GET /all/largefile
     */
    public static JsonNode allLargefile(Session.Gst session, AllLargefileArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/largefile",
            params(
                "url", args.url(),
                "ek", args.ek(),
                "gstin", args.gstin(),
                "returnperiod", args.returnperiod(),
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

    /** Arguments of GET /all/latefee. Optional ones may be null. */
    public record AllLatefeeArgs(String gstin, String retperiod, String rettype) {}

    /**
     * Late Fee
     * GET /all/latefee
     */
    public static JsonNode allLatefee(Session.Gst session, AllLatefeeArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/latefee",
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

    /** Arguments of GET /all/latefeebreakup. Optional ones may be null. */
    public record AllLatefeebreakupArgs(String gstin, String retperiod, String rettype) {}

    /**
     * Get additional late fee breakup
     * GET /all/latefeebreakup
     */
    public static JsonNode allLatefeebreakup(Session.Gst session, AllLatefeebreakupArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/latefeebreakup",
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

    /** Arguments of GET /all/newproceedfile. Optional ones may be null. */
    public record AllNewproceedfileArgs(String gstin, String retperiod, String type, String isNil) {}

    /**
     * New Proceed To File(GSTR1,GSTR5,GSTR6)
     * GET /all/newproceedfile
     */
    public static JsonNode allNewproceedfile(Session.Gst session, AllNewproceedfileArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/newproceedfile",
            params(
                "gstin", args.gstin(),
                "retperiod", args.retperiod(),
                "type", args.type(),
                "isNil", args.isNil(),
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

    /** Arguments of GET /all/newretstatus. Optional ones may be null. */
    public record AllNewretstatusArgs(String gstin, String returnperiod, String refid, String rettype) {}

    /**
     * Get Return Status
     * GET /all/newretstatus
     */
    public static JsonNode allNewretstatus(Session.Gst session, AllNewretstatusArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/newretstatus",
            params(
                "gstin", args.gstin(),
                "returnperiod", args.returnperiod(),
                "refid", args.refid(),
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

    /** Arguments of GET /all/proceedfile. Optional ones may be null. */
    public record AllProceedfileArgs(String gstin, String type, String retperiod) {}

    /**
     * Proceed To File
     * GET /all/proceedfile
     */
    public static JsonNode allProceedfile(Session.Gst session, AllProceedfileArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/all/proceedfile",
            params(
                "gstin", args.gstin(),
                "type", args.type(),
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

    /** Arguments of POST /all/docupld. Optional ones may be null. */
    public record AllDocupldArgs(String retPeriod) {}

    /**
     * Document Upload
     * POST /all/docupld
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode allDocupld(Session.Gst session, AllDocupldArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/all/docupld",
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

    public static JsonNode allDocupld(Session.Gst session, AllDocupldArgs args, JsonNode body) {
        return allDocupld(session, args, body, WriteOptions.none());
    }

    /** Arguments of POST /all/savemasters. Optional ones may be null. */
    public record AllSavemastersArgs(String retPeriod) {}

    /**
     * Save User Masters
     * POST /all/savemasters
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode allSavemasters(Session.Gst session, AllSavemastersArgs args, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/all/savemasters",
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

    public static JsonNode allSavemasters(Session.Gst session, AllSavemastersArgs args, JsonNode body) {
        return allSavemasters(session, args, body, WriteOptions.none());
    }

    /**
     * Save Preference
     * PUT /all/savepref
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
     * A status check runs only with a landed predicate (see isReturnProcessed) and a refid from this return's own save.
     */
    public static JsonNode allSavepref(Session.Gst session, JsonNode body, WriteOptions<GstrRetstatusArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "PUT", "/all/savepref",
            params(
                "email", config.email()
            ),
            params(
                "gstin", config.gstGstin(),
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

    public static JsonNode allSavepref(Session.Gst session, JsonNode body) {
        return allSavepref(session, body, WriteOptions.none());
    }
}
