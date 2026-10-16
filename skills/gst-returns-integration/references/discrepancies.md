<!-- WhiteBooks reference 1.0.8, spec_as_of 2026-10-13. From the WhiteBooks documentation compared with the specification and the sandbox. Do not edit. -->

# Docs versus reality: gst

Where the WhiteBooks docs and the gst spec or live behaviour disagree. Trust the operation contract and the observed behaviour.

### DISC-1 (row 1): Docs contradict spec and live behaviour

- Docs claim: OAuth 2.0 bearer + `x-api-key`. `GET /authentication/authtoken` returns `{access_token, token_type:"Bearer", expires_in:3600}` (quickstart, authentication)
- Observed: Spec: static client_id/secret + email + GST OTP session. Sandbox: authtoken demands `otp`
- Sources: https://whitebooks.in/developer/quickstart, https://whitebooks.in/developer/authentication
- Operations: `gst:GET:/authentication/otprequest`, `gst:GET:/authentication/authtoken`, `gst:GET:/authentication/refreshtoken`, `gst:GET:/authentication/logout`, `gst:GET:/authentication/otpforevc`
- Topics: auth

### DISC-2 (row 2): Docs wrong

- Docs claim: `/gst/public/search`
- Observed: Sandbox: WB_ERR_9404 on prod. Spec `/public/search` exists
- Operations: `gst:GET:/public/search`
