# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none (Python 3.10+ standard library only).

from __future__ import annotations

import json
import re
from typing import Any, Optional


class WhiteBooksError(Exception):
    """A typed error. source is one of whitebooks, gstn, nic, upstream, http, client.

    unknown is True when the call may or may not have taken effect (timeout, network failure, 5xx).
    Unknown is never success."""

    def __init__(
        self,
        source: str,
        code: str,
        message: str,
        http_status: Optional[int] = None,
        unknown: bool = False,
        correlation_id: Optional[str] = None,
    ) -> None:
        super().__init__(message)
        self.source = source
        self.code = code
        self.message = message
        self.http_status = http_status
        self.unknown = unknown
        self.correlation_id = correlation_id


def find_key(value: Any, key: str, depth: int = 4) -> Any:
    """Find the first value stored under key in a parsed JSON value, searching a few levels deep."""
    if depth < 0:
        return None
    if isinstance(value, list):
        for item in value:
            hit = find_key(item, key, depth - 1)
            if hit is not None:
                return hit
        return None
    if isinstance(value, dict):
        if key in value:
            return value[key]
        for inner in value.values():
            hit = find_key(inner, key, depth - 1)
            if hit is not None:
                return hit
    return None


def _text(value: Any) -> str:
    if isinstance(value, str):
        return value
    if isinstance(value, (int, float)) and not isinstance(value, bool):
        return str(value)
    return ""


def parse_failure(http_status: int, body: str) -> Optional[WhiteBooksError]:
    """Turn a response into a typed error, or None for a success.

    Handles the WhiteBooks envelope (status_cd 0 plus status_desc WB_ERR_xxxx : ...), GSTN error.error_cd and NIC ErrorDetails.
    """
    server_side = http_status >= 500
    try:
        parsed = json.loads(body) if body else None
    except ValueError:
        if http_status >= 400:
            return WhiteBooksError("http", "HTTP_%d" % http_status, body[:200], http_status, server_side)
        return WhiteBooksError("client", "BAD_RESPONSE", "response is not JSON", http_status, True)
    status_cd = find_key(parsed, "status_cd")
    status_desc = _text(find_key(parsed, "status_desc"))
    wb = re.search(r"(WB_ERR_\d+)\s*:?\s*(.*)", status_desc)
    if wb:
        code = wb.group(1)
        return WhiteBooksError("whitebooks", code, status_desc, http_status, server_side or code == "WB_ERR_9000")
    gstn = find_key(parsed, "error")
    error_cd = _text(find_key(gstn, "error_cd")) if isinstance(gstn, dict) else ""
    if error_cd != "":
        return WhiteBooksError("gstn", error_cd, _text(find_key(gstn, "message")) or status_desc, http_status, server_side)
    details = find_key(parsed, "ErrorDetails")
    if isinstance(details, list) and details:
        messages = [m for m in (_text(find_key(d, "ErrorMessage")) for d in details) if m]
        code = _text(find_key(details[0], "ErrorCode")) or "NIC_ERROR"
        return WhiteBooksError("nic", code, "; ".join(messages), http_status, server_side)
    if status_cd in ("0", 0) or http_status >= 400:
        code = "HTTP_%d" % http_status if http_status >= 400 else "UPSTREAM_ERROR"
        return WhiteBooksError("upstream", code, status_desc or body[:200], http_status, server_side)
    return None


def is_session_expired(err: BaseException) -> bool:
    """True for errors that mean the session token is no longer valid and the caller should authenticate again."""
    if not isinstance(err, WhiteBooksError):
        return False
    return err.code == "1005" or re.search(r"(session|token).*(expired|invalid)|expired", err.message, re.I) is not None
