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
class GstEinvoiceFiledtlArgs:
    """Arguments of GET /gst/einvoice/filedtl."""

    gstin: str  # query gstin
    rtnprd: str  # query rtnprd
    token: str  # query token


def gst_einvoice_filedtl(session: GstSession, args: GstEinvoiceFiledtlArgs) -> Any:
    """Get file URL
    GET /gst/einvoice/filedtl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gst/einvoice/filedtl",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "rtnprd": args.rtnprd,
                "token": args.token,
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
class GstEinvoiceHsnsumArgs:
    """Arguments of GET /gst/einvoice/hsnsum."""

    gstin: str  # query gstin
    ret_period: str  # query ret_period


def gst_einvoice_hsnsum(session: GstSession, args: GstEinvoiceHsnsumArgs) -> Any:
    """Get E-Invice HSN Summary
    GET /gst/einvoice/hsnsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gst/einvoice/hsnsum",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "ret_period": args.ret_period,
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
class GstEinvoiceIrndtlArgs:
    """Arguments of GET /gst/einvoice/irndtl."""

    gstin: str  # query gstin
    irn: str  # query irn


def gst_einvoice_irndtl(session: GstSession, args: GstEinvoiceIrndtlArgs) -> Any:
    """Get Json for IRN
    GET /gst/einvoice/irndtl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gst/einvoice/irndtl",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "irn": args.irn,
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
class GstEinvoiceIrnjsonsArgs:
    """Arguments of GET /gst/einvoice/irnjsons."""

    gstin: str  # query gstin
    suptyp: str  # query suptyp
    rtnprd: str  # query rtnprd
    rstinflag: Optional[str] = None  # query rstinflag


def gst_einvoice_irnjsons(session: GstSession, args: GstEinvoiceIrnjsonsArgs) -> Any:
    """Get list of IRN Jsons
    GET /gst/einvoice/irnjsons
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gst/einvoice/irnjsons",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "rstinflag": args.rstinflag,
                "suptyp": args.suptyp,
                "rtnprd": args.rtnprd,
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
class GstEinvoiceIrnlistArgs:
    """Arguments of GET /gst/einvoice/irnlist."""

    gstin: str  # query gstin
    suptyp: str  # query suptyp
    rtnprd: str  # query rtnprd
    rstinflag: Optional[str] = None  # query rstinflag


def gst_einvoice_irnlist(session: GstSession, args: GstEinvoiceIrnlistArgs) -> Any:
    """Get list of IRNs
    GET /gst/einvoice/irnlist
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gst/einvoice/irnlist",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "rstinflag": args.rstinflag,
                "suptyp": args.suptyp,
                "rtnprd": args.rtnprd,
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
