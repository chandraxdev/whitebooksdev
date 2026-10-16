// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";

export interface GstrRetstatusArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter returnperiod. */
  returnperiod: string;
  /** Query parameter refid. */
  refid: string;
}

/**
 * Get Return Status
 * GET /gstr/retstatus
 */
export async function gstrRetstatus(session: GstSession, args: GstrRetstatusArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr/retstatus",
    query: {
      "gstin": args.gstin,
      "returnperiod": args.returnperiod,
      "refid": args.refid,
      "email": config.email,
    },
    headers: {
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => session.call(build));
}

export interface GstrRettrackArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter returnperiod. */
  returnperiod: string;
  /** Query parameter type. */
  type?: string;
}

/**
 * View and Track Returns
 * GET /gstr/rettrack
 */
export async function gstrRettrack(session: GstSession, args: GstrRettrackArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr/rettrack",
    query: {
      "gstin": args.gstin,
      "returnperiod": args.returnperiod,
      "type": args.type,
      "email": config.email,
    },
    headers: {
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => session.call(build));
}
