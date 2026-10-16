# e-Invoice rules (EINV)

Rules a client can check before calling `einvoice:POST:/einvoice/type/GENERATE/version/V1_03`. Every row cites the NIC
e-Invoice sandbox page for IRN generation (JSON Schema and "Validations in e-Invoicing System"); the wording follows that
page. A rule without a public source is not listed. Ids follow design section 6 where the same rule exists there.

Severity: `error` means NIC rejects the request; `warning` means the request is accepted but likely wrong; `note` is
information. Amounts in the examples are synthetic.

| Rule id | Severity | Rule | Source |
|---|---|---|---|
| EINV-V1 | error | `Version` is mandatory and is passed as "1.1". | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System", point 2) |
| EINV-V2 | error | The request must not contain an IRN; the e-Invoice system generates it. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-M1 | error | `TranDtls` requires `TaxSch` and `SupTyp`; `DocDtls` requires `Typ`, `No`, `Dt`; `SellerDtls` requires `Gstin`, `LglNm`, `Addr1`, `Loc`, `Pin`, `Stcd`; `BuyerDtls` requires `Gstin`, `LglNm`, `Pos`, `Addr1`, `Loc`, `Stcd`. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema") |
| EINV-E1 | error | `SupTyp` is one of B2B, SEZWP, SEZWOP, EXPWP, EXPWOP, DEXP; `DocDtls.Typ` is INV, CRN or DBN; `TaxSch` is GST; `IgstOnIntra` is Y or N. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema") |
| EINV-E2 | error | `DocDtls.No` is 1 to 16 characters matching `^([a-zA-Z1-9]{1}[a-zA-Z0-9/-]{0,15})$`; a number starting with 0, / or - is rejected. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema" and "Validations in e-Invoicing System") |
| EINV-E3 | error | `DocDtls.Dt` is DD/MM/YYYY; requests with a document date before 01/04/2025 are rejected. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema" and "Validations in e-Invoicing System") |
| EINV-E4 | error | `Pin` is 100000 to 999999. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema") |
| EINV-E5 | error | The JSON payload does not exceed 2MB. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-E6 | error | A GSTIN in the supplier or recipient details has the first two digits equal to the state code passed alongside it; for exports the recipient state code is 96. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-G1 | error | `SellerDtls.Gstin` matches `([0-9]{2}[0-9A-Z]{13})`. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema") |
| EINV-X1 | error | For direct exports (`DEXP`) the recipient GSTIN is URP, the state code is 96, the PIN code is 999999 and `Pos` is 96. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-X2 | note | A PIN code of 999999 is also accepted when the supplier or recipient GSTIN belongs to state code 97 (other territory). | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-T1 | error | If the supplier state code and `Pos` are the same the supply is intra-state, otherwise inter-state; `IgstOnIntra` overrules this. Exports and SEZ supplies are always inter-state. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-T2 | error | For IGST on intra-state supply, the IGST rates and values are passed, supplier state code and `Pos` are equal, and reverse charge is mandatory. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-T3 | error | Inter-state, export and SEZ-recipient items carry the IGST rate and value; for intra-state items the GST rate is the sum of the CGST and SGST rates. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations on Items") |
| EINV-T4 | error | Reverse charge can be set to Y only for B2B and SEZ invoices, and not where the recipient taxpayer type is ISD. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-T5 | error | The tax rate 0.5% is withdrawn. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-H1 | error | `HsnCd` is 4, 6 or 8 digits (not all zeros) and valid in the GST master; if `IsServc` is Y the code must belong to services. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema" and "Validations on Items") |
| EINV-U1 | error | `SlNo` is numeric (1 to 6 digits) and is checked for duplicates across `ItemList`. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("JSON Schema" and "Validations on Items") |
| EINV-U2 | error | An invoice has at least 1 and at most 1000 items. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations on Items") |
| EINV-U3 | error | Quantity and unit quantity code are mandatory for goods and optional for services. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations on Items") |
| EINV-C1 | error | Per item, taxable value = gross amount - discount. Passed tax values are tolerated between the rupee part of the calculated value minus 1 and the calculated value rounded up to the next rupee plus 1 (for 2345.04 the range is 2344.00 to 2347.00). | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Calculation of Values") |
| EINV-C2 | error | Per item, SGST and CGST = taxable value x GST rate / 2 (intra-state); IGST = taxable value x GST rate (inter-state); cess and state cess = taxable value x the cess rate; the same tolerance applies. For credit and debit notes the tax values are not checked against rates. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Calculation of Values") |
| EINV-C3 | error | Per item, total value = taxable value + SGST + CGST + IGST + cess + state cess + non-advol cess + state cess non-advol + other charges. With reverse charge, and for EXPWP, the total may include or exclude the tax. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Calculation of Values") |
| EINV-C4 | error | Invoice totals for taxable value, SGST, CGST, IGST, cess and state cess equal the sums over the items, within the same tolerance. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Calculation of Values") |
| EINV-C5 | error | `RndOffAmt` is between -99.99 and +99.99, and total invoice value = sum of item total values - invoice discount + invoice other charges + round-off, within the same tolerance. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Calculation of Values") |
| EINV-S1 | error | IRN generation is allowed only for an active supplier; a cancelled or suspended supplier cannot generate it. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-S2 | error | A supplier in an SEZ unit cannot generate an e-Invoice. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-S3 | error | The recipient GSTIN is registered and active or suspended on the document date. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-S4 | error | SEZWP and SEZWOP apply only when the recipient taxpayer type is SEZ Unit or SEZ Developer. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-D1 | error | One IRN per supplier, document type and document number in a financial year (1 April to 31 March); an IRN cannot be regenerated for a cancelled e-Invoice. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-D2 | note | B2C invoices are out of scope and should not be sent for an IRN. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-W1 | error | If Ship-To details are given, Ship-To GSTIN is mandatory. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations in e-Invoicing System") |
| EINV-EC1 | error | An e-Commerce operator generating on a supplier's behalf passes `EcmGstin` equal to its own GSTIN; for suppliers it is blank. | https://einv-apisandbox.nic.in/version1.03/generate-irn.html ("Validations for e-Invoices by e-Commerce operators") |
