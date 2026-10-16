// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ./errors and ./session).

import { WhiteBooksError, findKey } from "./errors.js";
import { sleep } from "./session.js";

export interface IrreversibleOptions {
  /** Must be true to send an operation that cannot be undone upstream: filing, cancelling, ledger offsets, e-Way Bill updates. */
  confirmIrreversible?: boolean;
}

/** Refuse, before any network call, to send an irreversible operation the caller has not explicitly confirmed. */
export function assertIrreversibleConfirmed(operation: string, opts: IrreversibleOptions): void {
  if (opts.confirmIrreversible === true) return;
  throw new WhiteBooksError({
    source: "client",
    code: "IRREVERSIBLE_NOT_CONFIRMED",
    message: operation + " cannot be undone; pass { confirmIrreversible: true } only after the user has confirmed this exact operation",
    unknown: false,
  });
}

export const DEFAULT_RECONCILE_INTERVAL_MS = 600_000;
export const DEFAULT_MAX_ATTEMPTS = 3;

export interface WriteOptions<S> extends IrreversibleOptions {
  /** Arguments of the status operation that tells whether the write landed. Without them an unknown outcome is never repeated. */
  reconcile?: S;
  /**
   * True when a status reply proves the write landed. A reply that does not satisfy it leaves the outcome unknown
   * (no landed report, no resend). Defaults: e-Invoice a reply with Irn; e-Way Bill a reply with ewayBillNo or ewbNo.
   * GST has no default: see isReturnProcessed.
   */
  landed?: (response: unknown) => boolean;
  /** Minimum wait before each status check and between writes. Default 10 minutes. */
  minIntervalMs?: number;
  /** Writes and status checks together; default 3. */
  maxAttempts?: number;
  sleep?: (ms: number) => Promise<void>;
}

export interface ReconcilePolicy {
  landed?: (response: unknown) => boolean;
  /** The NIC error code that positively says the document does not exist. Only this code allows a resend. */
  notFoundCode?: string;
}

/**
 * Whether a retstatus reply says the return was processed: data.status_cd is P or PE. Pass it as opts.landed together with
 * opts.reconcile when the refid came from the save response of THIS return. GSTR-1 retsave answers with data.reference_id only when
 * it returns; if it times out there is no data.reference_id, retstatus cannot be asked about it, and the write ends in
 * WRITE_OUTCOME_UNKNOWN. A refid the caller held from an earlier save is stale and proves nothing about this one, which is
 * why GST reconciles only when opts.landed is given.
 */
export const isReturnProcessed = (response: unknown): boolean => {
  const data = findKey(response, "data");
  const code = findKey(data !== null && typeof data === "object" ? data : response, "status_cd");
  return code === "P" || code === "PE";
};

export const hasIrn = (response: unknown): boolean => typeof findKey(response, "Irn") === "string";

export const hasEwayBillNo = (response: unknown): boolean => {
  const no = findKey(response, "ewayBillNo") ?? findKey(response, "ewbNo");
  return typeof no === "string" || typeof no === "number";
};

const isUnknown = (err: unknown): boolean => err instanceof WhiteBooksError && err.unknown;

/**
 * Send the write once. If the outcome is unknown, wait minIntervalMs, ask the status operation, and treat the write as
 * landed only when opts.landed (or the API default) says the reply proves it. A status call that succeeds without proof, or
 * fails for any reason (429, 401, session expiry, a bad argument, a 5xx), leaves the outcome unknown and never causes a
 * resend. Only the policy's not-found code (e-Invoice 2154) proves nothing landed and allows a resend, at least
 * minIntervalMs after the previous try, up to maxAttempts. e-Way Bill and GST document no not-found code, so they never
 * resend. Without a status check the unknown outcome ends in WRITE_OUTCOME_UNKNOWN.
 */
export async function reconcileWrite(
  write: () => Promise<unknown>,
  check: (() => Promise<unknown>) | undefined,
  opts: WriteOptions<unknown>,
  policy: ReconcilePolicy,
): Promise<unknown> {
  const minIntervalMs = opts.minIntervalMs ?? DEFAULT_RECONCILE_INTERVAL_MS;
  const maxAttempts = opts.maxAttempts ?? DEFAULT_MAX_ATTEMPTS;
  const wait = opts.sleep ?? sleep;
  const landed = opts.landed ?? policy.landed;
  const unknownError = (): WhiteBooksError =>
    new WhiteBooksError({ source: "client", code: "WRITE_OUTCOME_UNKNOWN", message: "the write did not complete; its outcome is unknown", unknown: true });
  if (check === undefined || landed === undefined) {
    try {
      return await write();
    } catch (err) {
      throw isUnknown(err) ? unknownError() : err;
    }
  }
  let needsWrite = true;
  let notFound = false;
  for (let attempt = 1; attempt <= maxAttempts; attempt++) {
    if (needsWrite) {
      try {
        return await write();
      } catch (err) {
        if (!isUnknown(err)) throw err;
      }
    }
    await wait(minIntervalMs);
    try {
      const response = await check();
      if (landed(response)) return response;
      needsWrite = false;
      notFound = false;
    } catch (err) {
      notFound = policy.notFoundCode !== undefined && err instanceof WhiteBooksError && err.source === "nic" && err.code === policy.notFoundCode;
      needsWrite = notFound;
    }
  }
  throw new WhiteBooksError({
    source: "client",
    code: notFound ? "WRITE_NOT_LANDED" : "WRITE_OUTCOME_UNKNOWN",
    message: "the write did not complete after " + maxAttempts + " attempts" + (notFound ? "" : "; its outcome is unknown"),
    unknown: !notFound,
  });
}
