// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";

export interface NoticesNoticedetailsArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter refId. */
  refId: string;
}

/**
 * Get Notice Details
 * GET /notices/noticedetails
 */
export async function noticesNoticedetails(session: GstSession, args: NoticesNoticedetailsArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/notices/noticedetails",
    query: {
      "gstin": args.gstin,
      "refId": args.refId,
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

export interface NoticesNoticelistArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter date. */
  date: string;
}

/**
 * Get List Of Notices
 * GET /notices/noticelist
 */
export async function noticesNoticelist(session: GstSession, args: NoticesNoticelistArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/notices/noticelist",
    query: {
      "gstin": args.gstin,
      "date": args.date,
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
