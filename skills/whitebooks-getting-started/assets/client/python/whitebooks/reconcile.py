# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none (uses .errors).

from __future__ import annotations

import time
from dataclasses import dataclass
from typing import Any, Callable, Optional

from .errors import WhiteBooksError, find_key


def require_irreversible_confirmed(operation: str, confirmed: bool) -> None:
    """Refuse, before any network call, to send an irreversible operation the caller has not explicitly confirmed."""
    if confirmed is not True:
        raise WhiteBooksError(
            "client",
            "IRREVERSIBLE_NOT_CONFIRMED",
            "%s cannot be undone; pass confirm_irreversible=True only after the user has confirmed this exact operation" % operation,
        )


DEFAULT_RECONCILE_INTERVAL_MS = 600_000
DEFAULT_MAX_ATTEMPTS = 3


@dataclass
class WriteOptions:
    """Options of a write. Pass reconcile (the status operation arguments) so an unknown outcome can be checked."""

    # Arguments of the status operation that tells whether the write landed. Without them an unknown outcome is never repeated.
    reconcile: Any = None
    # True when a status reply proves the write landed. A reply that does not satisfy it leaves the outcome unknown (no landed
    # report, no resend). Defaults: e-Invoice a reply with Irn; e-Way Bill a reply with ewayBillNo or ewbNo. GST has no default.
    landed: Optional[Callable[[Any], bool]] = None
    # Minimum wait before each status check and between writes. Default 10 minutes.
    min_interval_ms: int = DEFAULT_RECONCILE_INTERVAL_MS
    # Writes and status checks together; default 3.
    max_attempts: int = DEFAULT_MAX_ATTEMPTS
    # Called with seconds to wait; tests replace it.
    sleep: Optional[Callable[[float], None]] = None


@dataclass
class Policy:
    landed: Optional[Callable[[Any], bool]] = None
    # The NIC error code that positively says the document does not exist. Only this code allows a resend.
    not_found_code: Optional[str] = None


def is_return_processed(response: Any) -> bool:
    """Whether a retstatus reply says the return was processed: data.status_cd is P or PE. Pass it as opts.landed together with
    opts.reconcile when the refid came from the save response of THIS return. GSTR-1 retsave answers with data.reference_id only when it
    returns; if it times out there is no data.reference_id, retstatus cannot be asked about it, and the write ends in WRITE_OUTCOME_UNKNOWN.
    A refid the caller held from an earlier save is stale and proves nothing about this one, which is why GST reconciles only
    when opts.landed is given."""
    data = find_key(response, "data")
    return find_key(data if isinstance(data, dict) else response, "status_cd") in ("P", "PE")


def has_irn(response: Any) -> bool:
    return isinstance(find_key(response, "Irn"), str)


def has_eway_bill_no(response: Any) -> bool:
    number = find_key(response, "ewayBillNo") or find_key(response, "ewbNo")
    return isinstance(number, (str, int))


def reconcile_write(write: Callable[[], Any], check: Optional[Callable[[], Any]], opts: WriteOptions, policy: Policy) -> Any:
    """Send the write once. If the outcome is unknown, wait min_interval_ms, ask the status operation, and treat the write
    as landed only when opts.landed (or the API default) says the reply proves it. A status call that succeeds without proof, or
    fails for any reason (429, 401, session expiry, a bad argument, a 5xx), leaves the outcome unknown and never causes a resend.
    Only the policy's not-found code (e-Invoice 2154) proves nothing landed and allows a resend, at least min_interval_ms after
    the previous try, up to max_attempts. e-Way Bill and GST document no not-found code, so they never resend. Without a status
    check the unknown outcome ends in WRITE_OUTCOME_UNKNOWN."""
    wait = opts.sleep or time.sleep
    landed = opts.landed or policy.landed
    if check is None or landed is None:
        try:
            return write()
        except WhiteBooksError as err:
            if err.unknown:
                raise WhiteBooksError("client", "WRITE_OUTCOME_UNKNOWN", "the write did not complete; its outcome is unknown", unknown=True) from err
            raise
    needs_write = True
    not_found = False
    for _ in range(opts.max_attempts):
        if needs_write:
            try:
                return write()
            except WhiteBooksError as err:
                if not err.unknown:
                    raise
        wait(opts.min_interval_ms / 1000.0)
        try:
            response = check()
            if landed(response):
                return response
            needs_write = False
            not_found = False
        except WhiteBooksError as err:
            not_found = policy.not_found_code is not None and err.source == "nic" and err.code == policy.not_found_code
            needs_write = not_found
    raise WhiteBooksError(
        "client",
        "WRITE_NOT_LANDED" if not_found else "WRITE_OUTCOME_UNKNOWN",
        "the write did not complete after %d attempts%s" % (opts.max_attempts, "" if not_found else "; its outcome is unknown"),
        unknown=not not_found,
    )
