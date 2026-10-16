// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3. Run: javac -cp <jackson jars> -d out whitebooks/*.java test/whitebooks/*.java; java -cp out:<jackson jars> whitebooks.EwaybillSmokeTest

package whitebooks;

/** Sandbox smoke checks of the ewaybill area: they run only with the sandbox variables set and WB_BASE_URL unset or on the sandbox host. */
public final class EwaybillSmokeTest {
    private EwaybillSmokeTest() {}

    public static void main(String[] argv) throws Exception {
        KitSupport.announceGate();
        if (KitSupport.have(new String[] {"WB_EWB_CLIENT_ID", "WB_EWB_CLIENT_SECRET", "WB_EMAIL", "WB_EWB_GSTIN", "WB_IP_ADDRESS", "WB_EWB_NIC_USERNAME", "WB_EWB_NIC_PASSWORD"})) {
            new Session.Ewaybill(Config.fromEnv(KitSupport.env())).authenticate();
            KitSupport.check("sandbox: e-Way Bill login", true);
        }
        KitSupport.finish();
    }
}
