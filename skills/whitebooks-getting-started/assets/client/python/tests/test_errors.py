# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none. Run: python -m unittest discover -s tests -t .

import unittest

from tests.fixtures import RECORDED
from whitebooks.errors import WhiteBooksError, is_session_expired, parse_failure


class ErrorParsing(unittest.TestCase):
    def test_gateway_error_becomes_source_whitebooks(self) -> None:
        err = parse_failure(200, RECORDED["gatewayMissingParam"])
        assert err is not None
        self.assertEqual(err.source, "whitebooks")
        self.assertEqual(err.code, "WB_ERR_9101")
        self.assertFalse(err.unknown)

    def test_wb_err_9000_is_unknown(self) -> None:
        err = parse_failure(200, RECORDED["gatewayUnexpected"])
        assert err is not None
        self.assertTrue(err.unknown)

    def test_gstn_rejection_keeps_error_cd(self) -> None:
        err = parse_failure(200, RECORDED["gstnRejected"])
        assert err is not None
        self.assertEqual(err.source, "gstn")
        self.assertEqual(err.code, "AUTH4033")
        self.assertEqual(err.message, "Invalid OTP")

    def test_nic_rejection_keeps_code_and_message(self) -> None:
        err = parse_failure(200, RECORDED["nicRejected"])
        assert err is not None
        self.assertEqual(err.source, "nic")
        self.assertEqual(err.code, "2150")
        self.assertEqual(err.message, "Duplicate IRN")

    def test_success_is_not_an_error(self) -> None:
        self.assertIsNone(parse_failure(200, RECORDED["success"]))

    def test_non_json_5xx_is_unknown_http_failure(self) -> None:
        err = parse_failure(502, RECORDED["bad_gateway_html"])
        assert err is not None
        self.assertEqual(err.source, "http")
        self.assertEqual(err.code, "HTTP_502")
        self.assertTrue(err.unknown)

    def test_only_nic_token_errors_count_as_expired_session(self) -> None:
        self.assertTrue(is_session_expired(parse_failure(200, RECORDED["nicSessionExpired"])))  # type: ignore[arg-type]
        self.assertFalse(is_session_expired(parse_failure(200, RECORDED["nicRejected"])))  # type: ignore[arg-type]
        self.assertFalse(is_session_expired(ValueError("boom")))


if __name__ == "__main__":
    unittest.main()
