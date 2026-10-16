# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area ewaybill
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: Python 3.10+ (typing only).

from __future__ import annotations

from typing import List, Literal, TypedDict


class _EwbCancelRequestRequired(TypedDict):
    ewbNo: float  # EwayBill Number
    cancelRsnCode: float  # Reason for cancellation


class EwbCancelRequest(_EwbCancelRequestRequired, total=False):
    cancelRmrk: str  # Remarks


class EwbGenerateRequestItemList(TypedDict, total=False):
    productName: str  # Product / Item Name
    productDesc: str  # Product / Item description
    hsnCode: float  # HSN Code
    quantity: float  # Quantity
    qtyUnit: str  # Unit
    taxableAmount: float  # Taxable Amount
    sgstRate: float  # SGST Rate of Tax
    cgstRate: float  # CGST Rate of Tax
    igstRate: float  # IGST Rate of Tax
    cessRate: float  # Cess Rate of Tax
    cessNonadvol: float  # Cess Non-Advolerum


class _EwbGenerateRequestRequired(TypedDict):
    supplyType: Literal["O", "I"]  # Supply Type
    subSupplyType: str  # Sub Supply Type
    docType: Literal["INV", "CHL", "BIL", "BOE", "CNT", "OTH"]  # Document Type
    docNo: str  # Document Number (Alphanumeric with / and - are allowed)
    docDate: str  # Document Date
    fromGstin: str  # From GSTIN (Supplier or Consignor)
    actFromStateCode: int  # Actual From State Code
    fromPincode: int  # From Pincode
    fromStateCode: int  # From State Code
    toGstin: str  # To GSTIN (Consignee or Recipient)
    toPincode: int  # To Pincode
    actToStateCode: int  # Actual To State Code
    toStateCode: int  # To State Code
    transactionType: int  # Transaction type
    totInvValue: float  # Total Invoice Value
    transMode: Literal["1", "2", "3", "4"]  # Mode of transport (Road-1, Rail-2, Air-3, Ship-4)
    transDistance: str  # Distance (<4000 km)
    itemList: List[EwbGenerateRequestItemList]


class EwbGenerateRequest(_EwbGenerateRequestRequired, total=False):
    subSupplyDesc: str  # Other Sub Supply Description
    fromTrdName: str  # From Trade Name (Consignor Trade name)
    fromAddr1: str  # From Address Line 1 (Valid Special Chars #,-,/)
    fromAddr2: str  # From Address Line 2(Valid Special Chars # , - ,/)
    fromPlace: str  # From Place
    toTrdName: str  # To Trade Name (Consignee Trade name or Recipient Trade name)
    toAddr1: str  # To Address Line 1 (Valid Special Chars #,-,/)
    toAddr2: str  # To Address Line 2 (Valid Special Chars #,-,/)
    toPlace: str  # To Place
    dispatchFromGSTIN: str  # GSTIN of Dispatch-From
    dispatchFromTradeName: str  # Trade name of Dispatch-From
    shipToGSTIN: str  # GSTIN of Ship-To
    shipToTradeName: str  # Trade name of Ship-To
    totalValue: float  # Sum of Taxable value and Tax value
    cgstValue: float  # CGST value
    sgstValue: float  # SGST value
    igstValue: float  # IGST value
    cessValue: float  # Cess value
    cessNonAdvolValue: float  # Cess value
    otherValue: float  # Other charges, if any
    transporterName: str  # Name of the transporter
    transporterId: str  # 15 Digit Transporter GSTIN/TRANSIN
    transDocNo: str  # Transport Document Number (Alphanumeric with / and – are allowed)
    transDocDate: str  # Transport Document Date
    vehicleNo: str  # Vehicle Number
    vehicleType: str  # Vehicle Type


class _EwbPartBRequestRequired(TypedDict):
    fromPlace: str  # From Place
    fromState: int  # From State
    reasonCode: str  # Reason Code
    reasonRem: str  # Remarks
    transMode: str  # Transport Mode


class EwbPartBRequest(_EwbPartBRequestRequired, total=False):
    ewbNo: float  # Ewaybill Number
    vehicleNo: str  # Vehicle Number
    transDocNo: str  # Transport Document Number
    transDocDate: str  # Transport Document Date
