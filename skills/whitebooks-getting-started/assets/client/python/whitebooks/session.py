# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: requests==2.32.5; Python 3.10+ standard library.

from __future__ import annotations

import json
import logging
import random
import threading
import time
import uuid
from dataclasses import dataclass
from typing import Any, Callable, Dict, Optional, TypeVar

import requests

from .config import SANDBOX_URL, Config, require_area, state_code
from .errors import WhiteBooksError, find_key, is_session_expired, parse_failure

T = TypeVar("T")
_log = logging.getLogger("whitebooks")


@dataclass
class Call:
    """One HTTP request: method, path, query parameters, headers and an optional JSON body."""

    method: str
    path: str
    query: Dict[str, Optional[str]]
    headers: Dict[str, Optional[str]]
    body: Any = None


def mask_gstin(gstin: str) -> str:
    """GSTIN shown as its two-digit state code, asterisks and the last character, so logs carry no full GSTIN."""
    if len(gstin) < 4:
        return "***"
    return gstin[:2] + "*" * (len(gstin) - 3) + gstin[-1]


def send(config: Config, call: Call) -> Any:
    """One HTTP exchange with a deadline. Errors are typed; a timeout or network failure is unknown, never success."""
    url = config.base_url.rstrip("/") + call.path
    params = {k: v for k, v in call.query.items() if v is not None}
    headers = {"accept": "application/json"}
    headers.update({k: v for k, v in call.headers.items() if v is not None})
    data = None
    if call.body is not None:
        data = json.dumps(call.body)
        headers["content-type"] = "application/json"
    correlation_id = str(uuid.uuid4())
    _log.info(json.dumps({"event": "request", "correlationId": correlation_id, "method": call.method, "path": call.path, **({"gstin": mask_gstin(call.headers["gstin"])} if call.headers.get("gstin") else {})}))
    try:
        response = requests.request(call.method, url, params=params, headers=headers, data=data, timeout=config.timeout_s)
    except requests.Timeout:
        raise WhiteBooksError(
            "client", "TIMEOUT", "request timed out after %s s" % config.timeout_s, unknown=True, correlation_id=correlation_id
        ) from None
    except requests.RequestException:
        raise WhiteBooksError("client", "NETWORK", "network failure", unknown=True, correlation_id=correlation_id) from None
    _log.info(json.dumps({"event": "response", "correlationId": correlation_id, "path": call.path, "status": response.status_code, **({"gstin": mask_gstin(call.headers["gstin"])} if call.headers.get("gstin") else {})}))
    failure = parse_failure(response.status_code, response.text)
    if failure is not None:
        failure.correlation_id = correlation_id
        raise failure
    return json.loads(response.text) if response.text else None


def is_retryable(err: BaseException) -> bool:
    """Errors worth another try for a read: unknown outcomes and throttling."""
    return isinstance(err, WhiteBooksError) and (err.unknown or err.http_status == 429)


def backoff_ms(attempt: int) -> int:
    """Capped jittered backoff: ceiling 0.5 s, 1 s, 2 s, then 4 s, with half of it random."""
    ceiling = min(4000, 500 * 2 ** (attempt - 1))
    return int(ceiling / 2 + random.random() * (ceiling / 2))


def with_retries(run: Callable[[], T], max_attempts: int = 3) -> T:
    """Retry a GET (idempotent) up to 3 attempts. Never use this for a write: writes go through reconcile_write."""
    attempt = 1
    while True:
        try:
            return run()
        except WhiteBooksError as err:
            if attempt >= max_attempts or not is_retryable(err):
                raise
            time.sleep(backoff_ms(attempt) / 1000.0)
            attempt += 1


# Refresh or re-authenticate when the session is within 5 minutes of expiry.
REFRESH_MARGIN_S = 5 * 60
# The spec does not document the token lifetime; sessions assume 6 hours (1 hour for the e-Invoice sandbox) unless lifetime_s says otherwise.
DEFAULT_LIFETIME_S = 6 * 60 * 60
# WhiteBooks' published e-Invoice API flow: a token lasts 1 hour in the sandbox, 6 hours in production.
SANDBOX_LIFETIME_S = 60 * 60


def _einvoice_lifetime_s(config: Config) -> float:
    trim = lambda url: url.strip().rstrip("/").lower()
    return SANDBOX_LIFETIME_S if trim(config.base_url) == trim(SANDBOX_URL) else DEFAULT_LIFETIME_S


def _text_of(value: Any) -> str:
    return value if isinstance(value, str) else ""


class GstSession:
    """GST session: request_otp() sends an OTP to the taxpayer, authenticate(otp) exchanges the OTP the end user types
    into your own UI for a session, refresh() renews it, logout() ends it. Never hard-code or store an OTP.
    """

    def __init__(self, config: Config, lifetime_s: float = DEFAULT_LIFETIME_S) -> None:
        require_area(config, "gst")
        self.config = config
        # Bound once for the life of this session and sent on every call.
        self.ip_address = config.ip_address
        self.txn = ""
        self._expires_at = 0.0
        self._lifetime_s = lifetime_s
        self._lock = threading.Lock()

    def _take(self, result: Any) -> None:
        txn = _text_of(find_key(result, "txn"))
        if txn != "":
            self.txn = txn

    def request_otp(self) -> None:
        """Ask GSTN to send an OTP to the taxpayer. Keeps the transaction id the next calls need."""
        config = self.config
        result = send(config, Call(
            method="GET",
            path="/authentication/otprequest",
            query={
                "email": config.email,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": config.ip_address,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        ))
        self._take(result)
        if self.txn == "":
            raise WhiteBooksError("client", "MISSING_TXN", "the OTP response carried no txn")

    def authenticate(self, otp: str) -> None:
        """Exchange the OTP the end user entered for a session."""
        config = self.config
        result = send(config, Call(
            method="GET",
            path="/authentication/authtoken",
            query={
                "email": config.email,
                "otp": otp,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": config.ip_address,
                "txn": self.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        ))
        self._take(result)
        self._expires_at = time.monotonic() + self._lifetime_s

    def refresh(self) -> None:
        """Renew the session before it expires."""
        config = self.config
        result = send(config, Call(
            method="GET",
            path="/authentication/refreshtoken",
            query={
                "email": config.email,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": config.ip_address,
                "txn": self.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        ))
        self._take(result)
        self._expires_at = time.monotonic() + self._lifetime_s

    def logout(self) -> None:
        config = self.config
        send(config, Call(
            method="GET",
            path="/authentication/logout",
            query={
                "email": config.email,
            },
            headers={
                "gst_username": config.gst_username,
                "state_cd": state_code(config.gst_gstin),
                "ip_address": config.ip_address,
                "txn": self.txn,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        ))
        self._expires_at = 0.0
        self.txn = ""

    def call(self, build: Callable[[], Call]) -> Any:
        """Run one call on this session, refreshing it first when it is within 5 minutes of expiry."""
        with self._lock:
            if self._expires_at == 0.0:
                raise WhiteBooksError("client", "NOT_AUTHENTICATED", "call request_otp() and authenticate(otp) first")
            if self._expires_at - time.monotonic() <= REFRESH_MARGIN_S:
                self.refresh()
        return send(self.config, build())


class EinvoiceSession:
    """e-Invoice session: authenticate() signs in with the NIC user name and password from the environment.
    The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
    """

    def __init__(self, config: Config, lifetime_s: Optional[float] = None) -> None:
        require_area(config, "einvoice")
        self.config = config
        # Bound once for the life of this session and sent on every call.
        self.ip_address = config.ip_address
        self.auth_token = ""
        self._expires_at = 0.0
        self._lifetime_s = lifetime_s if lifetime_s is not None else _einvoice_lifetime_s(config)
        self._lock = threading.Lock()

    def authenticate(self) -> None:
        """Sign in. Concurrent callers take turns, so only one sign-in runs at a time."""
        with self._lock:
            self._sign_in()

    def _sign_in(self) -> None:
        config = self.config
        result = send(config, Call(
            method="GET",
            path="/einvoice/authenticate",
            query={
                "email": config.email,
            },
            headers={
                "username": config.einv_nic_username,
                "password": config.einv_nic_password,
                "ip_address": config.ip_address,
                "client_id": config.einv_client_id,
                "client_secret": config.einv_client_secret,
                "gstin": config.einv_gstin,
            },
        ))
        token = _text_of(find_key(result, "AuthToken"))
        if token == "":
            raise WhiteBooksError("client", "MISSING_TOKEN", "the sign-in response carried no AuthToken")
        self.auth_token = token
        self._expires_at = time.monotonic() + self._lifetime_s

    def _ensure(self) -> None:
        with self._lock:
            if self._expires_at - time.monotonic() <= REFRESH_MARGIN_S:
                self._sign_in()

    def call(self, build: Callable[[], Call]) -> Any:
        """Run one call on this session; sign in first when needed and once more if the API says the session expired."""
        self._ensure()
        try:
            return send(self.config, build())
        except WhiteBooksError as err:
            if not is_session_expired(err):
                raise
            self.authenticate()
            return send(self.config, build())


class EwaybillSession:
    """e-Way Bill session: authenticate() signs in with the NIC user name and password from the environment.
    The session signs in again by itself when it is within 5 minutes of expiry or the API reports it expired.
    """

    def __init__(self, config: Config, lifetime_s: Optional[float] = None) -> None:
        require_area(config, "ewaybill")
        self.config = config
        # Bound once for the life of this session and sent on every call.
        self.ip_address = config.ip_address
        self._expires_at = 0.0
        self._lifetime_s = lifetime_s if lifetime_s is not None else DEFAULT_LIFETIME_S
        self._lock = threading.Lock()

    def authenticate(self) -> None:
        """Sign in. Concurrent callers take turns, so only one sign-in runs at a time."""
        with self._lock:
            self._sign_in()

    def _sign_in(self) -> None:
        config = self.config
        send(config, Call(
            method="GET",
            path="/ewaybillapi/v1.03/authenticate",
            query={
                "email": config.email,
                "username": config.ewb_nic_username,
                "password": config.ewb_nic_password,
            },
            headers={
                "ip_address": config.ip_address,
                "client_id": config.ewb_client_id,
                "client_secret": config.ewb_client_secret,
                "gstin": config.ewb_gstin,
            },
        ))
        self._expires_at = time.monotonic() + self._lifetime_s

    def _ensure(self) -> None:
        with self._lock:
            if self._expires_at - time.monotonic() <= REFRESH_MARGIN_S:
                self._sign_in()

    def call(self, build: Callable[[], Call]) -> Any:
        """Run one call on this session; sign in first when needed and once more if the API says the session expired."""
        self._ensure()
        try:
            return send(self.config, build())
        except WhiteBooksError as err:
            if not is_session_expired(err):
                raise
            self.authenticate()
            return send(self.config, build())
