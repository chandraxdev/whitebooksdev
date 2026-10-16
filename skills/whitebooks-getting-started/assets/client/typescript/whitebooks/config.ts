// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none (Node >= 20 built-ins only).

export const SANDBOX_URL = "https://apisandbox.whitebooks.in";
export const PRODUCTION_URL = "https://api.whitebooks.in";

export interface Config {
  /** WB_BASE_URL, defaulting to the sandbox. Set it to PRODUCTION_URL only for live traffic. */
  baseUrl: string;
  gstClientId: string;
  gstClientSecret: string;
  einvClientId: string;
  einvClientSecret: string;
  ewbClientId: string;
  ewbClientSecret: string;
  email: string;
  gstGstin: string;
  einvGstin: string;
  ewbGstin: string;
  ipAddress: string;
  gstUsername: string;
  einvNicUsername: string;
  einvNicPassword: string;
  ewbNicUsername: string;
  ewbNicPassword: string;
  /** Per-request deadline in milliseconds. */
  timeoutMs: number;
}

export class ConfigError extends Error {}

/** Which part of the API a call belongs to. Each area has its own credentials and is checked only when it is used. */
export type ConfigArea = "public" | "gst" | "einvoice" | "ewaybill";

const AREA_VARS: Record<ConfigArea, ReadonlyArray<readonly [keyof Config, string]>> = {
  public: [["gstClientId", "WB_GST_CLIENT_ID"], ["gstClientSecret", "WB_GST_CLIENT_SECRET"], ["email", "WB_EMAIL"]],
  gst: [["gstClientId", "WB_GST_CLIENT_ID"], ["gstClientSecret", "WB_GST_CLIENT_SECRET"], ["email", "WB_EMAIL"], ["gstGstin", "WB_GST_GSTIN"], ["ipAddress", "WB_IP_ADDRESS"], ["gstUsername", "WB_GST_USERNAME"]],
  einvoice: [["einvClientId", "WB_EINV_CLIENT_ID"], ["einvClientSecret", "WB_EINV_CLIENT_SECRET"], ["email", "WB_EMAIL"], ["einvGstin", "WB_EINV_GSTIN"], ["ipAddress", "WB_IP_ADDRESS"], ["einvNicUsername", "WB_EINV_NIC_USERNAME"], ["einvNicPassword", "WB_EINV_NIC_PASSWORD"]],
  ewaybill: [["ewbClientId", "WB_EWB_CLIENT_ID"], ["ewbClientSecret", "WB_EWB_CLIENT_SECRET"], ["email", "WB_EMAIL"], ["ewbGstin", "WB_EWB_GSTIN"], ["ipAddress", "WB_IP_ADDRESS"], ["ewbNicUsername", "WB_EWB_NIC_USERNAME"], ["ewbNicPassword", "WB_EWB_NIC_PASSWORD"]],
};

/** Read the configuration from environment variables; every secret comes from the environment, never from source. Nothing is checked here: call requireArea, which the sessions and public operations do for you. */
export function loadConfig(env: Record<string, string | undefined> = process.env): Config {
  const read = (name: string): string => env[name] ?? "";
  return {
    baseUrl: (env["WB_BASE_URL"] ?? "").trim() || SANDBOX_URL,
    gstClientId: read("WB_GST_CLIENT_ID"),
    gstClientSecret: read("WB_GST_CLIENT_SECRET"),
    einvClientId: read("WB_EINV_CLIENT_ID"),
    einvClientSecret: read("WB_EINV_CLIENT_SECRET"),
    ewbClientId: read("WB_EWB_CLIENT_ID"),
    ewbClientSecret: read("WB_EWB_CLIENT_SECRET"),
    email: read("WB_EMAIL"),
    gstGstin: read("WB_GST_GSTIN"),
    einvGstin: read("WB_EINV_GSTIN"),
    ewbGstin: read("WB_EWB_GSTIN"),
    ipAddress: read("WB_IP_ADDRESS"),
    gstUsername: read("WB_GST_USERNAME"),
    einvNicUsername: read("WB_EINV_NIC_USERNAME"),
    einvNicPassword: read("WB_EINV_NIC_PASSWORD"),
    ewbNicUsername: read("WB_EWB_NIC_USERNAME"),
    ewbNicPassword: read("WB_EWB_NIC_PASSWORD"),
    timeoutMs: 30_000,
  };
}

/** Throw a ConfigError naming the environment variables this area still needs. It runs before any network call. */
export function requireArea(config: Config, area: ConfigArea): void {
  const missing = AREA_VARS[area].filter(([field]) => config[field] === "").map(([, name]) => name);
  if (missing.length > 0) {
    throw new ConfigError("missing environment variables for " + area + ": " + missing.join(", "));
  }
}

/** The two-digit state code is the first two characters of the GSTIN. */
export function stateCode(gstin: string): string {
  return gstin.slice(0, 2);
}
