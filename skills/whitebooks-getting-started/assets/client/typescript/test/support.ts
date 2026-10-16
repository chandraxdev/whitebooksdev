// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20.

import { SANDBOX_URL } from "../whitebooks/config.js";

// Never talk to a live API from a test (fail closed): tests register only when WB_BASE_URL is unset or an https URL on the sandbox host.
// Anything else, including a value that does not parse, registers none, and the note names the parsed host, never the raw value.
function notSandbox(): string | undefined {
  const raw = (process.env.WB_BASE_URL ?? "").trim();
  if (raw === "") return undefined;
  try {
    const url = new URL(raw);
    return url.protocol === "https:" && url.host === new URL(SANDBOX_URL).host ? undefined : url.host;
  } catch {
    return "unparsable";
  }
}
const refused = notSandbox();
if (refused !== undefined) console.error("WB_BASE_URL is not the sandbox https URL (host: " + refused + "); the smoke tests run only against the sandbox, so none was run.");
export const have = (names: readonly string[]): boolean => refused === undefined && names.every((n) => (process.env[n] ?? "") !== "");
// loadConfig wants every variable; the ones this smoke run does not use get a placeholder.
const FILL: Record<string, string> = { WB_GST_CLIENT_ID: "x", WB_GST_CLIENT_SECRET: "x", WB_EINV_CLIENT_ID: "x", WB_EINV_CLIENT_SECRET: "x", WB_EWB_CLIENT_ID: "x", WB_EWB_CLIENT_SECRET: "x", WB_EMAIL: "x", WB_GST_GSTIN: "x", WB_EINV_GSTIN: "x", WB_EWB_GSTIN: "x", WB_IP_ADDRESS: "x", WB_GST_USERNAME: "x", WB_EINV_NIC_USERNAME: "x", WB_EINV_NIC_PASSWORD: "x", WB_EWB_NIC_USERNAME: "x", WB_EWB_NIC_PASSWORD: "x" };
export const env = (): Record<string, string | undefined> => ({ ...FILL, ...Object.fromEntries(Object.entries(process.env).filter(([, v]) => (v ?? "") !== "")) });
