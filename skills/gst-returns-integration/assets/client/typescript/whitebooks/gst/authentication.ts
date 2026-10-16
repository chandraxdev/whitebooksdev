// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { stateCode } from "../config.js";
import { type Call, withRetries, type GstSession } from "../session.js";

export interface AuthenticationOtpforevcArgs {
  /** Query parameter gstin. */
  gstin: string;
  /** Query parameter pan. */
  pan: string;
  /** Query parameter form_type. */
  formType: string;
}

/**
 * Initiate OTP for EVC
 * GET /authentication/otpforevc
 */
export async function authenticationOtpforevc(session: GstSession, args: AuthenticationOtpforevcArgs): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "GET",
    path: "/authentication/otpforevc",
    query: {
      "email": config.email,
      "gstin": args.gstin,
      "pan": args.pan,
      "form_type": args.formType,
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
