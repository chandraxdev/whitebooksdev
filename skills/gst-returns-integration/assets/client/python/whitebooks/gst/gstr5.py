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
class Gstr5B2bArgs:
    """Arguments of GET /gstr5/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr5_b2b(session: GstSession, args: Gstr5B2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr5/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2b",
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
class Gstr5B2baArgs:
    """Arguments of GET /gstr5/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr5_b2ba(session: GstSession, args: Gstr5B2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr5/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2ba",
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
class Gstr5B2clArgs:
    """Arguments of GET /gstr5/b2cl."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr5_b2cl(session: GstSession, args: Gstr5B2clArgs) -> Any:
    """Get B2CL Invoices
    GET /gstr5/b2cl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2cl",
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
class Gstr5B2claArgs:
    """Arguments of GET /gstr5/b2cla."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr5_b2cla(session: GstSession, args: Gstr5B2claArgs) -> Any:
    """Get B2CLA Invoices
    GET /gstr5/b2cla
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2cla",
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
class Gstr5B2csArgs:
    """Arguments of GET /gstr5/b2cs."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr5_b2cs(session: GstSession, args: Gstr5B2csArgs) -> Any:
    """Get B2CS Invoices
    GET /gstr5/b2cs
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2cs",
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
class Gstr5B2csaArgs:
    """Arguments of GET /gstr5/b2csa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    statecd: Optional[str] = None  # query statecd


def gstr5_b2csa(session: GstSession, args: Gstr5B2csaArgs) -> Any:
    """Get B2CSA Invoices
    GET /gstr5/b2csa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/b2csa",
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
class Gstr5CdnArgs:
    """Arguments of GET /gstr5/cdn."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr5_cdn(session: GstSession, args: Gstr5CdnArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr5/cdn
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/cdn",
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
class Gstr5CdnaArgs:
    """Arguments of GET /gstr5/cdna."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr5_cdna(session: GstSession, args: Gstr5CdnaArgs) -> Any:
    """Get CDNRA Invoices
    GET /gstr5/cdna
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/cdna",
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
class Gstr5CdnurArgs:
    """Arguments of GET /gstr5/cdnur."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_cdnur(session: GstSession, args: Gstr5CdnurArgs) -> Any:
    """Get CDN Unregistered
    GET /gstr5/cdnur
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/cdnur",
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
class Gstr5CdnuraArgs:
    """Arguments of GET /gstr5/cdnura."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_cdnura(session: GstSession, args: Gstr5CdnuraArgs) -> Any:
    """Get CDNA Unregistered
    GET /gstr5/cdnura
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/cdnura",
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
class Gstr5ImpgArgs:
    """Arguments of GET /gstr5/impg."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_impg(session: GstSession, args: Gstr5ImpgArgs) -> Any:
    """Get IMPG Invoices
    GET /gstr5/impg
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/impg",
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
class Gstr5ImpgaArgs:
    """Arguments of GET /gstr5/impga."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_impga(session: GstSession, args: Gstr5ImpgaArgs) -> Any:
    """Get IMPGA Invoices
    GET /gstr5/impga
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/impga",
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
class Gstr5ImpsArgs:
    """Arguments of GET /gstr5/imps."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_imps(session: GstSession, args: Gstr5ImpsArgs) -> Any:
    """Get IMPS Invoices
    GET /gstr5/imps
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/imps",
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
class Gstr5ImpsaArgs:
    """Arguments of GET /gstr5/impsa."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_impsa(session: GstSession, args: Gstr5ImpsaArgs) -> Any:
    """Get IMPSA Invoices
    GET /gstr5/impsa
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/impsa",
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
class Gstr5RetsumArgs:
    """Arguments of GET /gstr5/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_retsum(session: GstSession, args: Gstr5RetsumArgs) -> Any:
    """Get GSTR5 Summary
    GET /gstr5/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/retsum",
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
class Gstr5TtxliArgs:
    """Arguments of GET /gstr5/ttxli."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr5_ttxli(session: GstSession, args: Gstr5TtxliArgs) -> Any:
    """Get Tax Liab
    GET /gstr5/ttxli
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr5/ttxli",
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
class Gstr5RetevcfileArgs:
    """Arguments of POST /gstr5/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr5_retevcfile(session: GstSession, args: Gstr5RetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR5 data
    POST /gstr5/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr5_retevcfile (POST /gstr5/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr5/retevcfile",
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
class Gstr5RetfileArgs:
    """Arguments of POST /gstr5/retfile."""

    ret_period: str  # header ret_period


def gstr5_retfile(session: GstSession, args: Gstr5RetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR5
    POST /gstr5/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr5_retfile (POST /gstr5/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr5/retfile",
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
class Gstr5RetsubmitArgs:
    """Arguments of POST /gstr5/retsubmit."""

    ret_period: str  # header ret_period


def gstr5_retsubmit(session: GstSession, args: Gstr5RetsubmitArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Submit
    POST /gstr5/retsubmit
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr5_retsubmit (POST /gstr5/retsubmit)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr5/retsubmit",
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
class Gstr5RetoffsetArgs:
    """Arguments of PUT /gstr5/retoffset."""

    ret_period: str  # header ret_period


def gstr5_retoffset(session: GstSession, args: Gstr5RetoffsetArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Offset Liability GSTR5 data
    PUT /gstr5/retoffset
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr5_retoffset (PUT /gstr5/retoffset)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="PUT",
            path="/gstr5/retoffset",
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
class Gstr5RetsaveArgs:
    """Arguments of PUT /gstr5/retsave."""

    ret_period: str  # header ret_period


def gstr5_retsave(session: GstSession, args: Gstr5RetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR5 data
    PUT /gstr5/retsave
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
            path="/gstr5/retsave",
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
