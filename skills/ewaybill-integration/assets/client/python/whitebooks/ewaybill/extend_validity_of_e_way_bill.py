# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area ewaybill
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from typing import Any, Optional

from ..reconcile import Policy, WriteOptions, has_eway_bill_no, reconcile_write, require_irreversible_confirmed
from ..session import Call, EwaybillSession
from ..ewaybill.get_ewaybill_details import ewb_getewaybill


def ewb_extendvalidity(session: EwaybillSession, body: Any, opts: Optional[WriteOptions] = None, *, confirm_irreversible: bool = False) -> Any:
    """Extend Validity of E-Way Bill
    POST /ewaybillapi/v1.03/ewayapi/extendvalidity
    Request body: generic JSON. Its schema is in the WhiteBooks API reference for this endpoint.
    A timeout or other unknown outcome is reconciled: pass opts.reconcile with the arguments of the status operation
    (GET /ewaybillapi/v1.03/ewayapi/getewaybill); without it the write is never repeated and ends in WRITE_OUTCOME_UNKNOWN.
    Irreversible: this cannot be undone. It raises IRREVERSIBLE_NOT_CONFIRMED before any network call unless
    confirm_irreversible=True; pass that only after the user has confirmed this exact operation and document.
    """
    require_irreversible_confirmed("ewb_extendvalidity (POST /ewaybillapi/v1.03/ewayapi/extendvalidity)", confirm_irreversible)
    config = session.config

    def build() -> Call:
        return Call(
            method="POST",
            path="/ewaybillapi/v1.03/ewayapi/extendvalidity",
            query={
                "email": config.email,
            },
            headers={
                "ip_address": session.ip_address,
                "client_id": config.ewb_client_id,
                "client_secret": config.ewb_client_secret,
                "username": config.ewb_nic_username,
                "gstin": config.ewb_gstin,
            },
            body=body,
        )

    options = opts or WriteOptions()
    reconcile = options.reconcile
    check = None if reconcile is None else (lambda: ewb_getewaybill(session, reconcile))
    return reconcile_write(lambda: session.call(build), check, options, Policy(landed=has_eway_bill_no))
