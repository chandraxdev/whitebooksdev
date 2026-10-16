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
class Gstr3bAutoliabArgs:
    """Arguments of GET /gstr3b/autoliab."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr3b_autoliab(session: GstSession, args: Gstr3bAutoliabArgs) -> Any:
    """Get GSTR1 auto calculated liability details
    GET /gstr3b/autoliab
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/autoliab",
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
class Gstr3bClosingbalArgs:
    """Arguments of GET /gstr3b/closingbal."""

    gstin: str  # query gstin


def gstr3b_closingbal(session: GstSession, args: Gstr3bClosingbalArgs) -> Any:
    """Get ITC Reversal Balance
    GET /gstr3b/closingbal
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/closingbal",
            query={
                "gstin": args.gstin,
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
class Gstr3bOpeningbalArgs:
    """Arguments of GET /gstr3b/openingbal."""

    gstin: str  # query gstin


def gstr3b_openingbal(session: GstSession, args: Gstr3bOpeningbalArgs) -> Any:
    """Get Opening Balance For Credit Reversal and Re-claimed Details
    GET /gstr3b/openingbal
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/openingbal",
            query={
                "gstin": args.gstin,
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
class Gstr3bRcmclosingbalArgs:
    """Arguments of GET /gstr3b/rcmclosingbal."""

    ret_period: str  # header ret_period
    gstin: str  # query gstin


def gstr3b_rcmclosingbal(session: GstSession, args: Gstr3bRcmclosingbalArgs) -> Any:
    """Get latest closing balance
    GET /gstr3b/rcmclosingbal
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/rcmclosingbal",
            query={
                "gstin": args.gstin,
                "email": config.email,
            },
            headers={
                "ret_period": args.ret_period,
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
class Gstr3bRcmopeningbalArgs:
    """Arguments of GET /gstr3b/rcmopeningbal."""

    ret_period: str  # header ret_period
    gstin: str  # query gstin


def gstr3b_rcmopeningbal(session: GstSession, args: Gstr3bRcmopeningbalArgs) -> Any:
    """Get RCM opening balance
    GET /gstr3b/rcmopeningbal
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/rcmopeningbal",
            query={
                "gstin": args.gstin,
                "email": config.email,
            },
            headers={
                "ret_period": args.ret_period,
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
class Gstr3bRetsumArgs:
    """Arguments of GET /gstr3b/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr3b_retsum(session: GstSession, args: Gstr3bRetsumArgs) -> Any:
    """Get GSTR3B Summary
    GET /gstr3b/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/retsum",
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
class Gstr3bSyscalcintrstArgs:
    """Arguments of GET /gstr3b/syscalcintrst."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr3b_syscalcintrst(session: GstSession, args: Gstr3bSyscalcintrstArgs) -> Any:
    """Get system calculated interest
    GET /gstr3b/syscalcintrst
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr3b/syscalcintrst",
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
class Gstr3bCmpintArgs:
    """Arguments of POST /gstr3b/cmpint."""

    ret_period: str  # header ret_period


def gstr3b_cmpint(session: GstSession, args: Gstr3bCmpintArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Recompute System Calulated Interest
    POST /gstr3b/cmpint
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
            path="/gstr3b/cmpint",
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
class Gstr3bRetevcfileArgs:
    """Arguments of POST /gstr3b/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr3b_retevcfile(session: GstSession, args: Gstr3bRetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR3B data
    POST /gstr3b/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr3b_retevcfile (POST /gstr3b/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr3b/retevcfile",
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
class Gstr3bRetfileArgs:
    """Arguments of POST /gstr3b/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr3b_retfile(session: GstSession, args: Gstr3bRetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR3B data
    POST /gstr3b/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr3b_retfile (POST /gstr3b/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr3b/retfile",
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
class Gstr3bSavercmopnbalArgs:
    """Arguments of POST /gstr3b/savercmopnbal."""

    ret_period: str  # header ret_period


def gstr3b_savercmopnbal(session: GstSession, args: Gstr3bSavercmopnbalArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Submit RCM opening balance
    POST /gstr3b/savercmopnbal
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
            path="/gstr3b/savercmopnbal",
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
class Gstr3bValidateautocalculatedataArgs:
    """Arguments of POST /gstr3b/validateautocalculatedata."""

    ret_period: str  # header ret_period


def gstr3b_validateautocalculatedata(session: GstSession, args: Gstr3bValidateautocalculatedataArgs, body: Any) -> Any:
    """validate GSTR3B against auto calculated values
    POST /gstr3b/validateautocalculatedata
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr3b/validateautocalculatedata",
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
class Gstr3bLiabilitybreakupArgs:
    """Arguments of PUT /gstr3b/liabilitybreakup."""

    ret_period: str  # header ret_period


def gstr3b_liabilitybreakup(session: GstSession, args: Gstr3bLiabilitybreakupArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save past liability breakup GSTR3B Data
    PUT /gstr3b/liabilitybreakup
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
            path="/gstr3b/liabilitybreakup",
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
class Gstr3bRetoffsetArgs:
    """Arguments of PUT /gstr3b/retoffset."""

    ret_period: str  # header ret_period


def gstr3b_retoffset(session: GstSession, args: Gstr3bRetoffsetArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Offset Liability GSTR3B Data
    PUT /gstr3b/retoffset
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr3b_retoffset (PUT /gstr3b/retoffset)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="PUT",
            path="/gstr3b/retoffset",
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
class Gstr3bRetsaveArgs:
    """Arguments of PUT /gstr3b/retsave."""

    ret_period: str  # header ret_period


def gstr3b_retsave(session: GstSession, args: Gstr3bRetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR3B data
    PUT /gstr3b/retsave
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
            path="/gstr3b/retsave",
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
