// WhiteBooks client 1.0.8 | spec_as_of 2026-10-13 | template java | area gst
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
public record Gstr1SaveRequest(@JsonProperty("gstin") String gstin, @JsonProperty("fp") String fp, @JsonProperty("gt") BigDecimal gt, @JsonProperty("cur_gt") BigDecimal curGt, @JsonProperty("b2b") List<B2b> b2b, @JsonProperty("b2ba") List<B2ba> b2ba, @JsonProperty("b2cl") List<B2cl> b2cl, @JsonProperty("b2cla") List<B2cla> b2cla, @JsonProperty("cdnr") List<Cdnr> cdnr, @JsonProperty("cdnra") List<Cdnra> cdnra, @JsonProperty("b2cs") List<B2cs> b2cs, @JsonProperty("b2csa") List<B2csa> b2csa, @JsonProperty("exp") List<Exp> exp, @JsonProperty("expa") List<Expa> expa, @JsonProperty("hsn") Hsn hsn, @JsonProperty("nil") Nil nil, @JsonProperty("txpd") List<Txpd> txpd, @JsonProperty("txpda") List<Txpda> txpda, @JsonProperty("at") List<At> at, @JsonProperty("ata") List<Ata> ata, @JsonProperty("doc_issue") DocIssue docIssue, @JsonProperty("cdnur") List<Cdnur> cdnur, @JsonProperty("cdnura") List<Cdnura> cdnura) {
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
    public record B2b(@JsonProperty("ctin") String ctin, @JsonProperty("inv") List<B2bInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2bInv(@JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("val") BigDecimal val, @JsonProperty("pos") String pos, @JsonProperty("rchrg") String rchrg, @JsonProperty("etin") String etin, @JsonProperty("inv_typ") String invTyp, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<B2bInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2bInvItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") B2bInvItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2bInvItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2ba(@JsonProperty("ctin") String ctin, @JsonProperty("inv") List<B2baInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2baInv(@JsonProperty("oinum") String oinum, @JsonProperty("oidt") String oidt, @JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("val") BigDecimal val, @JsonProperty("pos") String pos, @JsonProperty("rchrg") String rchrg, @JsonProperty("etin") String etin, @JsonProperty("inv_typ") String invTyp, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<B2baInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2baInvItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") B2baInvItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2baInvItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("camt") BigDecimal camt, @JsonProperty("samt") BigDecimal samt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2cl(@JsonProperty("pos") String pos, @JsonProperty("inv") List<B2clInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2clInv(@JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("val") BigDecimal val, @JsonProperty("inv_typ") String invTyp, @JsonProperty("etin") String etin, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<B2clInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2clInvItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") B2clInvItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2clInvItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2cla(@JsonProperty("pos") String pos, @JsonProperty("inv") List<B2claInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2claInv(@JsonProperty("oinum") String oinum, @JsonProperty("oidt") String oidt, @JsonProperty("inv_typ") String invTyp, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("val") BigDecimal val, @JsonProperty("etin") String etin, @JsonProperty("itms") List<B2claInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2claInvItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") B2claInvItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2claInvItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Cdnr(@JsonProperty("ctin") String ctin, @JsonProperty("nt") List<CdnrNt> nt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnrNt(@JsonProperty("ntty") String ntty, @JsonProperty("nt_num") String ntNum, @JsonProperty("nt_dt") String ntDt, @JsonProperty("p_gst") String pGst, @JsonProperty("pos") String pos, @JsonProperty("rchrg") String rchrg, @JsonProperty("inv_typ") String invTyp, @JsonProperty("val") BigDecimal val, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<CdnrNtItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnrNtItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") CdnrNtItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnrNtItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Cdnra(@JsonProperty("ctin") String ctin, @JsonProperty("nt") List<CdnraNt> nt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnraNt(@JsonProperty("ntty") String ntty, @JsonProperty("ont_num") String ontNum, @JsonProperty("ont_dt") String ontDt, @JsonProperty("nt_num") String ntNum, @JsonProperty("nt_dt") String ntDt, @JsonProperty("p_gst") String pGst, @JsonProperty("pos") String pos, @JsonProperty("rchrg") String rchrg, @JsonProperty("inv_typ") String invTyp, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("val") BigDecimal val, @JsonProperty("itms") List<CdnraNtItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnraNtItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") CdnraNtItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnraNtItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("camt") BigDecimal camt, @JsonProperty("samt") BigDecimal samt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2cs(@JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("rt") BigDecimal rt, @JsonProperty("typ") String typ, @JsonProperty("etin") String etin, @JsonProperty("pos") String pos, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2csa(@JsonProperty("omon") String omon, @JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("typ") String typ, @JsonProperty("etin") String etin, @JsonProperty("pos") String pos, @JsonProperty("itms") List<B2csaItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record B2csaItms(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("camt") BigDecimal camt, @JsonProperty("samt") BigDecimal samt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Exp(@JsonProperty("exp_typ") String expTyp, @JsonProperty("inv") List<ExpInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ExpInv(@JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("val") BigDecimal val, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("sbpcode") String sbpcode, @JsonProperty("sbnum") String sbnum, @JsonProperty("sbdt") String sbdt, @JsonProperty("itms") List<ExpInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ExpInvItms(@JsonProperty("txval") BigDecimal txval, @JsonProperty("rt") BigDecimal rt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Expa(@JsonProperty("exp_typ") String expTyp, @JsonProperty("inv") List<ExpaInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ExpaInv(@JsonProperty("oinum") String oinum, @JsonProperty("oidt") String oidt, @JsonProperty("inum") String inum, @JsonProperty("idt") String idt, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("val") BigDecimal val, @JsonProperty("sbpcode") String sbpcode, @JsonProperty("sbnum") String sbnum, @JsonProperty("sbdt") String sbdt, @JsonProperty("itms") List<ExpaInvItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record ExpaInvItms(@JsonProperty("txval") BigDecimal txval, @JsonProperty("rt") BigDecimal rt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Hsn(@JsonProperty("data") List<HsnData> data) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record HsnData(@JsonProperty("num") BigDecimal num, @JsonProperty("hsn_sc") String hsnSc, @JsonProperty("desc") String desc, @JsonProperty("uqc") String uqc, @JsonProperty("qty") BigDecimal qty, @JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Nil(@JsonProperty("inv") List<NilInv> inv) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record NilInv(@JsonProperty("sply_ty") String splyTy, @JsonProperty("expt_amt") BigDecimal exptAmt, @JsonProperty("nil_amt") BigDecimal nilAmt, @JsonProperty("ngsup_amt") BigDecimal ngsupAmt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Txpd(@JsonProperty("pos") String pos, @JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<TxpdItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record TxpdItms(@JsonProperty("rt") BigDecimal rt, @JsonProperty("ad_amt") BigDecimal adAmt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Txpda(@JsonProperty("omon") String omon, @JsonProperty("pos") String pos, @JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<TxpdaItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record TxpdaItms(@JsonProperty("rt") BigDecimal rt, @JsonProperty("ad_amt") BigDecimal adAmt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record At(@JsonProperty("pos") String pos, @JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<AtItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record AtItms(@JsonProperty("rt") BigDecimal rt, @JsonProperty("ad_amt") BigDecimal adAmt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Ata(@JsonProperty("omon") String omon, @JsonProperty("pos") String pos, @JsonProperty("sply_ty") String splyTy, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<AtaItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record AtaItms(@JsonProperty("rt") BigDecimal rt, @JsonProperty("ad_amt") BigDecimal adAmt, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record DocIssue(@JsonProperty("doc_det") List<DocIssueDocDet> docDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record DocIssueDocDet(@JsonProperty("doc_num") BigDecimal docNum, @JsonProperty("docs") List<DocIssueDocDetDocs> docs) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record DocIssueDocDetDocs(@JsonProperty("num") BigDecimal num, @JsonProperty("from") String from, @JsonProperty("to") String to, @JsonProperty("totnum") BigDecimal totnum, @JsonProperty("cancel") BigDecimal cancel, @JsonProperty("net_issue") BigDecimal netIssue) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Cdnur(@JsonProperty("typ") String typ, @JsonProperty("ntty") String ntty, @JsonProperty("nt_num") String ntNum, @JsonProperty("nt_dt") String ntDt, @JsonProperty("p_gst") String pGst, @JsonProperty("pos") String pos, @JsonProperty("val") BigDecimal val, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<CdnurItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnurItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") CdnurItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnurItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Cdnura(@JsonProperty("ont_num") String ontNum, @JsonProperty("ont_dt") String ontDt, @JsonProperty("nt_num") String ntNum, @JsonProperty("nt_dt") String ntDt, @JsonProperty("ntty") String ntty, @JsonProperty("typ") String typ, @JsonProperty("p_gst") String pGst, @JsonProperty("inum") String inum, @JsonProperty("val") BigDecimal val, @JsonProperty("idt") String idt, @JsonProperty("diff_percent") BigDecimal diffPercent, @JsonProperty("itms") List<CdnuraItms> itms) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnuraItms(@JsonProperty("num") BigDecimal num, @JsonProperty("itm_det") CdnuraItmsItmDet itmDet) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CdnuraItmsItmDet(@JsonProperty("rt") BigDecimal rt, @JsonProperty("txval") BigDecimal txval, @JsonProperty("iamt") BigDecimal iamt, @JsonProperty("csamt") BigDecimal csamt) {
    }
}
