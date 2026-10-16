# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Optional

from ..config import Config, require_area
from ..session import Call, send, with_retries


@dataclass
class EinvoiceQrcodeArgs:
    """Arguments of GET /einvoice/qrcode."""

    sgstin: str  # header sgstin
    docno: str  # header docno
    docdate: str  # header docdate
    totinvval: str  # header totinvval
    bankaccno: str  # header bankaccno
    bankifsccode: str  # header bankifsccode
    accountholdername: str  # header accountholdername
    igstamount: str  # header igstamount
    cgstamount: str  # header cgstamount
    sgstamount: str  # header sgstamount
    cessamount: str  # header cessamount
    upiid: Optional[str] = None  # header upiid


def einvoice_qrcode(config: Config, args: EinvoiceQrcodeArgs) -> Any:
    """Get B2C QR Code Details
    GET /einvoice/qrcode
    Public: no session is needed.
    """
    require_area(config, "einvoice")

    def build() -> Call:
        return Call(
            method="GET",
            path="/einvoice/qrcode",
            query={
                "email": config.email,
            },
            headers={
                "ip_address": config.ip_address,
                "client_id": config.einv_client_id,
                "client_secret": config.einv_client_secret,
                "username": config.einv_nic_username,
                "sgstin": args.sgstin,
                "docno": args.docno,
                "docdate": args.docdate,
                "totinvval": args.totinvval,
                "upiid": args.upiid,
                "bankaccno": args.bankaccno,
                "bankifsccode": args.bankifsccode,
                "accountholdername": args.accountholdername,
                "igstamount": args.igstamount,
                "cgstamount": args.cgstamount,
                "sgstamount": args.sgstamount,
                "cessamount": args.cessamount,
            },
        )
    return with_retries(lambda: send(config, build()))
