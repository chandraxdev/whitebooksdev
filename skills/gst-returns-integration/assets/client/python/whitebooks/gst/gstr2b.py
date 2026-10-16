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
from ..reconcile import Policy, WriteOptions, reconcile_write
from ..session import Call, with_retries, GstSession
from ..gst.gstr import gstr_retstatus


@dataclass
class Gstr2bAllArgs:
    """Arguments of GET /gstr2b/all."""

    gstin: str  # query gstin
    rtnprd: str  # query rtnprd
    filenum: Optional[str] = None  # query filenum


def gstr2b_all(session: GstSession, args: Gstr2bAllArgs) -> Any:
    """Get All Details
    GET /gstr2b/all
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2b/all",
            query={
                "gstin": args.gstin,
                "rtnprd": args.rtnprd,
                "filenum": args.filenum,
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
class Gstr2bGet2bArgs:
    """Arguments of GET /gstr2b/get2b."""

    gstin: str  # query gstin
    int_tran_id: str  # query int_tran_id


def gstr2b_get2b(session: GstSession, args: Gstr2bGet2bArgs) -> Any:
    """Get 2B generate status
    GET /gstr2b/get2b
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/gstr2b/get2b",
            query={
                "gstin": args.gstin,
                "int_tran_id": args.int_tran_id,
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
class Gstr2bGen2bArgs:
    """Arguments of PUT /gstr2b/gen2b."""

    ret_period: str  # header ret_period


def gstr2b_gen2b(session: GstSession, args: Gstr2bGen2bArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Generate 2B on demand
    PUT /gstr2b/gen2b
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
            path="/gstr2b/gen2b",
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
