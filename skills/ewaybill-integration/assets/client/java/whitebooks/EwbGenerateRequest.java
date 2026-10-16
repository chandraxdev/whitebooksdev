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
public record EwbGenerateRequest(@JsonProperty("supplyType") String supplyType, @JsonProperty("subSupplyType") String subSupplyType, @JsonProperty("subSupplyDesc") String subSupplyDesc, @JsonProperty("docType") String docType, @JsonProperty("docNo") String docNo, @JsonProperty("docDate") String docDate, @JsonProperty("fromGstin") String fromGstin, @JsonProperty("fromTrdName") String fromTrdName, @JsonProperty("fromAddr1") String fromAddr1, @JsonProperty("fromAddr2") String fromAddr2, @JsonProperty("fromPlace") String fromPlace, @JsonProperty("actFromStateCode") Long actFromStateCode, @JsonProperty("fromPincode") Long fromPincode, @JsonProperty("fromStateCode") Long fromStateCode, @JsonProperty("toGstin") String toGstin, @JsonProperty("toTrdName") String toTrdName, @JsonProperty("toAddr1") String toAddr1, @JsonProperty("toAddr2") String toAddr2, @JsonProperty("toPlace") String toPlace, @JsonProperty("toPincode") Long toPincode, @JsonProperty("actToStateCode") Long actToStateCode, @JsonProperty("toStateCode") Long toStateCode, @JsonProperty("transactionType") Long transactionType, @JsonProperty("dispatchFromGSTIN") String dispatchFromGSTIN, @JsonProperty("dispatchFromTradeName") String dispatchFromTradeName, @JsonProperty("shipToGSTIN") String shipToGSTIN, @JsonProperty("shipToTradeName") String shipToTradeName, @JsonProperty("totalValue") BigDecimal totalValue, @JsonProperty("cgstValue") BigDecimal cgstValue, @JsonProperty("sgstValue") BigDecimal sgstValue, @JsonProperty("igstValue") BigDecimal igstValue, @JsonProperty("cessValue") BigDecimal cessValue, @JsonProperty("cessNonAdvolValue") BigDecimal cessNonAdvolValue, @JsonProperty("totInvValue") BigDecimal totInvValue, @JsonProperty("otherValue") BigDecimal otherValue, @JsonProperty("transMode") String transMode, @JsonProperty("transDistance") String transDistance, @JsonProperty("transporterName") String transporterName, @JsonProperty("transporterId") String transporterId, @JsonProperty("transDocNo") String transDocNo, @JsonProperty("transDocDate") String transDocDate, @JsonProperty("vehicleNo") String vehicleNo, @JsonProperty("vehicleType") String vehicleType, @JsonProperty("itemList") List<ItemList> itemList) {
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ItemList(@JsonProperty("productName") String productName, @JsonProperty("productDesc") String productDesc, @JsonProperty("hsnCode") BigDecimal hsnCode, @JsonProperty("quantity") BigDecimal quantity, @JsonProperty("qtyUnit") String qtyUnit, @JsonProperty("taxableAmount") BigDecimal taxableAmount, @JsonProperty("sgstRate") BigDecimal sgstRate, @JsonProperty("cgstRate") BigDecimal cgstRate, @JsonProperty("igstRate") BigDecimal igstRate, @JsonProperty("cessRate") BigDecimal cessRate, @JsonProperty("cessNonadvol") BigDecimal cessNonadvol) {
    }
}
