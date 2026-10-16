// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3. Run: javac -cp <jackson jars> -d out whitebooks/*.java test/whitebooks/*.java; java -cp out:<jackson jars> whitebooks.GstSmokeTest

package whitebooks;

import com.fasterxml.jackson.databind.JsonNode;

/** Sandbox smoke checks of the gst area: they run only with the sandbox variables set and WB_BASE_URL unset or on the sandbox host. */
public final class GstSmokeTest {
    private GstSmokeTest() {}

    public static void main(String[] argv) throws Exception {
        KitSupport.announceGate();
        if (KitSupport.have(new String[] {"WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN"})) {
            JsonNode result = GstPublic.publicSearch(Config.fromEnv(KitSupport.env()), new GstPublic.PublicSearchArgs(System.getenv("WB_GST_GSTIN")));
            KitSupport.check("sandbox: public search answers", result != null);
        }
        if (KitSupport.have(new String[] {"WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN", "WB_IP_ADDRESS", "WB_GST_USERNAME"})) {
            Session.Gst session = new Session.Gst(Config.fromEnv(KitSupport.env()));
            session.requestOtp();
            KitSupport.check("sandbox: GST login asks for an OTP", !session.txn().isEmpty());
            String otp = System.getenv("WB_OTP");
            if (otp != null && !otp.isEmpty()) {
                session.authenticate(otp);
            }
        }
        KitSupport.finish();
    }
}
