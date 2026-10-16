# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area gst
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none beyond session.py's requests (uses ..config, ..errors, ..session and ..reconcile).

from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Optional

from ..config import Config, require_area, state_code
from ..session import Call, send, with_retries


@dataclass
class PublicPrefArgs:
    """Arguments of GET /public/pref."""

    gstin: str  # query gstin
    fy: str  # query fy


def public_pref(config: Config, args: PublicPrefArgs) -> Any:
    """Get Preference
    GET /public/pref
    Public: no session is needed.
    """
    require_area(config, "public")

    def build() -> Call:
        return Call(
            method="GET",
            path="/public/pref",
            query={
                "gstin": args.gstin,
                "fy": args.fy,
                "email": config.email,
            },
            headers={
                "state_cd": state_code(config.gst_gstin),
                "ip_address": config.ip_address,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: send(config, build()))


@dataclass
class PublicRettrackArgs:
    """Arguments of GET /public/rettrack."""

    gstin: str  # query gstin
    fy: str  # query fy
    type: Optional[str] = None  # query type


def public_rettrack(config: Config, args: PublicRettrackArgs) -> Any:
    """View and Track Returns
    GET /public/rettrack
    Public: no session is needed.
    """
    require_area(config, "public")

    def build() -> Call:
        return Call(
            method="GET",
            path="/public/rettrack",
            query={
                "gstin": args.gstin,
                "fy": args.fy,
                "type": args.type,
                "email": config.email,
            },
            headers={
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: send(config, build()))


@dataclass
class PublicSearchArgs:
    """Arguments of GET /public/search."""

    gstin: str  # query gstin


def public_search(config: Config, args: PublicSearchArgs) -> Any:
    """Search Taxpayer
    GET /public/search
    Public: no session is needed.
    """
    require_area(config, "public")

    def build() -> Call:
        return Call(
            method="GET",
            path="/public/search",
            query={
                "email": config.email,
                "gstin": args.gstin,
            },
            headers={
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: send(config, build()))


@dataclass
class PublicUnregisteredApplicantsArgs:
    """Arguments of GET /public/unregistered-applicants."""

    uid: str  # query uid


def public_unregistered_applicants(config: Config, args: PublicUnregisteredApplicantsArgs) -> Any:
    """Unregistered Applicants API
    GET /public/unregistered-applicants
    Public: no session is needed.
    """
    require_area(config, "public")

    def build() -> Call:
        return Call(
            method="GET",
            path="/public/unregistered-applicants",
            query={
                "uid": args.uid,
                "email": config.email,
            },
            headers={
                "ip_address": config.ip_address,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: send(config, build()))


@dataclass
class PublicUnregisteredApplicantsValidationArgs:
    """Arguments of GET /public/unregistered-applicants-validation."""

    uid: str  # query uid
    ecom_email: Optional[str] = None  # query ecomEmail
    mobile: Optional[str] = None  # query mobile


def public_unregistered_applicants_validation(config: Config, args: PublicUnregisteredApplicantsValidationArgs) -> Any:
    """Unregistered Applicants Validation
    GET /public/unregistered-applicants-validation
    Public: no session is needed.
    """
    require_area(config, "public")

    def build() -> Call:
        return Call(
            method="GET",
            path="/public/unregistered-applicants-validation",
            query={
                "uid": args.uid,
                "ecomEmail": args.ecom_email,
                "mobile": args.mobile,
                "email": config.email,
            },
            headers={
                "ip_address": config.ip_address,
                "client_id": config.gst_client_id,
                "client_secret": config.gst_client_secret,
            },
        )
    return with_retries(lambda: send(config, build()))
