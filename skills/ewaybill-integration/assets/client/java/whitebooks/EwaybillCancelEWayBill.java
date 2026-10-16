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
import whitebooks.EwaybillGetEwaybillDetails.EwbGetewaybillArgs;
import static whitebooks.Session.params;
import static whitebooks.Reconcile.reconcileWrite;
import static whitebooks.Reconcile.requireIrreversibleConfirmed;
import static whitebooks.EwaybillGetEwaybillDetails.ewbGetewaybill;

/** ewaybill operations of the "Cancel E-Way bill" tag: one static method each. */
public final class EwaybillCancelEWayBill {
    private EwaybillCancelEWayBill() {}

    /** Arguments of POST /ewaybillapi/v1.03/ewayapi/canewb. Optional ones may be null. */
    public record EwbCanewbArgs(String irp) {}

    /**
     * Cancel E-Way bill
     * POST /ewaybillapi/v1.03/ewayapi/canewb
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /ewaybillapi/v1.03/ewayapi/getewaybill); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode ewbCanewb(Session.Ewaybill session, EwbCanewbArgs args, EwbCancelRequest request, WriteOptions<EwbGetewaybillArgs> opts) {
        requireIrreversibleConfirmed("ewbCanewb (POST /ewaybillapi/v1.03/ewayapi/canewb)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        JsonNode body = request.toJson();
        Supplier<Call> build = () -> new Call(
            "POST", "/ewaybillapi/v1.03/ewayapi/canewb",
            params(
                "email", config.email(),
                "irp", args.irp()
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
        Supplier<JsonNode> check = opts.reconcile() == null ? null : () -> ewbGetewaybill(session, opts.reconcile());
        return reconcileWrite(() -> session.call(build), check, opts, new Policy(Reconcile::hasEwayBillNo, null));
    }

    public static JsonNode ewbCanewb(Session.Ewaybill session, EwbCanewbArgs args, EwbCancelRequest request) {
        return ewbCanewb(session, args, request, WriteOptions.none());
    }
}
