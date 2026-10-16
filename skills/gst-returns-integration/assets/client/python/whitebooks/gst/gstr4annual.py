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
class Gstr4annualAutopopArgs:
    """Arguments of GET /gstr4annual/autopop."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_autopop(session: GstSession, args: Gstr4annualAutopopArgs) -> Any:
    """Get autopopulated data for table 4A/4B of GSTR4 Annual form
    GET /gstr4annual/autopop
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/autopop",
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
class Gstr4annualGetsumArgs:
    """Arguments of GET /gstr4annual/getsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_getsum(session: GstSession, args: Gstr4annualGetsumArgs) -> Any:
    """Get summary Invoices
    GET /gstr4annual/getsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/getsum",
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
class Gstr4annualTdscmpArgs:
    """Arguments of GET /gstr4annual/tdscmp."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_tdscmp(session: GstSession, args: Gstr4annualTdscmpArgs) -> Any:
    """Get tdscmp Invoices
    GET /gstr4annual/tdscmp
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/tdscmp",
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
class Gstr4annualTxiosArgs:
    """Arguments of GET /gstr4annual/txios."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_txios(session: GstSession, args: Gstr4annualTxiosArgs) -> Any:
    """Get txios Invoices
    GET /gstr4annual/txios
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/txios",
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
class Gstr4annualValidateliabilityArgs:
    """Arguments of GET /gstr4annual/validateliability."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_validateliability(session: GstSession, args: Gstr4annualValidateliabilityArgs) -> Any:
    """Get validate the liability provided in table 6 for GSTR4 Annual form
    GET /gstr4annual/validateliability
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/validateliability",
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
class Gstr4annualValidateturnoverArgs:
    """Arguments of GET /gstr4annual/validateturnover."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr4annual_validateturnover(session: GstSession, args: Gstr4annualValidateturnoverArgs) -> Any:
    """Get validate turnover for GSTR4 Annual form
    GET /gstr4annual/validateturnover
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr4annual/validateturnover",
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
class Gstr4annualRetevcfileArgs:
    """Arguments of POST /gstr4annual/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr4annual_retevcfile(session: GstSession, args: Gstr4annualRetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR4 Annual data
    POST /gstr4annual/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4annual_retevcfile (POST /gstr4annual/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4annual/retevcfile",
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
class Gstr4annualRetfileArgs:
    """Arguments of POST /gstr4annual/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def gstr4annual_retfile(session: GstSession, args: Gstr4annualRetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR4Annual data
    POST /gstr4annual/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr4annual_retfile (POST /gstr4annual/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr4annual/retfile",
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
class Gstr4annualRetsaveArgs:
    """Arguments of PUT /gstr4annual/retsave."""

    ret_period: str  # header ret_period


def gstr4annual_retsave(session: GstSession, args: Gstr4annualRetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR4Annual data
    PUT /gstr4annual/retsave
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
            path="/gstr4annual/retsave",
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
