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
class AllDocdwldArgs:
    """Arguments of GET /all/docdwld."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    id: str  # query id


def all_docdwld(session: GstSession, args: AllDocdwldArgs) -> Any:
    """Document Download
    GET /all/docdwld
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/docdwld",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "id": args.id,
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
class AllFiledetArgs:
    """Arguments of GET /all/filedet."""

    gstin: str  # query gstin
    returnperiod: str  # query returnperiod
    token: str  # query token


def all_filedet(session: GstSession, args: AllFiledetArgs) -> Any:
    """Get File Details
    GET /all/filedet
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/filedet",
            query={
                "gstin": args.gstin,
                "returnperiod": args.returnperiod,
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
class AllGetmastersArgs:
    """Arguments of GET /all/getmasters."""

    ret_period: str  # header ret_period
    gstin: str  # query gstin


def all_getmasters(session: GstSession, args: AllGetmastersArgs) -> Any:
    """Get User Masters
    GET /all/getmasters
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/getmasters",
            query={
                "email": config.email,
                "gstin": args.gstin,
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
class AllGetprefArgs:
    """Arguments of GET /all/getpref."""

    gstin: str  # query gstin
    fy: str  # query fy


def all_getpref(session: GstSession, args: AllGetprefArgs) -> Any:
    """Get Preference
    GET /all/getpref
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/getpref",
            query={
                "gstin": args.gstin,
                "fy": args.fy,
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
class AllLargefileArgs:
    """Arguments of GET /all/largefile."""

    url: str  # query url
    ek: str  # query ek
    gstin: str  # query gstin
    returnperiod: str  # query returnperiod


def all_largefile(session: GstSession, args: AllLargefileArgs) -> Any:
    """Get Large File Details
    GET /all/largefile
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/largefile",
            query={
                "url": args.url,
                "ek": args.ek,
                "gstin": args.gstin,
                "returnperiod": args.returnperiod,
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
class AllLatefeeArgs:
    """Arguments of GET /all/latefee."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rettype: str  # query rettype


def all_latefee(session: GstSession, args: AllLatefeeArgs) -> Any:
    """Late Fee
    GET /all/latefee
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/latefee",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "rettype": args.rettype,
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
class AllLatefeebreakupArgs:
    """Arguments of GET /all/latefeebreakup."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rettype: str  # query rettype


def all_latefeebreakup(session: GstSession, args: AllLatefeebreakupArgs) -> Any:
    """Get additional late fee breakup
    GET /all/latefeebreakup
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/latefeebreakup",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "rettype": args.rettype,
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
class AllNewproceedfileArgs:
    """Arguments of GET /all/newproceedfile."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    type: str  # query type
    is_nil: Optional[str] = None  # query isNil


def all_newproceedfile(session: GstSession, args: AllNewproceedfileArgs) -> Any:
    """New Proceed To File(GSTR1,GSTR5,GSTR6)
    GET /all/newproceedfile
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/newproceedfile",
            query={
                "gstin": args.gstin,
                "retperiod": args.retperiod,
                "type": args.type,
                "isNil": args.is_nil,
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
class AllNewretstatusArgs:
    """Arguments of GET /all/newretstatus."""

    gstin: str  # query gstin
    returnperiod: str  # query returnperiod
    refid: str  # query refid
    rettype: str  # query rettype


def all_newretstatus(session: GstSession, args: AllNewretstatusArgs) -> Any:
    """Get Return Status
    GET /all/newretstatus
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/newretstatus",
            query={
                "gstin": args.gstin,
                "returnperiod": args.returnperiod,
                "refid": args.refid,
                "rettype": args.rettype,
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
class AllProceedfileArgs:
    """Arguments of GET /all/proceedfile."""

    gstin: str  # query gstin
    type: str  # query type
    retperiod: str  # query retperiod


def all_proceedfile(session: GstSession, args: AllProceedfileArgs) -> Any:
    """Proceed To File
    GET /all/proceedfile
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/all/proceedfile",
            query={
                "gstin": args.gstin,
                "type": args.type,
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
class AllDocupldArgs:
    """Arguments of POST /all/docupld."""

    ret_period: str  # header ret_period


def all_docupld(session: GstSession, args: AllDocupldArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Document Upload
    POST /all/docupld
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
            path="/all/docupld",
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
class AllSavemastersArgs:
    """Arguments of POST /all/savemasters."""

    ret_period: str  # header ret_period


def all_savemasters(session: GstSession, args: AllSavemastersArgs, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save User Masters
    POST /all/savemasters
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
            path="/all/savemasters",
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


def all_savepref(session: GstSession, body: Any, opts: Optional[WriteOptions] = None) -> Any:
    """Save Preference
    PUT /all/savepref
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
            path="/all/savepref",
            query={
                "email": config.email,
            },
            headers={
                "gstin": config.gst_gstin,
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
