// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area einvoice
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
public record EinvoiceGenerateRequest(@JsonProperty("Version") String version, @JsonProperty("TranDtls") TranDtls tranDtls, @JsonProperty("DocDtls") DocDtls docDtls, @JsonProperty("SellerDtls") SellerDtls sellerDtls, @JsonProperty("BuyerDtls") BuyerDtls buyerDtls, @JsonProperty("DispDtls") DispDtls dispDtls, @JsonProperty("ShipDtls") ShipDtls shipDtls, @JsonProperty("ItemList") List<ItemList> itemList, @JsonProperty("ValDtls") ValDtls valDtls, @JsonProperty("PayDtls") PayDtls payDtls, @JsonProperty("RefDtls") RefDtls refDtls, @JsonProperty("AddlDocDtls") List<AddlDocDtls> addlDocDtls, @JsonProperty("ExpDtls") ExpDtls expDtls, @JsonProperty("EwbDtls") EwbDtls ewbDtls) {
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
    public record TranDtls(@JsonProperty("TaxSch") String taxSch, @JsonProperty("SupTyp") String supTyp, @JsonProperty("RegRev") String regRev, @JsonProperty("EcmGstin") String ecmGstin, @JsonProperty("IgstOnIntra") String igstOnIntra) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record DocDtls(@JsonProperty("Typ") String typ, @JsonProperty("No") String no, @JsonProperty("Dt") String dt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record SellerDtls(@JsonProperty("Gstin") String gstin, @JsonProperty("LglNm") String lglNm, @JsonProperty("TrdNm") String trdNm, @JsonProperty("Addr1") String addr1, @JsonProperty("Addr2") String addr2, @JsonProperty("Loc") String loc, @JsonProperty("Pin") BigDecimal pin, @JsonProperty("Stcd") String stcd, @JsonProperty("Ph") String ph, @JsonProperty("Em") String em) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record BuyerDtls(@JsonProperty("Gstin") String gstin, @JsonProperty("LglNm") String lglNm, @JsonProperty("TrdNm") String trdNm, @JsonProperty("Pos") String pos, @JsonProperty("Addr1") String addr1, @JsonProperty("Addr2") String addr2, @JsonProperty("Loc") String loc, @JsonProperty("Pin") BigDecimal pin, @JsonProperty("Stcd") String stcd, @JsonProperty("Ph") String ph, @JsonProperty("Em") String em) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record DispDtls(@JsonProperty("Nm") String nm, @JsonProperty("Addr1") String addr1, @JsonProperty("Addr2") String addr2, @JsonProperty("Loc") String loc, @JsonProperty("Pin") BigDecimal pin, @JsonProperty("Stcd") String stcd) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ShipDtls(@JsonProperty("Gstin") String gstin, @JsonProperty("LglNm") String lglNm, @JsonProperty("TrdNm") String trdNm, @JsonProperty("Addr1") String addr1, @JsonProperty("Addr2") String addr2, @JsonProperty("Loc") String loc, @JsonProperty("Pin") BigDecimal pin, @JsonProperty("Stcd") String stcd) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ItemList(@JsonProperty("SlNo") String slNo, @JsonProperty("IsServc") String isServc, @JsonProperty("PrdDesc") String prdDesc, @JsonProperty("HsnCd") String hsnCd, @JsonProperty("Barcde") String barcde, @JsonProperty("BchDtls") ItemListBchDtls bchDtls, @JsonProperty("Qty") BigDecimal qty, @JsonProperty("FreeQty") BigDecimal freeQty, @JsonProperty("Unit") String unit, @JsonProperty("UnitPrice") BigDecimal unitPrice, @JsonProperty("TotAmt") BigDecimal totAmt, @JsonProperty("Discount") BigDecimal discount, @JsonProperty("PreTaxVal") BigDecimal preTaxVal, @JsonProperty("AssAmt") BigDecimal assAmt, @JsonProperty("GstRt") BigDecimal gstRt, @JsonProperty("SgstAmt") BigDecimal sgstAmt, @JsonProperty("IgstAmt") BigDecimal igstAmt, @JsonProperty("CgstAmt") BigDecimal cgstAmt, @JsonProperty("CesRt") BigDecimal cesRt, @JsonProperty("CesAmt") BigDecimal cesAmt, @JsonProperty("CesNonAdvlAmt") BigDecimal cesNonAdvlAmt, @JsonProperty("StateCesRt") BigDecimal stateCesRt, @JsonProperty("StateCesAmt") BigDecimal stateCesAmt, @JsonProperty("StateCesNonAdvlAmt") BigDecimal stateCesNonAdvlAmt, @JsonProperty("OthChrg") BigDecimal othChrg, @JsonProperty("TotItemVal") BigDecimal totItemVal, @JsonProperty("OrdLineRef") String ordLineRef, @JsonProperty("OrgCntry") String orgCntry, @JsonProperty("PrdSlNo") String prdSlNo, @JsonProperty("AttribDtls") List<ItemListAttribDtls> attribDtls) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ItemListBchDtls(@JsonProperty("Nm") String nm, @JsonProperty("Expdt") String expdt, @JsonProperty("wrDt") String wrDt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ItemListAttribDtls(@JsonProperty("Nm") String nm, @JsonProperty("Val") String val) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ValDtls(@JsonProperty("AssVal") BigDecimal assVal, @JsonProperty("CgstVal") BigDecimal cgstVal, @JsonProperty("SgstVal") BigDecimal sgstVal, @JsonProperty("IgstVal") BigDecimal igstVal, @JsonProperty("CesVal") BigDecimal cesVal, @JsonProperty("StCesVal") BigDecimal stCesVal, @JsonProperty("Discount") BigDecimal discount, @JsonProperty("OthChrg") BigDecimal othChrg, @JsonProperty("RndOffAmt") BigDecimal rndOffAmt, @JsonProperty("TotInvVal") BigDecimal totInvVal, @JsonProperty("TotInvValFc") BigDecimal totInvValFc) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record PayDtls(@JsonProperty("Nm") String nm, @JsonProperty("Accdet") String accdet, @JsonProperty("Mode") String mode, @JsonProperty("Fininsbr") String fininsbr, @JsonProperty("Payterm") String payterm, @JsonProperty("Payinstr") String payinstr, @JsonProperty("Crtrn") String crtrn, @JsonProperty("Dirdr") String dirdr, @JsonProperty("Crday") BigDecimal crday, @JsonProperty("Paidamt") BigDecimal paidamt, @JsonProperty("Paymtdue") BigDecimal paymtdue) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record RefDtls(@JsonProperty("InvRm") String invRm, @JsonProperty("DocPerdDtls") RefDtlsDocPerdDtls docPerdDtls, @JsonProperty("PrecDocDtls") List<RefDtlsPrecDocDtls> precDocDtls, @JsonProperty("ContrDtls") List<RefDtlsContrDtls> contrDtls) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record RefDtlsDocPerdDtls(@JsonProperty("InvStDt") String invStDt, @JsonProperty("InvEndDt") String invEndDt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record RefDtlsPrecDocDtls(@JsonProperty("InvNo") String invNo, @JsonProperty("InvDt") String invDt, @JsonProperty("OthRefNo") String othRefNo) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record RefDtlsContrDtls(@JsonProperty("RecAdvRefr") String recAdvRefr, @JsonProperty("RecAdvDt") String recAdvDt, @JsonProperty("Tendrefr") String tendrefr, @JsonProperty("Contrrefr") String contrrefr, @JsonProperty("Extrefr") String extrefr, @JsonProperty("Projrefr") String projrefr, @JsonProperty("Porefr") String porefr, @JsonProperty("PoRefDt") String poRefDt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record AddlDocDtls(@JsonProperty("Url") String url, @JsonProperty("Docs") String docs, @JsonProperty("Info") String info) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ExpDtls(@JsonProperty("ShipBNo") String shipBNo, @JsonProperty("ShipBDt") String shipBDt, @JsonProperty("Port") String port, @JsonProperty("RefClm") String refClm, @JsonProperty("ForCur") String forCur, @JsonProperty("CntCode") String cntCode) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record EwbDtls(@JsonProperty("Transid") String transid, @JsonProperty("Transname") String transname, @JsonProperty("Distance") BigDecimal distance, @JsonProperty("Transdocno") String transdocno, @JsonProperty("TransdocDt") String transdocDt, @JsonProperty("Vehno") String vehno, @JsonProperty("Vehtype") String vehtype, @JsonProperty("TransMode") String transMode) {
    }
}
