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

/** einvoice operations of the "Get B2C QR Code Details" tag: one static method each. */
public final class EinvoiceGetB2cQrCodeDetails {
    private EinvoiceGetB2cQrCodeDetails() {}

    /** Arguments of GET /einvoice/qrcode. Optional ones may be null. */
    public record EinvoiceQrcodeArgs(String sgstin, String docno, String docdate, String totinvval, String bankaccno, String bankifsccode, String accountholdername, String igstamount, String cgstamount, String sgstamount, String cessamount, String upiid) {}

    /**
     * Get B2C QR Code Details
     * GET /einvoice/qrcode
     * Public: no session is needed.
     */
    public static JsonNode einvoiceQrcode(Config config, EinvoiceQrcodeArgs args) {
        Config.requireArea(config, "einvoice");
        Supplier<Call> build = () -> new Call(
            "GET", "/einvoice/qrcode",
            params(
                "email", config.email()
            ),
            params(
                "ip_address", config.ipAddress(),
                "client_id", config.einvClientId(),
                "client_secret", config.einvClientSecret(),
                "username", config.einvNicUsername(),
                "sgstin", args.sgstin(),
                "docno", args.docno(),
                "docdate", args.docdate(),
                "totinvval", args.totinvval(),
                "upiid", args.upiid(),
                "bankaccno", args.bankaccno(),
                "bankifsccode", args.bankifsccode(),
                "accountholdername", args.accountholdername(),
                "igstamount", args.igstamount(),
                "cgstamount", args.cgstamount(),
                "sgstamount", args.sgstamount(),
                "cessamount", args.cessamount()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }
}
