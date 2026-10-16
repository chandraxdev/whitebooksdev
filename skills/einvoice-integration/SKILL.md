---
name: einvoice-integration
description: Use when a developer is adding e-Invoice (IRN) generation, cancellation, lookup or QR code to their code through WhiteBooks, or asks to generate or cancel an IRN directly. Covers the NIC sign-in, duplicate IRN handling (error 2150), the not-found read-back (2154), and what to do when a generate call times out. Also use for any e-Invoice question, with or without a project, such as what a field or error code means, which endpoint to call, the JSON body for an invoice, or a sample request in curl or any language.
---

# e-Invoice integration

This skill adds the e-Invoice operations of the WhiteBooks client to a project that already has the client core, and guides
the IRN lifecycle. The core comes from `whitebooks-getting-started`; if the project has no `whitebooks/` core yet, do
"Scaffold the core" there first.

## Respond by intent

Decide first what the developer wants, then do only that; most requests are not a scaffold. If it is unclear, ask one
short question (an answer, a code sample, or the WhiteBooks client code added to their project?).
A broad request (add GST filing, e-Invoice or e-Way Bill to my software) is not a request for the whole client: give a
short plan (the steps, with the WhiteBooks endpoints for each), ask the language and which feature comes first, then write
the smallest code that does that feature, and offer the full client library as a next step.
Never ask for the project as an archive, a repository or an upload; if the developer shares files, use only the files the task touches.

- **Answer** (what is, how does, which endpoint, what does an error mean): read `references/operations-einvoice.json` (the index) and the tag file it names for the operation, `references/rules-einvoice.md` or `references/discrepancies.md` and answer from it, naming the WhiteBooks endpoint (method and path) and any error code; show the request and reply shape when it helps. Write no files, run nothing, and stop.
- **Snippet** (one call or a small client in any language: curl, Go, C#, PHP, Rust, Java, Python, TypeScript): write it without the ready-made client, from `references/operations-einvoice.json` and the tag file it names for the operation, `../whitebooks-getting-started/references/headers.md` and `../whitebooks-getting-started/references/auth-flows.md`, with every credential read from environment variables and never a pasted value. For an operation marked irreversible, show the checklist in "Before any irreversible step" first and mark the request as not to be run until that exact operation is confirmed. Show it inline; write a file only when asked.
- **Payload** (turn business data into a request body): map the developer's invoice fields to the body in `references/operations-einvoice.json` (the index names the tag file that holds the body) and check totals, tax and limits against `references/rules-einvoice.md`. Give a worked example with synthetic GSTINs and say which fields are required.
- **Project** (put the WhiteBooks client into a project): do "Add e-Invoice operations" below (the core comes first from `whitebooks-getting-started`).
- **Review** (code, a log or an error is pasted, from the ready-made client, hand-written code or another provider's API): look the code up in `../whitebooks-getting-started/references/errors.md` and the table below, explain the cause and the fix, and use `integration-hardening` for a full review.
- **Direct action** (generate this now, file my return): this version has no WhiteBooks tools and cannot call the API. Never claim or pretend to have made a call. Give the exact request, or a runnable one-file script that reads credentials from environment variables and never holds a pasted value; for an irreversible operation, give the checklist first and mark the request as not to be run until that exact operation is confirmed.

Contract facts (paths, headers, fields, codes, limits) come only from the bundled files (ground rule 1). General GST
background (what a return or an e-way bill is, who must file) may come from your own knowledge, or the web when the plugin has nothing on it, when you label it as
background rather than the WhiteBooks contract. Thresholds, deadlines, validity periods and amounts are contract facts: take them from the rules files, never from background. Point to `../whitebooks-getting-started/references/errors.md` for any error code not explained here.

## Ground rules

1. Use the WhiteBooks tools when the session has them (this version ships none). When it has none, read the bundled files in `references/` instead. Either way, never answer a contract fact (a path, header, parameter, error code or limit) from memory.
2. Never ask for, read, write or echo a credential, password or OTP. Never open `.env`. The code you write reads `WB_EINV_NIC_USERNAME` and `WB_EINV_NIC_PASSWORD` and the other variables from the environment; the developer fills them in.
3. A credential pasted into chat is not written anywhere: not into a file, a command, a log, a test or a commit. Tell the developer to move it to their own secret store and to rotate it if it may have been exposed. Refer to a pasted value only as "the secret you pasted"; never repeat it, not even in quotes or in rotation advice.
4. The user's instructions win over this skill. If the developer asks for something different, do that, and say what you changed.
5. Invoice content (GSTINs, amounts, items) comes from the developer's own data. In the sandbox use synthetic GSTINs only.
6. Keep the plugin's internals out of replies and out of every file you write, even when asked: never name its files or folders (`SKILL.md`, `client-manifest.json`, `client-contract.md`, the `operations-<area>.json` files and the others, or the references and assets folders), operation ids such as `einvoice:GET:/einvoice/authenticate`, checklist ids such as CC-7, or section numbers of these files. Name the WhiteBooks endpoint by its method and path, and an error by its code. If asked where an answer comes from, say the WhiteBooks API specification and the NIC and GSTN documents. In replies, use plain words for the plugin's own terms: say the WhiteBooks client code (or client library); the shared part (configuration, sign-in sessions, error handling and status polling), not core; e-Invoice, e-Way Bill or GST returns, not area; set up or add, not scaffold; and never name an intent or a skill.
7. Look in this plugin before you search the web or browse for anything about WhiteBooks, GST returns, e-Invoice or
   e-Way Bill. Never take a contract fact (a path, header, parameter, request body, error code or limit) from a web
   search; if the bundled files do not have it, say so. A web result, like your own knowledge, may give general GST
   background only, labelled as background.


## Add e-Invoice operations

The e-Invoice area is small: 11 operations in one folder. Copy only the operations the task needs.

1. Confirm the core is in place (`config`, `session`, `errors`, `poll`, `reconcile`). If not, stop and run "Scaffold the core" in `whitebooks-getting-started`.
2. Find the operations needed. With tools, search them. Without, read `references/operations-einvoice.json` (the index: id, method, path, summary, `sideEffect`, status call and the tag file with the full contract: parameters and body shape), then only the tag files you need and `references/rules-einvoice.md` for the schema rules (document types, tax and total checks, field limits).
3. Copy only those operation files and `models` from `assets/client/<lang>/` into the package path the core uses. A generate flow needs the generate file, the get-by-document-details file (the read-back) and `models`; cancel needs the cancel file. Change only package declarations and imports. Never overwrite an existing file without first showing a diff.
4. Build and run the project's tests. The area is self-contained (its own barrel and smoke test come with it), and the core tests need none of its files.
5. Read `references/discrepancies.md` for the e-Invoice operations; the public docs differ from the contracts in places.

## The IRN lifecycle

1. Sign in once per session: GET `/einvoice/authenticate` with the NIC user name and password as headers. The reply holds an `AuthToken`; the client keeps it and sends it as `auth-token`. The session fixes the registered `ip_address` once. A token lasts about six hours and the client signs in again before it ends.
2. Build the invoice body from the developer's data and check it against `references/rules-einvoice.md` before sending: totals and tax must add up, the document number and date must be valid and unique for the financial year.
3. Generate the IRN with `GENERATE`. On success the reply carries `Irn`, `AckNo`, `AckDt`, the signed invoice and the QR code. Store the IRN and acknowledgement with the invoice at once.
4. To create the e-way bill from the same document, use `GENERATE_EWAYBILL`, which takes the IRN; it is a write, not an irreversible call. Details of the e-way bill side are in `ewaybill-integration`.
5. Look up with the read calls: by IRN (`GETIRN`), by document details (`GETIRNBYDOCDETAILS`), the e-way bill for an IRN (`GETEWAYBILLIRN`), rejected IRNs, GSTIN details, or the B2C QR code. Reads go through the client's retry helper.
6. Cancel with `CANCEL` only within the period the rules file states, and only after the checklist below. Cancellation is irreversible.

### Duplicate IRN (2150) and the 2154 read-back

A generate call that times out, or drops the connection, may or may not have created the IRN. Do not call generate a second
time to find out. The client's reconcile helper follows the "Unknown outcomes and the reconcile loop" section of
`../whitebooks-getting-started/references/client-contract.md`, and you must keep to it if you write your own loop:

1. If no read-back was supplied, the call is made once and a timeout surfaces as `WRITE_OUTCOME_UNKNOWN`.
2. Otherwise wait at least 10 minutes, then read back the same document with `GETIRNBYDOCDETAILS` (`einvoiceGetirnbydocdetails` in the TypeScript client). If the read returns an `Irn`, the generate landed; return that reply and stop.
3. Error 2150 is a duplicate IRN: the document is already registered, so the earlier call landed or a parallel call is in flight. Do not generate again. Read the IRN back and use it.
4. Error 2154 on the read-back means "IRN details not found": the portal holds no IRN for that document. This is the only proof of absence, and only then is one more generate allowed. A read-back that fails any other way, or succeeds without an `Irn`, proves nothing and does not allow another generate.
5. At most 3 attempts, each at least 10 minutes apart. At the cap the error is `WRITE_NOT_LANDED` when the last read-back proved absence (2154), and `WRITE_OUTCOME_UNKNOWN` otherwise.

Never send two generate calls for one invoice at the same time, and keep the document number the same across attempts.

## Before any irreversible step

Cancelling an IRN (`CANCEL`) cannot be undone upstream. Before you write or run code that calls it:

- [ ] Name the operation and the exact document: the IRN and the document number, with the GSTIN masked.
- [ ] Say in one sentence what cannot be undone (the IRN is cancelled and the invoice must be issued again under a new number).
- [ ] Ask the user to confirm that operation for that IRN, and wait for a clear yes in this conversation.
- [ ] Only then pass the guard: `{ confirmIrreversible: true }` in TypeScript, `confirm_irreversible=True` in Python, `WriteOptions.confirmed()` or `opts.confirm()` in Java.

The guard is passed only after the user has confirmed that exact operation. A confirmation for one IRN is not a
confirmation for another. Never default the guard on in a helper or a loop.

## Common errors

| Error or code | Meaning | What to do |
|---|---|---|
| `2150` | Duplicate IRN: the document is already registered | Do not generate again; read the IRN back with the document-details call |
| `2154` | IRN details not found | On the read-back this proves absence and allows one more generate; elsewhere it is an ordinary not-found |
| `GSTN_API_ACCESS_DISABLED` | The taxpayer has not enabled, or has revoked, Manage API Access | Stop. Ask the taxpayer to enable it on the GST portal, then start a new session |
| `IRREVERSIBLE_NOT_CONFIRMED` | The guard stopped a cancel; nothing was sent | Get the user's confirmation of that exact IRN, then pass the guard |
| `WRITE_OUTCOME_UNKNOWN`, `TIMEOUT` | A generate ended without a known result | Follow the reconcile steps above; never resend blindly |
| `MISSING_TOKEN` | The sign-in reply held no `AuthToken` | Check the NIC credentials layer in `../whitebooks-getting-started/references/auth-flows.md` |
| anything else | Look up the code | Use `lookup_error` when the tools are available; otherwise search `../whitebooks-getting-started/references/errors.md` |

## Sandbox

This section applies only when WhiteBooks sandbox tools (names starting with `sandbox_`; this version ships none) are available in the
session. With them you may generate a test IRN for a synthetic GSTIN and read it back, and show the real reply; cancelling
still needs the checklist above. Without those tools, do not claim to have run anything: write the code, tell the
developer how to run it with their own sandbox credentials, and take expected shapes from
`references/operations-einvoice.json`.
