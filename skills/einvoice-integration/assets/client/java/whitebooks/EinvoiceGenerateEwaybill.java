// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area einvoice
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
import whitebooks.EinvoiceGetIrnDetailsByDocDetails.EinvoiceGetirnbydocdetailsArgs;
import static whitebooks.Session.params;
import static whitebooks.Reconcile.reconcileWrite;
import static whitebooks.EinvoiceGetIrnDetailsByDocDetails.einvoiceGetirnbydocdetails;

/** einvoice operations of the "Generate Ewaybill" tag: one static method each. */
public final class EinvoiceGenerateEwaybill {
    private EinvoiceGenerateEwaybill() {}

    /** Arguments of POST /einvoice/type/GENERATE_EWAYBILL/version/V1_03. Optional ones may be null. */
    public record EinvoiceGenerateEwaybillArgs(String irp) {}

    /**
     * Generate Ewaybill
     * POST /einvoice/type/GENERATE_EWAYBILL/version/V1_03
     * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     */
    public static JsonNode einvoiceGenerateEwaybill(Session.Einvoice session, EinvoiceGenerateEwaybillArgs args, JsonNode body, WriteOptions<EinvoiceGetirnbydocdetailsArgs> opts) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "POST", "/einvoice/type/GENERATE_EWAYBILL/version/V1_03",
            params(
                "email", config.email(),
                "irp", args.irp()
            ),
            params(
                "ip_address", session.ipAddress(),
                "client_id", config.einvClientId(),
                "client_secret", config.einvClientSecret(),
                "username", config.einvNicUsername(),
                "auth-token", session.authToken(),
                "gstin", config.einvGstin()
            ),
            body
        );
        Supplier<JsonNode> check = opts.reconcile() == null ? null : () -> einvoiceGetirnbydocdetails(session, opts.reconcile());
        return reconcileWrite(() -> session.call(build), check, opts, new Policy(Reconcile::hasIrn, "2154"));
    }

    public static JsonNode einvoiceGenerateEwaybill(Session.Einvoice session, EinvoiceGenerateEwaybillArgs args, JsonNode body) {
        return einvoiceGenerateEwaybill(session, args, body, WriteOptions.none());
    }
}
