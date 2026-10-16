// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area einvoice
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20 (node:test). Talks to the WhiteBooks sandbox, so it registers its tests only when the sandbox variables are set.

import { test } from "node:test";
import { loadConfig } from "../whitebooks/config.js";
import { EinvoiceSession } from "../whitebooks/session.js";
import { env, have } from "./support.js";

if (have(["WB_EINV_CLIENT_ID", "WB_EINV_CLIENT_SECRET", "WB_EMAIL", "WB_EINV_GSTIN", "WB_IP_ADDRESS", "WB_EINV_NIC_USERNAME", "WB_EINV_NIC_PASSWORD"])) {
  test("sandbox: e-Invoice login", async () => {
    await new EinvoiceSession(loadConfig(env())).authenticate();
  });
}
