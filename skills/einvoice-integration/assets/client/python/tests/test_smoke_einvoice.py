# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: requests. Talks to the WhiteBooks sandbox, so its tests exist only when the sandbox variables are set.

import os
import unittest

from tests.smoke_support import env, have
from whitebooks.config import load_config
from whitebooks.session import EinvoiceSession


if have(["WB_EINV_CLIENT_ID", "WB_EINV_CLIENT_SECRET", "WB_EMAIL", "WB_EINV_GSTIN", "WB_IP_ADDRESS", "WB_EINV_NIC_USERNAME", "WB_EINV_NIC_PASSWORD"]):

    class SandboxEinvoiceLogin(unittest.TestCase):
        def test_einvoice_login(self) -> None:
            EinvoiceSession(load_config(env())).authenticate()


if __name__ == "__main__":
    unittest.main()
