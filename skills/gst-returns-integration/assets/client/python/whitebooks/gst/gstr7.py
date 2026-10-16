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
class Gstr7RetsumArgs:
    """Arguments of GET /gstr7/retsum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def gstr7_retsum(session: GstSession, args: Gstr7RetsumArgs) -> Any:
    """Get GSTR7 Summary
    GET /gstr7/retsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr7/retsum",
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
class Gstr7TdsArgs:
    """Arguments of GET /gstr7/tds."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fromtime: str  # query fromtime
    rectype: str  # query rectype


def gstr7_tds(session: GstSession, args: Gstr7TdsArgs) -> Any:
    """Get TDS details
    GET /gstr7/tds
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr7/tds",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "fromtime": args.fromtime,
                "rectype": args.rectype,
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
class Gstr7TdschecksumArgs:
    """Arguments of GET /gstr7/tdschecksum."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    fromtime: str  # query fromtime
    rectype: str  # query rectype


def gstr7_tdschecksum(session: GstSession, args: Gstr7TdschecksumArgs) -> Any:
    """Get TDS Checksum
    GET /gstr7/tdschecksum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr7/tdschecksum",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "email": config.email,
                "fromtime": args.fromtime,
                "rectype": args.rectype,
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
class Gstr7RetevcfileArgs:
    """Arguments of POST /gstr7/retevcfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan
    evcotp: str  # query evcotp


def gstr7_retevcfile(session: GstSession, args: Gstr7RetevcfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR7 data
    POST /gstr7/retevcfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr7_retevcfile (POST /gstr7/retevcfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr7/retevcfile",
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
class Gstr7RetfileArgs:
    """Arguments of POST /gstr7/retfile."""

    ret_period: str  # header ret_period


def gstr7_retfile(session: GstSession, args: Gstr7RetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File GSTR7
    POST /gstr7/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("gstr7_retfile (POST /gstr7/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/gstr7/retfile",
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
class Gstr7RetsaveArgs:
    """Arguments of PUT /gstr7/retsave."""

    ret_period: str  # header ret_period


def gstr7_retsave(session: GstSession, args: Gstr7RetsaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save GSTR7
    PUT /gstr7/retsave
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
            path="/gstr7/retsave",
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
