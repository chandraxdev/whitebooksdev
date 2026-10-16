// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20 (node:test). Talks to the WhiteBooks sandbox, so it registers its tests only when the sandbox variables are set.

import { test } from "node:test";
import { loadConfig } from "../whitebooks/config.js";
import { EwaybillSession } from "../whitebooks/session.js";
import { env, have } from "./support.js";

if (have(["WB_EWB_CLIENT_ID", "WB_EWB_CLIENT_SECRET", "WB_EMAIL", "WB_EWB_GSTIN", "WB_IP_ADDRESS", "WB_EWB_NIC_USERNAME", "WB_EWB_NIC_PASSWORD"])) {
  test("sandbox: e-Way Bill login", async () => {
    await new EwaybillSession(loadConfig(env())).authenticate();
  });
}
