# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none (standard library http.server; a local fake server, no network).

import json
import threading
import unittest
from http.server import BaseHTTPRequestHandler, HTTPServer
from typing import Any, List

from tests.fixtures import RECORDED
from whitebooks.config import load_config
from whitebooks.session import Call, EinvoiceSession

ENV = {"WB_GST_CLIENT_ID": "x", "WB_GST_CLIENT_SECRET": "x", "WB_EINV_CLIENT_ID": "x", "WB_EINV_CLIENT_SECRET": "x", "WB_EWB_CLIENT_ID": "x", "WB_EWB_CLIENT_SECRET": "x", "WB_EMAIL": "x", "WB_GST_GSTIN": "x", "WB_EINV_GSTIN": "x", "WB_EWB_GSTIN": "x", "WB_IP_ADDRESS": "x", "WB_GST_USERNAME": "x", "WB_EINV_NIC_USERNAME": "x", "WB_EINV_NIC_PASSWORD": "x", "WB_EWB_NIC_USERNAME": "x", "WB_EWB_NIC_PASSWORD": "x"}
AUTH_PATH = "/einvoice/authenticate"
READ_PATH = "/einvoice/type/GETEWAYBILLIRN/version/V1_03"


def read(s: EinvoiceSession) -> Any:
    # The call is built here, so this test needs no operation file of any area.
    return s.call(lambda: Call(method="GET", path=READ_PATH, query={}, headers={}))


class Fake:
    """A local server: counts sign-ins and reads, and answers reads from a queue before falling back to success."""

    def __init__(self, reads: List[str]) -> None:
        self.auth = 0
        self.read = 0
        fake = self

        class Handler(BaseHTTPRequestHandler):
            def handle_any(self) -> None:
                path = self.path.split("?")[0]
                if path == AUTH_PATH:
                    fake.auth += 1
                    body = json.dumps({"Status": 1, "Data": {"AuthToken": "tok-%d" % fake.auth}})
                elif path == READ_PATH:
                    body = reads[fake.read] if fake.read < len(reads) else json.dumps({"Status": 1, "Data": {}})
                    fake.read += 1
                else:
                    body = "{}"
                data = body.encode("utf-8")
                self.send_response(200)
                self.send_header("content-type", "application/json")
                self.send_header("content-length", str(len(data)))
                self.end_headers()
                self.wfile.write(data)

            do_GET = handle_any
            do_POST = handle_any
            do_PUT = handle_any

            def log_message(self, format: str, *args: Any) -> None:
                pass

        self.server = HTTPServer(("127.0.0.1", 0), Handler)
        self.thread = threading.Thread(target=self.server.serve_forever, daemon=True)

    def __enter__(self) -> "Fake":
        self.thread.start()
        return self

    def __exit__(self, *exc: Any) -> None:
        self.server.shutdown()
        self.server.server_close()

    def session(self, lifetime_s: float = 6 * 60 * 60) -> EinvoiceSession:
        config = load_config({**ENV, "WB_BASE_URL": "http://127.0.0.1:%d" % self.server.server_address[1]})
        return EinvoiceSession(config, lifetime_s)


class SessionExpiry(unittest.TestCase):
    def test_signs_in_once_and_reuses_the_token_while_fresh(self) -> None:
        with Fake([]) as fake:
            s = fake.session()
            read(s)
            read(s)
            self.assertEqual(fake.auth, 1)
            self.assertEqual(fake.read, 2)

    def test_session_within_five_minutes_of_expiry_signs_in_again(self) -> None:
        with Fake([]) as fake:
            s = fake.session(lifetime_s=1)
            read(s)
            read(s)
            self.assertEqual(fake.auth, 2)

    def test_expired_token_reply_signs_in_again_and_repeats_once(self) -> None:
        with Fake([RECORDED["nicSessionExpired"]]) as fake:
            s = fake.session()
            result = read(s)
            self.assertEqual(fake.auth, 2)
            self.assertEqual(fake.read, 2)
            self.assertEqual(result, {"Status": 1, "Data": {}})


if __name__ == "__main__":
    unittest.main()
