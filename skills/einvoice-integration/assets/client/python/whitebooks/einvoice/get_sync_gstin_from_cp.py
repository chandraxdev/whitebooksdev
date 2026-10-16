# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any

from ..session import Call, with_retries, EinvoiceSession


@dataclass
class EinvoiceSyncGstinFromcpArgs:
    """Arguments of GET /einvoice/type/SYNC_GSTIN_FROMCP/version/V1_03."""

    param1: str  # query param1


def einvoice_sync_gstin_fromcp(session: EinvoiceSession, args: EinvoiceSyncGstinFromcpArgs) -> Any:
    """Get Sync GSTIN From CP
    GET /einvoice/type/SYNC_GSTIN_FROMCP/version/V1_03
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/einvoice/type/SYNC_GSTIN_FROMCP/version/V1_03",
            query={
                "param1": args.param1,
                "email": config.email,
            },
            headers={
                "ip_address": session.ip_address,
                "client_id": config.einv_client_id,
                "client_secret": config.einv_client_secret,
                "username": config.einv_nic_username,
                "auth-token": session.auth_token,
                "gstin": config.einv_gstin,
            },
        )
    return with_retries(lambda: session.call(build))
