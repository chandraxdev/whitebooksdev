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

export interface ImsGetfileArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter token. */
  token: string;
}

/**
 * Get IMS data
 * GET /ims/getfile
 */
export async function imsGetfile(session: GstSession, args: ImsGetfileArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/getfile",
    query: {
      "gstin": args.gstin,
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

export interface ImsInvoicesArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter section. */
  section: string;
  /** Query parameter status. */
  status?: string;
}

/**
 * Get IMS data
 * GET /ims/invoices
 */
export async function imsInvoices(session: GstSession, args: ImsInvoicesArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/invoices",
    query: {
      "gstin": args.gstin,
      "section": args.section,
      "email": config.email,
      "status": args.status,
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

export interface ImsInvoicescountArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter goodsType. */
  goodsType: string;
}

/**
 * Get IMS Count data
 * GET /ims/invoicescount
 */
export async function imsInvoicescount(session: GstSession, args: ImsInvoicescountArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/invoicescount",
    query: {
      "gstin": args.gstin,
      "goodsType": args.goodsType,
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

export interface ImsRejectedinvoicesArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter section. */
  section?: string;
}

/**
 * Get Added Back Liability Records
 * GET /ims/rejectedInvoices
 */
export async function imsRejectedinvoices(session: GstSession, args: ImsRejectedinvoicesArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/rejectedInvoices",
    query: {
      "gstin": args.gstin,
      "email": config.email,
      "retperiod": args.retperiod,
      "section": args.section,
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

export interface ImsStatusArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter int_tran_id. */
  intTranId: string;
}

/**
 * Get IMS Status
 * GET /ims/status
 */
export async function imsStatus(session: GstSession, args: ImsStatusArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/status",
    query: {
      "gstin": args.gstin,
      "int_tran_id": args.intTranId,
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

export interface ImsSupplierinvoicesArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter section. */
  section: string;
  /** Query parameter rtnTyp. */
  rtnTyp: string;
}

/**
 * Get Supplier IMS Invoices data
 * GET /ims/supplierInvoices
 */
export async function imsSupplierinvoices(session: GstSession, args: ImsSupplierinvoicesArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ims/supplierInvoices",
    query: {
      "gstin": args.gstin,
      "email": config.email,
      "retperiod": args.retperiod,
      "section": args.section,
      "rtnTyp": args.rtnTyp,
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

export interface ImsResetArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Reset IMS Data
 * PUT /ims/reset
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function imsReset(session: GstSession, args: ImsResetArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/ims/reset",
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

export interface ImsSaveArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save IMS Data
 * PUT /ims/save
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function imsSave(session: GstSession, args: ImsSaveArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/ims/save",
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
