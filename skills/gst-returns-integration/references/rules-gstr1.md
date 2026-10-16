# GSTR-1 and GSTR-1A rules (GSTR1)

Checks a client can make before saving GSTR-1 data. Every row cites the GST portal user guide for Form GSTR-1 (the FAQ
numbers below are those of that page), and the `GSTR1-1A` rows cite the FAQ page for Form GSTR-1A; the wording follows them. These are GSTN portal rules, not WhiteBooks rules. A rule
without a public source is not listed; the field formats of the GSTN JSON (date formats, `pos`, `gt`) are not on a public
GSTN page and are left to the operation spec.

Severity: `error` means the portal refuses the data; `warning` means a warning is shown; `note` is information.

| Rule id | Severity | Rule | Source |
|---|---|---|---|
| GSTR1-P1 | error | The filer is a registered taxpayer with an active GSTIN during the tax period being filed. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 8) |
| GSTR1-D1 | error | An invoice number is at most 16 characters, alphanumeric with dash and slash. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 31) |
| GSTR1-D2 | error | A GSTIN cannot have a duplicate invoice series in a financial year; the system does not accept duplicate supply invoices in a return. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 29) |
| GSTR1-E1 | error | The recipient GSTIN must have been active on the date of issue of the invoice; otherwise the invoice details are not accepted. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 39) |
| GSTR1-E2 | error | Invoice value, taxable value and tax amounts are declared up to 2 decimal digits. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 40) |
| GSTR1-T1 | error | An intra-state supply attracting IGST is allowed only when the supply attracts reverse charge. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 48) |
| GSTR1-C1 | note | There is no validation that invoice value equals taxable value plus tax. Do not reject a document on that relation. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 13) |
| GSTR1-H1 | error | HSN in the summary is at least 6 digits when the aggregate annual turnover exceeds Rs. 5 Crores, and at least 4 digits otherwise. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (Table 12 FAQ 3) |
| GSTR1-H2 | warning | Table 12 (B2B and B2C) is validated against tables 4, 6, 9A and 9B with a tolerance of +/-10%; outside it a warning is displayed. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (Table 12 FAQ 10) |
| GSTR1-A1 | error | Amendments to invoices of the previous financial year are not allowed after 30 November of the following financial year. | https://tutorial.gst.gov.in/userguide/returns/GSTR_1.htm (FAQ 11) |
| GSTR1-1A1 | note | GSTR-1A amends or adds records of the GSTR-1 of the same tax period only; records of an earlier period are amended in a later GSTR-1 within the time limit in law. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 1 and 8) |
| GSTR1-1A2 | error | GSTR-1A opens after the later of the GSTR-1 filing and the 11th of the next month (the 13th after the quarter for quarterly filers), and closes once the GSTR-3B of that period is filed. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 2 to 4) |
| GSTR1-1A3 | error | GSTR-1A is filed at most once per tax period, and a nil GSTR-1A cannot be filed. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 7 and 13) |
| GSTR1-1A4 | error | Records saved in GSTR-1A but not filed block the GSTR-3B of that period: file the GSTR-1A, delete the saved records or reset it before filing GSTR-3B. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 9) |
| GSTR1-1A5 | error | The recipient GSTIN cannot be changed in GSTR-1A; it is corrected in the GSTR-1 of a later period. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 11) |
| GSTR1-1A6 | note | Debit and credit notes can be added in GSTR-1A, and quarterly filers can amend IFF records of the first two months in the quarter's GSTR-1A. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 10 and 12) |
| GSTR1-1A7 | note | GSTR-1A is optional: it is filed only to add a missed record or change one already reported for that period. | https://tutorial.gst.gov.in/userguide/returns/FAQs_Creation_of_Outward_Supplies_Return_in_GSTR-1A.htm (FAQ 5) |
