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
from ..reconcile import Policy, WriteOptions, reconcile_write, require_irreversible_confirmed
from ..session import Call, with_retries, GstSession
from .models import Gstr1SaveRequest
from ..gst.gstr import gstr_retstatus


@dataclass
class Gstr1AtArgs:
    """Arguments of GET /gstr1/at."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_at(session: GstSession, args: Gstr1AtArgs) -> Any:
    """Get AT
    GET /gstr1/at
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/at",
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
class Gstr1AtaArgs:
    """Arguments of GET /gstr1/ata."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_ata(session: GstSession, args: Gstr1AtaArgs) -> Any:
    """Get ATA
    GET /gstr1/ata
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/ata",
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
class Gstr1B2bArgs:
    """Arguments of GET /gstr1/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr1_b2b(session: GstSession, args: Gstr1B2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr1/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2b",
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
class Gstr1B2baArgs:
    """Arguments of GET /gstr1/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr1_b2ba(session: GstSession, args: Gstr1B2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr1/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2ba",
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
class Gstr1B2clArgs:
    """Arguments of GET /gstr1/b2cl."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr1_b2cl(session: GstSession, args: Gstr1B2clArgs) -> Any:
    """Get B2CL Invoices
    GET /gstr1/b2cl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2cl",
            query={
                "statecd": args.statecd,
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
class Gstr1B2claArgs:
    """Arguments of GET /gstr1/b2cla."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr1_b2cla(session: GstSession, args: Gstr1B2claArgs) -> Any:
    """Get B2CLA Invoices
    GET /gstr1/b2cla
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2cla",
            query={
                "statecd": args.statecd,
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
class Gstr1B2csArgs:
    """Arguments of GET /gstr1/b2cs."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_b2cs(session: GstSession, args: Gstr1B2csArgs) -> Any:
    """Get B2CS Invoices
    GET /gstr1/b2cs
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2cs",
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
class Gstr1B2csaArgs:
    """Arguments of GET /gstr1/b2csa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_b2csa(session: GstSession, args: Gstr1B2csaArgs) -> Any:
    """Get B2CSA Invoices
    GET /gstr1/b2csa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/b2csa",
            query={
                "email": config.email,
                "gstin": args.gstin,
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
class Gstr1CdnrArgs:
    """Arguments of GET /gstr1/cdnr."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired


def gstr1_cdnr(session: GstSession, args: Gstr1CdnrArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr1/cdnr
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/cdnr",
            query={
                "email": config.email,
                "actionrequired": args.actionrequired,
                "gstin": args.gstin,
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
class Gstr1CdnraArgs:
    """Arguments of GET /gstr1/cdnra."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired


def gstr1_cdnra(session: GstSession, args: Gstr1CdnraArgs) -> Any:
    """Get CDNRA Invoices
    GET /gstr1/cdnra
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/cdnra",
            query={
                "actionrequired": args.actionrequired,
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
class Gstr1CdnurArgs:
    """Arguments of GET /gstr1/cdnur."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_cdnur(session: GstSession, args: Gstr1CdnurArgs) -> Any:
    """API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
    GET /gstr1/cdnur
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/cdnur",
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
class Gstr1CdnuraArgs:
    """Arguments of GET /gstr1/cdnura."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_cdnura(session: GstSession, args: Gstr1CdnuraArgs) -> Any:
    """API call for getting all amended Credit/ Debit Notes issued to un-registered persons for a return period.
    GET /gstr1/cdnura
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/cdnura",
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
class Gstr1DocissArgs:
    """Arguments of GET /gstr1/dociss."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_dociss(session: GstSession, args: Gstr1DocissArgs) -> Any:
    """Get GSTR1 Document Issued
    GET /gstr1/dociss
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/dociss",
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
class Gstr1EcomArgs:
    """Arguments of GET /gstr1/ecom."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rtin: Optional[str] = None  # query rtin
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1_ecom(session: GstSession, args: Gstr1EcomArgs) -> Any:
    """Get ECOM Invoices
    GET /gstr1/ecom
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/ecom",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "rtin": args.rtin,
                "subsection": args.subsection,
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
class Gstr1EcomaArgs:
    """Arguments of GET /gstr1/ecoma."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rtin: Optional[str] = None  # query rtin
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1_ecoma(session: GstSession, args: Gstr1EcomaArgs) -> Any:
    """Get ECOMA Invoices
    GET /gstr1/ecoma
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/ecoma",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "rtin": args.rtin,
                "subsection": args.subsection,
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
class Gstr1EinvoiceArgs:
    """Arguments of GET /gstr1/einvoice."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    sec: str  # query sec
    fromtime: Optional[str] = None  # query fromtime


def gstr1_einvoice(session: GstSession, args: Gstr1EinvoiceArgs) -> Any:
    """Get E-Invoices
    GET /gstr1/einvoice
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/einvoice",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "sec": args.sec,
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
class Gstr1ExpArgs:
    """Arguments of GET /gstr1/exp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_exp(session: GstSession, args: Gstr1ExpArgs) -> Any:
    """Get EXP
    GET /gstr1/exp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/exp",
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
class Gstr1ExpaArgs:
    """Arguments of GET /gstr1/expa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_expa(session: GstSession, args: Gstr1ExpaArgs) -> Any:
    """Get EXPA
    GET /gstr1/expa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/expa",
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
class Gstr1HsnsumArgs:
    """Arguments of GET /gstr1/hsnsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_hsnsum(session: GstSession, args: Gstr1HsnsumArgs) -> Any:
    """Get HSN Summary details
    GET /gstr1/hsnsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/hsnsum",
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
class Gstr1NilArgs:
    """Arguments of GET /gstr1/nil."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_nil(session: GstSession, args: Gstr1NilArgs) -> Any:
    """Get Nil Rated Supplies
    GET /gstr1/nil
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/nil",
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
class Gstr1RetsumArgs:
    """Arguments of GET /gstr1/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    smrytyp: Optional[str] = None  # query smrytyp


def gstr1_retsum(session: GstSession, args: Gstr1RetsumArgs) -> Any:
    """Get GSTR1 Summary
    GET /gstr1/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/retsum",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "smrytyp": args.smrytyp,
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
class Gstr1SupecoArgs:
    """Arguments of GET /gstr1/supeco."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1_supeco(session: GstSession, args: Gstr1SupecoArgs) -> Any:
    """Get Supplier ECO invoices
    GET /gstr1/supeco
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/supeco",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "subsection": args.subsection,
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
class Gstr1SupecoaArgs:
    """Arguments of GET /gstr1/supecoa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1_supecoa(session: GstSession, args: Gstr1SupecoaArgs) -> Any:
    """Get Supplier ECOA invoices
    GET /gstr1/supecoa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/supecoa",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "subsection": args.subsection,
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
class Gstr1TxpArgs:
    """Arguments of GET /gstr1/txp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_txp(session: GstSession, args: Gstr1TxpArgs) -> Any:
    """Get TXP
    GET /gstr1/txp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/txp",
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
class Gstr1TxpaArgs:
    """Arguments of GET /gstr1/txpa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_txpa(session: GstSession, args: Gstr1TxpaArgs) -> Any:
    """Get TXPA
    GET /gstr1/txpa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/txpa",
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
class Gstr1ValidatehsnsumArgs:
    """Arguments of GET /gstr1/validatehsnsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1_validatehsnsum(session: GstSession, args: Gstr1ValidatehsnsumArgs) -> Any:
    """Validate the HSN Summary details
    GET /gstr1/validatehsnsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1/validatehsnsum",
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
class Gstr1ResetArgs:
    """Arguments of POST /gstr1/reset."""

    ret_period: str  # header ret_period


def gstr1_reset(session: GstSession, args: Gstr1ResetArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Reset GSTR1 Data
    POST /gstr1/reset
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr1/reset",
            query={
                "email": config.email,
            },
            headers={
                "gstin": config.gst_gstin,
                "ret_period": args.ret_period,
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: gstr_retstatus(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy())


@dataclass
class Gstr1RetevcfileArgs:
    """Arguments of POST /gstr1/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr1_retevcfile(session: GstSession, args: Gstr1RetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR1 data
    POST /gstr1/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr1_retevcfile (POST /gstr1/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr1/retevcfile",
            query={
                "email": config.email,
                "pan": args.pan,
                "evcotp": args.evcotp,
            },
            headers={
                "gstin": config.gst_gstin,
                "ret_period": args.ret_period,
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: gstr_retstatus(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy())


@dataclass
class Gstr1RetfileArgs:
    """Arguments of POST /gstr1/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr1_retfile(session: GstSession, args: Gstr1RetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR1 data
    POST /gstr1/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr1_retfile (POST /gstr1/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr1/retfile",
            query={
                "email": config.email,
                "pan": args.pan,
            },
            headers={
                "gstin": config.gst_gstin,
                "ret_period": args.ret_period,
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: gstr_retstatus(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy())


@dataclass
class Gstr1RetsaveArgs:
    """Arguments of PUT /gstr1/retsave."""

    ret_period: str  # header ret_period


def gstr1_retsave(session: GstSession, args: Gstr1RetsaveArgs, body: Gstr1SaveRequest, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR1 data
    PUT /gstr1/retsave
    Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with wait_for_status.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="PUT",
            path="/gstr1/retsave",
            query={
                "email": config.email,
            },
            headers={
                "gstin": config.gst_gstin,
                "ret_period": args.ret_period,
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": session.ip_address,
                "txn": session.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: gstr_retstatus(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy())
