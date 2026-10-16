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

/** gst operations of the "Authentication" tag: one static method each. */
public final class GstAuthentication {
    private GstAuthentication() {}

    /** Arguments of GET /authentication/otpforevc. Optional ones may be null. */
    public record AuthenticationOtpforevcArgs(String gstin, String pan, String formType) {}

    /**
     * Initiate OTP for EVC
     * GET /authentication/otpforevc
     */
    public static JsonNode authenticationOtpforevc(Session.Gst session, AuthenticationOtpforevcArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/authentication/otpforevc",
            params(
                "email", config.email(),
                "gstin", args.gstin(),
                "pan", args.pan(),
                "form_type", args.formType()
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
