<!-- WhiteBooks reference 1.0.8, spec_as_of 2026-10-13. From the WhiteBooks documentation compared with the specification and the sandbox. Do not edit. -->

# Docs versus reality: einvoice

Where the WhiteBooks docs and the einvoice spec or live behaviour disagree. Trust the operation contract and the observed behaviour.

### DISC-1 (row 1): Docs contradict spec and live behaviour

- Docs claim: OAuth 2.0 bearer + `x-api-key`. `GET /authentication/authtoken` returns `{access_token, token_type:"Bearer", expires_in:3600}` (quickstart, authentication)
- Observed: Spec: static client_id/secret + email + GST OTP session. Sandbox: authtoken demands `otp`
- Sources: https://whitebooks.in/developer/quickstart, https://whitebooks.in/developer/authentication
- Operations: `einvoice:GET:/einvoice/authenticate`
- Topics: auth

### DISC-3 (row 3): Docs wrong

- Docs claim: `/einvoice/generate-irn`
- Observed: Sandbox: 9404. Real path: `/einvoice/type/GENERATE/version/V1_03`
- Operations: `einvoice:POST:/einvoice/type/GENERATE/version/V1_03`

### DISC-13 (row 13): Docs inconsistent (FAQ vs sample; NIC schema not checked here)

- Docs claim: e-Invoice `Version` should be "1.03" (FAQ)
- Observed: Sample payload uses "1.1"
- Operations: `einvoice:POST:/einvoice/type/GENERATE/version/V1_03`
