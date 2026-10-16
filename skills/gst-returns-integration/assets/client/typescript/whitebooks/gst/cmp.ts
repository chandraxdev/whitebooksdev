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

export interface CmpGetcmpArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get CMP
 * GET /cmp/getcmp
 */
export async function cmpGetcmp(session: GstSession, args: CmpGetcmpArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/cmp/getcmp",
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

export interface CmpValidateturnoverArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get validate turnover for CMP
 * GET /cmp/validateturnover
 */
export async function cmpValidateturnover(session: GstSession, args: CmpValidateturnoverArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/cmp/validateturnover",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
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

export interface CmpRetevcfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter evcotp. */
  evcotp: string;
}

/**
 * File CMP data
 * POST /cmp/retevcfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function cmpRetevcfile(session: GstSession, args: CmpRetevcfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("cmpRetevcfile (POST /cmp/retevcfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/cmp/retevcfile",
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

export interface CmpRetfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
}

/**
 * File CMP data
 * POST /cmp/retfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function cmpRetfile(session: GstSession, args: CmpRetfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("cmpRetfile (POST /cmp/retfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/cmp/retfile",
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

export interface CmpSavecmpArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save CMP
 * POST /cmp/savecmp
 * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function cmpSavecmp(session: GstSession, args: CmpSavecmpArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/cmp/savecmp",
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
