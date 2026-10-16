// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";

export interface GstEinvoiceFiledtlArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter rtnprd. */
  rtnprd: string;
  /** Query parameter token. */
  token: string;
}

/**
 * Get file URL
 * GET /gst/einvoice/filedtl
 */
export async function gstEinvoiceFiledtl(session: GstSession, args: GstEinvoiceFiledtlArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gst/einvoice/filedtl",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "rtnprd": args.rtnprd,
      "token": args.token,
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

export interface GstEinvoiceHsnsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter ret_period. */
  retPeriod: string;
}

/**
 * Get E-Invice HSN Summary
 * GET /gst/einvoice/hsnsum
 */
export async function gstEinvoiceHsnsum(session: GstSession, args: GstEinvoiceHsnsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gst/einvoice/hsnsum",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "ret_period": args.retPeriod,
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

export interface GstEinvoiceIrndtlArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter irn. */
  irn: string;
}

/**
 * Get Json for IRN
 * GET /gst/einvoice/irndtl
 */
export async function gstEinvoiceIrndtl(session: GstSession, args: GstEinvoiceIrndtlArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gst/einvoice/irndtl",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "irn": args.irn,
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

export interface GstEinvoiceIrnjsonsArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter rstinflag. */
  rstinflag?: string;
  /** Query parameter suptyp. */
  suptyp: string;
  /** Query parameter rtnprd. */
  rtnprd: string;
}

/**
 * Get list of IRN Jsons
 * GET /gst/einvoice/irnjsons
 */
export async function gstEinvoiceIrnjsons(session: GstSession, args: GstEinvoiceIrnjsonsArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gst/einvoice/irnjsons",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "rstinflag": args.rstinflag,
      "suptyp": args.suptyp,
      "rtnprd": args.rtnprd,
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

export interface GstEinvoiceIrnlistArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter rstinflag. */
  rstinflag?: string;
  /** Query parameter suptyp. */
  suptyp: string;
  /** Query parameter rtnprd. */
  rtnprd: string;
}

/**
 * Get list of IRNs
 * GET /gst/einvoice/irnlist
 */
export async function gstEinvoiceIrnlist(session: GstSession, args: GstEinvoiceIrnlistArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gst/einvoice/irnlist",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "rstinflag": args.rstinflag,
      "suptyp": args.suptyp,
      "rtnprd": args.rtnprd,
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
