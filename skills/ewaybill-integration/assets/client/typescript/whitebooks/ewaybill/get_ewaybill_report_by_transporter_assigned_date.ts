// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, withRetries, type EwaybillSession } from "../session.js";

export interface EwbGetewaybillreportbytransporterassigneddateArgs {
  /** Query parameter date. */
  date: string;
  /** Query parameter stateCode. */
  stateCode: string;
}

/**
 * Get eway bill assigned to you (requesting GSTIN) for a transportation - Particular Date
 * GET /ewaybillapi/v1.03/ewayapi/getewaybillreportbytransporterassigneddate
 */
export async function ewbGetewaybillreportbytransporterassigneddate(session: EwaybillSession, args: EwbGetewaybillreportbytransporterassigneddateArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ewaybillapi/v1.03/ewayapi/getewaybillreportbytransporterassigneddate",
    query: {
      "email": config.email,
      "date": args.date,
      "stateCode": args.stateCode,
    },
    headers: {
      "ip_address": session.ipAddress,
      "client_id": config.ewbClientId,
      "client_secret": config.ewbClientSecret,
      "username": config.ewbNicUsername,
      "gstin": config.ewbGstin,
    },
  });
  return withRetries(() => session.call(build));
}
