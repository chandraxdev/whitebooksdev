# WhiteBooks Developer

The WhiteBooks developer plugin for GST returns, e-Invoice and e-Way Bill integrations. Version 1.0.8.

It answers questions about the WhiteBooks APIs for GST returns, e-Invoice and e-Way Bill, and writes code for them: endpoints, request bodies, headers and error codes explained, a sample request in curl or any language, and ready-made client code in Java, TypeScript and Python to add to an existing app. Ask in plain words, for example "What does e-Invoice error 2150 mean?" or "Add GSTR-1 filing to my accounting app using WhiteBooks".

## What it runs and sends

Nothing. The plugin is instructions and reference files for your assistant only: it has no server, makes no network calls and collects no data, and it starts no process. It carries no credentials and never asks you to paste one. The code it writes for you calls WhiteBooks from your own server with your own WhiteBooks credentials, read from environment variables; start on the WhiteBooks sandbox. Get credentials and support from WhiteBooks at https://whitebooks.in/.

## Install

**Claude Code**

```
claude plugin marketplace add chandraxdev/whitebooksdev
claude plugin install whitebooks-developer@whitebooks
```

**Gemini CLI**

```
gemini extensions install https://github.com/chandraxdev/whitebooksdev
```

**ChatGPT**: add WhiteBooks Developer from the ChatGPT plugin directory once it is listed there; until then WhiteBooks provides the plugin as a zip to upload.

**Cursor and VS Code with GitHub Copilot**: this repository holds their manifests (`.cursor-plugin/plugin.json` and `plugin.json`); ask WhiteBooks for the supported install route for your version.

## Any programming language

Beyond the ready-made Java, TypeScript and Python client code, the `openapi/` folder holds an OpenAPI 3.1 document for every group of operations (`openapi/gst/`, `openapi/einvoice/`, `openapi/ewaybill/`), so a team can run the generator of its choice for Go, C#, PHP, Ruby or any other language. The plugin also carries language-neutral test vectors: when you ask the assistant for a client in your language, it writes it from the client contract and checks it against them.

## Licence

Apache License 2.0, Copyright 2026 BVM IT Consulting Services Pvt. Ltd. See `LICENSE` and `NOTICE`.
