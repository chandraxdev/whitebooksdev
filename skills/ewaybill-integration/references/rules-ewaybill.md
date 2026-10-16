# e-Way Bill rules (EWB)

Rules a client can check before calling `ewaybill:POST:/ewaybillapi/v1.03/ewayapi/genewaybill`. Every row cites the NIC
e-Way Bill API page for version 1.03 "Generate E-Way Bill" (JSON Schema, Data Structure and Validations); the wording
follows that page. A rule without a public source is not listed. Ids follow design section 6 where the same rule exists.

Severity: `error` means NIC rejects the request; `warning` means accepted with an alert; `note` is information.

| Rule id | Severity | Rule | Source |
|---|---|---|---|
| EWB-M1 | error | The request carries the schema's required fields: `supplyType`, `subSupplyType`, `docType`, `docNo`, `docDate`, `fromGstin`, `fromPincode`, `fromStateCode`, `toGstin`, `toPincode`, `toStateCode`, `transDistance`, `itemList`, `actToStateCode`, `actFromStateCode`, `totInvValue`, `transactionType` (17 fields). Each item requires `hsnCode` and `taxableAmount`. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema") |
| EWB-E1 | error | `supplyType` is O (outward) or I (inward); `docType` is one of INV, CHL, BIL, BOE, OTH; `transMode` is 1, 2, 3 or 4; `transactionType` is 1 to 4. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema") |
| EWB-E2 | error | `docDate` is DD/MM/YYYY and is less than or equal to the current date. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema" and "Validations") |
| EWB-E3 | error | `docNo` is at most 16 characters; letters, digits, / and - are allowed. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema") |
| EWB-E4 | error | Pin codes are 100000 to 999999 and are checked against the state code (`actFromStateCode` with `fromPincode`, `actToStateCode` with `toPincode`). | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema" and "Validations") |
| EWB-E5 | note | For "Other Country" the state codes 96 and 99 are both accepted; the system stores 99. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-E6 | error | The transport document date is greater than or equal to the document date. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-E7 | error | E-way bill generation is limited to 180 days from the document date. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-E8 | error | When the sub-supply type is Others, `subSupplyDesc` is passed. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-C1 | error | The sum of `totalValue`, `cgstValue`, `sgstValue`, `igstValue`, `cessValue`, `otherValue` and `cessNonAdvolValue` is equal to or less than `totInvValue`, with a grace of Rs. 2.00 (relaxed for certain RSP-based HSNs under Notification 20/2025). | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-C2 | error | `transDistance` is at most 4000. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Data Structure" and "Validations") |
| EWB-C3 | note | A `transDistance` of 0 asks the system to use the stored PIN-to-PIN distance; a passed distance more than 10% away from it is rejected. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-C4 | error | When `fromPincode` and `toPincode` are the same, the distance is at most 100 km (300 km for line sales). | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-T1 | error | Intra-state (`fromStateCode` equals `toStateCode`): the SGST and CGST rate and value are passed. Inter-state: the IGST rate and value are passed. If a party is an SEZ unit, IGST is passed. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-G1 | error | `fromGstin` and `toGstin` are valid GSTINs of the supplier and recipient, matching `[0-9]{2}[0-9A-Z]{13}`; an unregistered party is passed as URP. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("JSON Schema" and "Validations") |
| EWB-I1 | error | An e-way bill has at most 250 items. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-I2 | error | At least one item has an HSN code for goods; an e-way bill cannot be generated with only service (99) codes. HSN codes are valid per the GST master. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-V1 | error | With road transport, the vehicle number is passed and the transport document number is optional. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-V2 | error | With rail, air or ship, the transport document number is mandatory. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-V3 | error | A passed vehicle number must be in the valid format; temporary registrations use `TMXXXXXX`. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-V4 | error | `vehicleType` is R (regular) or O (over dimension cargo); with ship, the type can be ODC and a vehicle number must be given. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-D1 | error | One e-way bill per consignor document number; consignee and transporter are also refused once the consignor has used the number. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
| EWB-P1 | error | The requester's GSTIN is `fromGstin` when generating as supplier, `toGstin` as recipient, or `transporterId` as transporter; an enrolled transporter cannot be `fromGstin` or `toGstin`. | https://docs.ewaybillgst.gov.in/apidocs/version1.03/generate-eway-bill.html ("Validations") |
