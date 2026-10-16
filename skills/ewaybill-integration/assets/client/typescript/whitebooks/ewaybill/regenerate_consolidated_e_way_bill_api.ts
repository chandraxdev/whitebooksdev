// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ../config, ../errors, ../session and ../reconcile).

import { type Call, type EwaybillSession } from "../session.js";
import { reconcileWrite, type WriteOptions, hasEwayBillNo } from "../reconcile.js";
import { ewbGetewaybillgeneratedbyconsigner, type EwbGetewaybillgeneratedbyconsignerArgs } from "../ewaybill/get_ewaybill_by_consigner.js";

/**
 * Regenerate Consolidated E-Way Bill - Api
 * POST /ewaybillapi/v1.03/ewayapi/regentripsheet
 * Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
 * A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
 * (GET /ewaybillapi/v1.03/ewayapi/getewaybillgeneratedbyconsigner); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
 */
export async function ewbRegentripsheet(session: EwaybillSession, body: unknown, opts: WriteOptions<EwbGetewaybillgeneratedbyconsignerArgs> = {}): Promise<unknown> {
  const config = session.config;
  const build = (): Call => ({
    method: "POST",
    path: "/ewaybillapi/v1.03/ewayapi/regentripsheet",
    query: {
      "email": config.email,
    },
    headers: {
      "ip_address": session.ipAddress,
      "client_id": config.ewbClientId,
      "client_secret": config.ewbClientSecret,
      "username": config.ewbNicUsername,
      "gstin": config.ewbGstin,
    },
    body,
  });
  const reconcile = opts.reconcile;
  const check = reconcile === undefined ? undefined : () => ewbGetewaybillgeneratedbyconsigner(session, reconcile);
  return reconcileWrite(() => session.call(build), check, opts, { landed: hasEwayBillNo });
}
