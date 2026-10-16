---
name: ewaybill-integration
description: Use when a developer is adding e-Way Bill generation, Part-B vehicle updates, consolidation, validity extension, cancellation or rejection, multi-vehicle movement, or lookups to their code through WhiteBooks, or asks to generate or cancel an e-Way Bill directly. Covers the NIC sign-in and what to do when a generate call times out. Also use for any e-Way Bill question, with or without a project, such as when one is needed, what a field or error code means, which endpoint to call, the JSON body for a consignment, or a sample request in curl or any language.
---

# e-Way Bill integration

This skill adds the e-Way Bill operations of the WhiteBooks client to a project that already has the client core, and guides
the e-way bill lifecycle. The core comes from `whitebooks-getting-started`; if the project has no `whitebooks/` core yet,
do "Scaffold the core" there first.

## Respond by intent

Decide first what the developer wants, then do only that; most requests are not a scaffold. If it is unclear, ask one
short question (an answer, a code sample, or the WhiteBooks client code added to their project?).
A broad request (add GST filing, e-Invoice or e-Way Bill to my software) is not a request for the whole client: give a
short plan (the steps, with the WhiteBooks endpoints for each), ask the language and which feature comes first, then write
the smallest code that does that feature, and offer the full client library as a next step.
Never ask for the project as an archive, a repository or an upload; if the developer shares files, use only the files the task touches.

- **Answer** (what is, how does, which endpoint, what does an error mean): read `references/operations-ewaybill.json` (the index) and the tag file it names for the operation, `references/rules-ewaybill.md` or `references/discrepancies.md` and answer from it, naming the WhiteBooks endpoint (method and path) and any error code; show the request and reply shape when it helps. Write no files, run nothing, and stop.
- **Snippet** (one call or a small client in any language: curl, Go, C#, PHP, Rust, Java, Python, TypeScript): write it without the ready-made client, from `references/operations-ewaybill.json` and the tag file it names for the operation, `../whitebooks-getting-started/references/headers.md` and `../whitebooks-getting-started/references/auth-flows.md`, with every credential read from environment variables and never a pasted value. For an operation marked irreversible, show the checklist in "Before any irreversible step" first and mark the request as not to be run until that exact operation is confirmed. Show it inline; write a file only when asked.
- **Payload** (turn business data into a request body): map the developer's consignment fields to the body in `references/operations-ewaybill.json` (the index names the tag file that holds the body) and check them against `references/rules-ewaybill.md`. Give a worked example with synthetic GSTINs and say which fields are required.
- **Project** (put the WhiteBooks client into a project): do "Add e-Way Bill operations" below (the core comes first from `whitebooks-getting-started`).
- **Review** (code, a log or an error is pasted, from the ready-made client, hand-written code or another provider's API): look the code up in `../whitebooks-getting-started/references/errors.md` and the table below, explain the cause and the fix, and use `integration-hardening` for a full review.
- **Direct action** (generate this now, file my return): this version has no WhiteBooks tools and cannot call the API. Never claim or pretend to have made a call. Give the exact request, or a runnable one-file script that reads credentials from environment variables and never holds a pasted value; for an irreversible operation, give the checklist first and mark the request as not to be run until that exact operation is confirmed.

Contract facts (paths, headers, fields, codes, limits) come only from the bundled files (ground rule 1). General GST
background (what a return or an e-way bill is, who must file) may come from your own knowledge, or the web when the plugin has nothing on it, when you label it as
background rather than the WhiteBooks contract. Thresholds, deadlines, validity periods and amounts are contract facts: take them from the rules files, never from background. Point to `../whitebooks-getting-started/references/errors.md` for any error code not explained here.

## Ground rules

1. Use the WhiteBooks tools when the session has them (this version ships none). When it has none, read the bundled files in `references/` instead. Either way, never answer a contract fact (a path, header, parameter, error code or limit) from memory.
2. Never ask for, read, write or echo a credential, password or OTP. Never open `.env`. The code you write reads `WB_EWB_NIC_USERNAME` and `WB_EWB_NIC_PASSWORD` and the other variables from the environment; the developer fills them in.
3. A credential pasted into chat is not written anywhere: not into a file, a command, a log, a test or a commit. Tell the developer to move it to their own secret store and to rotate it if it may have been exposed. Refer to a pasted value only as "the secret you pasted"; never repeat it, not even in quotes or in rotation advice.
4. The user's instructions win over this skill. If the developer asks for something different, do that, and say what you changed.
5. Distances, vehicle numbers and document details come from the developer's own data. In the sandbox use synthetic GSTINs only.
6. Keep the plugin's internals out of replies and out of every file you write, even when asked: never name its files or folders (`SKILL.md`, `client-manifest.json`, `client-contract.md`, the `operations-<area>.json` files and the others, or the references and assets folders), operation ids such as `einvoice:GET:/einvoice/authenticate`, checklist ids such as CC-7, or section numbers of these files. Name the WhiteBooks endpoint by its method and path, and an error by its code. If asked where an answer comes from, say the WhiteBooks API specification and the NIC and GSTN documents. In replies, use plain words for the plugin's own terms: say the WhiteBooks client code (or client library); the shared part (configuration, sign-in sessions, error handling and status polling), not core; e-Invoice, e-Way Bill or GST returns, not area; set up or add, not scaffold; and never name an intent or a skill.
7. Look in this plugin before you search the web or browse for anything about WhiteBooks, GST returns, e-Invoice or
   e-Way Bill. Never take a contract fact (a path, header, parameter, request body, error code or limit) from a web
   search; if the bundled files do not have it, say so. A web result, like your own knowledge, may give general GST
   background only, labelled as background.


## Add e-Way Bill operations

The e-Way Bill area has 27 operations in one folder. Copy only the operations the task needs.

1. Confirm the core is in place (`config`, `session`, `errors`, `poll`, `reconcile`). If not, stop and run "Scaffold the core" in `whitebooks-getting-started`.
2. Find the operations needed. With tools, search them. Without, read `references/operations-ewaybill.json` (the index: id, method, path, summary, `sideEffect`, status call and the tag file with the full contract: parameters and body shape), then only the tag files you need and `references/rules-ewaybill.md` for the business rules (validity by distance, who may act at which stage, field limits).
3. Copy only those operation files and `models` from `assets/client/<lang>/` into the package path the core uses. Generating a bill needs `genewaybill` and `getewaybill` (the read-back); a Part-B update needs `vehewb`. Change only package declarations and imports. Never overwrite an existing file without first showing a diff.
4. Build and run the project's tests. The area is self-contained (its own barrel and smoke test come with it).
5. Read `references/discrepancies.md` for the e-Way Bill operations; the public docs differ from the contracts in places.

## The e-way bill lifecycle

1. Sign in once per session: GET `/ewaybillapi/v1.03/authenticate`. Unlike e-Invoice, the user name and password travel in the query string and the reply holds no token the client keeps. The session fixes the registered `ip_address` once. The client signs in again before the session ends.
2. Generate with `genewaybill`. The reply carries `ewayBillNo` (or `ewbNo`) and the validity. Store the number with the document at once. When the bill comes from an e-Invoice IRN, `einvoice-integration` has `GENERATE_EWAYBILL`.
3. Part-B (the vehicle) is set or changed with `vehewb`, which is a write and may be repeated when the vehicle changes. Use `updatetransporter` to hand the bill to a transporter and `regentripsheet` to regenerate a trip sheet.
4. Extend validity with `extendvalidity` when the goods are late; the rules file states the window and the reasons allowed. It is irreversible.
5. Consolidate several bills into one trip with `gencewb` (consolidated e-way bill). Multi-vehicle movement is `initmulti` (start), `addmulti` (add a vehicle) and `updtmulti` (change one); all three are irreversible.
6. Cancel with `canewb` (the generator, within the allowed time) or reject with `rejewb` (the recipient). Close a consolidated or multi-vehicle record with `clsewb`. All are irreversible.
7. Read with `getewaybill` and the other `get*` calls (by date, by consignor, for a transporter, rejected by others, trip sheet, HSN and GSTIN details). Reads go through the client's retry helper.

### When a generate call times out

A `genewaybill` that times out or drops may have created the bill. Do not generate again to find out. The client's reconcile
helper follows the "Unknown outcomes and the reconcile loop" section of `../whitebooks-getting-started/references/client-contract.md`:

1. If no read-back was supplied, the call is made once and a timeout surfaces as `WRITE_OUTCOME_UNKNOWN`.
2. Otherwise wait at least 10 minutes, then read back with `getewaybill` (or the consignor listing for that document). A reply with `ewayBillNo` or `ewbNo` means it landed; use it.
3. For e-Way Bill the loop never resends. It only reads back, up to 3 attempts at least 10 minutes apart, and ends in `WRITE_OUTCOME_UNKNOWN` when nothing proves the outcome. Resending is a decision for the developer after they check the portal.

## Before any irreversible step

Cancelling (`canewb`), rejecting (`rejewb`), closing (`clsewb`), extending validity (`extendvalidity`), consolidating
(`gencewb`) and the multi-vehicle calls (`initmulti`, `addmulti`, `updtmulti`) cannot be undone upstream: 8 operations
in this area. Before you write or run code that calls one:

- [ ] Name the operation and the exact e-way bill (or consolidated bill) number, with the GSTIN masked.
- [ ] Say in one sentence what cannot be undone (for example, that the bill is cancelled and a new one needs a new number).
- [ ] Ask the user to confirm that operation for that bill, and wait for a clear yes in this conversation.
- [ ] Only then pass the guard: `{ confirmIrreversible: true }` in TypeScript, `confirm_irreversible=True` in Python, `WriteOptions.confirmed()` or `opts.confirm()` in Java.

The guard is passed only after the user has confirmed that exact operation. A confirmation for one bill is not a
confirmation for another, and a Part-B update (`vehewb`) is an ordinary write that needs no guard. Never default the
guard on in a helper or a loop.

## Common errors

| Error or code | Meaning | What to do |
|---|---|---|
| `GSTN_API_ACCESS_DISABLED` | The taxpayer has not enabled, or has revoked, Manage API Access | Stop. Ask the taxpayer to enable it on the GST portal, then start a new session |
| `IRREVERSIBLE_NOT_CONFIRMED` | The guard stopped a cancel, reject, close or extend; nothing was sent | Get the user's confirmation of that exact operation, then pass the guard |
| `WRITE_OUTCOME_UNKNOWN`, `TIMEOUT` | A generate ended without a known result | Follow the read-back steps above; never resend blindly |
| a code starting `WB_ERR_` | WhiteBooks gateway error | Look it up; `WB_ERR_9000` means unknown outcome |
| anything else | Look up the code | Use `lookup_error` when the tools are available; otherwise search `../whitebooks-getting-started/references/errors.md` |

## Sandbox

This section applies only when WhiteBooks sandbox tools (names starting with `sandbox_`; this version ships none) are available in the
session. With them you may generate a test bill for a synthetic GSTIN, update Part-B and read it back, and show the real
reply; cancelling, rejecting and the other guarded calls still need the checklist above. Without those tools, do not
claim to have run anything: write the code, tell the developer how to run it with their own sandbox credentials, and
take expected shapes from `references/operations-ewaybill.json`.
