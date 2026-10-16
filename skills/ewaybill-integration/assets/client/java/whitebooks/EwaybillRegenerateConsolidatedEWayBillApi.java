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
import whitebooks.Reconcile.WriteOptions;
import whitebooks.Reconcile.Policy;
import whitebooks.EwaybillGetEwaybillByConsigner.EwbGetewaybillgeneratedbyconsignerArgs;
import static whitebooks.Session.params;
import static whitebooks.Reconcile.reconcileWrite;
import static whitebooks.EwaybillGetEwaybillByConsigner.ewbGetewaybillgeneratedbyconsigner;

/** ewaybill operations of the "Regenerate Consolidated E-Way Bill - Api" tag: one static method each. */
public final class EwaybillRegenerateConsolidatedEWayBillApi {
    private EwaybillRegenerateConsolidatedEWayBillApi() {}

    /**
     * Regenerate Consolidated E-Way Bill - Api
     * POST /ewaybillapi/v1.03/ewayapi/regentripsheet
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /ewaybillapi/v1.03/ewayapi/getewaybillgeneratedbyconsigner); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     */
    public static JsonNode ewbRegentripsheet(Session.Ewaybill session, JsonNode body, WriteOptions<EwbGetewaybillgeneratedbyconsignerArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/ewaybillapi/v1.03/ewayapi/regentripsheet",
            params(
                "email", config.email()
            ),
            params(
                "ip_address", session.ipAddress(),
                "client_id", config.ewbClientId(),
                "client_secret", config.ewbClientSecret(),
                "username", config.ewbNicUsername(),
                "gstin", config.ewbGstin()
            ),
            body
        );
        Supplier<JsonNode> check = opts.reconcile() == null ? null : () -> ewbGetewaybillgeneratedbyconsigner(session, opts.reconcile());
        return reconcileWrite(() -> session.call(build), check, opts, new Policy(Reconcile::hasEwayBillNo, null));
    }

    public static JsonNode ewbRegentripsheet(Session.Ewaybill session, JsonNode body) {
        return ewbRegentripsheet(session, body, WriteOptions.none());
    }
}
