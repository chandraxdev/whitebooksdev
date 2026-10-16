// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area ewaybill
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

/** ewaybill operations of the "GET HSN details" tag: one static method each. */
public final class EwaybillGetHsnDetails {
    private EwaybillGetHsnDetails() {}

    /** Arguments of GET /ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode. Optional ones may be null. */
    public record EwbGethsndetailsbyhsncodeArgs(String hsncode) {}

    /**
     * GET HSN details
     * GET /ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode
     */
    public static JsonNode ewbGethsndetailsbyhsncode(Session.Ewaybill session, EwbGethsndetailsbyhsncodeArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode",
            params(
                "email", config.email(),
                "hsncode", args.hsncode()
            ),
            params(
                "ip_address", session.ipAddress(),
                "client_id", config.ewbClientId(),
                "client_secret", config.ewbClientSecret(),
                "username", config.ewbNicUsername(),
                "gstin", config.ewbGstin()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }
}
