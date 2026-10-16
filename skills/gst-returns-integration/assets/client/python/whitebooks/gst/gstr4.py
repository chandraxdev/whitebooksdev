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
class Gstr4AtArgs:
    """Arguments of GET /gstr4/at."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_at(session: GstSession, args: Gstr4AtArgs) -> Any:
    """Get AT
    GET /gstr4/at
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/at",
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
class Gstr4AtaArgs:
    """Arguments of GET /gstr4/ata."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_ata(session: GstSession, args: Gstr4AtaArgs) -> Any:
    """Get Advances Paid Amendment
    GET /gstr4/ata
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/ata",
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
class Gstr4B2bArgs:
    """Arguments of GET /gstr4/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr4_b2b(session: GstSession, args: Gstr4B2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr4/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/b2b",
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
class Gstr4B2baArgs:
    """Arguments of GET /gstr4/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr4_b2ba(session: GstSession, args: Gstr4B2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr4/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/b2ba",
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
class Gstr4B2burArgs:
    """Arguments of GET /gstr4/b2bur."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_b2bur(session: GstSession, args: Gstr4B2burArgs) -> Any:
    """Get B2B Unregistered Invoice
    GET /gstr4/b2bur
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/b2bur",
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
class Gstr4B2buraArgs:
    """Arguments of GET /gstr4/b2bura."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_b2bura(session: GstSession, args: Gstr4B2buraArgs) -> Any:
    """Get B2BUR Amendment
    GET /gstr4/b2bura
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/b2bura",
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
class Gstr4CdnrArgs:
    """Arguments of GET /gstr4/cdnr."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr4_cdnr(session: GstSession, args: Gstr4CdnrArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr4/cdnr
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/cdnr",
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
class Gstr4CdnraArgs:
    """Arguments of GET /gstr4/cdnra."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired


def gstr4_cdnra(session: GstSession, args: Gstr4CdnraArgs) -> Any:
    """Get CDNR Amendment
    GET /gstr4/cdnra
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/cdnra",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "actionrequired": args.actionrequired,
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
class Gstr4CdnurArgs:
    """Arguments of GET /gstr4/cdnur."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_cdnur(session: GstSession, args: Gstr4CdnurArgs) -> Any:
    """API call for getting all Credit/ Debit Notes issued to un-registered persons for a return period.
    GET /gstr4/cdnur
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/cdnur",
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
class Gstr4CdnuraArgs:
    """Arguments of GET /gstr4/cdnura."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_cdnura(session: GstSession, args: Gstr4CdnuraArgs) -> Any:
    """Get CDNUR Amendment
    GET /gstr4/cdnura
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/cdnura",
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
class Gstr4ImpsArgs:
    """Arguments of GET /gstr4/imps."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_imps(session: GstSession, args: Gstr4ImpsArgs) -> Any:
    """Get IMPS
    GET /gstr4/imps
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/imps",
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
class Gstr4ImpsaArgs:
    """Arguments of GET /gstr4/impsa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_impsa(session: GstSession, args: Gstr4ImpsaArgs) -> Any:
    """Get Imports of Services Amendment
    GET /gstr4/impsa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/impsa",
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
class Gstr4RetsumArgs:
    """Arguments of GET /gstr4/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_retsum(session: GstSession, args: Gstr4RetsumArgs) -> Any:
    """Get GSTR1 Summary
    GET /gstr4/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/retsum",
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
class Gstr4TdsArgs:
    """Arguments of GET /gstr4/tds."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_tds(session: GstSession, args: Gstr4TdsArgs) -> Any:
    """Get TDS
    GET /gstr4/tds
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/tds",
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
class Gstr4TxosArgs:
    """Arguments of GET /gstr4/txos."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_txos(session: GstSession, args: Gstr4TxosArgs) -> Any:
    """API call for getting invoices for Tax on Outward Supplies for a return period.
    GET /gstr4/txos
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/txos",
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
class Gstr4TxosaArgs:
    """Arguments of GET /gstr4/txosa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_txosa(session: GstSession, args: Gstr4TxosaArgs) -> Any:
    """Get TXOS Amendment
    GET /gstr4/txosa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/txosa",
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
class Gstr4TxpArgs:
    """Arguments of GET /gstr4/txp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_txp(session: GstSession, args: Gstr4TxpArgs) -> Any:
    """Get TXP
    GET /gstr4/txp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/txp",
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
class Gstr4TxpaArgs:
    """Arguments of GET /gstr4/txpa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4_txpa(session: GstSession, args: Gstr4TxpaArgs) -> Any:
    """Get Advances Adjusted Amendment
    GET /gstr4/txpa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4/txpa",
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
class Gstr4RetevcfileArgs:
    """Arguments of POST /gstr4/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr4_retevcfile(session: GstSession, args: Gstr4RetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR4 data
    POST /gstr4/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4_retevcfile (POST /gstr4/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4/retevcfile",
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
class Gstr4RetfileArgs:
    """Arguments of POST /gstr4/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr4_retfile(session: GstSession, args: Gstr4RetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR4 data
    POST /gstr4/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4_retfile (POST /gstr4/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4/retfile",
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
class Gstr4RetoffsetArgs:
    """Arguments of POST /gstr4/retoffset."""

    ret_period: str  # header ret_period


def gstr4_retoffset(session: GstSession, args: Gstr4RetoffsetArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """API call for offsetting the liabilities and interest from GSTR4
    POST /gstr4/retoffset
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4_retoffset (POST /gstr4/retoffset)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4/retoffset",
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
class Gstr4RetsubmitArgs:
    """Arguments of POST /gstr4/retsubmit."""

    ret_period: str  # header ret_period


def gstr4_retsubmit(session: GstSession, args: Gstr4RetsubmitArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Submit GSTR4 data
    POST /gstr4/retsubmit
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4_retsubmit (POST /gstr4/retsubmit)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4/retsubmit",
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
class Gstr4RetsaveArgs:
    """Arguments of PUT /gstr4/retsave."""

    ret_period: str  # header ret_period


def gstr4_retsave(session: GstSession, args: Gstr4RetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR4 data
    PUT /gstr4/retsave
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
            path="/gstr4/retsave",
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
