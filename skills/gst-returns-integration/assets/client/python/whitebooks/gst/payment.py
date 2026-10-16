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
class PaymentChllnlstArgs:
    """Arguments of GET /payment/chllnlst."""

    gstin: str  # query gstin
    fromdate: str  # query fromdate
    todate: str  # query todate


def payment_chllnlst(session: GstSession, args: PaymentChllnlstArgs) -> Any:
    """Get Challan History
    GET /payment/chllnlst
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/payment/chllnlst",
            query={
                "gstin": args.gstin,
                "fromdate": args.fromdate,
                "todate": args.todate,
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
class PaymentChllnsumArgs:
    """Arguments of GET /payment/chllnsum."""

    gstin: str  # query gstin
    cpin: str  # query cpin


def payment_chllnsum(session: GstSession, args: PaymentChllnsumArgs) -> Any:
    """Get Challan Summary
    GET /payment/chllnsum
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/payment/chllnsum",
            query={
                "gstin": args.gstin,
                "cpin": args.cpin,
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
class PaymentGeneratechallanArgs:
    """Arguments of POST /payment/generateChallan."""

    ret_period: str  # header ret_period


def payment_generatechallan(session: GstSession, args: PaymentGeneratechallanArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Generate Challan
    POST /payment/generateChallan
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("payment_generatechallan (POST /payment/generateChallan)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/payment/generateChallan",
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
class PaymentValidatechlnrsnArgs:
    """Arguments of POST /payment/validatechlnrsn."""

    ret_period: str  # header ret_period


def payment_validatechlnrsn(session: GstSession, args: PaymentValidatechlnrsnArgs, body: Any) -> Any:
    """Validate Challan Reason
    POST /payment/validatechlnrsn
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/payment/validatechlnrsn",
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
