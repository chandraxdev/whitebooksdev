# WhiteBooks client contract

Client contract version 2

This file states, in no particular language, how a WhiteBooks API client must behave. It is derived only from the generated
TypeScript, Python and Java clients and their tests, which check that this file and the clients agree. Operation, header and error data live in the generated files
beside this one: `headers.md`, `errors.md`, `discrepancies.md` and `operations-<area>.json` in each area skill (an index of the area's operations, with one file per tag holding each full contract).

Use it two ways. Developers with a client copy it and read this file to understand it. When the developer's language is not
one of the three ready-made clients, the model writes the client from this file and stamps the header in the last section.

## 1. Environment

All configuration comes from environment variables. Nothing is hard-coded and no value belongs in a repository.

| Variable | Meaning |
|---|---|
| `WB_BASE_URL` | Optional. Defaults to the sandbox `https://apisandbox.whitebooks.in`. Production is `https://api.whitebooks.in`; set it only for live traffic. |
| `WB_GST_CLIENT_ID`, `WB_GST_CLIENT_SECRET` | WhiteBooks credentials for the GST (returns) area, sent as the `client_id` and `client_secret` headers on GST operations. The public operations (`/public/*`, catalogued under `gst:`) use this pair too. |
| `WB_EINV_CLIENT_ID`, `WB_EINV_CLIENT_SECRET` | The pair for the e-Invoice area, sent as the same two headers on e-Invoice operations. |
| `WB_EWB_CLIENT_ID`, `WB_EWB_CLIENT_SECRET` | The pair for the e-Way Bill area, sent as the same two headers on e-Way Bill operations. |
| `WB_EMAIL` | Account e-mail, sent as the `email` query parameter. |
| `WB_GST_GSTIN`, `WB_EINV_GSTIN`, `WB_EWB_GSTIN` | The test GSTIN of each area's sandbox account. The e-Invoice and e-Way Bill value is sent as the `gstin` header of that area's sign-in and calls; the state code of every session is the first two characters of its own area's GSTIN. Public operations take their `gstin` query argument from the caller (the smoke test passes `WB_GST_GSTIN`). |
| `WB_IP_ADDRESS` | The one IP address registered for the session (section 3). |
| `WB_GST_USERNAME` | GST portal user name, sent as the `gst_username` header on the OTP request. |
| `WB_EINV_NIC_USERNAME`, `WB_EINV_NIC_PASSWORD` | The e-Invoice API (NIC) user of that area's account. |
| `WB_EWB_NIC_USERNAME`, `WB_EWB_NIC_PASSWORD` | The e-Way Bill API (NIC) user of that area's account. |

Each area has its own pair and there is no shared fallback pair. Configuration is validated per area and lazily: loading it never fails, and an area's variables are checked when that area is first used (when its session is created, or at the start of a public operation). A project that sets only the e-Invoice variables therefore serves e-Invoice operations; calling a GST or e-Way Bill operation fails with the configuration error naming every missing variable of that area, before any network call. The request deadline is 30
seconds. The state code (`state_cd`) is the first two characters of the GSTIN.

## 2. Sessions

There are three session kinds. A session object owns its credentials, its expiry and its `ip_address`; every operation
takes the session, never loose credentials.

**GST (returns).** Four GET calls under `/authentication`, in this order.
1. `otprequest`: query `email`; headers `gst_username`, `state_cd`, `ip_address`, `client_id`, `client_secret`. The reply carries a `txn` value. Keep it; if the reply has none, fail with `MISSING_TXN`.
2. The GST portal sends an OTP to the registered mobile or e-mail. The developer supplies it; a client never reads or guesses it.
3. `authtoken`: query `email` and `otp`; the same headers plus `txn`.
4. `refreshtoken` before expiry, with the same headers plus `txn`. `logout` ends the session.

**e-Invoice.** One GET: `/einvoice/authenticate`. Query `email`; headers `username`, `password`, `ip_address`, `client_id`,
`client_secret`, `gstin`. The reply holds `AuthToken`; fail with `MISSING_TOKEN` if absent. Later calls send it as the
`auth-token` header, together with the `username` header. Concurrent sign-ins share one in-flight request.

**e-Way Bill.** One GET: `/ewaybillapi/v1.03/authenticate`. Unlike e-Invoice, `username` and `password` travel in the
query string with `email`; headers are `ip_address`, `client_id`, `client_secret`, `gstin`. The reply holds no token that
the client keeps; the client only records the expiry. Later calls send no `auth-token`.

Details and diagrams: `auth-flows.md`.

## 3. Session-bound `ip_address`

The `ip_address` header is read once from `WB_IP_ADDRESS` when the session is created and every call on that session
sends that same value. A session never changes its address in mid-flight, because the upstream binds the token to it.
Operations that take a session read the address from the session; the few public operations that take only the
configuration read it from the configuration.

## 4. Token lifetime and refresh

WhiteBooks' published e-Invoice API flow says an e-Invoice token lasts 1 hour in the sandbox and 6 hours in production; the
e-Invoice session picks 1 hour when the base URL is the client's `SANDBOX_URL` and 6 hours otherwise. For GST and e-Way Bill no
official lifetime is documented, so a client assumes six hours. A client refreshes (GST) or signs in again
(e-Invoice, e-Way Bill) when five minutes or less remain. If a call fails with code `1005` or a message saying the
session or token expired or is invalid, the session signs in once more and repeats that single call.

## 5. Headers

`headers.md` lists the header set of every operation. Common to all: `ip_address`, `client_id`, `client_secret`.
Headers and query parameters whose value is absent are left out. A client never logs `client_secret`, `password`, `auth-token` or an OTP. A GSTIN in
a log line is masked to its two-digit state code, asterisks and the last character.

## 6. Error parsing

Every response is parsed in this order; the first match wins and yields one typed error with `source`, `code`,
`message`, `httpStatus`, `unknown` and a `correlationId`.

1. Not JSON at status 400 or above: source `http`, code `HTTP_<status>`; unknown if the status is 500 or above. Not JSON on a 2xx: code `BAD_RESPONSE`, unknown.
2. `status_desc` containing `WB_ERR_<digits>`: source `whitebooks`. Unknown if the status is 500 or above or the code is `WB_ERR_9000`.
3. `error.error_cd` (GSTN): source `gstn`.
4. `ErrorDetails[]` with `ErrorCode` and `ErrorMessage` (NIC): source `nic`.
5. `status_cd` equal to `0`, or any status of 400 or above: source `upstream`.
6. Otherwise the call succeeded.

Code meanings come from `errors.md`. A timeout or network failure is not a failure of the request but an unknown
outcome: code `TIMEOUT` or `NETWORK`, `unknown` true. Unknown is never success (section 9).

## 7. Asynchronous returns (`reference_id` polling)

A GSTN save answers with `data.reference_id`, not a result. Poll the return-status operation with it as the `refid` header. Read `data.status_cd` first (and
fall back to a top-level `status_cd`). `P` (processed) and `PE` (processed with errors) and `ER` (error) are final; anything else
means wait. Defaults: deadline 120 seconds, first pause 5 seconds, doubling to at most 20 seconds. At the deadline fail
with `POLL_DEADLINE`, unknown.

## 8. Retries

A client retries in exactly one layer and only read operations: every GET, and the read-only POSTs that `operations-<area>.json` classes `sideEffect: read` (such as the GSTR-3B validate calls). A retry happens only for an unknown outcome or HTTP 429, at
most 3 attempts, with a delay of up to min(4000, 500 x 2^(attempt-1)) milliseconds of which half is random. Every write and irreversible
operation is never retried at the transport; it is sent once and any unknown outcome goes to section 9.

## 9. Unknown outcomes and the reconcile loop

A write that ends unknown (timeout, network failure, 5xx after the body was sent) may or may not have been applied.
Unknown is never success and a client must not resend blindly.

1. If the caller gave no status read-back, the write is sent once and the unknown error is raised as `WRITE_OUTCOME_UNKNOWN`.
2. Otherwise wait at least 10 minutes (600000 ms), then call the status read-back for the same document.
3. If the read-back shows the write landed, return that reply. Landed means: e-Invoice a reply with `Irn`; e-Way Bill a reply with `ewayBillNo` or `ewbNo`; GST only an explicit predicate supplied by the caller (for a return, `data.status_cd` is `P` or `PE` for the `reference_id` of this save; a `reference_id` from an earlier save proves nothing).
4. A resend is allowed only for e-Invoice, and only when the read-back fails with the NIC not-found code `2154`. A read-back that succeeds without proof, or fails any other way, is not proof of absence and does not allow a resend.
5. Attempts are capped at 3, each at least 10 minutes apart. When the cap is reached: `WRITE_NOT_LANDED` (not unknown) if the last read-back proved absence, else `WRITE_OUTCOME_UNKNOWN` (unknown).
6. e-Way Bill and GST writes never resend; they only read back.

## 10. Irreversible operations

Operations whose `sideEffect` in `operations-<area>.json` is `irreversible` (53 in v1: 44 GST, 1 e-Invoice, 8 e-Way Bill)
cannot be undone upstream: filing, cancelling, rejecting, closing. They are writes, so section 8 and 9 apply, and the code that
calls them must be preceded by an explicit confirmation from the developer or user that names the operation and the document.
The generated code asks for that confirmation itself: every one of the 53
functions starts with one shared guard, before any request, sign-in or reconcile read-back. Without an explicit confirmation
the function throws the typed error with code `IRREVERSIBLE_NOT_CONFIRMED` (source `client`, not unknown, nothing sent); the
message names the operation and says it cannot be undone. Reads and ordinary writes carry no guard.

- TypeScript: pass `{ confirmIrreversible: true }` in the options argument (`WriteOptions` extends it).
- Python: pass the keyword `confirm_irreversible=True`.
- Java: use `WriteOptions.confirmed()` or `opts.confirm()` (`withReconcile(...)` alone does not confirm).

Pass the confirmation only after the user has confirmed this exact operation and document; never default it on. A client
written from this contract must add the same guard; a skill must obtain the confirmation before running such an operation.

## 11. Model-authored files

When the model writes a client in a language outside the three ready-made clients, every file starts with a header of this form, in the
file's comment syntax, naming the client version, the spec date and the language:

```
WhiteBooks client <version> | spec_as_of <date> | template model-authored (<language>) | area <area>
Generated by the model from client contract version 2. Edit freely.
Not compile-tested by WhiteBooks; check it against the WhiteBooks client contract
SPDX-License-Identifier: Apache-2.0
Copyright 2026 BVM IT Consulting Services Pvt. Ltd
```

The last two lines are the licence of the client and are the same in every file the client places in a developer's project.

The header says the file is model-authored from client contract version 2, and a bumped contract version makes older
model-authored files visibly stale. Examples of the language marker: `template model-authored (typescript)`,
`template model-authored (python)`, `template model-authored (java)` for the three ready-made languages when a file is
re-created by hand.

## 12. Conformance checklist

`conformance-vectors.json` (beside this file) turns the error-parsing, masking, processed-return and retry-delay parts of CC-7 to CC-10, CC-12 and CC-16 into exact input and output pairs in no particular language (session refresh timing, the sign-in-and-repeat flow and the polling deadlines are not in it, so check those against the rules above): error bodies and the typed error each must give, GSTIN masks, processed-return replies and the retry delay range of each attempt. The TypeScript, Python and Java clients give the same answers to every case (a test replays the file against all three); a client in any other language is conformant on those points when it does too.

Each item holds in the TypeScript, Python and Java clients. The test checks each one in all three.

- **CC-1** Configuration reads exactly the seventeen `WB_*` variables (`WB_BASE_URL`, `WB_EMAIL`, `WB_IP_ADDRESS`, the three client pairs, `WB_GST_GSTIN`, `WB_GST_USERNAME`, and per NIC area `WB_EINV_*`/`WB_EWB_*` `GSTIN`, `NIC_USERNAME`, `NIC_PASSWORD`), defaults to the sandbox base URL and loads without failing.
- **CC-2** The GST sequence is `otprequest`, `authtoken`, `refreshtoken`, `logout`; the OTP request sends `gst_username` and `state_cd`; `authtoken` sends `otp` in the query and `txn` in the headers; a missing `txn` is `MISSING_TXN`.
- **CC-3** e-Invoice login is GET `/einvoice/authenticate` with `username` and `password` as headers beside `ip_address`; the `AuthToken` is kept and used as `auth-token`; a missing one is `MISSING_TOKEN`.
- **CC-4** e-Way Bill login is GET `/ewaybillapi/v1.03/authenticate` with `username` and `password` in the query and no token kept.
- **CC-5** Every operation that takes a session reads `ip_address` from the session, and the session fixes it once from configuration.
- **CC-6** The session refreshes five minutes before expiry, assumes a six-hour lifetime (e-Invoice in the sandbox: one hour) and the GST refresh carries `txn`.
- **CC-7** Error parsing recognises `WB_ERR_<n>`, `error_cd`, `ErrorDetails` and `status_cd`, in that order, treats `WB_ERR_9000` as unknown and knows code `1005`.
- **CC-8** An expired-session failure triggers one sign-in and one repeat of the call.
- **CC-9** Timeout, network failure, poll deadline and unconfirmed writes are unknown (`TIMEOUT`, `NETWORK`, `POLL_DEADLINE`, `WRITE_OUTCOME_UNKNOWN`), and `WRITE_NOT_LANDED` exists for proven absence.
- **CC-10** Polling reads `data.status_cd`, ends on `P`, `PE` or `ER`, and defaults to 120 s deadline, 5 s start and 20 s ceiling.
- **CC-11** Every operation classed `read` (all GETs and the read-only POSTs) goes through the retry helper and never the reconcile helper; every `write` and `irreversible` operation goes through the reconcile helper and never the retry helper.
- **CC-12** The retry helper makes at most 3 attempts with the 500 ms base and 4000 ms ceiling, and retries only unknown failures and HTTP 429.
- **CC-13** The reconcile loop waits 600000 ms by default and is capped at 3 attempts.
- **CC-14** Landed predicates exist for `Irn`, `ewayBillNo`, `ewbNo` and a processed return (`P` or `PE`).
- **CC-15** The not-found code `2154` appears on e-Invoice writes only; each e-Invoice write uses the `Irn` predicate, each e-Way Bill write the `ewayBillNo`/`ewbNo` predicate, and no GST write has a default predicate.
- **CC-16** Logs carry a masked GSTIN and a per-request correlation id, and the request deadline is 30 seconds.
- **CC-17** All 53 operations that `operations-<area>.json` marks irreversible are non-GET, exist as a function in each client and go through the reconcile helper, and each starts with the confirmation guard of section 10 (`IRREVERSIBLE_NOT_CONFIRMED` unless the caller confirms), which runs before the reconcile helper.
- **CC-18** Each area sends its own client pair (public operations send the GST pair); the area's variables are validated when its session is created or a public operation starts, with one configuration error naming every missing variable of that area and before any network call.
- **CC-19** Every file starts with the client header: the client line naming the area, the edit note, `SPDX-License-Identifier: Apache-2.0` and `Copyright 2026 BVM IT Consulting Services Pvt. Ltd`; a model-authored file carries the same two licence lines.
