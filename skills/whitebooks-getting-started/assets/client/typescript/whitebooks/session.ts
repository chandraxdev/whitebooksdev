// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (Node >= 20: global fetch, URL, AbortSignal; node:crypto).

import { randomUUID } from "node:crypto";
import { SANDBOX_URL, stateCode, requireArea, type Config } from "./config.js";
import { WhiteBooksError, findKey, isSessionExpired, parseFailure } from "./errors.js";

export interface Call {
  method: string;
  path: string;
  query: Record<string, string | undefined>;
  headers: Record<string, string | undefined>;
  body?: unknown;
}

export const sleep = (ms: number): Promise<void> => new Promise((resolve) => setTimeout(resolve, ms));

/** GSTIN shown as its two-digit state code, asterisks and the last character, so logs carry no full GSTIN. */
export function maskGstin(gstin: string): string {
  if (gstin.length < 4) return "***";
  return gstin.slice(0, 2) + "*".repeat(gstin.length - 3) + gstin.slice(-1);
}

/** One structured log line; the GSTIN of the call, when it carries one, appears only masked. */
function log(call: Call, event: Record<string, unknown>): void {
  const gstin = call.headers["gstin"];
  console.error(JSON.stringify(gstin ? { ...event, gstin: maskGstin(gstin) } : event));
}

/** One HTTP exchange with a deadline. Errors are typed; a timeout or network failure is unknown, never success. */
export async function send(config: Config, call: Call): Promise<unknown> {
  const url = new URL(config.baseUrl.replace(/\/+$/, "") + call.path);
  for (const [key, value] of Object.entries(call.query)) {
    if (value !== undefined) url.searchParams.set(key, value);
  }
  const headers: Record<string, string> = { accept: "application/json" };
  for (const [key, value] of Object.entries(call.headers)) {
    if (value !== undefined) headers[key] = value;
  }
  let body: string | undefined;
  if (call.body !== undefined) {
    body = JSON.stringify(call.body);
    headers["content-type"] = "application/json";
  }
  const correlationId = randomUUID();
  log(call, { event: "request", correlationId, method: call.method, path: call.path });
  let status: number;
  let payload: string;
  try {
    const response = await fetch(url, {
      method: call.method,
      headers,
      ...(body === undefined ? {} : { body }),
      signal: AbortSignal.timeout(config.timeoutMs),
    });
    status = response.status;
    payload = await response.text();
  } catch (cause) {
    const timedOut = cause instanceof Error && (cause.name === "TimeoutError" || cause.name === "AbortError");
    throw new WhiteBooksError({
      source: "client",
      code: timedOut ? "TIMEOUT" : "NETWORK",
      message: timedOut ? "request timed out after " + config.timeoutMs + " ms" : "network failure",
      unknown: true,
      correlationId,
    });
  }
  log(call, { event: "response", correlationId, path: call.path, status });
  const failure = parseFailure(status, payload);
  if (failure) {
    failure.correlationId = correlationId;
    throw failure;
  }
  return payload.length === 0 ? null : (JSON.parse(payload) as unknown);
}

/** Errors worth another try for a read: unknown outcomes and throttling. */
export function isRetryable(err: unknown): boolean {
  if (!(err instanceof WhiteBooksError)) return false;
  return err.unknown || err.httpStatus === 429;
}

/** Capped jittered backoff: ceiling 0.5 s, 1 s, 2 s, then 4 s, with half of it random. */
export function backoffMs(attempt: number): number {
  const ceiling = Math.min(4000, 500 * 2 ** (attempt - 1));
  return Math.floor(ceiling / 2 + Math.random() * (ceiling / 2));
}

/** Retry a GET (idempotent) up to 3 attempts. Never use this for a write: writes go through reconcileWrite. */
export async function withRetries<T>(run: () => Promise<T>, maxAttempts = 3): Promise<T> {
  for (let attempt = 1; ; attempt++) {
    try {
      return await run();
    } catch (err) {
      if (attempt >= maxAttempts || !isRetryable(err)) throw err;
      await sleep(backoffMs(attempt));
    }
  }
}

/** Refresh or re-authenticate when the session is within 5 minutes of expiry. */
const REFRESH_MARGIN_MS = 5 * 60 * 1000;
/** The spec does not document the token lifetime; sessions assume 6 hours (1 hour for the e-Invoice sandbox) unless the option says otherwise. */
const DEFAULT_LIFETIME_MS = 6 * 60 * 60 * 1000;
/** WhiteBooks' published e-Invoice API flow: a token lasts 1 hour in the sandbox, 6 hours in production. */
const SANDBOX_LIFETIME_MS = 60 * 60 * 1000;
const trimUrl = (url: string): string => url.trim().replace(/\/+$/, "").toLowerCase();
const einvoiceLifetimeMs = (config: Config): number =>
  trimUrl(config.baseUrl) === trimUrl(SANDBOX_URL) ? SANDBOX_LIFETIME_MS : DEFAULT_LIFETIME_MS;

export interface SessionOptions {
  lifetimeMs?: number;
}

const textOf = (value: unknown): string => (typeof value === "string" ? value : "");

/**
 * GST session: requestOtp() sends an OTP to the taxpayer, authenticate(otp) exchanges the OTP the end user types
 * into your own UI for a session, refresh() renews it, logout() ends it. Never hard-code or store an OTP.
 */
export class GstSession {
  readonly config: Config;
  /** Bound once for the life of this session and sent on every call. */
  readonly ipAddress: string;
  txn = "";
  private expiresAt = 0;
  private readonly lifetimeMs: number;

  constructor(config: Config, options: SessionOptions = {}) {
    requireArea(config, "gst");
    this.config = config;
    this.ipAddress = config.ipAddress;
    this.lifetimeMs = options.lifetimeMs ?? DEFAULT_LIFETIME_MS;
  }

  private take(result: unknown): void {
    const txn = textOf(findKey(result, "txn"));
    if (txn !== "") this.txn = txn;
  }

  /** Ask GSTN to send an OTP to the taxpayer. Keeps the transaction id the next calls need. */
  async requestOtp(): Promise<void> {
    const config = this.config;
    const result = await send(config, {
      method: "GET",
      path: "/authentication/otprequest",
      query: {
        "email": config.email,
      },
      headers: {
        "gst_username": config.gstUsername,
        "state_cd": stateCode(config.gstGstin),
        "ip_address": config.ipAddress,
        "client_id": config.gstClientId,
        "client_secret": config.gstClientSecret,
      },
    });
    this.take(result);
    if (this.txn === "") {
      throw new WhiteBooksError({ source: "client", code: "MISSING_TXN", message: "the OTP response carried no txn" });
    }
  }

  /** Exchange the OTP the end user entered for a session. */
  async authenticate(otp: string): Promise<void> {
    const config = this.config;
    const result = await send(config, {
      method: "GET",
      path: "/authentication/authtoken",
      query: {
        "email": config.email,
        "otp": otp,
      },
      headers: {
        "gst_username": config.gstUsername,
        "state_cd": stateCode(config.gstGstin),
        "ip_address": config.ipAddress,
        "txn": this.txn,
        "client_id": config.gstClientId,
        "client_secret": config.gstClientSecret,
      },
    });
    this.take(result);
    this.expiresAt = Date.now() + this.lifetimeMs;
  }

  /** Renew the session before it expires. */
  async refresh(): Promise<void> {
    const config = this.config;
    const result = await send(config, {
      method: "GET",
      path: "/authentication/refreshtoken",
      query: {
        "email": config.email,
      },
      headers: {
        "gst_username": config.gstUsername,
        "state_cd": stateCode(config.gstGstin),
        "ip_address": config.ipAddress,
        "txn": this.txn,
        "client_id": config.gstClientId,
        "client_secret": config.gstClientSecret,
      },
    });
    this.take(result);
    this.expiresAt = Date.now() + this.lifetimeMs;
  }

  async logout(): Promise<void> {
    const config = this.config;
    await send(config, {
      method: "GET",
      path: "/authentication/logout",
      query: {
        "email": config.email,
      },
      headers: {
        "gst_username": config.gstUsername,
        "state_cd": stateCode(config.gstGstin),
        "ip_address": config.ipAddress,
        "txn": this.txn,
        "client_id": config.gstClientId,
        "client_secret": config.gstClientSecret,
      },
    });
    this.expiresAt = 0;
    this.txn = "";
  }

  /** Run one call on this session, refreshing it first when it is within 5 minutes of expiry. */
  async call(build: () => Call): Promise<unknown> {
    if (this.expiresAt === 0) {
      throw new WhiteBooksError({ source: "client", code: "NOT_AUTHENTICATED", message: "call requestOtp() and authenticate(otp) first" });
    }
    if (this.expiresAt - Date.now() <= REFRESH_MARGIN_MS) await this.refresh();
    return send(this.config, build());
  }
}

/**
 * e-Invoice session: authenticate() signs in with the NIC user name and password from the environment.
 * The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
 */
export class EinvoiceSession {
  readonly config: Config;
  /** Bound once for the life of this session and sent on every call. */
  readonly ipAddress: string;
  authToken = "";
  private expiresAt = 0;
  private readonly lifetimeMs: number;
  private pending: Promise<void> | undefined;

  constructor(config: Config, options: SessionOptions = {}) {
    requireArea(config, "einvoice");
    this.config = config;
    this.ipAddress = config.ipAddress;
    this.lifetimeMs = options.lifetimeMs ?? einvoiceLifetimeMs(config);
  }

  /** Sign in. Concurrent callers share one sign-in. */
  authenticate(): Promise<void> {
    this.pending ??= this.signIn().finally(() => {
      this.pending = undefined;
    });
    return this.pending;
  }

  private async signIn(): Promise<void> {
    const config = this.config;
    const result = await send(config, {
      method: "GET",
      path: "/einvoice/authenticate",
      query: {
        "email": config.email,
      },
      headers: {
        "username": config.einvNicUsername,
        "password": config.einvNicPassword,
        "ip_address": config.ipAddress,
        "client_id": config.einvClientId,
        "client_secret": config.einvClientSecret,
        "gstin": config.einvGstin,
      },
    });
    const token = textOf(findKey(result, "AuthToken"));
    if (token === "") {
      throw new WhiteBooksError({ source: "client", code: "MISSING_TOKEN", message: "the sign-in response carried no AuthToken" });
    }
    this.authToken = token;
    this.expiresAt = Date.now() + this.lifetimeMs;
  }

  /** Run one call on this session; sign in first when needed and once more if the API says the session expired. */
  async call(build: () => Call): Promise<unknown> {
    if (this.expiresAt - Date.now() <= REFRESH_MARGIN_MS) await this.authenticate();
    try {
      return await send(this.config, build());
    } catch (err) {
      if (!isSessionExpired(err)) throw err;
      await this.authenticate();
      return send(this.config, build());
    }
  }
}

/**
 * e-Way Bill session: authenticate() signs in with the NIC user name and password from the environment.
 * The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
 */
export class EwaybillSession {
  readonly config: Config;
  /** Bound once for the life of this session and sent on every call. */
  readonly ipAddress: string;
  private expiresAt = 0;
  private readonly lifetimeMs: number;
  private pending: Promise<void> | undefined;

  constructor(config: Config, options: SessionOptions = {}) {
    requireArea(config, "ewaybill");
    this.config = config;
    this.ipAddress = config.ipAddress;
    this.lifetimeMs = options.lifetimeMs ?? DEFAULT_LIFETIME_MS;
  }

  /** Sign in. Concurrent callers share one sign-in. */
  authenticate(): Promise<void> {
    this.pending ??= this.signIn().finally(() => {
      this.pending = undefined;
    });
    return this.pending;
  }

  private async signIn(): Promise<void> {
    const config = this.config;
    await send(config, {
      method: "GET",
      path: "/ewaybillapi/v1.03/authenticate",
      query: {
        "email": config.email,
        "username": config.ewbNicUsername,
        "password": config.ewbNicPassword,
      },
      headers: {
        "ip_address": config.ipAddress,
        "client_id": config.ewbClientId,
        "client_secret": config.ewbClientSecret,
        "gstin": config.ewbGstin,
      },
    });
    this.expiresAt = Date.now() + this.lifetimeMs;
  }

  /** Run one call on this session; sign in first when needed and once more if the API says the session expired. */
  async call(build: () => Call): Promise<unknown> {
    if (this.expiresAt - Date.now() <= REFRESH_MARGIN_MS) await this.authenticate();
    try {
      return await send(this.config, build());
    } catch (err) {
      if (!isSessionExpired(err)) throw err;
      await this.authenticate();
      return send(this.config, build());
    }
  }
}
