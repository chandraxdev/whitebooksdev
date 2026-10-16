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

export interface Gstr4annualAutopopArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get autopopulated data for table 4A/4B of GSTR4 Annual form
 * GET /gstr4annual/autopop
 */
export async function gstr4annualAutopop(session: GstSession, args: Gstr4annualAutopopArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/autopop",
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

export interface Gstr4annualGetsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get summary Invoices
 * GET /gstr4annual/getsum
 */
export async function gstr4annualGetsum(session: GstSession, args: Gstr4annualGetsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/getsum",
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

export interface Gstr4annualTdscmpArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get tdscmp Invoices
 * GET /gstr4annual/tdscmp
 */
export async function gstr4annualTdscmp(session: GstSession, args: Gstr4annualTdscmpArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/tdscmp",
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

export interface Gstr4annualTxiosArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get txios Invoices
 * GET /gstr4annual/txios
 */
export async function gstr4annualTxios(session: GstSession, args: Gstr4annualTxiosArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/txios",
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

export interface Gstr4annualValidateliabilityArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get validate the liability provided in table 6 for GSTR4 Annual form
 * GET /gstr4annual/validateliability
 */
export async function gstr4annualValidateliability(session: GstSession, args: Gstr4annualValidateliabilityArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/validateliability",
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

export interface Gstr4annualValidateturnoverArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get validate turnover for GSTR4 Annual form
 * GET /gstr4annual/validateturnover
 */
export async function gstr4annualValidateturnover(session: GstSession, args: Gstr4annualValidateturnoverArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr4annual/validateturnover",
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

export interface Gstr4annualRetevcfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter evcotp. */
  evcotp: string;
}

/**
 * File GSTR4 Annual data
 * POST /gstr4annual/retevcfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr4annualRetevcfile(session: GstSession, args: Gstr4annualRetevcfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr4annualRetevcfile (POST /gstr4annual/retevcfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr4annual/retevcfile",
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

export interface Gstr4annualRetfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
}

/**
 * File GSTR4Annual data
 * POST /gstr4annual/retfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr4annualRetfile(session: GstSession, args: Gstr4annualRetfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr4annualRetfile (POST /gstr4annual/retfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr4annual/retfile",
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

export interface Gstr4annualRetsaveArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save GSTR4Annual data
 * PUT /gstr4annual/retsave
 * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function gstr4annualRetsave(session: GstSession, args: Gstr4annualRetsaveArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/gstr4annual/retsave",
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
