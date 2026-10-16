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

export interface Itc03CloseArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter type. */
  type: string;
}

/**
 * Get ITC03 Invoices
 * GET /itc03/close
 */
export async function itc03Close(session: GstSession, args: Itc03CloseArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/itc03/close",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "type": args.type,
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

export interface Itc03GetinvArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter type. */
  type: string;
  /** Query parameter arnnum. */
  arnnum: string;
}

/**
 * Get ITC03 Invoices
 * GET /itc03/getinv
 */
export async function itc03Getinv(session: GstSession, args: Itc03GetinvArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/itc03/getinv",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "type": args.type,
      "arnnum": args.arnnum,
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

export interface Itc03RetsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter type. */
  type: string;
  /** Query parameter arnnum. */
  arnnum: string;
}

/**
 * Get ITC03 Summary
 * GET /itc03/retsum
 */
export async function itc03Retsum(session: GstSession, args: Itc03RetsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/itc03/retsum",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "email": config.email,
      "type": args.type,
      "arnnum": args.arnnum,
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

export interface Itc03RetevcfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter evcotp. */
  evcotp: string;
  /** Query parameter type. */
  type: string;
}

/**
 * File ITC03 data
 * POST /itc03/retevcfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function itc03Retevcfile(session: GstSession, args: Itc03RetevcfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("itc03Retevcfile (POST /itc03/retevcfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/itc03/retevcfile",
    query: {
      "email": config.email,
      "pan": args.pan,
      "evcotp": args.evcotp,
      "type": args.type,
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

export interface Itc03RetfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter type. */
  type: string;
}

/**
 * File ITC03 data
 * POST /itc03/retfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function itc03Retfile(session: GstSession, args: Itc03RetfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("itc03Retfile (POST /itc03/retfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/itc03/retfile",
    query: {
      "email": config.email,
      "type": args.type,
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

export interface Itc03RetoffsetArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter type. */
  type: string;
}

/**
 * Offset Liability ITC03 data
 * PUT /itc03/retoffset
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function itc03Retoffset(session: GstSession, args: Itc03RetoffsetArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("itc03Retoffset (PUT /itc03/retoffset)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/itc03/retoffset",
    query: {
      "email": config.email,
      "type": args.type,
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

export interface Itc03RetsaveArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter type. */
  type: string;
}

/**
 * Save ITC03 data
 * PUT /itc03/retsave
 * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function itc03Retsave(session: GstSession, args: Itc03RetsaveArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/itc03/retsave",
    query: {
      "email": config.email,
      "type": args.type,
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
