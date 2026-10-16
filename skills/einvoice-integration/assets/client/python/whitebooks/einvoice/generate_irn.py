# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from typing import Any, Optional

from ..reconcile import Policy, WriteOptions, has_irn, reconcile_write
from ..session import Call, EinvoiceSession
from .models import EinvoiceGenerateRequest
from ..einvoice.get_irn_details_by_doc_details import einvoice_getirnbydocdetails


def einvoice_generate(session: EinvoiceSession, body: EinvoiceGenerateRequest, opts: Optional[WriteOptions] = None) -> Any:
    """Generate IRN
    POST /einvoice/type/GENERATE/version/V1_03
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /einvoice/type/GETIRNBYDOCDETAILS/version/V1_03); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    """
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/einvoice/type/GENERATE/version/V1_03",
            query={
                "email": config.email,
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
