<!-- WhiteBooks reference 1.0.8, spec_as_of 2026-10-13. From the WhiteBooks API specification. Do not edit. -->

# Header and parameter dictionary

spec_as_of 2026-10-13. Secret values are never logged, echoed or written to a file by the client code or the skills.

| Name | In | Layer | Secret | Personal data | Meaning |
|---|---|---|---|---|---|
| `auth-token` | header | session | yes | no | NIC session token from authenticate |
| `client_id` | header | app | yes | no | WhiteBooks app credential from the developer portal |
| `client_secret` | header | app | yes | no | WhiteBooks app credential from the developer portal |
| `email` | query | app | no | no | Email registered with WhiteBooks |
| `gst_username` | header | taxpayer | yes | no | GST portal username |
| `gstin` | header | taxpayer | no | yes | Taxpayer GSTIN (15 characters) |
| `ip_address` | header | app | no | no | Caller's public IP |
| `otp` | query | taxpayer | yes | no | GST OTP (sandbox 575757) |
| `password` | header | taxpayer | yes | no | NIC e-Invoice / EWB API user |
| `ret_period` | header | request | no | no | Return period MMYYYY |
| `state_cd` | header | taxpayer | no | no | 2-digit state code (first 2 characters of the GSTIN) |
| `txn` | header | session | yes | no | GST session transaction id from otprequest |
| `username` | header | taxpayer | yes | no | NIC e-Invoice / EWB API user |
