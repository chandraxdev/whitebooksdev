# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area gst
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Optional

from ..config import state_code
from ..session import Call, with_retries, GstSession


@dataclass
class GstrRetstatusArgs:
    """Arguments of GET /gstr/retstatus."""

    gstin: str  # query gstin
    returnperiod: str  # query returnperiod
    refid: str  # query refid


def gstr_retstatus(session: GstSession, args: GstrRetstatusArgs) -> Any:
    """Get Return Status
    GET /gstr/retstatus
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr/retstatus",
            query={
                "gstin": args.gstin,
                "returnperiod": args.returnperiod,
                "refid": args.refid,
                "email": config.email,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: session.call(build))


@dataclass
class GstrRettrackArgs:
    """Arguments of GET /gstr/rettrack."""

    gstin: str  # query gstin
    returnperiod: str  # query returnperiod
    type: Optional[str] = None  # query type


def gstr_rettrack(session: GstSession, args: GstrRettrackArgs) -> Any:
    """View and Track Returns
    GET /gstr/rettrack
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr/rettrack",
            query={
                "gstin": args.gstin,
                "returnperiod": args.returnperiod,
                "type": args.type,
                "email": config.email,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: session.call(build))
