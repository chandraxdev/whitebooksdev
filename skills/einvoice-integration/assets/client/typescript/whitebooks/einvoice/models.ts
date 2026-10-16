// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area einvoice
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

export interface EinvoiceCancelRequest {
  /** Irn number */
  Irn?: string;
  /** Cancel Reason Number */
  CnlRsn?: string | null;
  /** Cancel Reason */
  CnlRem?: string;
}

export interface EinvoiceGenerateRequest {
  /** Version Type */
  Version?: string;
  TranDtls?: EinvoiceGenerateRequestTranDtls;
  DocDtls?: EinvoiceGenerateRequestDocDtls;
  SellerDtls?: EinvoiceGenerateRequestSellerDtls;
  BuyerDtls?: EinvoiceGenerateRequestBuyerDtls;
  DispDtls?: EinvoiceGenerateRequestDispDtls;
  ShipDtls?: EinvoiceGenerateRequestShipDtls;
  ItemList?: EinvoiceGenerateRequestItemList[];
  ValDtls?: EinvoiceGenerateRequestValDtls;
  PayDtls?: EinvoiceGenerateRequestPayDtls;
  RefDtls?: EinvoiceGenerateRequestRefDtls;
  AddlDocDtls?: EinvoiceGenerateRequestAddlDocDtls[];
  ExpDtls?: EinvoiceGenerateRequestExpDtls;
  EwbDtls?: EinvoiceGenerateRequestEwbDtls;
}

export interface EinvoiceGenerateRequestTranDtls {
  /** Tax type */
  TaxSch?: string;
  /** Supply Type */
  SupTyp?: string;
  /** Reg Rev */
  RegRev?: string;
  /** Ecom GSTIN */
  EcmGstin?: string | null;
  /** IGST On Intra */
  IgstOnIntra?: string;
}

export interface EinvoiceGenerateRequestDocDtls {
  /** Type */
  Typ?: string;
  /** Invoice Number */
  No?: string;
  /** Invoice Date */
  Dt?: string;
}

export interface EinvoiceGenerateRequestSellerDtls {
  /** GST Number */
  Gstin?: string;
  /** Legal Name */
  LglNm?: string;
  /** Trade Name */
  TrdNm?: string;
  /** Address1 */
  Addr1?: string;
  /** Address2 */
  Addr2?: string;
  /** Location Name */
  Loc?: string;
  /** Pincode Number */
  Pin?: number;
  /** State Code */
  Stcd?: string;
  /** Phone Number */
  Ph?: string;
  /** Email Id */
  Em?: string;
}

export interface EinvoiceGenerateRequestBuyerDtls {
  /** GST Number */
  Gstin?: string;
  /** Legal Name */
  LglNm?: string;
  /** Trade Name */
  TrdNm?: string;
  /** Place of Supply */
  Pos?: string;
  /** Address1 */
  Addr1?: string;
  /** Address2 */
  Addr2?: string;
  /** Location Name */
  Loc?: string;
  /** Pincode Number */
  Pin?: number;
  /** State Code */
  Stcd?: string;
  /** Phone Number */
  Ph?: string;
  /** Email Id */
  Em?: string;
}

export interface EinvoiceGenerateRequestDispDtls {
  /** Name */
  Nm?: string;
  /** Address1 */
  Addr1?: string;
  /** Address2 */
  Addr2?: string;
  /** Location Name */
  Loc?: string;
  /** Pincode Number */
  Pin?: number;
  /** State Name */
  Stcd?: string;
}

export interface EinvoiceGenerateRequestShipDtls {
  /** GST Number */
  Gstin?: string;
  /** Legal Name */
  LglNm?: string;
  /** Trade Name */
  TrdNm?: string;
  /** Address1 */
  Addr1?: string;
  /** Address2 */
  Addr2?: string;
  /** Location Name */
  Loc?: string;
  /** Pincode Number */
  Pin?: number;
  /** State Name */
  Stcd?: string;
}

export interface EinvoiceGenerateRequestItemList {
  /** Serial Number */
  SlNo?: string;
  /** Service */
  IsServc?: string;
  /** Product Description */
  PrdDesc?: string;
  /** HSN Code */
  HsnCd?: string;
  /** Bar Code */
  Barcde?: string;
  BchDtls?: EinvoiceGenerateRequestItemListBchDtls;
  /** Quntity */
  Qty?: number;
  /** Free Quntity */
  FreeQty?: number;
  /** Units Of Measurment */
  Unit?: string;
  /** Unit Price */
  UnitPrice?: number;
  /** Total Amount */
  TotAmt?: number;
  /** Discount */
  Discount?: number;
  /** Discount */
  PreTaxVal?: number;
  /** Assesment Amount */
  AssAmt?: number;
  /** gst Rate */
  GstRt?: number | null;
  /** Sgst Rate */
  SgstAmt?: number;
  /** Igst Rate */
  IgstAmt?: number;
  /** Cgst Rate */
  CgstAmt?: number;
  /** Cess Rate */
  CesRt?: number;
  /** Cess Amount */
  CesAmt?: number;
  /** CesNonAd value */
  CesNonAdvlAmt?: number;
  /** State Cess Rate */
  StateCesRt?: number;
  /** State Cess Amount */
  StateCesAmt?: number;
  /** State Cess none advance Amount */
  StateCesNonAdvlAmt?: number;
  /** Other Charges */
  OthChrg?: number;
  /** Total Item Value */
  TotItemVal?: number;
  /** Total Item Value */
  OrdLineRef?: string;
  /** Total Item Value */
  OrgCntry?: string;
  /** Total Item Value */
  PrdSlNo?: string;
  AttribDtls?: EinvoiceGenerateRequestItemListAttribDtls[];
}

export interface EinvoiceGenerateRequestItemListBchDtls {
  /** Tax type */
  Nm?: string;
  /** Tax type */
  Expdt?: string;
  /** Tax type */
  wrDt?: string;
}

export interface EinvoiceGenerateRequestItemListAttribDtls {
  /** Tax type */
  Nm?: string;
  /** Tax type */
  Val?: string;
}

export interface EinvoiceGenerateRequestValDtls {
  /** Assestment Val */
  AssVal?: number;
  /** Cgst Value */
  CgstVal?: number;
  /** Sgst Value */
  SgstVal?: number;
  /** Igst Value */
  IgstVal?: number;
  /** Cess Value */
  CesVal?: number;
  /** StCess Value */
  StCesVal?: number;
  /** StCess Value */
  Discount?: number;
  /** StCess Value */
  OthChrg?: number;
  /** Round off */
  RndOffAmt?: number;
  /** Total Invoice Value */
  TotInvVal?: number;
  /** StCess Value */
  TotInvValFc?: number;
}

export interface EinvoiceGenerateRequestPayDtls {
  /** State Name */
  Nm?: string;
  /** State Name */
  Accdet?: string;
  /** State Name */
  Mode?: string;
  /** State Name */
  Fininsbr?: string;
  /** State Name */
  Payterm?: string;
  /** State Name */
  Payinstr?: string;
  /** State Name */
  Crtrn?: string;
  /** State Name */
  Dirdr?: string;
  /** State Name */
  Crday?: number;
  /** State Name */
  Paidamt?: number;
  /** State Name */
  Paymtdue?: number;
}

export interface EinvoiceGenerateRequestRefDtls {
  /** GST Number */
  InvRm?: string;
  DocPerdDtls?: EinvoiceGenerateRequestRefDtlsDocPerdDtls;
  PrecDocDtls?: EinvoiceGenerateRequestRefDtlsPrecDocDtls[];
  ContrDtls?: EinvoiceGenerateRequestRefDtlsContrDtls[];
}

export interface EinvoiceGenerateRequestRefDtlsDocPerdDtls {
  /** State Name */
  InvStDt?: string;
  /** State Name */
  InvEndDt?: string;
}

export interface EinvoiceGenerateRequestRefDtlsPrecDocDtls {
  /** State Name */
  InvNo?: string;
  /** State Name */
  InvDt?: string;
  /** State Name */
  OthRefNo?: string;
}

export interface EinvoiceGenerateRequestRefDtlsContrDtls {
  /** State Name */
  RecAdvRefr?: string;
  /** State Name */
  RecAdvDt?: string;
  /** State Name */
  Tendrefr?: string;
  /** State Name */
  Contrrefr?: string;
  /** State Name */
  Extrefr?: string;
  /** State Name */
  Projrefr?: string;
  /** State Name */
  Porefr?: string;
  /** State Name */
  PoRefDt?: string;
}

export interface EinvoiceGenerateRequestAddlDocDtls {
  /** State Name */
  Url?: string;
  /** State Name */
  Docs?: string;
  /** State Name */
  Info?: string;
}

export interface EinvoiceGenerateRequestExpDtls {
  /** State Name */
  ShipBNo?: string;
  /** State Name */
  ShipBDt?: string;
  /** State Name */
  Port?: string;
  /** State Name */
  RefClm?: string;
  /** State Name */
  ForCur?: string;
  /** State Name */
  CntCode?: string;
}

export interface EinvoiceGenerateRequestEwbDtls {
  /** State Name */
  Transid?: string;
  /** State Name */
  Transname?: string;
  /** State Name */
  Distance?: number;
  /** State Name */
  Transdocno?: string;
  /** State Name */
  TransdocDt?: string;
  /** State Name */
  Vehno?: string;
  /** State Name */
  Vehtype?: string;
  /** State Name */
  TransMode?: string;
}
