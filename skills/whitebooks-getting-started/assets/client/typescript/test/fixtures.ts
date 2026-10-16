// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

/** Response bodies the tests replay. The WB_ERR_9101 body was recorded from the WhiteBooks sandbox on 2026-10-13; the rest follow the documented shapes. */
export const RECORDED = {
  gatewayMissingParam: "{\"status_cd\":\"0\",\"status_desc\":\"WB_ERR_9101 : Missing mandatory parameters : otp\"}",
  gatewayUnexpected: "{\"status_cd\":\"0\",\"status_desc\":\"WB_ERR_9000 : Unexpected error\"}",
  gstnRejected: "{\"status_cd\":\"0\",\"status_desc\":\"Failure\",\"error\":{\"message\":\"Invalid OTP\",\"error_cd\":\"AUTH4033\"}}",
  nicRejected: "{\"Status\":\"0\",\"ErrorDetails\":[{\"ErrorCode\":\"2150\",\"ErrorMessage\":\"Duplicate IRN\"}]}",
  nicSessionExpired: "{\"Status\":\"0\",\"ErrorDetails\":[{\"ErrorCode\":\"1005\",\"ErrorMessage\":\"Invalid Token\"}]}",
  success: "{\"status_cd\":\"1\",\"status_desc\":\"Success\",\"data\":{}}",
  badGatewayHtml: "<html><body>502 Bad Gateway</body></html>",
} as const;
