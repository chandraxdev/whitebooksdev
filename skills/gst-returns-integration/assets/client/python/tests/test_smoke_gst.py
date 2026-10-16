# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area gst
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: requests. Talks to the WhiteBooks sandbox, so its tests exist only when the sandbox variables are set.

import os
import unittest

from tests.smoke_support import env, have
from whitebooks.config import load_config
from whitebooks.session import GstSession
from whitebooks.gst.public import public_search, PublicSearchArgs


if have(["WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN"]):

    class SandboxPublicSearch(unittest.TestCase):
        def test_public_search_answers(self) -> None:
            result = public_search(load_config(env()), PublicSearchArgs(gstin=os.environ.get("WB_GST_GSTIN", "")))
            self.assertIsNotNone(result)


if have(["WB_GST_CLIENT_ID", "WB_GST_CLIENT_SECRET", "WB_EMAIL", "WB_GST_GSTIN", "WB_IP_ADDRESS", "WB_GST_USERNAME"]):

    class SandboxGstLogin(unittest.TestCase):
        def test_gst_login_asks_for_an_otp(self) -> None:
            session = GstSession(load_config(env()))
            session.request_otp()
            self.assertNotEqual(session.txn, "")
            if os.environ.get("WB_OTP", "") != "":
                session.authenticate(os.environ["WB_OTP"])


if __name__ == "__main__":
    unittest.main()
