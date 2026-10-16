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
import static whitebooks.Session.params;

/** gst operations of the "GSTR" tag: one static method each. */
public final class GstGstr {
    private GstGstr() {}

    /** Arguments of GET /gstr/retstatus. Optional ones may be null. */
    public record GstrRetstatusArgs(String gstin, String returnperiod, String refid) {}

    /**
     * Get Return Status
     * GET /gstr/retstatus
     */
    public static JsonNode gstrRetstatus(Session.Gst session, GstrRetstatusArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr/retstatus",
            params(
                "gstin", args.gstin(),
                "returnperiod", args.returnperiod(),
                "refid", args.refid(),
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

    /** Arguments of GET /gstr/rettrack. Optional ones may be null. */
    public record GstrRettrackArgs(String gstin, String returnperiod, String type) {}

    /**
     * View and Track Returns
     * GET /gstr/rettrack
     */
    public static JsonNode gstrRettrack(Session.Gst session, GstrRettrackArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/gstr/rettrack",
            params(
                "gstin", args.gstin(),
                "returnperiod", args.returnperiod(),
                "type", args.type(),
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
}
