// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area ewaybill
// Generated code. Edit freely; "Upgrade the client" shows a diff before changing anything.
// SPDX-License-Identifier: Apache-2.0
// Copyright 2026 BVM IT Consulting Services Pvt. Ltd
// Credentials stay in the environment, never in chat or files; filing and cancelling need explicit confirmation.
// Dependencies: com.fasterxml.jackson.core:jackson-databind:2.22.3 (databind and annotations).

package whitebooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.JsonNodeFeature;
import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EwbPartBRequest(@JsonProperty("ewbNo") BigDecimal ewbNo, @JsonProperty("vehicleNo") String vehicleNo, @JsonProperty("fromPlace") String fromPlace, @JsonProperty("fromState") Long fromState, @JsonProperty("reasonCode") String reasonCode, @JsonProperty("reasonRem") String reasonRem, @JsonProperty("transDocNo") String transDocNo, @JsonProperty("transDocDate") String transDocDate, @JsonProperty("transMode") String transMode) {
    // JsonNode.toString() ignores the mapper's generator features, so a BigDecimal node of scale -2 would print 1E+2. toJson
    // therefore writes the request as plain text and parses it back: whole numbers become integer nodes, decimals keep their digits.
    private static final ObjectMapper MAPPER = new ObjectMapper()
        .configure(JsonNodeFeature.STRIP_TRAILING_BIGDECIMAL_ZEROES, false)
        .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
        .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

    /** The wire JSON of this request; null fields are left out and numbers are plain digits (100, 560001, 118.50). */
    public JsonNode toJson() {
        try {
            return MAPPER.readTree(MAPPER.writeValueAsString(this));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("cannot serialise the request", e);
        }
    }
}
