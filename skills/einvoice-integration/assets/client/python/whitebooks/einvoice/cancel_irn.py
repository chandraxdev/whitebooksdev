# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Optional

from ..reconcile import Policy, WriteOptions, has_irn, reconcile_write, require_irreversible_confirmed
from ..session import Call, EinvoiceSession
from .models import EinvoiceCancelRequest
from ..einvoice.get_irn_details_by_doc_details import einvoice_getirnbydocdetails


@dataclass
class EinvoiceCancelArgs:
    """Arguments of POST /einvoice/type/CANCEL/version/V1_03."""

    irp: Optional[str] = None  # query irp


def einvoice_cancel(session: EinvoiceSession, args: EinvoiceCancelArgs, body: EinvoiceCancelRequest, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Cancel IRN
    POST /einvoice/type/CANCEL/version/V1_03
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("einvoice_cancel (POST /einvoice/type/CANCEL/version/V1_03)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/einvoice/type/CANCEL/version/V1_03",
            query={
                "email": config.email,
                "irp": args.irp,
            },
            headers={
                "ip_address": session.ip_address,
                "client_id": config.einv_client_id,
                "client_secret": config.einv_client_secret,
                "username": config.einv_nic_username,
                "auth-token": session.auth_token,
                "gstin": config.einv_gstin,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: einvoice_getirnbydocdetails(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy(landed=has_irn, not_found_code="2154"))
