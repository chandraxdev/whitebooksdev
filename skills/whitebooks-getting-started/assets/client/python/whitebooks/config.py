# WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template python | area core
# Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
# SPDX-License-Identifier: Apache-2.0
# Copyright 2026 BVM IT Consulting Services Pvt. Ltd
# Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
# Dependencies: none (Python 3.10+ standard library only).

from __future__ import annotations

import os
from dataclasses import dataclass
from typing import Dict, List, Mapping, Optional, Tuple

SANDBOX_URL = "https://apisandbox.whitebooks.in"
PRODUCTION_URL = "https://api.whitebooks.in"


class ConfigError(Exception):
    """A required environment variable is missing for the area being used."""


@dataclass(frozen=True)
class Config:
    """Settings read from the environment. base_url defaults to the sandbox; use PRODUCTION_URL only for live traffic."""

    base_url: str
    gst_client_id: str
    gst_client_secret: str
    einv_client_id: str
    einv_client_secret: str
    ewb_client_id: str
    ewb_client_secret: str
    email: str
    gst_gstin: str
    einv_gstin: str
    ewb_gstin: str
    ip_address: str
    gst_username: str
    einv_nic_username: str
    einv_nic_password: str
    ewb_nic_username: str
    ewb_nic_password: str
    timeout_s: float = 30.0


def load_config(env: Optional[Mapping[str, str]] = None) -> Config:
    """Read the configuration from environment variables; every secret comes from the environment, never from source.

    Nothing is checked here: require_area runs when a session is created or a public operation is called."""
    source = os.environ if env is None else env
    return Config(
        base_url=(source.get("WB_BASE_URL") or "").strip() or SANDBOX_URL,
        gst_client_id=source.get("WB_GST_CLIENT_ID", ""),
        gst_client_secret=source.get("WB_GST_CLIENT_SECRET", ""),
        einv_client_id=source.get("WB_EINV_CLIENT_ID", ""),
        einv_client_secret=source.get("WB_EINV_CLIENT_SECRET", ""),
        ewb_client_id=source.get("WB_EWB_CLIENT_ID", ""),
        ewb_client_secret=source.get("WB_EWB_CLIENT_SECRET", ""),
        email=source.get("WB_EMAIL", ""),
        gst_gstin=source.get("WB_GST_GSTIN", ""),
        einv_gstin=source.get("WB_EINV_GSTIN", ""),
        ewb_gstin=source.get("WB_EWB_GSTIN", ""),
        ip_address=source.get("WB_IP_ADDRESS", ""),
        gst_username=source.get("WB_GST_USERNAME", ""),
        einv_nic_username=source.get("WB_EINV_NIC_USERNAME", ""),
        einv_nic_password=source.get("WB_EINV_NIC_PASSWORD", ""),
        ewb_nic_username=source.get("WB_EWB_NIC_USERNAME", ""),
        ewb_nic_password=source.get("WB_EWB_NIC_PASSWORD", ""),
    )


# Which part of the API a call belongs to. Each area has its own credentials and is checked only when it is used.
AREA_VARS: Dict[str, List[Tuple[str, str]]] = {
    "public": [("gst_client_id", "WB_GST_CLIENT_ID"), ("gst_client_secret", "WB_GST_CLIENT_SECRET"), ("email", "WB_EMAIL")],
    "gst": [("gst_client_id", "WB_GST_CLIENT_ID"), ("gst_client_secret", "WB_GST_CLIENT_SECRET"), ("email", "WB_EMAIL"), ("gst_gstin", "WB_GST_GSTIN"), ("ip_address", "WB_IP_ADDRESS"), ("gst_username", "WB_GST_USERNAME")],
    "einvoice": [("einv_client_id", "WB_EINV_CLIENT_ID"), ("einv_client_secret", "WB_EINV_CLIENT_SECRET"), ("email", "WB_EMAIL"), ("einv_gstin", "WB_EINV_GSTIN"), ("ip_address", "WB_IP_ADDRESS"), ("einv_nic_username", "WB_EINV_NIC_USERNAME"), ("einv_nic_password", "WB_EINV_NIC_PASSWORD")],
    "ewaybill": [("ewb_client_id", "WB_EWB_CLIENT_ID"), ("ewb_client_secret", "WB_EWB_CLIENT_SECRET"), ("email", "WB_EMAIL"), ("ewb_gstin", "WB_EWB_GSTIN"), ("ip_address", "WB_IP_ADDRESS"), ("ewb_nic_username", "WB_EWB_NIC_USERNAME"), ("ewb_nic_password", "WB_EWB_NIC_PASSWORD")],
}


def require_area(config: Config, area: str) -> None:
    """Raise ConfigError naming the environment variables this area still needs. It runs before any network call."""
    missing = [name for attr, name in AREA_VARS[area] if not getattr(config, attr)]
    if missing:
        raise ConfigError("missing environment variables for " + area + ": " + ", ".join(missing))


def state_code(gstin: str) -> str:
    """The two-digit state code is the first two characters of the GSTIN."""
    return gstin[:2]
