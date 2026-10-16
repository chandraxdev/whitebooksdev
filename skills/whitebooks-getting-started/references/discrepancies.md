<!-- WhiteBooks reference 1.0.8, spec_as_of 2026-10-13. From the WhiteBooks documentation compared with the specification and the sandbox. Do not edit. -->

# Docs versus reality: portal-level notes

Discrepancies that concern no single operation (portal, SDKs, SLA, legal). Operation-level notes are in each area skill.

### DISC-4 (row 4): Docs wrong

- Docs claim: `/api/v1/bulk-generate` (use-cases)
- Observed: Sandbox: 9404. Not in spec
- Sources: https://whitebooks.in/apis/use-cases
- Topics: bulk-einvoice

### DISC-5 (row 5): Docs wrong

- Docs claim: `/v1/ksa/einvoice/create` (apis/ksa)
- Observed: Sandbox: 9404. Spec uses `/einvoice/compliance…` on api.mastergst.com
- Sources: https://whitebooks.in/apis/ksa
- Topics: ksa

### DISC-6 (row 6): Not available

- Docs claim: `GET /accounts/api/v1/audit-log` (security)
- Observed: Sandbox: 9404
- Sources: https://whitebooks.in/apis/security
- Topics: audit-log

### DISC-7 (row 7): Docs wrong

- Docs claim: Error envelope `{code,message,transaction_id,timestamp}` with GSTIN_INVALID, TOKEN_EXPIRED, RATE_LIMITED, DUPLICATE_IRN, UPSTREAM_TIMEOUT (errors)
- Observed: Sandbox: `{status_cd,status_desc:"WB_ERR_xxxx : …"}`
- Sources: https://whitebooks.in/developer/errors
- Topics: errors

### DISC-8 (row 8): Not published

- Docs claim: "OpenAPI specs published at stable URLs" (changelog v3.2.0)
- Observed: `/openapi.json`, `/openapi/gst.json`, `/swagger/` all 404. Page code holds `SWAGGER_*_URL_PLACEHOLDER`
- Topics: openapi-publication

### DISC-9 (row 9): Unverified / inconsistent

- Docs claim: SDKs in 3 / 5 / 7 languages (varies by page)
- Observed: None on npm or PyPI. Behind login
- Topics: sdks

### DISC-10 (row 10): Unverified

- Docs claim: Bulk EWB endpoint, 1,000 per call (changelog v3.1.0)
- Observed: Not among 27 EWB ops
- Topics: bulk-ewaybill

### DISC-11 (row 11): Unverified

- Docs claim: Webhooks with HMAC-SHA256 (v3.1.1, security page)
- Observed: The word "webhook" appears 0 times in all four specs
- Topics: webhooks

### DISC-12 (row 12): Inconsistent

- Docs claim: 99.99% SLA
- Observed: Appears on some pages, absent on the security page
- Topics: sla

### DISC-14 (row 14): Spec defect

- Docs claim: Spec `security: [{OAuth2:["read"]}]`
- Observed: No `securitySchemes` defined
- Topics: auth, spec-security

### DISC-15 (row 15): Legal ambiguity

- Docs claim: "Indian residents only" (Terms §1)
- Observed: KSA product sold to Saudi businesses
- Topics: legal

### DISC-16 (row 16): Quality issue

- Docs claim: Docs pages
- Observed: Leftover "TODO" notes in content
- Topics: docs-quality
