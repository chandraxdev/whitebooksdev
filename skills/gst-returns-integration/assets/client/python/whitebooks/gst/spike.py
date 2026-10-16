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
class SpikeRtncomplistArgs:
    """Arguments of GET /spike/rtncomplist."""

    gstin: str  # query gstin
    refid: str  # query refid
    retperiod: str  # query retperiod
    frmtyp: str  # query frmtyp
    status: Optional[str] = None  # query status


def spike_rtncomplist(session: GstSession, args: SpikeRtncomplistArgs) -> Any:
    """Get DRC01C/DRC01B Data
    GET /spike/rtncomplist
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/spike/rtncomplist",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "refid": args.refid,
                "retperiod": args.retperiod,
                "status": args.status,
                "frmtyp": args.frmtyp,
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
class SpikeRtncompsumArgs:
    """Arguments of GET /spike/rtncompsum."""

    gstin: str  # query gstin
    refid: str  # query refid
    retperiod: str  # query retperiod


def spike_rtncompsum(session: GstSession, args: SpikeRtncompsumArgs) -> Any:
    """get mismatch in GSTR1 and GSTR3B
    GET /spike/rtncompsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/spike/rtncompsum",
            query={
                "email": config.email,
                "gstin": args.gstin,
                "refid": args.refid,
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
class SpikeRetfileArgs:
    """Arguments of POST /spike/retfile."""

    ret_period: str  # header ret_period
    pan: str  # query pan


def spike_retfile(session: GstSession, args: SpikeRetfileArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """File SPIKE data
    POST /spike/retfile
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("spike_retfile (POST /spike/retfile)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/spike/retfile",
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
class SpikeSpikesaveArgs:
    """Arguments of PUT /spike/spikesave."""

    ret_period: str  # header ret_period


def spike_spikesave(session: GstSession, args: SpikeSpikesaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save SPIKE data
    PUT /spike/spikesave
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
            path="/spike/spikesave",
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
