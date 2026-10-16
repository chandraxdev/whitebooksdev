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
import static whitebooks.Session.params;

/** einvoice operations of the "Get IRN details by Doc Details" tag: one static method each. */
public final class EinvoiceGetIrnDetailsByDocDetails {
    private EinvoiceGetIrnDetailsByDocDetails() {}

    /** Arguments of GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03. Optional ones may be null. */
    public record EinvoiceGetirnbydocdetailsArgs(String docnum, String docdate, String param1, String supplierGstn, String irp) {}

    /**
     * Get IRN details by Doc Details
     * GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03
     */
    public static JsonNode einvoiceGetirnbydocdetails(Session.Einvoice session, EinvoiceGetirnbydocdetailsArgs args) {
        Config config = session.config();
        Supplier<Call> build = () -> new Call(
            "GET", "/einvoice/type/GETIRNBYDOCDETAILS/version/V1_03",
            params(
                "param1", args.param1(),
                "supplier_gstn", args.supplierGstn(),
                "irp", args.irp(),
                "email", config.email()
            ),
            params(
                "docnum", args.docnum(),
                "docdate", args.docdate(),
                "ip_address", session.ipAddress(),
                "client_id", config.einvClientId(),
                "client_secret", config.einvClientSecret(),
                "username", config.einvNicUsername(),
                "auth-token", session.authToken(),
                "gstin", config.einvGstin()
            ),
            null
        );
        return Session.withRetries(() -> session.call(build));
    }
}
