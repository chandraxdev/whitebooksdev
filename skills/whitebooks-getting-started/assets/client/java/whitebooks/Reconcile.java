// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area core
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3; uses Config, Session and WhiteBooksException from this package.

package whitebooks;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/** Write reconciliation: shared by every area. */
public final class Reconcile {
    private Reconcile() {}

    /** Refuse, before any network call, to send an irreversible operation the caller has not explicitly confirmed. */
    static void requireIrreversibleConfirmed(String operation, boolean confirmed) {
        if (!confirmed) {
            throw new WhiteBooksException(
                "client",
                "IRREVERSIBLE_NOT_CONFIRMED",
                operation + " cannot be undone; confirm it explicitly only after the user has confirmed this exact operation",
                null,
                false);
        }
    }

    public static final long DEFAULT_RECONCILE_INTERVAL_MS = 600_000L;
    public static final int DEFAULT_MAX_ATTEMPTS = 3;

    /**
     * Options of a write. reconcile holds the arguments of the status operation that tells whether the write landed;
     * without them an unknown outcome is never repeated. landed is true when a status reply proves the write landed; a reply
     * that does not satisfy it leaves the outcome unknown (no landed report, no resend). Defaults: e-Invoice a reply with Irn;
     * e-Way Bill a reply with ewayBillNo or ewbNo; GST has none (see isReturnProcessed). minIntervalMs is the minimum wait
     * before each status check and between writes (default 10 minutes); maxAttempts counts writes and status checks
     * together (default 3). confirmIrreversible must be true to send an operation that cannot be undone upstream;
     * it is false in none() and withReconcile(...), so call confirmed() or .confirm() only after the user has confirmed.
     */
    public record WriteOptions<S>(
            S reconcile, Predicate<JsonNode> landed, long minIntervalMs, int maxAttempts, LongConsumer sleep, boolean confirmIrreversible) {
        public WriteOptions(S reconcile, Predicate<JsonNode> landed, long minIntervalMs, int maxAttempts, LongConsumer sleep) {
            this(reconcile, landed, minIntervalMs, maxAttempts, sleep, false);
        }

        public static <S> WriteOptions<S> none() {
            return new WriteOptions<>(null, null, DEFAULT_RECONCILE_INTERVAL_MS, DEFAULT_MAX_ATTEMPTS, null);
        }

        /** No reconcile, but the caller has explicitly confirmed an irreversible operation. */
        public static <S> WriteOptions<S> confirmed() {
            return WriteOptions.<S>none().confirm();
        }

        public static <S> WriteOptions<S> withReconcile(S statusArgs) {
            return new WriteOptions<>(statusArgs, null, DEFAULT_RECONCILE_INTERVAL_MS, DEFAULT_MAX_ATTEMPTS, null);
        }

        public static <S> WriteOptions<S> withReconcile(S statusArgs, Predicate<JsonNode> landed) {
            return new WriteOptions<>(statusArgs, landed, DEFAULT_RECONCILE_INTERVAL_MS, DEFAULT_MAX_ATTEMPTS, null);
        }

        /** A copy with confirmIrreversible set. */
        public WriteOptions<S> confirm() {
            return new WriteOptions<>(reconcile, landed, minIntervalMs, maxAttempts, sleep, true);
        }
    }

    /** The API's default proof of landing and the one NIC error code that positively says the document does not exist. */
    record Policy(Predicate<JsonNode> landed, String notFoundCode) {}

    /**
     * Whether a retstatus reply says the return was processed: data.status_cd is P or PE. Pass it as the landed predicate of
     * WriteOptions.withReconcile together with the refid from the save response of THIS return. GSTR-1 retsave answers with
     * data.reference_id only when it returns; if it times out there is no data.reference_id, retstatus cannot be asked about it, and the write ends
     * in WRITE_OUTCOME_UNKNOWN. A refid the caller held from an earlier save is stale and proves nothing about this one, which
     * is why GST reconciles only when a landed predicate is given.
     */
    public static boolean isReturnProcessed(JsonNode response) {
        JsonNode data = WhiteBooksException.findKey(response, "data", 4);
        String code = WhiteBooksException.textOf(WhiteBooksException.findKey(data != null && data.isObject() ? data : response, "status_cd", 4));
        return code.equals("P") || code.equals("PE");
    }

    static boolean hasIrn(JsonNode response) {
        JsonNode irn = WhiteBooksException.findKey(response, "Irn", 4);
        return irn != null && irn.isTextual();
    }

    static boolean hasEwayBillNo(JsonNode response) {
        JsonNode number = WhiteBooksException.findKey(response, "ewayBillNo", 4);
        if (number == null) {
            number = WhiteBooksException.findKey(response, "ewbNo", 4);
        }
        return number != null && (number.isTextual() || number.isNumber());
    }

    /**
     * Send the write once. If the outcome is unknown, wait minIntervalMs, ask the status operation, and treat the write as
     * landed only when the landed predicate (or the API default) says the reply proves it. A status call that succeeds without
     * proof, or fails for any reason (429, 401, session expiry, a bad argument, a 5xx), leaves the outcome unknown and never
     * causes a resend. Only the policy's not-found code (e-Invoice 2154) proves nothing landed and allows a resend, at least
     * minIntervalMs after the previous try, up to maxAttempts. e-Way Bill and GST document no not-found code, so they never
     * resend. Without a status check the unknown outcome ends in WRITE_OUTCOME_UNKNOWN.
     */
    static <S> JsonNode reconcileWrite(Supplier<JsonNode> write, Supplier<JsonNode> check, WriteOptions<S> opts, Policy policy) {
        LongConsumer wait = opts.sleep() != null ? opts.sleep() : Session::sleep;
        Predicate<JsonNode> landed = opts.landed() != null ? opts.landed() : policy.landed();
        if (check == null || landed == null) {
            try {
                return write.get();
            } catch (WhiteBooksException err) {
                if (err.unknown) {
                    throw new WhiteBooksException("client", "WRITE_OUTCOME_UNKNOWN", "the write did not complete; its outcome is unknown", null, true);
                }
                throw err;
            }
        }
        boolean needsWrite = true;
        boolean notFound = false;
        for (int attempt = 1; attempt <= opts.maxAttempts(); attempt++) {
            if (needsWrite) {
                try {
                    return write.get();
                } catch (WhiteBooksException err) {
                    if (!err.unknown) {
                        throw err;
                    }
                }
            }
            wait.accept(opts.minIntervalMs());
            try {
                JsonNode response = check.get();
                if (landed.test(response)) {
                    return response;
                }
                needsWrite = false;
                notFound = false;
            } catch (WhiteBooksException err) {
                notFound = policy.notFoundCode() != null && err.source.equals("nic") && err.code.equals(policy.notFoundCode());
                needsWrite = notFound;
            }
        }
        throw new WhiteBooksException(
            "client",
            notFound ? "WRITE_NOT_LANDED" : "WRITE_OUTCOME_UNKNOWN",
            "the write did not complete after " + opts.maxAttempts() + " attempts" + (notFound ? "" : "; its outcome is unknown"),
            null,
            !notFound);
    }
}
