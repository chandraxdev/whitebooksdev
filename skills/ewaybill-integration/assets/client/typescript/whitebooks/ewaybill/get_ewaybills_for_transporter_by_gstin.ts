// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, withRetries, type EwaybillSession } from "../session.js";

export interface EwbGetewaybillsfortransporterbygstinArgs {
  /** Query parameter Gen_gstin. */
  genGstin: string;
  /** Query parameter date. */
  date: string;
}

/**
 * Get eway bill assigned to you (requesting GSTIN) for transportation – Particular GSTIN and Date
 * GET /ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbygstin
 */
export async function ewbGetewaybillsfortransporterbygstin(session: EwaybillSession, args: EwbGetewaybillsfortransporterbygstinArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbygstin",
    query: {
      "email": config.email,
      "Gen_gstin": args.genGstin,
      "date": args.date,
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
