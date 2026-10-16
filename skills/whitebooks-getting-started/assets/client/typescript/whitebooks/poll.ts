// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (uses ./errors and ./session).

import { WhiteBooksError, findKey } from "./errors.js";
import { sleep } from "./session.js";

export interface WaitOptions {
  /** Give up after this long. Default 120 s. */
  deadlineMs?: number;
  /** First pause between polls; doubles up to maxIntervalMs. Default 5 s. */
  intervalMs?: number;
  maxIntervalMs?: number;
  /** Decides whether a status response is final. The default reads data.status_cd, then the top level, and accepts P, PE or ER. */
  isDone?: (response: unknown) => boolean;
  sleep?: (ms: number) => Promise<void>;
}

const defaultIsDone = (response: unknown): boolean => {
  const data = findKey(response, "data");
  const code = findKey(data !== null && typeof data === "object" ? data : response, "status_cd");
  return code === "P" || code === "PE" || code === "ER";
};

/** Call fetchStatus (which asks the status operation about the reference_id of the saved return) until the answer is final or the deadline passes. */
export async function waitForStatus(fetchStatus: () => Promise<unknown>, opts: WaitOptions = {}): Promise<unknown> {
  const deadlineMs = opts.deadlineMs ?? 120_000;
  const maxIntervalMs = opts.maxIntervalMs ?? 20_000;
  const isDone = opts.isDone ?? defaultIsDone;
  const wait = opts.sleep ?? sleep;
  const startedAt = Date.now();
  let interval = opts.intervalMs ?? 5_000;
  for (;;) {
    const response = await fetchStatus();
    if (isDone(response)) return response;
    if (Date.now() - startedAt + interval > deadlineMs) {
      throw new WhiteBooksError({ source: "client", code: "POLL_DEADLINE", message: "status still not final after " + deadlineMs + " ms", unknown: true });
    }
    await wait(interval);
    interval = Math.min(interval * 2, maxIntervalMs);
  }
}
