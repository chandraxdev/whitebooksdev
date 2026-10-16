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
class LedgersBalArgs:
    """Arguments of GET /ledgers/bal."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod


def ledgers_bal(session: GstSession, args: LedgersBalArgs) -> Any:
    """Get Cash ITC Balance
    GET /ledgers/bal
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/bal",
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
class LedgersCashdtlArgs:
    """Arguments of GET /ledgers/cashdtl."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_cashdtl(session: GstSession, args: LedgersCashdtlArgs) -> Any:
    """Cash Ledger Details
    GET /ledgers/cashdtl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/cashdtl",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersItcArgs:
    """Arguments of GET /ledgers/itc."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_itc(session: GstSession, args: LedgersItcArgs) -> Any:
    """ITC Ledger Details
    GET /ledgers/itc
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/itc",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersItcblocktrandetlsArgs:
    """Arguments of GET /ledgers/itcblocktrandetls."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_itcblocktrandetls(session: GstSession, args: LedgersItcblocktrandetlsArgs) -> Any:
    """Get Block Unblock
    GET /ledgers/itcblocktrandetls
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/itcblocktrandetls",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersNegliabstmtArgs:
    """Arguments of GET /ledgers/negliabstmt."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_negliabstmt(session: GstSession, args: LedgersNegliabstmtArgs) -> Any:
    """Get NegativeLiability Details of GSTR3B
    GET /ledgers/negliabstmt
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/negliabstmt",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersRcmldgArgs:
    """Arguments of GET /ledgers/rcmldg."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_rcmldg(session: GstSession, args: LedgersRcmldgArgs) -> Any:
    """Get RCM Statement
    GET /ledgers/rcmldg
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/rcmldg",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersRevrclmdtlArgs:
    """Arguments of GET /ledgers/revrclmdtl."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_revrclmdtl(session: GstSession, args: LedgersRevrclmdtlArgs) -> Any:
    """Get Credit Reversal and Re-claimed Details
    GET /ledgers/revrclmdtl
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/revrclmdtl",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersTaxArgs:
    """Arguments of GET /ledgers/tax."""

    gstin: str  # query gstin
    frdt: str  # query frdt
    todt: str  # query todt


def ledgers_tax(session: GstSession, args: LedgersTaxArgs) -> Any:
    """Get Liability Ledger Details
    GET /ledgers/tax
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/tax",
            query={
                "gstin": args.gstin,
                "frdt": args.frdt,
                "todt": args.todt,
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
class LedgersTaxpayableArgs:
    """Arguments of GET /ledgers/taxpayable."""

    gstin: str  # query gstin
    retperiod: str  # query retperiod
    rettype: str  # query rettype


def ledgers_taxpayable(session: GstSession, args: LedgersTaxpayableArgs) -> Any:
    """Get RetLiab Balance
    GET /ledgers/taxpayable
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="GET",
            path="/ledgers/taxpayable",
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
class LedgersUtlcshArgs:
    """Arguments of POST /ledgers/utlcsh."""

    ret_period: str  # header ret_period


def ledgers_utlcsh(session: GstSession, args: LedgersUtlcshArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Utilize Cash
    POST /ledgers/utlcsh
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("ledgers_utlcsh (POST /ledgers/utlcsh)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/ledgers/utlcsh",
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
class LedgersUtlitcArgs:
    """Arguments of POST /ledgers/utlitc."""

    ret_period: str  # header ret_period


def ledgers_utlitc(session: GstSession, args: LedgersUtlitcArgs, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Utilize ITC
    POST /ledgers/utlitc
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /gstr/retstatus); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    GSTR-1 retsave that times out has no data.reference_id, so retstatus cannot be asked about it and the outcome stays unknown.
    A status check runs only with opts.landed (see is_return_processed) and a refid from this return's own save.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("ledgers_utlitc (POST /ledgers/utlitc)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/ledgers/utlitc",
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
