# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area gst
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: Python 3.10+ (typing only).

from __future__ import annotations

from typing import List, TypedDict


class Gstr1SaveRequestCdnuraItmsItmDet(TypedDict, total=False):
    rt: float  # Product / Item Rate
    txval: float  # Taxable Value
    iamt: float  # Product / Item Name
    csamt: float  # Cess Amount


class Gstr1SaveRequestCdnuraItms(TypedDict, total=False):
    num: float  # Product / Item number
    itm_det: Gstr1SaveRequestCdnuraItmsItmDet


class Gstr1SaveRequestCdnura(TypedDict, total=False):
    ont_num: str  # Original Credit note/debit note / Refund Voucher Number
    ont_dt: str  # Original Credit Note/Debit Note/ Refund Voucher date
    nt_num: str  # Credit note/debit note / Refund Voucher Number
    nt_dt: str  # Credit Note/Debit Note/ Refund Voucher date
    ntty: str  # Credit/debit note type/ Refund Voucher
    typ: str  # EXPWP/ EXPWOP/ B2CL
    p_gst: str  # Pre GST Regime Dr./ Cr. Notes
    inum: str  # Invoice Number
    val: float  # Invoice Value
    idt: str  # Invoice Date
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestCdnuraItms]


class Gstr1SaveRequestCdnurItmsItmDet(TypedDict, total=False):
    rt: float  # Product / Item Rate
    txval: float  # Taxable Value
    iamt: float  # Product / Item Name
    csamt: float  # Cess Amount


class Gstr1SaveRequestCdnurItms(TypedDict, total=False):
    num: float  # Product / Item number
    itm_det: Gstr1SaveRequestCdnurItmsItmDet


class Gstr1SaveRequestCdnur(TypedDict, total=False):
    typ: str  # EXPWP/ EXPWOP/ B2CL
    ntty: str  # Credit/debit note type/ Refund Voucher
    nt_num: str  # Credit note/debit note / Refund Voucher Number
    nt_dt: str  # Credit Note/Debit Note/ Refund Voucher date
    p_gst: str  # Pre GST Regime Dr./ Cr. Notes
    pos: str  # Place Of Supply
    val: float  # Invoice Value
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestCdnurItms]


Gstr1SaveRequestDocIssueDocDetDocs = TypedDict("Gstr1SaveRequestDocIssueDocDetDocs", {"num": float, "from": str, "to": str, "totnum": float, "cancel": float, "net_issue": float}, total=False)


class Gstr1SaveRequestDocIssueDocDet(TypedDict, total=False):
    doc_num: float  # Document Number
    docs: List[Gstr1SaveRequestDocIssueDocDetDocs]


class Gstr1SaveRequestDocIssue(TypedDict, total=False):
    doc_det: List[Gstr1SaveRequestDocIssueDocDet]


class Gstr1SaveRequestAtaItms(TypedDict, total=False):
    rt: float  # Product / Item Rate
    ad_amt: float  # Advance to be adjusted
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestAta(TypedDict, total=False):
    omon: str  # Original Month
    pos: str  # Place Of Supply
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestAtaItms]


class Gstr1SaveRequestAtItms(TypedDict, total=False):
    rt: float  # Product / Item Rate
    ad_amt: float  # Advance to be adjusted
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestAt(TypedDict, total=False):
    pos: str  # Place Of Supply
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestAtItms]


class Gstr1SaveRequestTxpdaItms(TypedDict, total=False):
    rt: float  # Product / Item Rate
    ad_amt: float  # Advance to be adjusted
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestTxpda(TypedDict, total=False):
    omon: str  # Original Month
    pos: str  # Place Of Supply
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestTxpdaItms]


class Gstr1SaveRequestTxpdItms(TypedDict, total=False):
    rt: float  # Product / Item Rate
    ad_amt: float  # Advance to be adjusted
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestTxpd(TypedDict, total=False):
    pos: str  # Place Of Supply
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestTxpdItms]


class Gstr1SaveRequestNilInv(TypedDict, total=False):
    sply_ty: str  # Supply Type
    expt_amt: float  # Exempted Amount
    nil_amt: float  # Total Nil rated outward supplies
    ngsup_amt: float  # Total Non GST outward supplies


class Gstr1SaveRequestNil(TypedDict, total=False):
    inv: List[Gstr1SaveRequestNilInv]


class Gstr1SaveRequestHsnData(TypedDict, total=False):
    num: float  # Product / Item number
    hsn_sc: str  # HSN/SAC CODE
    desc: str  # Goods Description
    uqc: str  # uqc
    qty: float  # Quantity
    rt: float  # Invoice Value
    txval: float  # Taxable Value
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestHsn(TypedDict, total=False):
    data: List[Gstr1SaveRequestHsnData]


class Gstr1SaveRequestExpaInvItms(TypedDict, total=False):
    txval: float  # Taxable Value
    rt: float  # Product / Item Rate
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestExpaInv(TypedDict, total=False):
    oinum: str  # Original Invoice Number
    oidt: str  # Original Invoice Date
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    diff_percent: float  # Differencial Percentage
    val: float  # Invoice Value
    sbpcode: str  # prort Code
    sbnum: str  # Shipping Bill Number
    sbdt: str  # Shipping Bill Date
    itms: List[Gstr1SaveRequestExpaInvItms]


class Gstr1SaveRequestExpa(TypedDict, total=False):
    exp_typ: str  # Export Type
    inv: List[Gstr1SaveRequestExpaInv]


class Gstr1SaveRequestExpInvItms(TypedDict, total=False):
    txval: float  # Taxable Value
    rt: float  # Product / Item Rate
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestExpInv(TypedDict, total=False):
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    val: float  # Invoice Value
    diff_percent: float  # Differencial Percentage
    sbpcode: str  # prort Code
    sbnum: str  # Shipping Bill Number
    sbdt: str  # Shipping Bill Date
    itms: List[Gstr1SaveRequestExpInvItms]


class Gstr1SaveRequestExp(TypedDict, total=False):
    exp_typ: str  # Export Type
    inv: List[Gstr1SaveRequestExpInv]


class Gstr1SaveRequestB2csaItms(TypedDict, total=False):
    rt: float  # Product / Item Rate
    txval: float  # Taxable Value
    iamt: float  # Igst Amount
    camt: float  # CGST Amount
    samt: float  # SGST Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestB2csa(TypedDict, total=False):
    omon: str  # Original Month Of Invoice
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    typ: str  # Type
    etin: str  # etin number
    pos: str  # Place Of Supply
    itms: List[Gstr1SaveRequestB2csaItms]


class Gstr1SaveRequestB2cs(TypedDict, total=False):
    sply_ty: str  # Supply Type
    diff_percent: float  # Differencial Percentage
    rt: float  # Rate
    typ: str  # Type
    etin: str  # etin
    pos: str  # Place Of Supply
    txval: float  # Taxable Value
    iamt: float  # igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestCdnraNtItmsItmDet(TypedDict, total=False):
    rt: float  # Item rate
    txval: float  # Taxable value
    iamt: float  # Igst Amount
    camt: float  # CGST Amount
    samt: float  # sgst Amount
    csamt: float  # cess Amount


class Gstr1SaveRequestCdnraNtItms(TypedDict, total=False):
    num: float  # number
    itm_det: Gstr1SaveRequestCdnraNtItmsItmDet


class Gstr1SaveRequestCdnraNt(TypedDict, total=False):
    ntty: str  # Note Type
    ont_num: str  # Original Note Number
    ont_dt: str  # Original Note Date
    nt_num: str  # Note Number
    nt_dt: str  # Note Date
    p_gst: str  # Pre GST
    pos: str  # Place of Supply
    rchrg: str  # Reverse Charge
    inv_typ: str  # Invoice Type
    diff_percent: float  # Differencial Percentage
    val: float  # Invoice Value
    itms: List[Gstr1SaveRequestCdnraNtItms]


class Gstr1SaveRequestCdnra(TypedDict, total=False):
    ctin: str  # ctin number
    nt: List[Gstr1SaveRequestCdnraNt]


class Gstr1SaveRequestCdnrNtItmsItmDet(TypedDict, total=False):
    rt: float  # item Rate
    txval: float  # Taxable Value
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestCdnrNtItms(TypedDict, total=False):
    num: float  # item Number
    itm_det: Gstr1SaveRequestCdnrNtItmsItmDet


class Gstr1SaveRequestCdnrNt(TypedDict, total=False):
    ntty: str  # Note Type
    nt_num: str  # Note Number
    nt_dt: str  # Note Date
    p_gst: str  # Pre GST
    pos: str  # Place of Supply
    rchrg: str  # Reverse Charge
    inv_typ: str  # Invoice Type
    val: float  # Invoice Value
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestCdnrNtItms]


class Gstr1SaveRequestCdnr(TypedDict, total=False):
    ctin: str  # ctin Number
    nt: List[Gstr1SaveRequestCdnrNt]


class Gstr1SaveRequestB2claInvItmsItmDet(TypedDict, total=False):
    rt: float  # item rate
    txval: float  # Taxable Value
    iamt: float  # Igst Amount


class Gstr1SaveRequestB2claInvItms(TypedDict, total=False):
    num: float  # Number
    itm_det: Gstr1SaveRequestB2claInvItmsItmDet


class Gstr1SaveRequestB2claInv(TypedDict, total=False):
    oinum: str  # Original Invoice Number
    oidt: str  # Original Invoice Date
    inv_typ: str  # Invoice Type
    diff_percent: float  # Differencial percentage
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    val: float  # Invoice Value
    etin: str  # etin number
    itms: List[Gstr1SaveRequestB2claInvItms]


class Gstr1SaveRequestB2cla(TypedDict, total=False):
    pos: str  # Place of Supply
    inv: List[Gstr1SaveRequestB2claInv]


class Gstr1SaveRequestB2clInvItmsItmDet(TypedDict, total=False):
    rt: float  # rate
    txval: float  # Taxable Value
    iamt: float  # Igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestB2clInvItms(TypedDict, total=False):
    num: float  # item number
    itm_det: Gstr1SaveRequestB2clInvItmsItmDet


class Gstr1SaveRequestB2clInv(TypedDict, total=False):
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    val: float  # Invoice Value
    inv_typ: str  # Invoice Type
    etin: str  # etin
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestB2clInvItms]


class Gstr1SaveRequestB2cl(TypedDict, total=False):
    pos: str  # Place Of Supply
    inv: List[Gstr1SaveRequestB2clInv]


class Gstr1SaveRequestB2baInvItmsItmDet(TypedDict, total=False):
    rt: float  # item Rate
    txval: float  # Taxable Value
    iamt: float  # Igst Amount
    camt: float  # CGST Amount
    samt: float  # SGST Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestB2baInvItms(TypedDict, total=False):
    num: float  # number
    itm_det: Gstr1SaveRequestB2baInvItmsItmDet


class Gstr1SaveRequestB2baInv(TypedDict, total=False):
    oinum: str  # Original Invoice Number
    oidt: str  # Original Invoice Date
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    val: float  # Invoice Amount
    pos: str  # Place Of Supply
    rchrg: str  # Reverse Charge
    etin: str  # etin number
    inv_typ: str  # Invoice Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestB2baInvItms]


class Gstr1SaveRequestB2ba(TypedDict, total=False):
    ctin: str  # Challan Temporary Identification Number
    inv: List[Gstr1SaveRequestB2baInv]


class Gstr1SaveRequestB2bInvItmsItmDet(TypedDict, total=False):
    rt: float  # item Rate
    txval: float  # Taxable Value
    iamt: float  # igst Amount
    csamt: float  # Cess Amount


class Gstr1SaveRequestB2bInvItms(TypedDict, total=False):
    num: float  # number
    itm_det: Gstr1SaveRequestB2bInvItmsItmDet


class Gstr1SaveRequestB2bInv(TypedDict, total=False):
    inum: str  # Invoice Number
    idt: str  # Invoice Date
    val: float  # Invoice Value
    pos: str  # Place of Supply
    rchrg: str  # Reverse Charge
    etin: str  # etin Number
    inv_typ: str  # Invoice Type
    diff_percent: float  # Differencial Percentage
    itms: List[Gstr1SaveRequestB2bInvItms]


class Gstr1SaveRequestB2b(TypedDict, total=False):
    ctin: str  # Challan Temporary Identification Number
    inv: List[Gstr1SaveRequestB2bInv]


class Gstr1SaveRequest(TypedDict, total=False):
    gstin: str  # GSTIN number
    fp: str  # Fp Type
    gt: float  # gt Type
    cur_gt: float  # Document Number (Alphanumeric with / and - are allowed)
    b2b: List[Gstr1SaveRequestB2b]
    b2ba: List[Gstr1SaveRequestB2ba]
    b2cl: List[Gstr1SaveRequestB2cl]
    b2cla: List[Gstr1SaveRequestB2cla]
    cdnr: List[Gstr1SaveRequestCdnr]
    cdnra: List[Gstr1SaveRequestCdnra]
    b2cs: List[Gstr1SaveRequestB2cs]
    b2csa: List[Gstr1SaveRequestB2csa]
    exp: List[Gstr1SaveRequestExp]
    expa: List[Gstr1SaveRequestExpa]
    hsn: Gstr1SaveRequestHsn
    nil: Gstr1SaveRequestNil
    txpd: List[Gstr1SaveRequestTxpd]
    txpda: List[Gstr1SaveRequestTxpda]
    at: List[Gstr1SaveRequestAt]
    ata: List[Gstr1SaveRequestAta]
    doc_issue: Gstr1SaveRequestDocIssue
    cdnur: List[Gstr1SaveRequestCdnur]
    cdnura: List[Gstr1SaveRequestCdnura]
