// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: Node >= 20 (node:test). Run: npx tsc -p . && node --test "out/test/*.test.js"

import assert from "node:assert/strict";
import { test } from "node:test";
import { WhiteBooksError, isSessionExpired, parseFailure } from "../whitebooks/errors.js";
import { RECORDED } from "./fixtures.js";

test("a WhiteBooks gateway error becomes source whitebooks with its WB_ERR code", () => {
  const err = parseFailure(200, RECORDED.gatewayMissingParam);
  assert.ok(err instanceof WhiteBooksError);
  assert.equal(err.source, "whitebooks");
  assert.equal(err.code, "WB_ERR_9101");
  assert.equal(err.unknown, false);
});

test("WB_ERR_9000 is an unknown outcome, never a plain failure", () => {
  assert.equal(parseFailure(200, RECORDED.gatewayUnexpected)?.unknown, true);
});

test("a GSTN rejection keeps error_cd as the code", () => {
  const err = parseFailure(200, RECORDED.gstnRejected);
  assert.equal(err?.source, "gstn");
  assert.equal(err?.code, "AUTH4033");
  assert.equal(err?.message, "Invalid OTP");
});

test("a NIC rejection keeps ErrorCode and ErrorMessage", () => {
  const err = parseFailure(200, RECORDED.nicRejected);
  assert.equal(err?.source, "nic");
  assert.equal(err?.code, "2150");
  assert.equal(err?.message, "Duplicate IRN");
});

test("a success body is not an error", () => {
  assert.equal(parseFailure(200, RECORDED.success), undefined);
});

test("a non-JSON 5xx is an unknown HTTP failure", () => {
  const err = parseFailure(502, RECORDED.badGatewayHtml);
  assert.equal(err?.source, "http");
  assert.equal(err?.code, "HTTP_502");
  assert.equal(err?.unknown, true);
});

test("only the NIC token errors count as an expired session", () => {
  assert.equal(isSessionExpired(parseFailure(200, RECORDED.nicSessionExpired)), true);
  assert.equal(isSessionExpired(parseFailure(200, RECORDED.nicRejected)), false);
  assert.equal(isSessionExpired(new Error("boom")), false);
});
