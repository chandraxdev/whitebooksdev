// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";

export interface Gstr6aB2bArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter ctin. */
  ctin?: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get B2B Invoices
 * GET /gstr6a/b2b
 */
export async function gstr6aB2b(session: GstSession, args: Gstr6aB2bArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6a/b2b",
    query: {
      "email": config.email,
      "actionrequired": args.actionrequired,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "ctin": args.ctin,
      "fromtime": args.fromtime,
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

export interface Gstr6aB2baArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter ctin. */
  ctin?: string;
}

/**
 * Get B2BA Invoices
 * GET /gstr6a/b2ba
 */
export async function gstr6aB2ba(session: GstSession, args: Gstr6aB2baArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6a/b2ba",
    query: {
      "email": config.email,
      "actionrequired": args.actionrequired,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "ctin": args.ctin,
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

export interface Gstr6aCdnArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter ctin. */
  ctin?: string;
}

/**
 * Get CDNR Invoices
 * GET /gstr6a/cdn
 */
export async function gstr6aCdn(session: GstSession, args: Gstr6aCdnArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6a/cdn",
    query: {
      "email": config.email,
      "actionrequired": args.actionrequired,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "ctin": args.ctin,
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

export interface Gstr6aCdnaArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter ctin. */
  ctin?: string;
}

/**
 * Get CDNRA Invoices
 * GET /gstr6a/cdna
 */
export async function gstr6aCdna(session: GstSession, args: Gstr6aCdnaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6a/cdna",
    query: {
      "actionrequired": args.actionrequired,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "email": config.email,
      "ctin": args.ctin,
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
