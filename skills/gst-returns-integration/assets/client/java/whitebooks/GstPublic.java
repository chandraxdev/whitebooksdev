// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area gst
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3; uses Config, Session and WhiteBooksException from this package.

package whitebooks;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.function.Supplier;
import whitebooks.Session.Call;
import static whitebooks.Session.params;

/** gst operations of the "Public" tag: one static method each. */
public final class GstPublic {
    private GstPublic() {}

    /** Arguments of GET /public/pref. Optional ones may be null. */
    public record PublicPrefArgs(String gstin, String fy) {}

    /**
     * Get Preference
     * GET /public/pref
     * Public: no session is needed.
     */
    public static JsonNode publicPref(Config config, PublicPrefArgs args) {
        Config.requireArea(config, "public");
        Supplier<Call> build = () -> new Call(
            "GET", "/public/pref",
            params(
                "gstin", args.gstin(),
                "fy", args.fy(),
                "email", config.email()
            ),
            params(
                "state_cd", Config.stateCode(config.gstGstin()),
                "ip_address", config.ipAddress(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }

    /** Arguments of GET /public/rettrack. Optional ones may be null. */
    public record PublicRettrackArgs(String gstin, String fy, String type) {}

    /**
     * View and Track Returns
     * GET /public/rettrack
     * Public: no session is needed.
     */
    public static JsonNode publicRettrack(Config config, PublicRettrackArgs args) {
        Config.requireArea(config, "public");
        Supplier<Call> build = () -> new Call(
            "GET", "/public/rettrack",
            params(
                "gstin", args.gstin(),
                "fy", args.fy(),
                "type", args.type(),
                "email", config.email()
            ),
            params(
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }

    /** Arguments of GET /public/search. Optional ones may be null. */
    public record PublicSearchArgs(String gstin) {}

    /**
     * Search Taxpayer
     * GET /public/search
     * Public: no session is needed.
     */
    public static JsonNode publicSearch(Config config, PublicSearchArgs args) {
        Config.requireArea(config, "public");
        Supplier<Call> build = () -> new Call(
            "GET", "/public/search",
            params(
                "email", config.email(),
                "gstin", args.gstin()
            ),
            params(
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }

    /** Arguments of GET /public/unregistered-applicants. Optional ones may be null. */
    public record PublicUnregisteredApplicantsArgs(String uid) {}

    /**
     * Unregistered Applicants API
     * GET /public/unregistered-applicants
     * Public: no session is needed.
     */
    public static JsonNode publicUnregisteredApplicants(Config config, PublicUnregisteredApplicantsArgs args) {
        Config.requireArea(config, "public");
        Supplier<Call> build = () -> new Call(
            "GET", "/public/unregistered-applicants",
            params(
                "uid", args.uid(),
                "email", config.email()
            ),
            params(
                "ip_address", config.ipAddress(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }

    /** Arguments of GET /public/unregistered-applicants-validation. Optional ones may be null. */
    public record PublicUnregisteredApplicantsValidationArgs(String uid, String ecomEmail, String mobile) {}

    /**
     * Unregistered Applicants Validation
     * GET /public/unregistered-applicants-validation
     * Public: no session is needed.
     */
    public static JsonNode publicUnregisteredApplicantsValidation(Config config, PublicUnregisteredApplicantsValidationArgs args) {
        Config.requireArea(config, "public");
        Supplier<Call> build = () -> new Call(
            "GET", "/public/unregistered-applicants-validation",
            params(
                "uid", args.uid(),
                "ecomEmail", args.ecomEmail(),
                "mobile", args.mobile(),
                "email", config.email()
            ),
            params(
                "ip_address", config.ipAddress(),
                "client_id", config.gstClientId(),
                "client_secret", config.gstClientSecret()
            ),
            null
        );
        return Session.withRetries(() -> Session.send(config, build.get()));
    }
}
