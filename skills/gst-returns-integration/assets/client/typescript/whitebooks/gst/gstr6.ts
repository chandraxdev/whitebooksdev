// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";
import { reconcileWrite, type WriteOptions, assertIrreversibleConfirmed } from "../reconcile.js";
import { gstrRetstatus, type GstrRetstatusArgs } from "../gst/gstr.js";

export interface Gstr6B2bArgs {
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
 * GET /gstr6/b2b
 */
export async function gstr6B2b(session: GstSession, args: Gstr6B2bArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/b2b",
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

export interface Gstr6B2baArgs {
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
 * GET /gstr6/b2ba
 */
export async function gstr6B2ba(session: GstSession, args: Gstr6B2baArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/b2ba",
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

export interface Gstr6CdnArgs {
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
 * GET /gstr6/cdn
 */
export async function gstr6Cdn(session: GstSession, args: Gstr6CdnArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/cdn",
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

export interface Gstr6CdnaArgs {
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
 * GET /gstr6/cdna
 */
export async function gstr6Cdna(session: GstSession, args: Gstr6CdnaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/cdna",
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

export interface Gstr6IsdArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get ISD Details
 * GET /gstr6/isd
 */
export async function gstr6Isd(session: GstSession, args: Gstr6IsdArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/isd",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
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

export interface Gstr6IsdaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter ctin. */
  ctin?: string;
}

/**
 * Get Amendment ISD Details
 * GET /gstr6/isda
 */
export async function gstr6Isda(session: GstSession, args: Gstr6IsdaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/isda",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "ctin": args.ctin,
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

export interface Gstr6ItcArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get ITC Details
 * GET /gstr6/itc
 */
export async function gstr6Itc(session: GstSession, args: Gstr6ItcArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/itc",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
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

export interface Gstr6LatefeeArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get Late Fee
 * GET /gstr6/latefee
 */
export async function gstr6Latefee(session: GstSession, args: Gstr6LatefeeArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/latefee",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
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

export interface Gstr6RetsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter fnl. */
  fnl: string;
}

/**
 * Get GSTR6 Summary
 * GET /gstr6/retsum
 */
export async function gstr6Retsum(session: GstSession, args: Gstr6RetsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr6/retsum",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "email": config.email,
      "fnl": args.fnl,
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

export interface Gstr6RetcalArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * GSTR6 Calculate R6
 * POST /gstr6/retcal
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 */
export async function gstr6Retcal(session: GstSession, args: Gstr6RetcalArgs, body: unknown): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr6/retcal",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  return withRetries(() => session.call(build));
}

export interface Gstr6RetevcfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter evcotp. */
  evcotp: string;
}

/**
 * File GSTR6 data
 * POST /gstr6/retevcfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr6Retevcfile(session: GstSession, args: Gstr6RetevcfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr6Retevcfile (POST /gstr6/retevcfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr6/retevcfile",
    query: {
      "email": config.email,
      "pan": args.pan,
      "evcotp": args.evcotp,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}

export interface Gstr6RetfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
}

/**
 * File GSTR6 data
 * POST /gstr6/retfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr6Retfile(session: GstSession, args: Gstr6RetfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr6Retfile (POST /gstr6/retfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr6/retfile",
    query: {
      "email": config.email,
      "pan": args.pan,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}

export interface Gstr6RetsubmitArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Submit GSTR6 data
 * POST /gstr6/retsubmit
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr6Retsubmit(session: GstSession, args: Gstr6RetsubmitArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr6Retsubmit (POST /gstr6/retsubmit)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr6/retsubmit",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}

export interface Gstr6SavecrossitcdetailsArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save GSTR6 Cross ITC details
 * POST /gstr6/savecrossitcdetails
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function gstr6Savecrossitcdetails(session: GstSession, args: Gstr6SavecrossitcdetailsArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr6/savecrossitcdetails",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}

export interface Gstr6RetoffsetlatefeeArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Offset Liability GSTR6 Late fee
 * PUT /gstr6/retoffsetlatefee
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr6Retoffsetlatefee(session: GstSession, args: Gstr6RetoffsetlatefeeArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr6Retoffsetlatefee (PUT /gstr6/retoffsetlatefee)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/gstr6/retoffsetlatefee",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}

export interface Gstr6RetsaveArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save GSTR6 data
 * PUT /gstr6/retsave
 * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function gstr6Retsave(session: GstSession, args: Gstr6RetsaveArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/gstr6/retsave",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
      "ret_period": args.retPeriod,
      "gst_username": config.gstUsername,
      "state_cd": stateCode(config.gstGstin),
      "ip_address": session.ipAddress,
      "txn": session.txn,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => gstrRetstatus(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, {});
}
