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

export interface LedgersBalArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get Cash ITC Balance
 * GET /ledgers/bal
 */
export async function ledgersBal(session: GstSession, args: LedgersBalArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/bal",
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

export interface LedgersCashdtlArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Cash Ledger Details
 * GET /ledgers/cashdtl
 */
export async function ledgersCashdtl(session: GstSession, args: LedgersCashdtlArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/cashdtl",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersItcArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * ITC Ledger Details
 * GET /ledgers/itc
 */
export async function ledgersItc(session: GstSession, args: LedgersItcArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/itc",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersItcblocktrandetlsArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Get Block Unblock
 * GET /ledgers/itcblocktrandetls
 */
export async function ledgersItcblocktrandetls(session: GstSession, args: LedgersItcblocktrandetlsArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/itcblocktrandetls",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersNegliabstmtArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Get NegativeLiability Details of GSTR3B
 * GET /ledgers/negliabstmt
 */
export async function ledgersNegliabstmt(session: GstSession, args: LedgersNegliabstmtArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/negliabstmt",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersRcmldgArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Get RCM Statement
 * GET /ledgers/rcmldg
 */
export async function ledgersRcmldg(session: GstSession, args: LedgersRcmldgArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/rcmldg",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersRevrclmdtlArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Get Credit Reversal and Re-claimed Details
 * GET /ledgers/revrclmdtl
 */
export async function ledgersRevrclmdtl(session: GstSession, args: LedgersRevrclmdtlArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/revrclmdtl",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersTaxArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter frdt. */
  frdt: string;
  /** Query parameter todt. */
  todt: string;
}

/**
 * Get Liability Ledger Details
 * GET /ledgers/tax
 */
export async function ledgersTax(session: GstSession, args: LedgersTaxArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/tax",
    query: {
      "gstin": args.gstin,
      "frdt": args.frdt,
      "todt": args.todt,
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

export interface LedgersTaxpayableArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter rettype. */
  rettype: string;
}

/**
 * Get RetLiab Balance
 * GET /ledgers/taxpayable
 */
export async function ledgersTaxpayable(session: GstSession, args: LedgersTaxpayableArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/ledgers/taxpayable",
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

export interface LedgersUtlcshArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Utilize Cash
 * POST /ledgers/utlcsh
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function ledgersUtlcsh(session: GstSession, args: LedgersUtlcshArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("ledgersUtlcsh (POST /ledgers/utlcsh)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/ledgers/utlcsh",
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

export interface LedgersUtlitcArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Utilize ITC
 * POST /ledgers/utlitc
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function ledgersUtlitc(session: GstSession, args: LedgersUtlitcArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("ledgersUtlitc (POST /ledgers/utlitc)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/ledgers/utlitc",
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
