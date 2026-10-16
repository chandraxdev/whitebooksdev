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
from ..gst.gstr import gstr_retstatus


@dataclass
class Gstr1aAtArgs:
    """Arguments of GET /gstr1a/at."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_at(session: GstSession, args: Gstr1aAtArgs) -> Any:
    """Get AT
    GET /gstr1a/at
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/at",
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
class Gstr1aAtaArgs:
    """Arguments of GET /gstr1a/ata."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_ata(session: GstSession, args: Gstr1aAtaArgs) -> Any:
    """Get ATA
    GET /gstr1a/ata
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/ata",
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
class Gstr1aB2bArgs:
    """Arguments of GET /gstr1a/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fromtime: Optional[str] = None  # query fromtime
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr1a_b2b(session: GstSession, args: Gstr1aB2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr1a/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2b",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "fromtime": args.fromtime,
                "actionrequired": args.actionrequired,
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
class Gstr1aB2baArgs:
    """Arguments of GET /gstr1a/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr1a_b2ba(session: GstSession, args: Gstr1aB2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr1a/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2ba",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "actionrequired": args.actionrequired,
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
class Gstr1aB2clArgs:
    """Arguments of GET /gstr1a/b2cl."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_b2cl(session: GstSession, args: Gstr1aB2clArgs) -> Any:
    """Get B2CL Invoices
    GET /gstr1a/b2cl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2cl",
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
class Gstr1aB2claArgs:
    """Arguments of GET /gstr1a/b2cla."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_b2cla(session: GstSession, args: Gstr1aB2claArgs) -> Any:
    """Get B2CLA Invoices
    GET /gstr1a/b2cla
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2cla",
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
class Gstr1aB2csArgs:
    """Arguments of GET /gstr1a/b2cs."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_b2cs(session: GstSession, args: Gstr1aB2csArgs) -> Any:
    """Get B2CS Invoices
    GET /gstr1a/b2cs
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2cs",
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
class Gstr1aB2csaArgs:
    """Arguments of GET /gstr1a/b2csa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_b2csa(session: GstSession, args: Gstr1aB2csaArgs) -> Any:
    """Get B2CSA Invoices
    GET /gstr1a/b2csa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/b2csa",
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
class Gstr1aCdnrArgs:
    """Arguments of GET /gstr1a/cdnr."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr1a_cdnr(session: GstSession, args: Gstr1aCdnrArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr1a/cdnr
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/cdnr",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "actionrequired": args.actionrequired,
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
class Gstr1aCdnraArgs:
    """Arguments of GET /gstr1a/cdnra."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr1a_cdnra(session: GstSession, args: Gstr1aCdnraArgs) -> Any:
    """Get CDNRA Invoices
    GET /gstr1a/cdnra
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/cdnra",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "actionrequired": args.actionrequired,
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
class Gstr1aCdnurArgs:
    """Arguments of GET /gstr1a/cdnur."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_cdnur(session: GstSession, args: Gstr1aCdnurArgs) -> Any:
    """API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
    GET /gstr1a/cdnur
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/cdnur",
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
class Gstr1aCdnuraArgs:
    """Arguments of GET /gstr1a/cdnura."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_cdnura(session: GstSession, args: Gstr1aCdnuraArgs) -> Any:
    """API call for getting all amended Credit/ Debit Notes issued to un-registered persons for a return period.
    GET /gstr1a/cdnura
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/cdnura",
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
class Gstr1aDocissArgs:
    """Arguments of GET /gstr1a/dociss."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_dociss(session: GstSession, args: Gstr1aDocissArgs) -> Any:
    """Get GSTR1A Document Issued
    GET /gstr1a/dociss
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/dociss",
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
class Gstr1aEcomArgs:
    """Arguments of GET /gstr1a/ecom."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rtin: Optional[str] = None  # query rtin
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1a_ecom(session: GstSession, args: Gstr1aEcomArgs) -> Any:
    """Get ECOM Invoices
    GET /gstr1a/ecom
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/ecom",
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
class Gstr1aEcomaArgs:
    """Arguments of GET /gstr1a/ecoma."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rtin: Optional[str] = None  # query rtin
    subsection: Optional[str] = None  # query subsection


def gstr1a_ecoma(session: GstSession, args: Gstr1aEcomaArgs) -> Any:
    """Get ECOMA Invoices
    GET /gstr1a/ecoma
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/ecoma",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "rtin": args.rtin,
                "subsection": args.subsection,
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
class Gstr1aExpArgs:
    """Arguments of GET /gstr1a/exp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_exp(session: GstSession, args: Gstr1aExpArgs) -> Any:
    """Get EXP
    GET /gstr1a/exp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/exp",
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
class Gstr1aExpaArgs:
    """Arguments of GET /gstr1a/expa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_expa(session: GstSession, args: Gstr1aExpaArgs) -> Any:
    """Get EXPA
    GET /gstr1a/expa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/expa",
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
class Gstr1aHsnsumArgs:
    """Arguments of GET /gstr1a/hsnsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_hsnsum(session: GstSession, args: Gstr1aHsnsumArgs) -> Any:
    """Get HSN Summary details
    GET /gstr1a/hsnsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/hsnsum",
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
class Gstr1aNilArgs:
    """Arguments of GET /gstr1a/nil."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_nil(session: GstSession, args: Gstr1aNilArgs) -> Any:
    """Get Nil Rated Supplies
    GET /gstr1a/nil
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/nil",
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
class Gstr1aProceedfileArgs:
    """Arguments of GET /gstr1a/proceedfile."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    is_nil: Optional[str] = None  # query isNil


def gstr1a_proceedfile(session: GstSession, args: Gstr1aProceedfileArgs) -> Any:
    """Proceed To File
    GET /gstr1a/proceedfile
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/proceedfile",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "isNil": args.is_nil,
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
class Gstr1aRetsumArgs:
    """Arguments of GET /gstr1a/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_retsum(session: GstSession, args: Gstr1aRetsumArgs) -> Any:
    """Get GSTR1A Summary
    GET /gstr1a/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/retsum",
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
class Gstr1aSupecoArgs:
    """Arguments of GET /gstr1a/supeco."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    subsection: Optional[str] = None  # query subsection
    fromtime: Optional[str] = None  # query fromtime


def gstr1a_supeco(session: GstSession, args: Gstr1aSupecoArgs) -> Any:
    """Get Supplier ECO invoices
    GET /gstr1a/supeco
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/supeco",
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
class Gstr1aSupecoaArgs:
    """Arguments of GET /gstr1a/supecoa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    subsection: Optional[str] = None  # query subsection


def gstr1a_supecoa(session: GstSession, args: Gstr1aSupecoaArgs) -> Any:
    """Get Supplier ECOA invoices
    GET /gstr1a/supecoa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/supecoa",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "subsection": args.subsection,
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
class Gstr1aTxpArgs:
    """Arguments of GET /gstr1a/txp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_txp(session: GstSession, args: Gstr1aTxpArgs) -> Any:
    """Get TXP
    GET /gstr1a/txp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/txp",
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
class Gstr1aTxpaArgs:
    """Arguments of GET /gstr1a/txpa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr1a_txpa(session: GstSession, args: Gstr1aTxpaArgs) -> Any:
    """Get TXPA
    GET /gstr1a/txpa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr1a/txpa",
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
class Gstr1aResetArgs:
    """Arguments of POST /gstr1a/reset."""

    ret_period: str  # header ret_period


def gstr1a_reset(session: GstSession, args: Gstr1aResetArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Reset GSTR1A Data
    POST /gstr1a/reset
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
            path="/gstr1a/reset",
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
class Gstr1aRetevcfileArgs:
    """Arguments of POST /gstr1a/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr1a_retevcfile(session: GstSession, args: Gstr1aRetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR1A data
    POST /gstr1a/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr1a_retevcfile (POST /gstr1a/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr1a/retevcfile",
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
class Gstr1aRetfileArgs:
    """Arguments of POST /gstr1a/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr1a_retfile(session: GstSession, args: Gstr1aRetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR1A data
    POST /gstr1a/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr1a_retfile (POST /gstr1a/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr1a/retfile",
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
class Gstr1aRetsaveArgs:
    """Arguments of PUT /gstr1a/retsave."""

    ret_period: str  # header ret_period


def gstr1a_retsave(session: GstSession, args: Gstr1aRetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR1A data
    PUT /gstr1a/retsave
    Asynchronous: the response carries data.reference_id; pass it as refid to retstatus and poll with wait_for_status.
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="PUT",
            path="/gstr1a/retsave",
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
