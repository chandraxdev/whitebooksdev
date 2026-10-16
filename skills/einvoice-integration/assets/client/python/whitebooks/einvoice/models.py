# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area einvoice
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: Python 3.10+ (typing only).

from __future__ import annotations

from typing import List, Optional, TypedDict


class EinvoiceCancelRequest(TypedDict, total=False):
    Irn: str  # Irn number
    CnlRsn: Optional[str]  # Cancel Reason Number
    CnlRem: str  # Cancel Reason


class EinvoiceGenerateRequestEwbDtls(TypedDict, total=False):
    Transid: str  # State Name
    Transname: str  # State Name
    Distance: float  # State Name
    Transdocno: str  # State Name
    TransdocDt: str  # State Name
    Vehno: str  # State Name
    Vehtype: str  # State Name
    TransMode: str  # State Name


class EinvoiceGenerateRequestExpDtls(TypedDict, total=False):
    ShipBNo: str  # State Name
    ShipBDt: str  # State Name
    Port: str  # State Name
    RefClm: str  # State Name
    ForCur: str  # State Name
    CntCode: str  # State Name


class EinvoiceGenerateRequestAddlDocDtls(TypedDict, total=False):
    Url: str  # State Name
    Docs: str  # State Name
    Info: str  # State Name


class EinvoiceGenerateRequestRefDtlsContrDtls(TypedDict, total=False):
    RecAdvRefr: str  # State Name
    RecAdvDt: str  # State Name
    Tendrefr: str  # State Name
    Contrrefr: str  # State Name
    Extrefr: str  # State Name
    Projrefr: str  # State Name
    Porefr: str  # State Name
    PoRefDt: str  # State Name


class EinvoiceGenerateRequestRefDtlsPrecDocDtls(TypedDict, total=False):
    InvNo: str  # State Name
    InvDt: str  # State Name
    OthRefNo: str  # State Name


class EinvoiceGenerateRequestRefDtlsDocPerdDtls(TypedDict, total=False):
    InvStDt: str  # State Name
    InvEndDt: str  # State Name


class EinvoiceGenerateRequestRefDtls(TypedDict, total=False):
    InvRm: str  # GST Number
    DocPerdDtls: EinvoiceGenerateRequestRefDtlsDocPerdDtls
    PrecDocDtls: List[EinvoiceGenerateRequestRefDtlsPrecDocDtls]
    ContrDtls: List[EinvoiceGenerateRequestRefDtlsContrDtls]


class EinvoiceGenerateRequestPayDtls(TypedDict, total=False):
    Nm: str  # State Name
    Accdet: str  # State Name
    Mode: str  # State Name
    Fininsbr: str  # State Name
    Payterm: str  # State Name
    Payinstr: str  # State Name
    Crtrn: str  # State Name
    Dirdr: str  # State Name
    Crday: float  # State Name
    Paidamt: float  # State Name
    Paymtdue: float  # State Name


class EinvoiceGenerateRequestValDtls(TypedDict, total=False):
    AssVal: float  # Assestment Val
    CgstVal: float  # Cgst Value
    SgstVal: float  # Sgst Value
    IgstVal: float  # Igst Value
    CesVal: float  # Cess Value
    StCesVal: float  # StCess Value
    Discount: float  # StCess Value
    OthChrg: float  # StCess Value
    RndOffAmt: float  # Round off
    TotInvVal: float  # Total Invoice Value
    TotInvValFc: float  # StCess Value


class EinvoiceGenerateRequestItemListAttribDtls(TypedDict, total=False):
    Nm: str  # Tax type
    Val: str  # Tax type


class EinvoiceGenerateRequestItemListBchDtls(TypedDict, total=False):
    Nm: str  # Tax type
    Expdt: str  # Tax type
    wrDt: str  # Tax type


class EinvoiceGenerateRequestItemList(TypedDict, total=False):
    SlNo: str  # Serial Number
    IsServc: str  # Service
    PrdDesc: str  # Product Description
    HsnCd: str  # HSN Code
    Barcde: str  # Bar Code
    BchDtls: EinvoiceGenerateRequestItemListBchDtls
    Qty: float  # Quntity
    FreeQty: float  # Free Quntity
    Unit: str  # Units Of Measurment
    UnitPrice: float  # Unit Price
    TotAmt: float  # Total Amount
    Discount: float  # Discount
    PreTaxVal: float  # Discount
    AssAmt: float  # Assesment Amount
    GstRt: Optional[float]  # gst Rate
    SgstAmt: float  # Sgst Rate
    IgstAmt: float  # Igst Rate
    CgstAmt: float  # Cgst Rate
    CesRt: float  # Cess Rate
    CesAmt: float  # Cess Amount
    CesNonAdvlAmt: float  # CesNonAd value
    StateCesRt: float  # State Cess Rate
    StateCesAmt: float  # State Cess Amount
    StateCesNonAdvlAmt: float  # State Cess none advance Amount
    OthChrg: float  # Other Charges
    TotItemVal: float  # Total Item Value
    OrdLineRef: str  # Total Item Value
    OrgCntry: str  # Total Item Value
    PrdSlNo: str  # Total Item Value
    AttribDtls: List[EinvoiceGenerateRequestItemListAttribDtls]


class EinvoiceGenerateRequestShipDtls(TypedDict, total=False):
    Gstin: str  # GST Number
    LglNm: str  # Legal Name
    TrdNm: str  # Trade Name
    Addr1: str  # Address1
    Addr2: str  # Address2
    Loc: str  # Location Name
    Pin: float  # Pincode Number
    Stcd: str  # State Name


class EinvoiceGenerateRequestDispDtls(TypedDict, total=False):
    Nm: str  # Name
    Addr1: str  # Address1
    Addr2: str  # Address2
    Loc: str  # Location Name
    Pin: float  # Pincode Number
    Stcd: str  # State Name


class EinvoiceGenerateRequestBuyerDtls(TypedDict, total=False):
    Gstin: str  # GST Number
    LglNm: str  # Legal Name
    TrdNm: str  # Trade Name
    Pos: str  # Place of Supply
    Addr1: str  # Address1
    Addr2: str  # Address2
    Loc: str  # Location Name
    Pin: float  # Pincode Number
    Stcd: str  # State Code
    Ph: str  # Phone Number
    Em: str  # Email Id


class EinvoiceGenerateRequestSellerDtls(TypedDict, total=False):
    Gstin: str  # GST Number
    LglNm: str  # Legal Name
    TrdNm: str  # Trade Name
    Addr1: str  # Address1
    Addr2: str  # Address2
    Loc: str  # Location Name
    Pin: float  # Pincode Number
    Stcd: str  # State Code
    Ph: str  # Phone Number
    Em: str  # Email Id


class EinvoiceGenerateRequestDocDtls(TypedDict, total=False):
    Typ: str  # Type
    No: str  # Invoice Number
    Dt: str  # Invoice Date


class EinvoiceGenerateRequestTranDtls(TypedDict, total=False):
    TaxSch: str  # Tax type
    SupTyp: str  # Supply Type
    RegRev: str  # Reg Rev
    EcmGstin: Optional[str]  # Ecom GSTIN
    IgstOnIntra: str  # IGST On Intra


class EinvoiceGenerateRequest(TypedDict, total=False):
    Version: str  # Version Type
    TranDtls: EinvoiceGenerateRequestTranDtls
    DocDtls: EinvoiceGenerateRequestDocDtls
    SellerDtls: EinvoiceGenerateRequestSellerDtls
    BuyerDtls: EinvoiceGenerateRequestBuyerDtls
    DispDtls: EinvoiceGenerateRequestDispDtls
    ShipDtls: EinvoiceGenerateRequestShipDtls
    ItemList: List[EinvoiceGenerateRequestItemList]
    ValDtls: EinvoiceGenerateRequestValDtls
    PayDtls: EinvoiceGenerateRequestPayDtls
    RefDtls: EinvoiceGenerateRequestRefDtls
    AddlDocDtls: List[EinvoiceGenerateRequestAddlDocDtls]
    ExpDtls: EinvoiceGenerateRequestExpDtls
    EwbDtls: EinvoiceGenerateRequestEwbDtls
