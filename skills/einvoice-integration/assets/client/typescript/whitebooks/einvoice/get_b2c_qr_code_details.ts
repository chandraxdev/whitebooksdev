// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area einvoice
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { requireArea, type Config } from "../config.js";
import { send, type Call, withRetries } from "../session.js";

export interface EinvoiceQrcodeArgs {
  /** Header sgstin. */
  sgstin: string;
  /** Header docno. */
  docno: string;
  /** Header docdate. */
  docdate: string;
  /** Header totinvval. */
  totinvval: string;
  /** Header upiid. */
  upiid?: string;
  /** Header bankaccno. */
  bankaccno: string;
  /** Header bankifsccode. */
  bankifsccode: string;
  /** Header accountholdername. */
  accountholdername: string;
  /** Header igstamount. */
  igstamount: string;
  /** Header cgstamount. */
  cgstamount: string;
  /** Header sgstamount. */
  sgstamount: string;
  /** Header cessamount. */
  cessamount: string;
}

/**
 * Get B2C QR Code Details
 * GET /einvoice/qrcode
 * Public: no session is needed.
 */
export async function einvoiceQrcode(config: Config, args: EinvoiceQrcodeArgs): Promise<unknown> {
  requireArea(config, "einvoice");
  const build = (): Call => ({
    method: "GET",
    path: "/einvoice/qrcode",
    query: {
      "email": config.email,
    },
    headers: {
      "ip_address": config.ipAddress,
      "client_id": config.einvClientId,
      "client_secret": config.einvClientSecret,
      "username": config.einvNicUsername,
      "sgstin": args.sgstin,
      "docno": args.docno,
      "docdate": args.docdate,
      "totinvval": args.totinvval,
      "upiid": args.upiid,
      "bankaccno": args.bankaccno,
      "bankifsccode": args.bankifsccode,
      "accountholdername": args.accountholdername,
      "igstamount": args.igstamount,
      "cgstamount": args.cgstamount,
      "sgstamount": args.sgstamount,
      "cessamount": args.cessamount,
    },
  });
  return withRetries(() => send(config, build()));
}
