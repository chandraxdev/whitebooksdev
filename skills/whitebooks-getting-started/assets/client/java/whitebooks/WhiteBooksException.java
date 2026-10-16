// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3 (com.fasterxml.jackson.databind).

package whitebooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A typed error. source is one of whitebooks, gstn, nic, upstream, http, client.
 * unknown is true when the call may or may not have taken effect (timeout, network failure, 5xx). Unknown is never success.
 */
public class WhiteBooksException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final Pattern WB_ERR = Pattern.compile("(WB_ERR_\\d+)\\s*:?\\s*(.*)");
    private static final Pattern EXPIRED = Pattern.compile("(session|token).*(expired|invalid)|expired", Pattern.CASE_INSENSITIVE);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public final String source;
    public final String code;
    public final Integer httpStatus;
    public final boolean unknown;
    private String correlationId;

    public WhiteBooksException(String source, String code, String message) {
        this(source, code, message, null, false);
    }

    public WhiteBooksException(String source, String code, String message, Integer httpStatus, boolean unknown) {
        super(message);
        this.source = source;
        this.code = code;
        this.httpStatus = httpStatus;
        this.unknown = unknown;
    }

    public String correlationId() {
        return correlationId;
    }

    public void correlationId(String id) {
        this.correlationId = id;
    }

    /** Find the first value stored under key in a parsed JSON value, searching a few levels deep. */
    public static JsonNode findKey(JsonNode value, String key, int depth) {
        if (depth < 0 || value == null) {
            return null;
        }
        if (value.isArray()) {
            for (JsonNode item : value) {
                JsonNode hit = findKey(item, key, depth - 1);
                if (hit != null) {
                    return hit;
                }
            }
            return null;
        }
        if (value.isObject()) {
            if (value.has(key)) {
                return value.get(key);
            }
            for (JsonNode inner : value) {
                JsonNode hit = findKey(inner, key, depth - 1);
                if (hit != null) {
                    return hit;
                }
            }
        }
        return null;
    }

    /** Text of a string or number node, otherwise the empty string. */
    public static String textOf(JsonNode value) {
        if (value != null && (value.isTextual() || value.isNumber())) {
            return value.asText();
        }
        return "";
    }

    private static String head(String body) {
        return body.length() > 200 ? body.substring(0, 200) : body;
    }

    /**
     * Turn a response into a typed error, or null for a success.
     * Handles the WhiteBooks envelope (status_cd 0 plus status_desc WB_ERR_xxxx : ...), GSTN error.error_cd and NIC ErrorDetails.
     */
    public static WhiteBooksException parseFailure(int httpStatus, String body) {
        boolean serverSide = httpStatus >= 500;
        JsonNode parsed = null;
        try {
            if (body != null && !body.isEmpty()) {
                parsed = MAPPER.readTree(body);
            }
        } catch (JsonProcessingException err) {
            if (httpStatus >= 400) {
                return new WhiteBooksException("http", "HTTP_" + httpStatus, head(body), httpStatus, serverSide);
            }
            return new WhiteBooksException("client", "BAD_RESPONSE", "response is not JSON", httpStatus, true);
        }
        JsonNode statusCd = findKey(parsed, "status_cd", 4);
        String statusDesc = textOf(findKey(parsed, "status_desc", 4));
        Matcher wb = WB_ERR.matcher(statusDesc);
        if (wb.find()) {
            String code = wb.group(1);
            return new WhiteBooksException("whitebooks", code, statusDesc, httpStatus, serverSide || code.equals("WB_ERR_9000"));
        }
        JsonNode gstn = findKey(parsed, "error", 4);
        String errorCd = gstn != null && gstn.isObject() ? textOf(findKey(gstn, "error_cd", 4)) : "";
        if (!errorCd.isEmpty()) {
            String message = textOf(findKey(gstn, "message", 4));
            return new WhiteBooksException("gstn", errorCd, message.isEmpty() ? statusDesc : message, httpStatus, serverSide);
        }
        JsonNode details = findKey(parsed, "ErrorDetails", 4);
        if (details != null && details.isArray() && details.size() > 0) {
            StringBuilder messages = new StringBuilder();
            for (JsonNode detail : details) {
                String m = textOf(findKey(detail, "ErrorMessage", 4));
                if (!m.isEmpty()) {
                    messages.append(messages.length() == 0 ? "" : "; ").append(m);
                }
            }
            String code = textOf(findKey(details.get(0), "ErrorCode", 4));
            return new WhiteBooksException("nic", code.isEmpty() ? "NIC_ERROR" : code, messages.toString(), httpStatus, serverSide);
        }
        if ("0".equals(textOf(statusCd)) || httpStatus >= 400) {
            String code = httpStatus >= 400 ? "HTTP_" + httpStatus : "UPSTREAM_ERROR";
            return new WhiteBooksException("upstream", code, statusDesc.isEmpty() ? head(body == null ? "" : body) : statusDesc, httpStatus, serverSide);
        }
        return null;
    }

    /** True for errors that mean the session token is no longer valid and the caller should authenticate again. */
    public static boolean isSessionExpired(Throwable err) {
        if (!(err instanceof WhiteBooksException)) {
            return false;
        }
        WhiteBooksException failure = (WhiteBooksException) err;
        return "1005".equals(failure.code) || (failure.getMessage() != null && EXPIRED.matcher(failure.getMessage()).find());
    }
}
