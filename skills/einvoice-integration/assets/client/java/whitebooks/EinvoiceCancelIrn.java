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
import static whitebooks.Reconcile.requireIrreversibleConfirmed;
import static whitebooks.EinvoiceGetIrnDetailsByDocDetails.einvoiceGetirnbydocdetails;

/** einvoice operations of the "Cancel IRN" tag: one static method each. */
public final class EinvoiceCancelIrn {
    private EinvoiceCancelIrn() {}

    /** Arguments of POST /einvoice/type/CANCEL/version/V1_03. Optional ones may be null. */
    public record EinvoiceCancelArgs(String irp) {}

    /**
     * Cancel IRN
     * POST /einvoice/type/CANCEL/version/V1_03
     * A timeout or other unknown outcome is reconciled: pass WriteOptions.withReconcile(...) with the arguments of the status operation
     * (GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
     * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless the
     * options carry confirmIrreversible (WriteOptions.confirmed() or .confirm()); pass that only after the user has
     * confirmed this exact operation and document.
     */
    public static JsonNode einvoiceCancel(Session.Einvoice session, EinvoiceCancelArgs args, EinvoiceCancelRequest request, WriteOptions<EinvoiceGetirnbydocdetailsArgs> opts) {
        requireIrreversibleConfirmed("einvoiceCancel (POST /einvoice/type/CANCEL/version/V1_03)", opts != null && opts.confirmIrreversible());
        Config config = session.config();
        JsonNode body = request.toJson();
        Supplier<Call> build = () -> new Call(
            "POST", "/einvoice/type/CANCEL/version/V1_03",
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

    public static JsonNode einvoiceCancel(Session.Einvoice session, EinvoiceCancelArgs args, EinvoiceCancelRequest request) {
        return einvoiceCancel(session, args, request, WriteOptions.none());
    }
}
