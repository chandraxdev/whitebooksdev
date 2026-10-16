// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template typescript | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: none.

export interface EwbCancelRequest {
  /** EwayBill Number */
  ewbNo: number;
  /** Reason for cancellation */
  cancelRsnCode: number;
  /** Remarks */
  cancelRmrk?: string;
}

export interface EwbGenerateRequest {
  /** Supply Type */
  supplyType: "O" | "I";
  /** Sub Supply Type */
  subSupplyType: string;
  /** Other Sub Supply Description */
  subSupplyDesc?: string;
  /** Document Type */
  docType: "INV" | "CHL" | "BIL" | "BOE" | "CNT" | "OTH";
  /** Document Number (Alphanumeric with / and - are allowed) */
  docNo: string;
  /** Document Date */
  docDate: string;
  /** From GSTIN (Supplier or Consignor) */
  fromGstin: string;
  /** From Trade Name (Consignor Trade name) */
  fromTrdName?: string;
  /** From Address Line 1 (Valid Special Chars #,-,/) */
  fromAddr1?: string;
  /** From Address Line 2(Valid Special Chars # , - ,/) */
  fromAddr2?: string;
  /** From Place */
  fromPlace?: string;
  /** Actual From State Code */
  actFromStateCode: number;
  /** From Pincode */
  fromPincode: number;
  /** From State Code */
  fromStateCode: number;
  /** To GSTIN (Consignee or Recipient) */
  toGstin: string;
  /** To Trade Name (Consignee Trade name or Recipient Trade name) */
  toTrdName?: string;
  /** To Address Line 1 (Valid Special Chars #,-,/) */
  toAddr1?: string;
  /** To Address Line 2 (Valid Special Chars #,-,/) */
  toAddr2?: string;
  /** To Place */
  toPlace?: string;
  /** To Pincode */
  toPincode: number;
  /** Actual To State Code */
  actToStateCode: number;
  /** To State Code */
  toStateCode: number;
  /** Transaction type */
  transactionType: number;
  /** GSTIN of Dispatch-From */
  dispatchFromGSTIN?: string;
  /** Trade name of Dispatch-From */
  dispatchFromTradeName?: string;
  /** GSTIN of Ship-To */
  shipToGSTIN?: string;
  /** Trade name of Ship-To */
  shipToTradeName?: string;
  /** Sum of Taxable value and Tax value */
  totalValue?: number;
  /** CGST value */
  cgstValue?: number;
  /** SGST value */
  sgstValue?: number;
  /** IGST value */
  igstValue?: number;
  /** Cess value */
  cessValue?: number;
  /** Cess value */
  cessNonAdvolValue?: number;
  /** Total Invoice Value */
  totInvValue: number;
  /** Other charges, if any */
  otherValue?: number;
  /** Mode of transport (Road-1, Rail-2, Air-3, Ship-4) */
  transMode: "1" | "2" | "3" | "4";
  /** Distance (<4000 km) */
  transDistance: string;
  /** Name of the transporter */
  transporterName?: string;
  /** 15 Digit Transporter GSTIN/TRANSIN */
  transporterId?: string;
  /** Transport Document Number (Alphanumeric with / and – are allowed) */
  transDocNo?: string;
  /** Transport Document Date */
  transDocDate?: string;
  /** Vehicle Number */
  vehicleNo?: string;
  /** Vehicle Type */
  vehicleType?: string;
  itemList: EwbGenerateRequestItemList[];
}

export interface EwbGenerateRequestItemList {
  /** Product / Item Name */
  productName?: string;
  /** Product / Item description */
  productDesc?: string;
  /** HSN Code */
  hsnCode?: number;
  /** Quantity */
  quantity?: number;
  /** Unit */
  qtyUnit?: string;
  /** Taxable Amount */
  taxableAmount?: number;
  /** SGST Rate of Tax */
  sgstRate?: number;
  /** CGST Rate of Tax */
  cgstRate?: number;
  /** IGST Rate of Tax */
  igstRate?: number;
  /** Cess Rate of Tax */
  cessRate?: number;
  /** Cess Non-Advolerum */
  cessNonadvol?: number;
}

export interface EwbPartBRequest {
  /** Ewaybill Number */
  ewbNo?: number;
  /** Vehicle Number */
  vehicleNo?: string;
  /** From Place */
  fromPlace: string;
  /** From State */
  fromState: number;
  /** Reason Code */
  reasonCode: string;
  /** Remarks */
  reasonRem: string;
  /** Transport Document Number */
  transDocNo?: string;
  /** Transport Document Date */
  transDocDate?: string;
  /** Transport Mode */
  transMode: string;
}
