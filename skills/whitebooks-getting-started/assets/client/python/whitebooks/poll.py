# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none (uses .errors).

from __future__ import annotations

import time
from typing import Any, Callable, Optional

from .errors import WhiteBooksError, find_key


def _default_is_done(response: Any) -> bool:
    data = find_key(response, "data")
    return find_key(data if isinstance(data, dict) else response, "status_cd") in ("P", "PE", "ER")


def wait_for_status(
    fetch_status: Callable[[], Any],
    deadline_ms: int = 120_000,
    interval_ms: int = 5_000,
    max_interval_ms: int = 20_000,
    is_done: Optional[Callable[[Any], bool]] = None,
    sleep: Optional[Callable[[float], None]] = None,
) -> Any:
    """Call fetch_status (which asks the status operation about the reference_id of the saved return) until the answer is final or the deadline passes.
    The default is_done reads data.status_cd, then the top level, and accepts P, PE or ER. The pause starts at interval_ms and doubles up to max_interval_ms.
    """
    done = is_done or _default_is_done
    wait = sleep or time.sleep
    started = time.monotonic()
    interval = interval_ms
    while True:
        response = fetch_status()
        if done(response):
            return response
        if (time.monotonic() - started) * 1000 + interval > deadline_ms:
            raise WhiteBooksError(
                "client", "POLL_DEADLINE", "status still not final after %d ms" % deadline_ms, unknown=True
            )
        wait(interval / 1000.0)
        interval = min(interval * 2, max_interval_ms)
