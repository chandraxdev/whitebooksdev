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
class Gstr6B2bArgs:
    """Arguments of GET /gstr6/b2b."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin
    fromtime: Optional[str] = None  # query fromtime


def gstr6_b2b(session: GstSession, args: Gstr6B2bArgs) -> Any:
    """Get B2B Invoices
    GET /gstr6/b2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/b2b",
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
class Gstr6B2baArgs:
    """Arguments of GET /gstr6/b2ba."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6_b2ba(session: GstSession, args: Gstr6B2baArgs) -> Any:
    """Get B2BA Invoices
    GET /gstr6/b2ba
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/b2ba",
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
class Gstr6CdnArgs:
    """Arguments of GET /gstr6/cdn."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6_cdn(session: GstSession, args: Gstr6CdnArgs) -> Any:
    """Get CDNR Invoices
    GET /gstr6/cdn
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/cdn",
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
class Gstr6CdnaArgs:
    """Arguments of GET /gstr6/cdna."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    actionrequired: Optional[str] = None  # query actionrequired
    ctin: Optional[str] = None  # query ctin


def gstr6_cdna(session: GstSession, args: Gstr6CdnaArgs) -> Any:
    """Get CDNRA Invoices
    GET /gstr6/cdna
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/cdna",
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


@dataclass
class Gstr6IsdArgs:
    """Arguments of GET /gstr6/isd."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr6_isd(session: GstSession, args: Gstr6IsdArgs) -> Any:
    """Get ISD Details
    GET /gstr6/isd
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/isd",
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
class Gstr6IsdaArgs:
    """Arguments of GET /gstr6/isda."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    ctin: Optional[str] = None  # query ctin


def gstr6_isda(session: GstSession, args: Gstr6IsdaArgs) -> Any:
    """Get Amendment ISD Details
    GET /gstr6/isda
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/isda",
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
class Gstr6ItcArgs:
    """Arguments of GET /gstr6/itc."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr6_itc(session: GstSession, args: Gstr6ItcArgs) -> Any:
    """Get ITC Details
    GET /gstr6/itc
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/itc",
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
class Gstr6LatefeeArgs:
    """Arguments of GET /gstr6/latefee."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr6_latefee(session: GstSession, args: Gstr6LatefeeArgs) -> Any:
    """Get Late Fee
    GET /gstr6/latefee
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/latefee",
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
class Gstr6RetsumArgs:
    """Arguments of GET /gstr6/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fnl: str  # query fnl


def gstr6_retsum(session: GstSession, args: Gstr6RetsumArgs) -> Any:
    """Get GSTR6 Summary
    GET /gstr6/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr6/retsum",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "fnl": args.fnl,
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
class Gstr6RetcalArgs:
    """Arguments of POST /gstr6/retcal."""

    ret_period: str  # header ret_period


def gstr6_retcal(session: GstSession, args: Gstr6RetcalArgs, body: Any) -> Any:
    """GSTR6 Calculate R6
    POST /gstr6/retcal
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr6/retcal",
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
    return with_retries(lambda: session.call(build))


@dataclass
class Gstr6RetevcfileArgs:
    """Arguments of POST /gstr6/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr6_retevcfile(session: GstSession, args: Gstr6RetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR6 data
    POST /gstr6/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr6_retevcfile (POST /gstr6/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr6/retevcfile",
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
class Gstr6RetfileArgs:
    """Arguments of POST /gstr6/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr6_retfile(session: GstSession, args: Gstr6RetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR6 data
    POST /gstr6/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr6_retfile (POST /gstr6/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr6/retfile",
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
class Gstr6RetsubmitArgs:
    """Arguments of POST /gstr6/retsubmit."""

    ret_period: str  # header ret_period


def gstr6_retsubmit(session: GstSession, args: Gstr6RetsubmitArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Submit GSTR6 data
    POST /gstr6/retsubmit
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr6_retsubmit (POST /gstr6/retsubmit)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr6/retsubmit",
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
class Gstr6SavecrossitcdetailsArgs:
    """Arguments of POST /gstr6/savecrossitcdetails."""

    ret_period: str  # header ret_period


def gstr6_savecrossitcdetails(session: GstSession, args: Gstr6SavecrossitcdetailsArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR6 Cross ITC details
    POST /gstr6/savecrossitcdetails
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
            path="/gstr6/savecrossitcdetails",
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
class Gstr6RetoffsetlatefeeArgs:
    """Arguments of PUT /gstr6/retoffsetlatefee."""

    ret_period: str  # header ret_period


def gstr6_retoffsetlatefee(session: GstSession, args: Gstr6RetoffsetlatefeeArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Offset Liability GSTR6 Late fee
    PUT /gstr6/retoffsetlatefee
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr6_retoffsetlatefee (PUT /gstr6/retoffsetlatefee)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="PUT",
            path="/gstr6/retoffsetlatefee",
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
class Gstr6RetsaveArgs:
    """Arguments of PUT /gstr6/retsave."""

    ret_period: str  # header ret_period


def gstr6_retsave(session: GstSession, args: Gstr6RetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR6 data
    PUT /gstr6/retsave
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
            path="/gstr6/retsave",
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
