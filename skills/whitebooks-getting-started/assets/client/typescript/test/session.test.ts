// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20 (node:test, node:http); a local fake server, no network.

import assert from "node:assert/strict";
import { createServer } from "node:http";
import type { AddressInfo } from "node:net";
import { test } from "node:test";
import { loadConfig } from "../whitebooks/config.js";
import { EinvoiceSession, type Call } from "../whitebooks/session.js";
import { RECORDED } from "./fixtures.js";

const ENV = { WB_GST_CLIENT_ID: "t", WB_GST_CLIENT_SECRET: "t", WB_EINV_CLIENT_ID: "t", WB_EINV_CLIENT_SECRET: "t", WB_EWB_CLIENT_ID: "t", WB_EWB_CLIENT_SECRET: "t", WB_EMAIL: "t", WB_GST_GSTIN: "t", WB_EINV_GSTIN: "t", WB_EWB_GSTIN: "t", WB_IP_ADDRESS: "t", WB_GST_USERNAME: "t", WB_EINV_NIC_USERNAME: "t", WB_EINV_NIC_PASSWORD: "t", WB_EWB_NIC_USERNAME: "t", WB_EWB_NIC_PASSWORD: "t" };
const AUTH_PATH = "/einvoice/authenticate";
const READ_PATH = "/einvoice/type/GETEWAYBILLIRN/version/V1_03";

// The call is built here, so this test needs no operation file of any area.
const read = (s: EinvoiceSession): Promise<unknown> => s.call((): Call => ({ method: "GET", path: READ_PATH, query: {}, headers: {} }));

interface Counts {
  auth: number;
  read: number;
}

async function withServer(
  reads: readonly string[],
  run: (session: (options?: { lifetimeMs?: number }) => EinvoiceSession, counts: Counts) => Promise<void>,
): Promise<void> {
  const counts: Counts = { auth: 0, read: 0 };
  const server = createServer((req, res) => {
    const path = (req.url ?? "").split("?")[0];
    res.writeHead(200, { "content-type": "application/json" });
    if (path === AUTH_PATH) {
      counts.auth++;
      res.end(JSON.stringify({ Status: 1, Data: { AuthToken: "tok-" + counts.auth } }));
    } else if (path === READ_PATH) {
      res.end(reads[counts.read++] ?? JSON.stringify({ Status: 1, Data: {} }));
    } else {
      res.end("{}");
    }
  });
  await new Promise<void>((ok) => server.listen(0, "127.0.0.1", ok));
  try {
    const config = loadConfig({ ...ENV, WB_BASE_URL: "http://127.0.0.1:" + (server.address() as AddressInfo).port });
    await run((options) => new EinvoiceSession(config, options), counts);
  } finally {
    await new Promise<void>((ok) => server.close(() => ok()));
  }
}

test("the session signs in once and reuses the token while it is fresh", async () => {
  await withServer([], async (session, counts) => {
    const s = session();
    await read(s);
    await read(s);
    assert.equal(counts.auth, 1);
    assert.equal(counts.read, 2);
  });
});

test("a session within five minutes of expiry signs in again before the call", async () => {
  await withServer([], async (session, counts) => {
    const s = session({ lifetimeMs: 1000 });
    await read(s);
    await read(s);
    assert.equal(counts.auth, 2);
  });
});

test("an expired-token reply signs in again and repeats the call once", async () => {
  await withServer([RECORDED.nicSessionExpired], async (session, counts) => {
    const s = session();
    const result = await read(s);
    assert.equal(counts.auth, 2);
    assert.equal(counts.read, 2);
    assert.deepEqual(result, { Status: 1, Data: {} });
  });
});
