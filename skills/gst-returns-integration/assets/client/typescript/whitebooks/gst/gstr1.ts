// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";
import { reconcileWrite, type WriteOptions, assertIrreversibleConfirmed } from "../reconcile.js";
import { type Gstr1SaveRequest } from "./models.js";
import { gstrRetstatus, type GstrRetstatusArgs } from "../gst/gstr.js";

export interface Gstr1AtArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get AT
 * GET /gstr1/at
 */
export async function gstr1At(session: GstSession, args: Gstr1AtArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/at",
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

export interface Gstr1AtaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get ATA
 * GET /gstr1/ata
 */
export async function gstr1Ata(session: GstSession, args: Gstr1AtaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/ata",
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

export interface Gstr1B2bArgs {
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
 * GET /gstr1/b2b
 */
export async function gstr1B2b(session: GstSession, args: Gstr1B2bArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2b",
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

export interface Gstr1B2baArgs {
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
 * GET /gstr1/b2ba
 */
export async function gstr1B2ba(session: GstSession, args: Gstr1B2baArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2ba",
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

export interface Gstr1B2clArgs {
  /** Query parameter statecd. */
  statecd?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get B2CL Invoices
 * GET /gstr1/b2cl
 */
export async function gstr1B2cl(session: GstSession, args: Gstr1B2clArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2cl",
    query: {
      "statecd": args.statecd,
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

export interface Gstr1B2claArgs {
  /** Query parameter statecd. */
  statecd?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get B2CLA Invoices
 * GET /gstr1/b2cla
 */
export async function gstr1B2cla(session: GstSession, args: Gstr1B2claArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2cla",
    query: {
      "statecd": args.statecd,
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

export interface Gstr1B2csArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get B2CS Invoices
 * GET /gstr1/b2cs
 */
export async function gstr1B2cs(session: GstSession, args: Gstr1B2csArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2cs",
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

export interface Gstr1B2csaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get B2CSA Invoices
 * GET /gstr1/b2csa
 */
export async function gstr1B2csa(session: GstSession, args: Gstr1B2csaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/b2csa",
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

export interface Gstr1CdnrArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get CDNR Invoices
 * GET /gstr1/cdnr
 */
export async function gstr1Cdnr(session: GstSession, args: Gstr1CdnrArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/cdnr",
    query: {
      "email": config.email,
      "actionrequired": args.actionrequired,
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

export interface Gstr1CdnraArgs {
  /** Query parameter actionrequired. */
  actionrequired?: string;
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get CDNRA Invoices
 * GET /gstr1/cdnra
 */
export async function gstr1Cdnra(session: GstSession, args: Gstr1CdnraArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/cdnra",
    query: {
      "actionrequired": args.actionrequired,
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

export interface Gstr1CdnurArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
 * GET /gstr1/cdnur
 */
export async function gstr1Cdnur(session: GstSession, args: Gstr1CdnurArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/cdnur",
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

export interface Gstr1CdnuraArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * API call for getting all amended Credit/ Debit Notes issued to un-registered persons for a return period.
 * GET /gstr1/cdnura
 */
export async function gstr1Cdnura(session: GstSession, args: Gstr1CdnuraArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/cdnura",
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

export interface Gstr1DocissArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get GSTR1 Document Issued
 * GET /gstr1/dociss
 */
export async function gstr1Dociss(session: GstSession, args: Gstr1DocissArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/dociss",
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

export interface Gstr1EcomArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter rtin. */
  rtin?: string;
  /** Query parameter subsection. */
  subsection?: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get ECOM Invoices
 * GET /gstr1/ecom
 */
export async function gstr1Ecom(session: GstSession, args: Gstr1EcomArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/ecom",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "rtin": args.rtin,
      "subsection": args.subsection,
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

export interface Gstr1EcomaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter rtin. */
  rtin?: string;
  /** Query parameter subsection. */
  subsection?: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get ECOMA Invoices
 * GET /gstr1/ecoma
 */
export async function gstr1Ecoma(session: GstSession, args: Gstr1EcomaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/ecoma",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "rtin": args.rtin,
      "subsection": args.subsection,
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

export interface Gstr1EinvoiceArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter sec. */
  sec: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get E-Invoices
 * GET /gstr1/einvoice
 */
export async function gstr1Einvoice(session: GstSession, args: Gstr1EinvoiceArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/einvoice",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "sec": args.sec,
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

export interface Gstr1ExpArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get EXP
 * GET /gstr1/exp
 */
export async function gstr1Exp(session: GstSession, args: Gstr1ExpArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/exp",
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

export interface Gstr1ExpaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get EXPA
 * GET /gstr1/expa
 */
export async function gstr1Expa(session: GstSession, args: Gstr1ExpaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/expa",
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

export interface Gstr1HsnsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get HSN Summary details
 * GET /gstr1/hsnsum
 */
export async function gstr1Hsnsum(session: GstSession, args: Gstr1HsnsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/hsnsum",
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

export interface Gstr1NilArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get Nil Rated Supplies
 * GET /gstr1/nil
 */
export async function gstr1Nil(session: GstSession, args: Gstr1NilArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/nil",
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

export interface Gstr1RetsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter smrytyp. */
  smrytyp?: string;
}

/**
 * Get GSTR1 Summary
 * GET /gstr1/retsum
 */
export async function gstr1Retsum(session: GstSession, args: Gstr1RetsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/retsum",
    query: {
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "email": config.email,
      "smrytyp": args.smrytyp,
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

export interface Gstr1SupecoArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter subsection. */
  subsection?: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get Supplier ECO invoices
 * GET /gstr1/supeco
 */
export async function gstr1Supeco(session: GstSession, args: Gstr1SupecoArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/supeco",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "subsection": args.subsection,
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

export interface Gstr1SupecoaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
  /** Query parameter subsection. */
  subsection?: string;
  /** Query parameter fromtime. */
  fromtime?: string;
}

/**
 * Get Supplier ECOA invoices
 * GET /gstr1/supecoa
 */
export async function gstr1Supecoa(session: GstSession, args: Gstr1SupecoaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/supecoa",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "retperiod": args.retperiod,
      "subsection": args.subsection,
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

export interface Gstr1TxpArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get TXP
 * GET /gstr1/txp
 */
export async function gstr1Txp(session: GstSession, args: Gstr1TxpArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/txp",
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

export interface Gstr1TxpaArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Get TXPA
 * GET /gstr1/txpa
 */
export async function gstr1Txpa(session: GstSession, args: Gstr1TxpaArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/txpa",
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

export interface Gstr1ValidatehsnsumArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter retperiod. */
  retperiod: string;
}

/**
 * Validate the HSN Summary details
 * GET /gstr1/validatehsnsum
 */
export async function gstr1Validatehsnsum(session: GstSession, args: Gstr1ValidatehsnsumArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/gstr1/validatehsnsum",
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

export interface Gstr1ResetArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Reset GSTR1 Data
 * POST /gstr1/reset
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function gstr1Reset(session: GstSession, args: Gstr1ResetArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr1/reset",
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

export interface Gstr1RetevcfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter evcotp. */
  evcotp: string;
}

/**
 * File GSTR1 data
 * POST /gstr1/retevcfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr1Retevcfile(session: GstSession, args: Gstr1RetevcfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr1Retevcfile (POST /gstr1/retevcfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr1/retevcfile",
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

export interface Gstr1RetfileArgs {
  /** Header ret_period. */
  retPeriod: string;
  /** Query parameter pan. */
  pan: string;
}

/**
 * File GSTR1 data
 * POST /gstr1/retfile
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 * Irreversible: this cannot be undone. It throws IRREVERSIBLE_NOT_CONFIRMED before any network call unless
 * opts.confirmIrreversible is true; pass that only after the user has confirmed this exact operation and document.
 */
export async function gstr1Retfile(session: GstSession, args: Gstr1RetfileArgs, body: unknown, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  assertIrreversibleConfirmed("gstr1Retfile (POST /gstr1/retfile)", opts);
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/gstr1/retfile",
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

export interface Gstr1RetsaveArgs {
  /** Header ret_period. */
  retPeriod: string;
}

/**
 * Save GSTR1 data
 * PUT /gstr1/retsave
 * Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with waitForStatus.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 * GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
 * A status check runs only with opts.landed (see isReturnProcessed) and a refid from this return's own save.
 */
export async function gstr1Retsave(session: GstSession, args: Gstr1RetsaveArgs, body: Gstr1SaveRequest, opts: WriteOptions<GstrRetstatusArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "PUT",
    path: "/gstr1/retsave",
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
