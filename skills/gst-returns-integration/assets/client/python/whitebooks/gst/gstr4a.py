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
class Gstr4aB2bArgs:
    """Arguments of GET /gstr4a/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr4a_b2b(session: GstSession, args: Gstr4aB2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr4a/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4a/b2b",
            query={
                "email": config.email,
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
class Gstr4aB2baArgs:
    """Arguments of GET /gstr4a/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr4a_b2ba(session: GstSession, args: Gstr4aB2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr4a/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4a/b2ba",
            query={
                "email": config.email,
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
class Gstr4aCdnrArgs:
    """Arguments of GET /gstr4a/cdnr."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr4a_cdnr(session: GstSession, args: Gstr4aCdnrArgs) -> Any:
    """CDNR Invoice
    GET /gstr4a/cdnr
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4a/cdnr",
            query={
                "email": config.email,
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
class Gstr4aCdnraArgs:
    """Arguments of GET /gstr4a/cdnra."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr4a_cdnra(session: GstSession, args: Gstr4aCdnraArgs) -> Any:
    """CDNRA Invoice
    GET /gstr4a/cdnra
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4a/cdnra",
            query={
                "email": config.email,
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
class Gstr4aTdsArgs:
    """Arguments of GET /gstr4a/tds."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr4a_tds(session: GstSession, args: Gstr4aTdsArgs) -> Any:
    """TDS Details
    GET /gstr4a/tds
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4a/tds",
            query={
                "email": config.email,
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
