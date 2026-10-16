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
class ImsGetfileArgs:
    """Arguments of GET /ims/getfile."""

    gstin: str  # query gstin
    token: str  # query token


def ims_getfile(session: GstSession, args: ImsGetfileArgs) -> Any:
    """Get IMS data
    GET /ims/getfile
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/getfile",
            query={
                "gstin": args.gstin,
                "token": args.token,
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
class ImsInvoicesArgs:
    """Arguments of GET /ims/invoices."""

    gstin: str  # query gstin
    section: str  # query section
    status: Optional[str] = None  # query status


def ims_invoices(session: GstSession, args: ImsInvoicesArgs) -> Any:
    """Get IMS data
    GET /ims/invoices
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/invoices",
            query={
                "gstin": args.gstin,
                "section": args.section,
                "email": config.email,
                "status": args.status,
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
class ImsInvoicescountArgs:
    """Arguments of GET /ims/invoicescount."""

    gstin: str  # query gstin
    goods_type: str  # query goodsType


def ims_invoicescount(session: GstSession, args: ImsInvoicescountArgs) -> Any:
    """Get IMS Count data
    GET /ims/invoicescount
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/invoicescount",
            query={
                "gstin": args.gstin,
                "goodsType": args.goods_type,
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
class ImsRejectedinvoicesArgs:
    """Arguments of GET /ims/rejectedInvoices."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    section: Optional[str] = None  # query section


def ims_rejectedinvoices(session: GstSession, args: ImsRejectedinvoicesArgs) -> Any:
    """Get Added Back Liability Records
    GET /ims/rejectedInvoices
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/rejectedInvoices",
            query={
                "gstin": args.gstin,
                "email": config.email,
                "retperiod": args.retperiod,
                "section": args.section,
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
class ImsStatusArgs:
    """Arguments of GET /ims/status."""

    gstin: str  # query gstin
    int_tran_id: str  # query int_tran_id


def ims_status(session: GstSession, args: ImsStatusArgs) -> Any:
    """Get IMS Status
    GET /ims/status
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/status",
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
class ImsSupplierinvoicesArgs:
    """Arguments of GET /ims/supplierInvoices."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    section: str  # query section
    rtn_typ: str  # query rtnTyp


def ims_supplierinvoices(session: GstSession, args: ImsSupplierinvoicesArgs) -> Any:
    """Get Supplier IMS Invoices data
    GET /ims/supplierInvoices
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ims/supplierInvoices",
            query={
                "gstin": args.gstin,
                "email": config.email,
                "retperiod": args.retperiod,
                "section": args.section,
                "rtnTyp": args.rtn_typ,
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
class ImsResetArgs:
    """Arguments of PUT /ims/reset."""

    ret_period: str  # header ret_period


def ims_reset(session: GstSession, args: ImsResetArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Reset IMS Data
    PUT /ims/reset
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
            path="/ims/reset",
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
class ImsSaveArgs:
    """Arguments of PUT /ims/save."""

    ret_period: str  # header ret_period


def ims_save(session: GstSession, args: ImsSaveArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save IMS Data
    PUT /ims/save
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
            path="/ims/save",
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
