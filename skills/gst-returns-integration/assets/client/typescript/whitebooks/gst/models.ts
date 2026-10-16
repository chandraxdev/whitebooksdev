// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

export interface Gstr1SaveRequest {
  /** GSTIN number */
  gstin?: string;
  /** Fp Type */
  fp?: string;
  /** gt Type */
  gt?: number;
  /** Document Number (Alphanumeric with / and - are allowed) */
  cur_gt?: number;
  b2b?: Gstr1SaveRequestB2b[];
  b2ba?: Gstr1SaveRequestB2ba[];
  b2cl?: Gstr1SaveRequestB2cl[];
  b2cla?: Gstr1SaveRequestB2cla[];
  cdnr?: Gstr1SaveRequestCdnr[];
  cdnra?: Gstr1SaveRequestCdnra[];
  b2cs?: Gstr1SaveRequestB2cs[];
  b2csa?: Gstr1SaveRequestB2csa[];
  exp?: Gstr1SaveRequestExp[];
  expa?: Gstr1SaveRequestExpa[];
  hsn?: Gstr1SaveRequestHsn;
  nil?: Gstr1SaveRequestNil;
  txpd?: Gstr1SaveRequestTxpd[];
  txpda?: Gstr1SaveRequestTxpda[];
  at?: Gstr1SaveRequestAt[];
  ata?: Gstr1SaveRequestAta[];
  doc_issue?: Gstr1SaveRequestDocIssue;
  cdnur?: Gstr1SaveRequestCdnur[];
  cdnura?: Gstr1SaveRequestCdnura[];
}

export interface Gstr1SaveRequestB2b {
  /** Challan Temporary Identification Number */
  ctin?: string;
  inv?: Gstr1SaveRequestB2bInv[];
}

export interface Gstr1SaveRequestB2bInv {
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Invoice Value */
  val?: number;
  /** Place of Supply */
  pos?: string;
  /** Reverse Charge */
  rchrg?: string;
  /** etin Number */
  etin?: string;
  /** Invoice Type */
  inv_typ?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestB2bInvItms[];
}

export interface Gstr1SaveRequestB2bInvItms {
  /** number */
  num?: number;
  itm_det?: Gstr1SaveRequestB2bInvItmsItmDet;
}

export interface Gstr1SaveRequestB2bInvItmsItmDet {
  /** item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestB2ba {
  /** Challan Temporary Identification Number */
  ctin?: string;
  inv?: Gstr1SaveRequestB2baInv[];
}

export interface Gstr1SaveRequestB2baInv {
  /** Original Invoice Number */
  oinum?: string;
  /** Original Invoice Date */
  oidt?: string;
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Invoice Amount */
  val?: number;
  /** Place Of Supply */
  pos?: string;
  /** Reverse Charge */
  rchrg?: string;
  /** etin number */
  etin?: string;
  /** Invoice Type */
  inv_typ?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestB2baInvItms[];
}

export interface Gstr1SaveRequestB2baInvItms {
  /** number */
  num?: number;
  itm_det?: Gstr1SaveRequestB2baInvItmsItmDet;
}

export interface Gstr1SaveRequestB2baInvItmsItmDet {
  /** item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** CGST Amount */
  camt?: number;
  /** SGST Amount */
  samt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestB2cl {
  /** Place Of Supply */
  pos?: string;
  inv?: Gstr1SaveRequestB2clInv[];
}

export interface Gstr1SaveRequestB2clInv {
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Invoice Value */
  val?: number;
  /** Invoice Type */
  inv_typ?: string;
  /** etin */
  etin?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestB2clInvItms[];
}

export interface Gstr1SaveRequestB2clInvItms {
  /** item number */
  num?: number;
  itm_det?: Gstr1SaveRequestB2clInvItmsItmDet;
}

export interface Gstr1SaveRequestB2clInvItmsItmDet {
  /** rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestB2cla {
  /** Place of Supply */
  pos?: string;
  inv?: Gstr1SaveRequestB2claInv[];
}

export interface Gstr1SaveRequestB2claInv {
  /** Original Invoice Number */
  oinum?: string;
  /** Original Invoice Date */
  oidt?: string;
  /** Invoice Type */
  inv_typ?: string;
  /** Differencial percentage */
  diff_percent?: number;
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Invoice Value */
  val?: number;
  /** etin number */
  etin?: string;
  itms?: Gstr1SaveRequestB2claInvItms[];
}

export interface Gstr1SaveRequestB2claInvItms {
  /** Number */
  num?: number;
  itm_det?: Gstr1SaveRequestB2claInvItmsItmDet;
}

export interface Gstr1SaveRequestB2claInvItmsItmDet {
  /** item rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
}

export interface Gstr1SaveRequestCdnr {
  /** ctin Number */
  ctin?: string;
  nt?: Gstr1SaveRequestCdnrNt[];
}

export interface Gstr1SaveRequestCdnrNt {
  /** Note Type */
  ntty?: string;
  /** Note Number */
  nt_num?: string;
  /** Note Date */
  nt_dt?: string;
  /** Pre GST */
  p_gst?: string;
  /** Place of Supply */
  pos?: string;
  /** Reverse Charge */
  rchrg?: string;
  /** Invoice Type */
  inv_typ?: string;
  /** Invoice Value */
  val?: number;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestCdnrNtItms[];
}

export interface Gstr1SaveRequestCdnrNtItms {
  /** item Number */
  num?: number;
  itm_det?: Gstr1SaveRequestCdnrNtItmsItmDet;
}

export interface Gstr1SaveRequestCdnrNtItmsItmDet {
  /** item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestCdnra {
  /** ctin number */
  ctin?: string;
  nt?: Gstr1SaveRequestCdnraNt[];
}

export interface Gstr1SaveRequestCdnraNt {
  /** Note Type */
  ntty?: string;
  /** Original Note Number */
  ont_num?: string;
  /** Original Note Date */
  ont_dt?: string;
  /** Note Number */
  nt_num?: string;
  /** Note Date */
  nt_dt?: string;
  /** Pre GST */
  p_gst?: string;
  /** Place of Supply */
  pos?: string;
  /** Reverse Charge */
  rchrg?: string;
  /** Invoice Type */
  inv_typ?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  /** Invoice Value */
  val?: number;
  itms?: Gstr1SaveRequestCdnraNtItms[];
}

export interface Gstr1SaveRequestCdnraNtItms {
  /** number */
  num?: number;
  itm_det?: Gstr1SaveRequestCdnraNtItmsItmDet;
}

export interface Gstr1SaveRequestCdnraNtItmsItmDet {
  /** Item rate */
  rt?: number;
  /** Taxable value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** CGST Amount */
  camt?: number;
  /** sgst Amount */
  samt?: number;
  /** cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestB2cs {
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  /** Rate */
  rt?: number;
  /** Type */
  typ?: string;
  /** etin */
  etin?: string;
  /** Place Of Supply */
  pos?: string;
  /** Taxable Value */
  txval?: number;
  /** igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestB2csa {
  /** Original Month Of Invoice */
  omon?: string;
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  /** Type */
  typ?: string;
  /** etin number */
  etin?: string;
  /** Place Of Supply */
  pos?: string;
  itms?: Gstr1SaveRequestB2csaItms[];
}

export interface Gstr1SaveRequestB2csaItms {
  /** Product / Item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** CGST Amount */
  camt?: number;
  /** SGST Amount */
  samt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestExp {
  /** Export Type */
  exp_typ?: string;
  inv?: Gstr1SaveRequestExpInv[];
}

export interface Gstr1SaveRequestExpInv {
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Invoice Value */
  val?: number;
  /** Differencial Percentage */
  diff_percent?: number;
  /** prort Code */
  sbpcode?: string;
  /** Shipping Bill Number */
  sbnum?: string;
  /** Shipping Bill Date */
  sbdt?: string;
  itms?: Gstr1SaveRequestExpInvItms[];
}

export interface Gstr1SaveRequestExpInvItms {
  /** Taxable Value */
  txval?: number;
  /** Product / Item Rate */
  rt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestExpa {
  /** Export Type */
  exp_typ?: string;
  inv?: Gstr1SaveRequestExpaInv[];
}

export interface Gstr1SaveRequestExpaInv {
  /** Original Invoice Number */
  oinum?: string;
  /** Original Invoice Date */
  oidt?: string;
  /** Invoice Number */
  inum?: string;
  /** Invoice Date */
  idt?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  /** Invoice Value */
  val?: number;
  /** prort Code */
  sbpcode?: string;
  /** Shipping Bill Number */
  sbnum?: string;
  /** Shipping Bill Date */
  sbdt?: string;
  itms?: Gstr1SaveRequestExpaInvItms[];
}

export interface Gstr1SaveRequestExpaInvItms {
  /** Taxable Value */
  txval?: number;
  /** Product / Item Rate */
  rt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestHsn {
  data?: Gstr1SaveRequestHsnData[];
}

export interface Gstr1SaveRequestHsnData {
  /** Product / Item number */
  num?: number;
  /** HSN/SAC CODE */
  hsn_sc?: string;
  /** Goods Description */
  desc?: string;
  /** uqc */
  uqc?: string;
  /** Quantity */
  qty?: number;
  /** Invoice Value */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestNil {
  inv?: Gstr1SaveRequestNilInv[];
}

export interface Gstr1SaveRequestNilInv {
  /** Supply Type */
  sply_ty?: string;
  /** Exempted Amount */
  expt_amt?: number;
  /** Total Nil rated outward supplies */
  nil_amt?: number;
  /** Total Non GST outward supplies */
  ngsup_amt?: number;
}

export interface Gstr1SaveRequestTxpd {
  /** Place Of Supply */
  pos?: string;
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestTxpdItms[];
}

export interface Gstr1SaveRequestTxpdItms {
  /** Product / Item Rate */
  rt?: number;
  /** Advance to be adjusted */
  ad_amt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestTxpda {
  /** Original Month */
  omon?: string;
  /** Place Of Supply */
  pos?: string;
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestTxpdaItms[];
}

export interface Gstr1SaveRequestTxpdaItms {
  /** Product / Item Rate */
  rt?: number;
  /** Advance to be adjusted */
  ad_amt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestAt {
  /** Place Of Supply */
  pos?: string;
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestAtItms[];
}

export interface Gstr1SaveRequestAtItms {
  /** Product / Item Rate */
  rt?: number;
  /** Advance to be adjusted */
  ad_amt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestAta {
  /** Original Month */
  omon?: string;
  /** Place Of Supply */
  pos?: string;
  /** Supply Type */
  sply_ty?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestAtaItms[];
}

export interface Gstr1SaveRequestAtaItms {
  /** Product / Item Rate */
  rt?: number;
  /** Advance to be adjusted */
  ad_amt?: number;
  /** Igst Amount */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestDocIssue {
  doc_det?: Gstr1SaveRequestDocIssueDocDet[];
}

export interface Gstr1SaveRequestDocIssueDocDet {
  /** Document Number */
  doc_num?: number;
  docs?: Gstr1SaveRequestDocIssueDocDetDocs[];
}

export interface Gstr1SaveRequestDocIssueDocDetDocs {
  /** Serial Number */
  num?: number;
  /** from Serial Number */
  from?: string;
  /** to Serial Number */
  to?: string;
  /** Total Number */
  totnum?: number;
  /** Cancelled */
  cancel?: number;
  /** Net issued */
  net_issue?: number;
}

export interface Gstr1SaveRequestCdnur {
  /** EXPWP/ EXPWOP/ B2CL */
  typ?: string;
  /** Credit/debit note type/ Refund Voucher */
  ntty?: string;
  /** Credit note/debit note / Refund Voucher Number */
  nt_num?: string;
  /** Credit Note/Debit Note/ Refund Voucher date */
  nt_dt?: string;
  /** Pre GST Regime Dr./ Cr. Notes */
  p_gst?: string;
  /** Place Of Supply */
  pos?: string;
  /** Invoice Value */
  val?: number;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestCdnurItms[];
}

export interface Gstr1SaveRequestCdnurItms {
  /** Product / Item number */
  num?: number;
  itm_det?: Gstr1SaveRequestCdnurItmsItmDet;
}

export interface Gstr1SaveRequestCdnurItmsItmDet {
  /** Product / Item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Product / Item Name */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}

export interface Gstr1SaveRequestCdnura {
  /** Original Credit note/debit note / Refund Voucher Number */
  ont_num?: string;
  /** Original Credit Note/Debit Note/ Refund Voucher date */
  ont_dt?: string;
  /** Credit note/debit note / Refund Voucher Number */
  nt_num?: string;
  /** Credit Note/Debit Note/ Refund Voucher date */
  nt_dt?: string;
  /** Credit/debit note type/ Refund Voucher */
  ntty?: string;
  /** EXPWP/ EXPWOP/ B2CL */
  typ?: string;
  /** Pre GST Regime Dr./ Cr. Notes */
  p_gst?: string;
  /** Invoice Number */
  inum?: string;
  /** Invoice Value */
  val?: number;
  /** Invoice Date */
  idt?: string;
  /** Differencial Percentage */
  diff_percent?: number;
  itms?: Gstr1SaveRequestCdnuraItms[];
}

export interface Gstr1SaveRequestCdnuraItms {
  /** Product / Item number */
  num?: number;
  itm_det?: Gstr1SaveRequestCdnuraItmsItmDet;
}

export interface Gstr1SaveRequestCdnuraItmsItmDet {
  /** Product / Item Rate */
  rt?: number;
  /** Taxable Value */
  txval?: number;
  /** Product / Item Name */
  iamt?: number;
  /** Cess Amount */
  csamt?: number;
}
