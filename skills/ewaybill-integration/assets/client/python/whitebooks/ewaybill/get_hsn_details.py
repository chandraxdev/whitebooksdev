# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area ewaybill
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any

from ..session import Call, with_retries, EwaybillSession


@dataclass
class EwbGethsndetailsbyhsncodeArgs:
    """Arguments of GET /ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode."""

    hsncode: str  # query hsncode


def ewb_gethsndetailsbyhsncode(session: EwaybillSession, args: EwbGethsndetailsbyhsncodeArgs) -> Any:
    """GET HSN details
    GET /ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ewaybillapi/v1.03/ewayapi/gethsndetailsbyhsncode",
            query={
                "email": config.email,
                "hsncode": args.hsncode,
            },
            headers={
                "ip_address": session.ip_address,
                "client_id": config.ewb_client_id,
                "client_secret": config.ewb_client_secret,
                "username": config.ewb_nic_username,
                "gstin": config.ewb_gstin,
            },
        )
    return with_retries(lambda: session.call(build))
