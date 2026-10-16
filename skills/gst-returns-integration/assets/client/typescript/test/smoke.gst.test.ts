// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20 (node:test). Talks to the WhiteBooks sandbox, so it registers its tests only when the sandbox variables are set.

import assert from "node:assert/strict";
import { test } from "node:test";
import { loadConfig } from "../whitebooks/config.js";
import { GstSession } from "../whitebooks/session.js";
import { publicSearch } from "../whitebooks/gst/public.js";
import { env, have } from "./support.js";

if (have(["WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN"])) {
  test("sandbox: public search answers", async () => {
    const result = await publicSearch(loadConfig(env()), { gstin: process.env.WB_GST_GSTIN ?? "" });
    assert.ok(result !== undefined);
  });
}

if (have(["WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN", "WB_IP_ADDRESS", "WB_GST_USERNAME"])) {
  test("sandbox: GST login asks for an OTP (and signs in when WB_OTP is set)", async () => {
    const session = new GstSession(loadConfig(env()));
    await session.requestOtp();
    assert.notEqual(session.txn, "");
    if ((process.env.WB_OTP ?? "") !== "") await session.authenticate(process.env.WB_OTP ?? "");
  });
}
