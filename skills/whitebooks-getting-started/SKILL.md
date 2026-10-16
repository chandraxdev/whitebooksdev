---
name: whitebooks-getting-started
description: Use when a repository has a whitebooks/ client folder, or a developer mentions WhiteBooks, GST, GSTIN, e-Invoice or e-Way Bill credentials, a client id or client secret, a NIC username or password, an OTP, WB_* environment variables or a .env file (which this skill never opens), including pasting a secret or asking to put values into config. Also use when starting a WhiteBooks GST integration (GST returns, e-Invoice or e-Way Bill), asking how sessions, sandbox and production, credentials or taxpayer consent work, scaffolding the client in TypeScript, Python or Java, upgrading an installed client, or needing a client in another language. Also use for plain questions with or without a project open, such as what something is, how sign-in or sessions work, which endpoint to call, what an error means, or a sample request in curl or any language.
---

# WhiteBooks getting started

This skill introduces a developer to the WhiteBooks GST APIs and answers their questions, and, only when the developer asks
for it, adds the core of the client to their project.
It owns the client core (configuration, sessions, errors, polling, reconcile loop) and the shared references. The three area
skills (`gst-returns-integration`, `einvoice-integration`, `ewaybill-integration`) add operations on top of the core, and
`integration-hardening` reviews an integration that already exists.

## Respond by intent

Decide first what the developer wants, then do only that; most requests are not a scaffold. If it is unclear, ask one
short question (an answer, a code sample, or the WhiteBooks client code added to their project?).
A broad request (add GST filing, e-Invoice or e-Way Bill to my software) is not a request for the whole client: give a
short plan (the steps, with the WhiteBooks endpoints for each), ask the language and which feature comes first, then write
the smallest code that does that feature, and offer the full client library as a next step.
Never ask for the project as an archive, a repository or an upload; if the developer shares files, use only the files the task touches.

- **Setup** (the skill is loaded with no question or task, for example from a host's setup or onboarding button, or the message only names the plugin, or says set up, get started or onboard, without naming a feature): say in two or three lines what the plugin does: it explains endpoints, payloads and errors, writes a sample request in any language, and adds the WhiteBooks client code to an existing app. Then ask one question: what they are building and which feature they need first. Do not ask for a language, write or show code, or ask for the project, and stop.
- **Answer** (what is, how does, which endpoint, what does an error mean): read the matching file in `references/` (`auth-flows.md`, `headers.md`, `errors.md`, `client-contract.md`, `discrepancies.md`) and answer from it, naming the WhiteBooks endpoint (method and path) and any error code; show the request and reply shape when it helps. Write no files, run nothing, and stop.
- **Snippet** (one call or a small client in any language: curl, Go, C#, PHP, Rust, Java, Python, TypeScript): write it without the ready-made client, from `references/auth-flows.md`, `references/headers.md` and the area skill's operation file, with every credential read from environment variables and never a pasted value. For an operation marked irreversible, show the checklist in "Before any irreversible step" first and mark the request as not to be run until that exact operation is confirmed. Show it inline; write a file only when asked.
- **Payload** (turn business data into a request body): map the developer's fields to the body in the area skill's operation file (`operations-<area>.json`) and check it against that skill's rules file. Give a worked example with synthetic GSTINs and say which fields are required.
- **Project** (put the WhiteBooks client into a project): do "Scaffold the core" below, then add the areas with their skills.
- **Review** (code, a log or an error is pasted, from the ready-made client, hand-written code or another provider's API): for a full review use `integration-hardening`; for one error, look it up in `references/errors.md` and `references/discrepancies.md` and explain the cause and the fix.
- **Direct action** (generate this now, file my return): this version has no WhiteBooks tools and cannot call the API. Never claim or pretend to have made a call. Give the exact request, or a runnable one-file script that reads credentials from environment variables and never holds a pasted value; for an irreversible operation, give the checklist first and mark the request as not to be run until that exact operation is confirmed.

Contract facts (paths, headers, fields, codes, limits) come only from the bundled files (ground rule 1). General GST
background (what a return or an e-way bill is, who must file) may come from your own knowledge, or the web when the plugin has nothing on it, when you label it as
background rather than the WhiteBooks contract. Thresholds, deadlines, validity periods and amounts are contract facts: take them from the rules files, never from background. Point to `references/errors.md` for any error code not explained here.

## Ground rules

1. Use the WhiteBooks tools when the session has them (this version ships none). When it has none, read the bundled files in `references/` instead. Either way, never answer a contract fact (a path, header, parameter, error code or limit) from memory.
2. Never ask for, read, write or echo a credential, password or OTP. Never open `.env`. Configuration is read from environment variables by the code you scaffold, and the developer fills them in.
3. A credential pasted into chat is not written anywhere: not into a file, a command, a log, a test or a commit. Tell the developer to move it to their own secret store and to rotate it if it may have been exposed. Refer to a pasted value only as "the secret you pasted"; never repeat it, not even in quotes or in rotation advice.
4. The user's instructions win over this skill. If the developer asks for something different, do that, and say what you changed.
5. Keep reasoning about money, dates and identifiers in the references' terms: amounts are rupees as the API defines them, a GSTIN is 15 characters and is masked in anything you print.
6. Keep the plugin's internals out of replies and out of every file you write, even when asked: never name its files or folders (`SKILL.md`, `client-manifest.json`, `client-contract.md`, the `operations-<area>.json` files and the others, or the references and assets folders), operation ids such as `einvoice:GET:/einvoice/authenticate`, checklist ids such as CC-7, or section numbers of these files. Name the WhiteBooks endpoint by its method and path, and an error by its code. If asked where an answer comes from, say the WhiteBooks API specification and the NIC and GSTN documents. In replies, use plain words for the plugin's own terms: say the WhiteBooks client code (or client library); the shared part (configuration, sign-in sessions, error handling and status polling), not core; e-Invoice, e-Way Bill or GST returns, not area; set up or add, not scaffold; and never name an intent or a skill.
7. Look in this plugin before you search the web or browse for anything about WhiteBooks, GST returns, e-Invoice or
   e-Way Bill. Never take a contract fact (a path, header, parameter, request body, error code or limit) from a web
   search; if the bundled files do not have it, say so. A web result, like your own knowledge, may give general GST
   background only, labelled as background.


## Before the first session

Before any API session works, the taxpayer must enable API access for this GSP-ASP pair on the GST portal. Tell the developer
this before they run anything against live data.

- The taxpayer signs in to the GST portal and enables "Manage API Access" for the period they choose, from 6 hours to 30 days. The setting is per GSP-ASP pair, so a different provider needs its own consent.
- When the period ends, or the taxpayer revokes it, calls fail until the taxpayer enables it again and a new session is started. This is a user-actionable stop, not an error to retry.
- Secondary sources say the portal now notifies the taxpayer when an ASP is given access and lets them revoke it. The notification rule is reported, not confirmed; do not promise the taxpayer will or will not be notified.
- Sources: the GST portal at https://www.gst.gov.in (the taxpayer's own Manage API Access page). The official GSTN notice has not been found yet, so treat the wording above as reported.
- When this consent is missing or revoked the symbolic error is `GSTN_API_ACCESS_DISABLED`. Its entry is in `references/errors.md` (evidence `inferred`, because the real GSTN code is not yet transcribed).

## What you need first

A WhiteBooks account is needed only for the live calls of an integration. Reading the contracts, scaffolding the client and
writing code need no account: these files work without signing in. When the developer does run
calls, the sandbox base URL is the default and all sandbox calls use synthetic GSTINs, never a real taxpayer's.
Production is a separate base URL that the developer must set on purpose.

- Two credential layers exist: WhiteBooks API credentials (one client id and secret pair per area: `WB_GST_CLIENT_ID`/`WB_GST_CLIENT_SECRET`, `WB_EINV_CLIENT_ID`/`WB_EINV_CLIENT_SECRET`, `WB_EWB_CLIENT_ID`/`WB_EWB_CLIENT_SECRET`, plus the shared `WB_EMAIL`) and the credentials of the upstream system (the GST portal user and OTP for returns; the NIC user and password for e-Invoice and e-Way Bill). `references/auth-flows.md` draws all three flows.
- The first harmless call is the public GSTIN search, `/public/search` (not `/gst/public/search`, which the docs wrongly show; see `references/discrepancies.md`). The GST area's smoke test makes this call.
- Where the public docs and reality disagree, trust `references/discrepancies.md` and the operation contracts.

## Scaffold the core

Do this once per project. The client is generated, tested code; you copy it and adapt only its package declarations and imports.

1. Detect the host, then the project. If you cannot read or write the project files (a chat such as ChatGPT, or no project is open), say so, ask the language and build tool, and give each file inline with the path it belongs at instead of writing it; the developer copies them, and you give the build and test commands instead of running them. Otherwise look for `pom.xml` or `build.gradle` / `build.gradle.kts` (Java), `package.json` with a lock file (`package-lock.json`, `pnpm-lock.yaml` or `yarn.lock`, which tells you npm, pnpm or yarn) for TypeScript, and `pyproject.toml`, `requirements.txt`, a poetry or `uv` lock for Python. If several are present, ask which one the WhiteBooks code belongs to. If none, ask the language and offer to create a minimal project, or go to "Other languages".
2. Ask which areas the developer needs now (GST returns, e-Invoice, e-Way Bill, any mix). The core always comes; the areas come from the area skills later.
3. Choose the package path. TypeScript: a folder such as `src/whitebooks/`. Python: a package such as `whitebooks/` beside the code that uses it. Java: the package path under `src/main/java` (for example the project's base package plus `.whitebooks`). Follow the project's existing layout and name, and tell the developer the path you chose before copying.
4. Copy the files from `assets/client/<lang>/` where `<lang>` is `typescript`, `python` or `java`. The core is the `whitebooks/` folder beside `test/` (`tests/` in Python). Copy each file whole. Change only package declarations and imports: the Java `package` line, TypeScript relative import paths, Python import roots. Do not reformat, rename or "improve" anything else, because the upgrade step compares against the original.
5. The core is self-contained, so there is no barrel to trim. TypeScript `whitebooks/index.ts` exports core files only and each area has its own barrel (`whitebooks/<area>/index.ts`, which the area skill brings), so there is nothing to delete. Python `__init__.py` is only a package marker and Java has no barrel. Nothing in the core imports an area file, so it compiles with no area present.
6. Run the core tests as copied. The error and session tests (TypeScript `test/errors.test.ts` and `test/session.test.ts`, Python `tests/test_errors.py` and `tests/test_session.py`, Java `KitTest`) build their calls inline and import no area file, so they pass with the core alone. The sandbox smoke tests are per area: each area skill brings its own (`smoke.<area>`), and the shared sandbox gate (`test/support.ts`, `tests/smoke_support.py`, `KitSupport.java`) is part of the core. Do not edit a test, and do not claim the suite is green until you have run it.
7. Propose the two dependencies the client needs, with the exact version it was tested with (it is in `client-manifest.json` under `dependencies` and in the file headers): Java needs Jackson, `com.fasterxml.jackson.core:jackson-databind` 2.22.3; Python `requests` 2.32.5; TypeScript needs none (Node 20 or newer). Add them to the dependency file you found in step 1 (`pom.xml`, `build.gradle` or `build.gradle.kts`, `requirements.txt` or `pyproject.toml`), show the line you would add, and add it only after the developer agrees. Propose exactly these versions (the exact version, never a range, and never a version the developer has not seen); if the project already pins a different version, say so and ask.
8. Never overwrite an existing file without first showing a diff. If a target file already exists, show the difference, ask, and write only what the developer approves. A new file needs no diff, but list it.
9. Write `.env.example` with placeholder names only, never values: `WB_BASE_URL` (commented out; sandbox is the default), `WB_GST_CLIENT_ID`, `WB_GST_CLIENT_SECRET`, `WB_EINV_CLIENT_ID`, `WB_EINV_CLIENT_SECRET`, `WB_EWB_CLIENT_ID`, `WB_EWB_CLIENT_SECRET`, `WB_EMAIL`, `WB_IP_ADDRESS`, `WB_GST_GSTIN`, `WB_GST_USERNAME`, `WB_EINV_GSTIN`, `WB_EINV_NIC_USERNAME`, `WB_EINV_NIC_PASSWORD`, `WB_EWB_GSTIN`, `WB_EWB_NIC_USERNAME`, `WB_EWB_NIC_PASSWORD`. Each line has the form `NAME=<placeholder>` (for example `WB_GST_CLIENT_SECRET=<your-gst-client-secret>`). Check that the project's ignore file already keeps local environment files out of version control, and tell the developer if it does not. Do not create or fill a real environment file; the developer does that.
10. Run the project's own build and the client's tests (the commands are in each client file header). Report the last lines of the output. If a test fails because of your edits, fix the edit; if it fails in unchanged client code, stop and report it.
11. Tell the developer what remains: fill the environment variables, register one IP address (`WB_IP_ADDRESS`; one per session, see `integration-hardening`), enable consent (see "Before the first session"), then add the areas with their skills.

`references/client-contract.md` is the readable description of everything the core does. Explain from it when the developer asks why, in plain words (ground rule 6).

## Upgrade the client

A client file begins with a header line of the form `WhiteBooks client <version> | spec_as_of <date> | template <lang> | area <area>`,
where the area is `core`, `gst`, `einvoice` or `ewaybill`. Recognise a client file by the fields `| spec_as_of <date> | template <lang> |` on that
first line, whatever the words before the version: files from before 1.0.7 start with another product word, and files before 1.0.4 end the line
with `| skill <skill>` instead of the area. All of these are client files. Upgrading writes the current form. Upgrading never changes anything by itself.

1. Find the installed client files by their header and read the client version and spec date from each. A file with no header, or a model-authored header, is not from a client and is left alone.
2. Compare with the version in this skill's `client-manifest.json` (`client_version`, `spec_as_of`). If they are equal, say the client is current and stop. If the installed client has a newer major version than the plugin, stop and tell the developer to update the plugin first.
3. For each installed file, render the new version from `assets/client/<lang>/` with the same package declarations and imports the developer's copy uses (step 4 of "Scaffold the core"), then compute a diff against the installed file.
4. Decide whether a file was edited by hand. The manifest lists the sha256 of every original file. Compute the sha256 of the installed file after reversing your package and import changes; if it differs from the manifest, the developer edited it. List edited files separately from untouched ones and show their diffs on their own, because a plain overwrite would lose the edits.
5. Show the diffs, grouped as: new files, changed untouched files, changed edited files, files removed from the client. Add the area skills' files the same way, each from its own manifest.
6. Nothing is written until the developer agrees, file by file or in groups. For an edited file offer to apply the client change and keep their lines, and do the merge only when they confirm it.
7. After writing, run the build and tests again and report the last lines. Mention any change to the client contract version, because it can change behaviour your integration code relies on.

## Other languages

When the developer's language is not TypeScript, Python or Java, there is no client to copy. Write the client from
`references/client-contract.md` and the operation contracts (`operations-<area>.json` in each area skill, an index that names the tag file holding each full contract) and say clearly
that it is model-written. Any language works: a compiled or a scripting one, with its own HTTP and JSON libraries.

1. Read `references/client-contract.md` fully, then `references/headers.md`, `references/errors.md` and the area's operation index, then the tag file it names, for the operations the developer needs.
2. Write the same layers as the clients: configuration, session, error parsing, retry helper for reads, polling, reconcile helper for writes, then one function per operation with the irreversible guard of the contract's "Irreversible operations" section.
3. Start every file with the model-authored header from the "Model-authored files" section of the contract, in the file's comment syntax, with the client version, the spec date and the language:

```
WhiteBooks client <version> | spec_as_of <date> | template model-authored (<language>) | area <area>
Generated by the model from client contract version 2. Edit freely.
Not compile-tested by WhiteBooks; check it against the WhiteBooks client contract
```

4. Work through the conformance checklist at the end of the contract (CC-1 to CC-19) item by item and report which items the code meets, naming each by its plain name, never by its CC number.
5. Write a test that replays `references/conformance-vectors.json` against the helpers you wrote: every error-parsing case (the typed error's source, code, unknown flag and, where given, message, and whether it counts as an expired session), every GSTIN mask, every return-processed reply, and the retry delay of each attempt within its range. All of them must pass; a failing case means the code is wrong, not the vector. This is the check that the client behaves like the ready-made ones.
6. Write a smoke test that makes the public search call, the way the clients' smoke tests do, and a unit test for each helper. Run them. Report that the client is not compile-tested by WhiteBooks, that the conformance vectors passed, and that the client contract version it follows is 2.

## Before any irreversible step

Some operations cannot be undone upstream: filing a return, cancelling an IRN or an e-way bill, rejecting, closing.
The clients mark 53 of them and refuse to run them unless the caller confirms. Before you write or run code that
calls one:

- [ ] Name the operation and the exact document: GSTIN (masked), return period or IRN or e-way bill number.
- [ ] Say in one sentence what cannot be undone.
- [ ] Ask the user to confirm that operation on that document, and wait for a clear yes in this conversation.
- [ ] Only then pass the guard: `{ confirmIrreversible: true }` in TypeScript, `confirm_irreversible=True` in Python, `WriteOptions.confirmed()` or `opts.confirm()` in Java.

The guard is passed only after the user has confirmed that exact operation. A general "go ahead" earlier in the
conversation, or a confirmation of a different document, does not count. Never default the guard on in a helper.

## Common errors

| Error or code | Meaning | What to do |
|---|---|---|
| `GSTN_API_ACCESS_DISABLED` | The taxpayer has not enabled, or has revoked, Manage API Access for this GSP-ASP pair | Stop. Ask the taxpayer to enable it on the GST portal, then start a new session |
| `IRREVERSIBLE_NOT_CONFIRMED` | The guard stopped an irreversible call; nothing was sent | Get the user's confirmation of that exact operation, then pass the guard |
| `MISSING_TXN`, `MISSING_TOKEN` | The sign-in reply held no `txn` or `AuthToken` | Check the credentials layer in `references/auth-flows.md`; do not loop |
| `TIMEOUT`, `NETWORK`, `WRITE_OUTCOME_UNKNOWN` | The outcome is unknown | Never treat as success or resend blindly; follow the reconcile loop in `integration-hardening` |
| anything else | Look up the code | Use `lookup_error` when the tools are available; otherwise search `references/errors.md` |

## Sandbox

This section applies only when WhiteBooks sandbox tools (names starting with `sandbox_`; this version ships none) are available in the
session. With them you may run the developer's chosen read operations against the sandbox with synthetic GSTINs, one call
at a time, and show the real reply; writes and irreversible operations still need the checklist above. Without those
tools, do not pretend to have run anything: tell the developer to run the client's smoke test with their own sandbox
credentials, and read the expected shapes from `references/` and the operation files.
