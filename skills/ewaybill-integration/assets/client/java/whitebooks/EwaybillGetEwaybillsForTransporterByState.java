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

/** ewaybill operations of the "Get EwayBills For Transporter By State" tag: one static method each. */
public final class EwaybillGetEwaybillsForTransporterByState {
    private EwaybillGetEwaybillsForTransporterByState() {}

    /** Arguments of GET /ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbystate. Optional ones may be null. */
    public record EwbGetewaybillsfortransporterbystateArgs(String stateCode, String date) {}

    /**
     * Get eway bill assigned to you (requesting GSTIN) for transportation – Particular State and Date
     * GET /ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbystate
     */
    public static JsonNode ewbGetewaybillsfortransporterbystate(Session.Ewaybill session, EwbGetewaybillsfortransporterbystateArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbystate",
            params(
                "email", config.email(),
                "stateCode", args.stateCode(),
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
