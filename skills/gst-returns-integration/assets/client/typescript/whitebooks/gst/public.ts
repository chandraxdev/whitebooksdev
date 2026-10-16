// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode, requireArea, type Config } from "../config.js";
import { send, type Call, withRetries } from "../session.js";

export interface PublicPrefArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter fy. */
  fy: string;
}

/**
 * Get Preference
 * GET /public/pref
 * Public: no session is needed.
 */
export async function publicPref(config: Config, args: PublicPrefArgs): Promise<unknown> {
  requireArea(config, "public");
  const build = (): Call => ({
    method: "GET",
    path: "/public/pref",
    query: {
      "gstin": args.gstin,
      "fy": args.fy,
      "email": config.email,
    },
    headers: {
      "state_cd": stateCode(config.gstGstin),
      "ip_address": config.ipAddress,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => send(config, build()));
}

export interface PublicRettrackArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter fy. */
  fy: string;
  /** Query parameter type. */
  type?: string;
}

/**
 * View and Track Returns
 * GET /public/rettrack
 * Public: no session is needed.
 */
export async function publicRettrack(config: Config, args: PublicRettrackArgs): Promise<unknown> {
  requireArea(config, "public");
  const build = (): Call => ({
    method: "GET",
    path: "/public/rettrack",
    query: {
      "gstin": args.gstin,
      "fy": args.fy,
      "type": args.type,
      "email": config.email,
    },
    headers: {
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => send(config, build()));
}

export interface PublicSearchArgs {
  /** Query parameter gstin. */
  gstin: string;
}

/**
 * Search Taxpayer
 * GET /public/search
 * Public: no session is needed.
 */
export async function publicSearch(config: Config, args: PublicSearchArgs): Promise<unknown> {
  requireArea(config, "public");
  const build = (): Call => ({
    method: "GET",
    path: "/public/search",
    query: {
      "email": config.email,
      "gstin": args.gstin,
    },
    headers: {
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => send(config, build()));
}

export interface PublicUnregisteredApplicantsArgs {
  /** Query parameter uid. */
  uid: string;
}

/**
 * Unregistered Applicants API
 * GET /public/unregistered-applicants
 * Public: no session is needed.
 */
export async function publicUnregisteredApplicants(config: Config, args: PublicUnregisteredApplicantsArgs): Promise<unknown> {
  requireArea(config, "public");
  const build = (): Call => ({
    method: "GET",
    path: "/public/unregistered-applicants",
    query: {
      "uid": args.uid,
      "email": config.email,
    },
    headers: {
      "ip_address": config.ipAddress,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => send(config, build()));
}

export interface PublicUnregisteredApplicantsValidationArgs {
  /** Query parameter uid. */
  uid: string;
  /** Query parameter ecomEmail. */
  ecomEmail?: string;
  /** Query parameter mobile. */
  mobile?: string;
}

/**
 * Unregistered Applicants Validation
 * GET /public/unregistered-applicants-validation
 * Public: no session is needed.
 */
export async function publicUnregisteredApplicantsValidation(config: Config, args: PublicUnregisteredApplicantsValidationArgs): Promise<unknown> {
  requireArea(config, "public");
  const build = (): Call => ({
    method: "GET",
    path: "/public/unregistered-applicants-validation",
    query: {
      "uid": args.uid,
      "ecomEmail": args.ecomEmail,
      "mobile": args.mobile,
      "email": config.email,
    },
    headers: {
      "ip_address": config.ipAddress,
      "client_id": config.gstClientId,
      "client_secret": config.gstClientSecret,
    },
  });
  return withRetries(() => send(config, build()));
}
