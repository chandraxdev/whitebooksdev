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

/** ewaybill operations of the "Get Eway bills by parties" tag: one static method each. */
public final class EwaybillGetEwayBillsByParties {
    private EwaybillGetEwayBillsByParties() {}

    /** Arguments of GET /ewaybillapi/v1.03/ewayapi/getewaybillsofotherparty. Optional ones may be null. */
    public record EwbGetewaybillsofotherpartyArgs(String date) {}

    /**
     * Get e-way bills generated on you (requesting GSTIN) by other parties
     * GET /ewaybillapi/v1.03/ewayapi/getewaybillsofotherparty
     */
    public static JsonNode ewbGetewaybillsofotherparty(Session.Ewaybill session, EwbGetewaybillsofotherpartyArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ewaybillapi/v1.03/ewayapi/getewaybillsofotherparty",
            params(
                "email", config.email(),
                "date", args.date()
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
