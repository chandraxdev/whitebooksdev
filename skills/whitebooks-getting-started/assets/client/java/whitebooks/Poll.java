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

/** Poll a reference_id until its status is final. */
public final class Poll {
    private Poll() {}

    /**
     * Options of waitForStatus: give up after deadlineMs (default 120 s); the pause starts at intervalMs (5 s) and doubles up to
     * maxIntervalMs (20 s); isDone decides whether a status response is final (default: data.status_cd, then the top level; P, PE or ER).
     */
    public record WaitOptions(long deadlineMs, long intervalMs, long maxIntervalMs, Predicate<JsonNode> isDone, LongConsumer sleep) {
        public static WaitOptions defaults() {
            return new WaitOptions(120_000L, 5_000L, 20_000L, null, null);
        }
    }

    private static boolean defaultIsDone(JsonNode response) {
        JsonNode data = WhiteBooksException.findKey(response, "data", 4);
        String code = WhiteBooksException.textOf(WhiteBooksException.findKey(data != null && data.isObject() ? data : response, "status_cd", 4));
        return code.equals("P") || code.equals("PE") || code.equals("ER");
    }

    /** Call fetchStatus (which asks the status operation about the reference_id of the saved return) until the answer is final or the deadline passes. */
    public static JsonNode waitForStatus(Supplier<JsonNode> fetchStatus) {
        return waitForStatus(fetchStatus, WaitOptions.defaults());
    }

    public static JsonNode waitForStatus(Supplier<JsonNode> fetchStatus, WaitOptions opts) {
        Predicate<JsonNode> done = opts.isDone() != null ? opts.isDone() : Poll::defaultIsDone;
        LongConsumer wait = opts.sleep() != null ? opts.sleep() : Session::sleep;
        long startedAt = System.nanoTime();
        long interval = opts.intervalMs();
        while (true) {
            JsonNode response = fetchStatus.get();
            if (done.test(response)) {
                return response;
            }
            if ((System.nanoTime() - startedAt) / 1_000_000L + interval > opts.deadlineMs()) {
                throw new WhiteBooksException(
                    "client", "POLL_DEADLINE", "status still not final after " + opts.deadlineMs() + " ms", null, true);
            }
            wait.accept(interval);
            interval = Math.min(interval * 2, opts.maxIntervalMs());
        }
    }
}
