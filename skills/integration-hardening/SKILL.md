---
name: integration-hardening
description: Use when a developer wants a WhiteBooks GST integration (GST returns, e-Invoice or e-Way Bill) reviewed, debugged or made production-safe, whether it uses the ready-made client, hand-written code or another provider's API, or pastes code, a log or an error to explain. Covers sessions and token refresh, the registered IP address, polling, retries, unknown outcomes after timeouts, irreversible calls, logging and expired taxpayer consent. Also use for questions on these topics with or without a project, and for a corrected sample request in curl or any language.
---

# Integration hardening

This skill reviews an integration that already calls WhiteBooks, whether it uses the ready-made client or hand-written code, against the
client contract. It finds gaps, proposes fixes and applies them only when the developer agrees. The checklist and the
rules are in `../whitebooks-getting-started/references/client-contract.md` (client contract version 2).

## Respond by intent

Decide first what the developer wants, then do only that; most requests are not a scaffold. If it is unclear, ask one
short question (an answer, a code sample, or the WhiteBooks client code added to their project?).
A broad request (add GST filing, e-Invoice or e-Way Bill to my software) is not a request for the whole client: give a
short plan (the steps, with the WhiteBooks endpoints for each), ask the language and which feature comes first, then write
the smallest code that does that feature, and offer the full client library as a next step.
Never ask for the project as an archive, a repository or an upload; if the developer shares files, use only the files the task touches.

- **Answer** (what is, how does, which endpoint, what does an error mean): read `../whitebooks-getting-started/references/client-contract.md`, `../whitebooks-getting-started/references/errors.md` or `../whitebooks-getting-started/references/auth-flows.md` and answer from it, naming the WhiteBooks endpoint (method and path) and any error code; show the request and reply shape when it helps. Write no files, run nothing, and stop.
- **Snippet** (one call or a small client in any language: curl, Go, C#, PHP, Rust, Java, Python, TypeScript): write it without the ready-made client, from `../whitebooks-getting-started/references/client-contract.md`, `../whitebooks-getting-started/references/headers.md` and the area skill's operation file, with every credential read from environment variables and never a pasted value. For an operation marked irreversible, show the checklist in "Before any irreversible step" first and mark the request as not to be run until that exact operation is confirmed. Show it inline; write a file only when asked.
- **Payload** (turn business data into a request body): send the developer to the area skill, which maps the body from its operation file (`operations-<area>.json`) and rules file; this skill holds no operation file, so it does not build the body itself.
- **Project** (put the WhiteBooks client into a project): this skill does not scaffold; point to `whitebooks-getting-started`.
- **Review** (code, a log or an error is pasted, from the ready-made client, hand-written code or another provider's API): this skill's main job: do "Check an existing integration" below; for a single pasted error or log, explain the cause and the fix from the files above without asking for the whole codebase.
- **Direct action** (generate this now, file my return): this version has no WhiteBooks tools and cannot call the API. Never claim or pretend to have made a call. Give the exact request, or a runnable one-file script that reads credentials from environment variables and never holds a pasted value; for an irreversible operation, give the checklist first and mark the request as not to be run until that exact operation is confirmed.

Contract facts (paths, headers, fields, codes, limits) come only from the bundled files (ground rule 1). General GST
background (what a return or an e-way bill is, who must file) may come from your own knowledge, or the web when the plugin has nothing on it, when you label it as
background rather than the WhiteBooks contract. Thresholds, deadlines, validity periods and amounts are contract facts: take them from the rules files, never from background. Point to `../whitebooks-getting-started/references/errors.md` for any error code not explained here.

## Ground rules

1. Use the WhiteBooks tools when the session has them (this version ships none). When it has none, read the bundled files in `../whitebooks-getting-started/references/` instead (the client contract and the error list). Either way, never answer a contract fact (a path, header, parameter, error code or limit) from memory.
2. Never ask for, read, write or echo a credential, password or OTP. Never open `.env`. When you review configuration, read only the code that reads the environment and the `.env.example` placeholder names, never a real environment file.
3. A credential pasted into chat is not written anywhere: not into a file, a command, a log, a test or a commit. Tell the developer to move it to their own secret store and to rotate it if it may have been exposed. Refer to a pasted value only as "the secret you pasted"; never repeat it, not even in quotes or in rotation advice. If the review finds a credential already committed, say so and tell them to rotate it; do not print it.
4. The user's instructions win over this skill. If the developer asks for something different, do that, and say what you changed.
5. A review reports findings with file and line; it does not rewrite working code the contract does not touch.
6. Keep the plugin's internals out of replies and out of every file you write, even when asked: never name its files or folders (`SKILL.md`, `client-manifest.json`, `client-contract.md`, the `operations-<area>.json` files and the others, or the references and assets folders), operation ids such as `einvoice:GET:/einvoice/authenticate`, checklist ids such as CC-7, or section numbers of these files. Name the WhiteBooks endpoint by its method and path, and an error by its code. If asked where an answer comes from, say the WhiteBooks API specification and the NIC and GSTN documents. In replies, use plain words for the plugin's own terms: say the WhiteBooks client code (or client library); the shared part (configuration, sign-in sessions, error handling and status polling), not core; e-Invoice, e-Way Bill or GST returns, not area; set up or add, not scaffold; and never name an intent or a skill.
7. Look in this plugin before you search the web or browse for anything about WhiteBooks, GST returns, e-Invoice or
   e-Way Bill. Never take a contract fact (a path, header, parameter, request body, error code or limit) from a web
   search; if the bundled files do not have it, say so. A web result, like your own knowledge, may give general GST
   background only, labelled as background.


## Check an existing integration

1. Locate the integration: client files (the first line holds `spec_as_of` and `template` fields, see "Upgrade the client" in `whitebooks-getting-started`), hand-written client code, and the code that calls it. Note the language and which areas it uses.
2. If it is the client, compare it with the plugin's client using "Upgrade the client" in `whitebooks-getting-started`; a stale or hand-edited core explains many findings. If it is hand-written, check it against the list below item by item.
3. Walk the checklist CC-1 to CC-19 in the "Conformance checklist" section of `../whitebooks-getting-started/references/client-contract.md`. For each item write pass, fail or not applicable, with the file and line that shows it. The items that most often fail are listed in the next section.
4. Report findings ordered by risk: lost or duplicated writes first, then security, then availability, then tidiness. Name each item in the report by its plain name, never by its CC number, the contract's section numbers or its file name (ground rule 6); say what the code must do and why.
5. Offer fixes as small separate changes, show the diff for each, and apply only those the developer accepts. Run the project's tests after each and report the last lines.

## What to look for

- **Configuration (CC-1).** Exactly the thirteen `WB_*` variables, a separate client id and secret pair for each of GST, e-Invoice and e-Way Bill, sandbox base URL by default; an area's missing variables are all reported at once when that area is first used, before any call. No key or password in code, tests, fixtures or logs.
- **One `ip_address` per session (CC-5).** The registered address is read once when the session is created and every call on that session sends the same value. Look for code that fills the header per request, from a proxy, a load balancer or a changing client address; the upstream binds the token to the address, so a mismatch looks like an expired session.
- **Sessions and refresh (CC-2 to CC-8).** GST OTP flow with `txn`; e-Invoice token as `auth-token`; e-Way Bill credentials in the query; refresh five minutes before the assumed six-hour expiry; one sign-in and one repeat on an expired session, never a loop; concurrent sign-ins share one request.
- **Errors (CC-7, CC-9).** Parsing order as in the "Error parsing" section of the contract; `WB_ERR_9000` and every timeout treated as unknown, never as success or as failure.
- **Polling (CC-10).** Reads `data.status_cd`, ends on `P`, `PE` or `ER`, has a deadline, and a missed deadline is unknown.
- **Retries (CC-11, CC-12).** Reads retry in exactly one layer, at most 3 attempts, with capped jittered backoff, only on unknown failures and 429. Writes never retry at the transport.
- **Unknown outcomes (CC-13 to CC-15).** The reconcile loop below.
- **Per-area credentials (CC-18).** Each area sends its own pair, public operations send the GST pair, and a project with only one area's variables still starts and serves that area.
- **Irreversible calls (CC-17).** Every one of the 53 irreversible operations sits behind the confirmation guard, and no code path passes the guard by default.
- **Logging and personal data (CC-16).** GSTINs masked, a correlation id on every line, no token, password, OTP or invoice contents in logs, metrics labels or URLs.
- **Idempotency.** Anything that could submit the same document twice (a queue redelivery, a double click, a restarted job) keys the work by document identity and checks before it calls.

## The reconcile loop

A write that times out, or fails after the body was sent, may or may not have been applied. Check that the integration
does all of this, and add it where missing:

1. Never resend a write blindly after a timeout, a dropped connection or a 5xx.
2. Wait at least 10 minutes, then read back the same document: e-Invoice by document details, e-Way Bill by bill lookup, GST return by the return status for this save's `reference_id`.
3. If the read-back shows the write landed (an `Irn`, an `ewayBillNo` or `ewbNo`, or `P` or `PE` for this `reference_id`), use that reply.
4. Resend only for e-Invoice, and only when the read-back fails with the not-found code 2154. A read-back that fails any other way proves nothing.
5. Cap at 3 attempts, each at least 10 minutes apart; at the cap report `WRITE_NOT_LANDED` if absence was proven, else `WRITE_OUTCOME_UNKNOWN`, and leave the decision to a person.
6. e-Way Bill and GST writes never resend; they only read back.

The loop has an owner: a person or job that is told when a write stays unknown, and a record of every unknown outcome until
it is closed.

## Before any irreversible step

Hardening work may touch code that calls irreversible operations (filing, cancelling, rejecting, closing). Before you
write or run anything that executes one, even in a test:

- [ ] Name the operation and the exact document: return and period, IRN, or e-way bill number, with the GSTIN masked.
- [ ] Say in one sentence what cannot be undone.
- [ ] Ask the user to confirm that operation on that document, and wait for a clear yes in this conversation.
- [ ] Only then pass the guard: `{ confirmIrreversible: true }` in TypeScript, `confirm_irreversible=True` in Python, `WriteOptions.confirmed()` or `opts.confirm()` in Java.

The guard is passed only after the user has confirmed that exact operation. Reviewing that the guard exists is not
the same as running the call; tests of guarded paths use the failing case (no confirmation) and never real documents.

## Common errors

| Error or code | Meaning | What to do |
|---|---|---|
| Consent expired or revoked: `GSTN_API_ACCESS_DISABLED` | The taxpayer has not enabled, or has revoked, Manage API Access for this GSP-ASP pair (6 hours to 30 days) | Stop retrying; this is not a code bug. Tell the taxpayer to enable access on the GST portal, then start a new session. Make sure the integration surfaces this to a person rather than looping |
| `IRREVERSIBLE_NOT_CONFIRMED` | The guard stopped an irreversible call; nothing was sent | Correct behaviour. Get the user's confirmation of that exact operation, then pass the guard |
| `WRITE_OUTCOME_UNKNOWN`, `TIMEOUT`, `NETWORK` | Outcome unknown | Reconcile as above; never treat as success |
| `WRITE_NOT_LANDED` | A read-back proved the write is absent | Safe to decide on a resend (e-Invoice only) |
| `POLL_DEADLINE` | The status poll ran out of time | Poll again with the same `reference_id`; do not save again |
| expired-session code `1005` | The token or session is no longer valid | One sign-in and one repeat; if it recurs, check the `ip_address` finding above |
| anything else | Look up the code | Use `lookup_error` when the tools are available; otherwise search `../whitebooks-getting-started/references/errors.md` |

## Sandbox

This section applies only when WhiteBooks sandbox tools (names starting with `sandbox_`; this version ships none) are available in the
session. With them you may reproduce a finding against the sandbox with synthetic GSTINs, for example a session whose
address changes, and show the real reply; guarded calls still need the checklist above. Without those tools, do not
claim to have reproduced anything: describe the failing case, point to the contract item, and suggest a test the
developer can run with their own sandbox credentials. See `../whitebooks-getting-started/references/client-contract.md`.
