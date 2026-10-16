# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area gst
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any

from ..config import state_code
from ..session import Call, with_retries, GstSession


@dataclass
class NoticesNoticedetailsArgs:
    """Arguments of GET /notices/noticedetails."""

    gstin: str  # query gstin
    ref_id: str  # query refId


def notices_noticedetails(session: GstSession, args: NoticesNoticedetailsArgs) -> Any:
    """Get Notice Details
    GET /notices/noticedetails
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/notices/noticedetails",
            query={
                "gstin": args.gstin,
                "refId": args.ref_id,
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
class NoticesNoticelistArgs:
    """Arguments of GET /notices/noticelist."""

    gstin: str  # query gstin
    date: str  # query date


def notices_noticelist(session: GstSession, args: NoticesNoticelistArgs) -> Any:
    """Get List Of Notices
    GET /notices/noticelist
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/notices/noticelist",
            query={
                "gstin": args.gstin,
                "date": args.date,
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
