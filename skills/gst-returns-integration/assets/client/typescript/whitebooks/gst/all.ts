// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";
import { reconcileWrite, type WriteOptions } from "../reconcile.js";
import { gstrRetstatus, type GstrRetstatusArgs } from "../gst/gstr.js";

export interface AllDocdwldArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter id. */
  id: string;
}

/**
 * Document Download
 * GET /all/docdwld
 */
export async function allDocdwld(session: GstSession, args: AllDocdwldArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/docdwld",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "id": args.id,
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

export interface AllFiledetArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter returnperiod. */
  returnperiod: string;
  /** Query parameter token. */
  token: string;
}

/**
 * Get File Details
 * GET /all/filedet
 */
export async function allFiledet(session: GstSession, args: AllFiledetArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/filedet",
    query: {
      "gstin": args.gstin,
      "returnperiod": args.returnperiod,
      "token": args.token,
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

export interface AllGetmastersArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter gstin. */
  gstin: string;
}

/**
 * Get User Masters
 * GET /all/getmasters
 */
export async function allGetmasters(session: GstSession, args: AllGetmastersArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/getmasters",
    query: {
      "email": config.email,
      "gstin": args.gstin,
    },
    headers: {
      "ret_period": args.retPeriod,
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

export interface AllGetprefArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter fy. */
  fy: string;
}

/**
 * Get Preference
 * GET /all/getpref
 */
export async function allGetpref(session: GstSession, args: AllGetprefArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/getpref",
    query: {
      "gstin": args.gstin,
      "fy": args.fy,
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

export interface AllLargefileArgs {
  /** Query parameter url. */
  url: string;
  /** Query parameter ek. */
  ek: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter returnperiod. */
  returnperiod: string;
}

/**
 * Get Large File Details
 * GET /all/largefile
 */
export async function allLargefile(session: GstSession, args: AllLargefileArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/largefile",
    query: {
      "url": args.url,
      "ek": args.ek,
      "gstin": args.gstin,
      "returnperiod": args.returnperiod,
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

export interface AllLatefeeArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter rettype. */
  rettype: string;
}

/**
 * Late Fee
 * GET /all/latefee
 */
export async function allLatefee(session: GstSession, args: AllLatefeeArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/latefee",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "rettype": args.rettype,
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

export interface AllLatefeebreakupArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter rettype. */
  rettype: string;
}

/**
 * Get additional late fee breakup
 * GET /all/latefeebreakup
 */
export async function allLatefeebreakup(session: GstSession, args: AllLatefeebreakupArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/latefeebreakup",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "rettype": args.rettype,
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

export interface AllNewproceedfileArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter type. */
  type: string;
  /** Query parameter isNil. */
  isNil?: string;
}

/**
 * New Proceed To File(GSTR1,GSTR5,GSTR6)
 * GET /all/newproceedfile
 */
export async function allNewproceedfile(session: GstSession, args: AllNewproceedfileArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/newproceedfile",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "type": args.type,
      "isNil": args.isNil,
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

export interface AllNewretstatusArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter returnperiod. */
  returnperiod: string;
  /** Query parameter refid. */
  refid: string;
  /** Query parameter rettype. */
  rettype: string;
}

/**
 * Get Return Status
 * GET /all/newretstatus
 */
export async function allNewretstatus(session: GstSession, args: AllNewretstatusArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/newretstatus",
    query: {
      "gstin": args.gstin,
      "returnperiod": args.returnperiod,
      "refid": args.refid,
      "rettype": args.rettype,
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

export interface AllProceedfileArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter type. */
  type: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Proceed To File
 * GET /all/proceedfile
 */
export async function allProceedfile(session: GstSession, args: AllProceedfileArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/all/proceedfile",
    query: {
      "gstin": args.gstin,
      "type": args.type,
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

export interface AllDocupldArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Document Upload
 * POST /all/docupld
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function allDocupld(session: GstSession, args: AllDocupldArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/all/docupld",
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

export interface AllSavemastersArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save User Masters
 * POST /all/savemasters
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function allSavemasters(session: GstSession, args: AllSavemastersArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/all/savemasters",
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

/**
 * Save Preference
 * PUT /all/savepref
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function allSavepref(session: GstSession, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/all/savepref",
    query: {
      "email": config.email,
    },
    headers: {
      "gstin": config.gstGstin,
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
