// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area einvoice
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, withRetries, type EinvoiceSession } from "../session.js";

export interface EinvoiceGetirnbydocdetailsArgs {
  /** Header docnum. */
  docnum: string;
  /** Header docdate. */
  docdate: string;
  /** Query parameter param1. */
  param1: string;
  /** Query parameter supplier_gstn. */
  supplierGstn?: string;
  /** Query parameter irp. */
  irp?: string;
}

/**
 * Get IRN details by Doc Details
 * GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03
 */
export async function einvoiceGetirnbydocdetails(session: EinvoiceSession, args: EinvoiceGetirnbydocdetailsArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/einvoice/type/GETIRNBYDOCDETAILS/version/V1_03",
    query: {
      "param1": args.param1,
      "supplier_gstn": args.supplierGstn,
      "irp": args.irp,
      "email": config.email,
    },
    headers: {
      "docnum": args.docnum,
      "docdate": args.docdate,
      "ip_address": session.ipAddress,
      "client_id": config.einvClientId,
      "client_secret": config.einvClientSecret,
      "username": config.einvNicUsername,
      "auth-token": session.authToken,
      "gstin": config.einvGstin,
    },
  });
  return withRetries(() => session.call(build));
}
