// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

export type ErrorSource = "whitebooks" | "gstn" | "nic" | "upstream" | "http" | "client";

export interface WhiteBooksErrorInit {
  source: ErrorSource;
  code: string;
  message: string;
  httpStatus?: number;
  /** True when the call may or may not have taken effect (timeout, network failure, 5xx). Unknown is never success. */
  unknown?: boolean;
  correlationId?: string;
}

export class WhiteBooksError extends Error {
  readonly source: ErrorSource;
  readonly code: string;
  readonly httpStatus: number | undefined;
  readonly unknown: boolean;
  correlationId: string | undefined;

  constructor(init: WhiteBooksErrorInit) {
    super(init.message);
    this.name = "WhiteBooksError";
    this.source = init.source;
    this.code = init.code;
    this.httpStatus = init.httpStatus;
    this.unknown = init.unknown ?? false;
    this.correlationId = init.correlationId;
  }
}

/** Find the first value stored under `key` in a parsed JSON value, searching a few levels deep. */
export function findKey(value: unknown, key: string, depth = 4): unknown {
  if (depth < 0 || value === null || typeof value !== "object") return undefined;
  if (Array.isArray(value)) {
    for (const item of value) {
      const hit = findKey(item, key, depth - 1);
      if (hit !== undefined) return hit;
    }
    return undefined;
  }
  const record = value as Record<string, unknown>;
  if (key in record) return record[key];
  for (const inner of Object.values(record)) {
    const hit = findKey(inner, key, depth - 1);
    if (hit !== undefined) return hit;
  }
  return undefined;
}

const text = (v: unknown): string => (typeof v === "string" ? v : typeof v === "number" ? String(v) : "");

/**
 * Turn a response into a typed error, or return undefined when it is a success.
 * Handles the WhiteBooks envelope (status_cd 0 plus status_desc WB_ERR_xxxx : ...), GSTN error.error_cd and NIC ErrorDetails.
 */
export function parseFailure(httpStatus: number, body: string): WhiteBooksError | undefined {
  const serverSide = httpStatus >= 500;
  let parsed: unknown;
  try {
    parsed = body.length === 0 ? null : JSON.parse(body);
  } catch {
    if (httpStatus >= 400) {
      return new WhiteBooksError({ source: "http", code: "HTTP_" + httpStatus, message: body.slice(0, 200), httpStatus, unknown: serverSide });
    }
    return new WhiteBooksError({ source: "client", code: "BAD_RESPONSE", message: "response is not JSON", httpStatus, unknown: true });
  }
  const statusCd = findKey(parsed, "status_cd");
  const statusDesc = text(findKey(parsed, "status_desc"));
  const wb = /(WB_ERR_\d+)\s*:?\s*(.*)/.exec(statusDesc);
  if (wb) {
    const code = wb[1] ?? "WB_ERR";
    return new WhiteBooksError({ source: "whitebooks", code, message: statusDesc, httpStatus, unknown: serverSide || code === "WB_ERR_9000" });
  }
  const gstn = findKey(parsed, "error");
  const errorCd = gstn !== null && typeof gstn === "object" ? text(findKey(gstn, "error_cd")) : "";
  if (errorCd !== "") {
    return new WhiteBooksError({ source: "gstn", code: errorCd, message: text(findKey(gstn, "message")) || statusDesc, httpStatus, unknown: serverSide });
  }
  const details = findKey(parsed, "ErrorDetails");
  if (Array.isArray(details) && details.length > 0) {
    const messages = details.map((d) => text(findKey(d, "ErrorMessage"))).filter((m) => m !== "");
    return new WhiteBooksError({ source: "nic", code: text(findKey(details[0], "ErrorCode")) || "NIC_ERROR", message: messages.join("; "), httpStatus, unknown: serverSide });
  }
  if (statusCd === "0" || statusCd === 0 || httpStatus >= 400) {
    return new WhiteBooksError({ source: "upstream", code: httpStatus >= 400 ? "HTTP_" + httpStatus : "UPSTREAM_ERROR", message: statusDesc || body.slice(0, 200), httpStatus, unknown: serverSide });
  }
  return undefined;
}

/** True for errors that mean the session token is no longer valid and the caller should authenticate again. */
export function isSessionExpired(err: unknown): boolean {
  if (!(err instanceof WhiteBooksError)) return false;
  return err.code === "1005" || /(session|token).*(expired|invalid)|expired/i.test(err.message);
}
