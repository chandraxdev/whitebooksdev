// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, withRetries, type EwaybillSession } from "../session.js";

export interface EwbGetewaybillsfortransporterbystateArgs {
  /** Query parameter stateCode. */
  stateCode: string;
  /** Query parameter date. */
  date: string;
}

/**
 * Get eway bill assigned to you (requesting GSTIN) for transportation – Particular State and Date
 * GET /ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbystate
 */
export async function ewbGetewaybillsfortransporterbystate(session: EwaybillSession, args: EwbGetewaybillsfortransporterbystateArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ewaybillapi/v1.03/ewayapi/getewaybillsfortransporterbystate",
    query: {
      "email": config.email,
      "stateCode": args.stateCode,
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
