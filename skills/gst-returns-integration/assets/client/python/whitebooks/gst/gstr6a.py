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
class Gstr6aB2bArgs:
    """Arguments of GET /gstr6a/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr6a_b2b(session: GstSession, args: Gstr6aB2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr6a/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6a/b2b",
            query={
                "email": config.email,
                "actionrequired": args.actionrequired,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "ctin": args.ctin,
                "fromtime": args.fromtime,
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
class Gstr6aB2baArgs:
    """Arguments of GET /gstr6a/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6a_b2ba(session: GstSession, args: Gstr6aB2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr6a/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6a/b2ba",
            query={
                "email": config.email,
                "actionrequired": args.actionrequired,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "ctin": args.ctin,
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
class Gstr6aCdnArgs:
    """Arguments of GET /gstr6a/cdn."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6a_cdn(session: GstSession, args: Gstr6aCdnArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr6a/cdn
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6a/cdn",
            query={
                "email": config.email,
                "actionrequired": args.actionrequired,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "ctin": args.ctin,
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
class Gstr6aCdnaArgs:
    """Arguments of GET /gstr6a/cdna."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6a_cdna(session: GstSession, args: Gstr6aCdnaArgs) -> Any:
    """Get CDNRA Invoices
    GET /gstr6a/cdna
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6a/cdna",
            query={
                "actionrequired": args.actionrequired,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "ctin": args.ctin,
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
