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
class Gstr2aAmdhistArgs:
    """Arguments of GET /gstr2a/amdhist."""

    gstin: str  # query gstin
    portcode: str  # query portcode
    benumber: str  # query benumber
    bedate: str  # query bedate
    retperiod: str  # query retperiod


def gstr2a_amdhist(session: GstSession, args: Gstr2aAmdhistArgs) -> Any:
    """Get AMDHIST
    GET /gstr2a/amdhist
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/amdhist",
            query={
                "gstin": args.gstin,
                "portcode": args.portcode,
                "benumber": args.benumber,
                "bedate": args.bedate,
                "email": config.email,
                "retperiod": args.retperiod,
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
class Gstr2aB2bArgs:
    """Arguments of GET /gstr2a/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr2a_b2b(session: GstSession, args: Gstr2aB2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr2a/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/b2b",
            query={
                "email": config.email,
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
class Gstr2aB2baArgs:
    """Arguments of GET /gstr2a/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr2a_b2ba(session: GstSession, args: Gstr2aB2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr2a/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/b2ba",
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
class Gstr2aCdnArgs:
    """Arguments of GET /gstr2a/cdn."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr2a_cdn(session: GstSession, args: Gstr2aCdnArgs) -> Any:
    """CDN Invoice
    GET /gstr2a/cdn
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/cdn",
            query={
                "email": config.email,
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
class Gstr2aCdnaArgs:
    """Arguments of GET /gstr2a/cdna."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr2a_cdna(session: GstSession, args: Gstr2aCdnaArgs) -> Any:
    """Get CDNA Invoices
    GET /gstr2a/cdna
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/cdna",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "ctin": args.ctin,
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
class Gstr2aEcomArgs:
    """Arguments of GET /gstr2a/ecom."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr2a_ecom(session: GstSession, args: Gstr2aEcomArgs) -> Any:
    """Get ECOM Invoices
    GET /gstr2a/ecom
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/ecom",
            query={
                "email": config.email,
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
class Gstr2aEcomaArgs:
    """Arguments of GET /gstr2a/ecoma."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr2a_ecoma(session: GstSession, args: Gstr2aEcomaArgs) -> Any:
    """Get ECOMA Invoices
    GET /gstr2a/ecoma
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/ecoma",
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
class Gstr2aImpgArgs:
    """Arguments of GET /gstr2a/impg."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fromtime: Optional[str] = None  # query fromtime


def gstr2a_impg(session: GstSession, args: Gstr2aImpgArgs) -> Any:
    """Get IMPG
    GET /gstr2a/impg
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/impg",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "fromtime": args.fromtime,
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
class Gstr2aImpgsezArgs:
    """Arguments of GET /gstr2a/impgsez."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fromtime: Optional[str] = None  # query fromtime


def gstr2a_impgsez(session: GstSession, args: Gstr2aImpgsezArgs) -> Any:
    """Get IMPGSEZ
    GET /gstr2a/impgsez
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/impgsez",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "fromtime": args.fromtime,
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
class Gstr2aIsdArgs:
    """Arguments of GET /gstr2a/isd."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr2a_isd(session: GstSession, args: Gstr2aIsdArgs) -> Any:
    """Get ISD Details
    GET /gstr2a/isd
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/isd",
            query={
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


@dataclass
class Gstr2aTcsArgs:
    """Arguments of GET /gstr2a/tcs."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr2a_tcs(session: GstSession, args: Gstr2aTcsArgs) -> Any:
    """Get TCS
    GET /gstr2a/tcs
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/tcs",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
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
class Gstr2aTdsArgs:
    """Arguments of GET /gstr2a/tds."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr2a_tds(session: GstSession, args: Gstr2aTdsArgs) -> Any:
    """Get TDS Credit
    GET /gstr2a/tds
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2a/tds",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
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
