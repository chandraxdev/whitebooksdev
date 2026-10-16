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

export interface PaymentChllnlstArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter fromdate. */
  fromdate: string;
  /** Query parameter todate. */
  todate: string;
}

/**
 * Get Challan History
 * GET /payment/chllnlst
 */
export async function paymentChllnlst(session: GstSession, args: PaymentChllnlstArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/payment/chllnlst",
    query: {
      "gstin": args.gstin,
      "fromdate": args.fromdate,
      "todate": args.todate,
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

export interface PaymentChllnsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter cpin. */
  cpin: string;
}

/**
 * Get Challan Summary
 * GET /payment/chllnsum
 */
export async function paymentChllnsum(session: GstSession, args: PaymentChllnsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/payment/chllnsum",
    query: {
      "gstin": args.gstin,
      "cpin": args.cpin,
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

export interface PaymentGeneratechallanArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Generate Challan
 * POST /payment/generateChallan
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function paymentGeneratechallan(session: GstSession, args: PaymentGeneratechallanArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("paymentGeneratechallan (POST /payment/generateChallan)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/payment/generateChallan",
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

export interface PaymentValidatechlnrsnArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Validate Challan Reason
 * POST /payment/validatechlnrsn
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 */
export async function paymentValidatechlnrsn(session: GstSession, args: PaymentValidatechlnrsnArgs, body: unknown): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/payment/validatechlnrsn",
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
