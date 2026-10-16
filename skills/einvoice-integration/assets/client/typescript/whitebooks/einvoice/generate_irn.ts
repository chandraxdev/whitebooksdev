// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area einvoice
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, type EinvoiceSession } from "../session.js";
import { reconcileWrite, type WriteOptions, hasIrn } from "../reconcile.js";
import { type EinvoiceGenerateRequest } from "./models.js";
import { einvoiceGetirnbydocdetails, type EinvoiceGetirnbydocdetailsArgs } from "../einvoice/get_irn_details_by_doc_details.js";

/**
 * Generate IRN
 * POST /einvoice/type/GENERATE/version/V1_03
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 */
export async function einvoiceGenerate(session: EinvoiceSession, body: EinvoiceGenerateRequest, opts: WriteOptions<EinvoiceGetirnbydocdetailsArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/einvoice/type/GENERATE/version/V1_03",
    query: {
      "email": config.email,
    },
    headers: {
      "ip_address": session.ipAddress,
      "client_id": config.einvClientId,
      "client_secret": config.einvClientSecret,
      "username": config.einvNicUsername,
      "auth-token": session.authToken,
      "gstin": config.einvGstin,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => einvoiceGetirnbydocdetails(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, { landed: hasIrn, notFoundCode: "2154" });
}
