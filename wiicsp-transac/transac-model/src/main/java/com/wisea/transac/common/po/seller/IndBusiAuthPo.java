package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("个体工商户新增或修改Po")
public class IndBusiAuthPo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id",hidden = true)
    private Long membId;

    @ApiModelProperty(value="企业名称")
    @Check(test = { "required" })
    private String entpName;

    @ApiModelProperty(value="企业简称")
    private String entpShortName;

    @ApiModelProperty(value="批发市场id",hidden = true)
    private Long wholeSaleMarketId;

    @ApiModelProperty(value="客户类型",hidden = true)
    private String custType;

    @ApiModelProperty(value="注册地省",hidden = true)
    private String areaProv;

    @ApiModelProperty(value="注册地市",hidden = true)
    private String areaCity;

    @ApiModelProperty(value="注册地区县",hidden = true)
    private String areaCou;

    @ApiModelProperty(value="详细地址",hidden = true)
    private String address;

    @ApiModelProperty(value="统一社会信用代码")
    @Check(test = { "required" })
    private String ctscc;

    @ApiModelProperty(value="营业执照有效期",hidden = true)
    private String yyzzValidity;

    @ApiModelProperty(value="营业执照url")
    @Check(test = { "required" })
    private String yyzzUrl;

    @ApiModelProperty(value="门头照",hidden = true)
    private String mtzUrl;

    @ApiModelProperty(value="联系人",hidden = true)
    private String conter;

    @ApiModelProperty(value="联系人手机号",hidden = true)
    private String contTel;

    @ApiModelProperty(value="邮箱",hidden = true)
    private String email;

    @ApiModelProperty(value="法人姓名/经营者姓名")
    @Check(test = { "required" })
    private String legalPersonName;

    @ApiModelProperty(value="法人手机号",hidden = true)
    private String legalPersonTel;

    @ApiModelProperty(value="法人身份证号",hidden = true)
    private String legalPersonNum;

    @ApiModelProperty(value="法人身份证有效期",hidden = true)
    private String legalPersonValidity;

    @ApiModelProperty(value="身份证正面url")
    @Check(test = { "required" })
    private String sfzZmUrl;

    @ApiModelProperty(value="身份证反面url")
    @Check(test = { "required" })
    private String sfzFmUrl;

    @ApiModelProperty(value="手持身份证照片")
    @Check(test = { "required" })
    private String holdSfzZmUrl;

    @ApiModelProperty(value="认证时间",hidden = true)
    private OffsetDateTime authDate;

    @ApiModelProperty(value="审核状态",hidden = true)
    private String authStateType;

    @ApiModelProperty(value="审核未通过原因",hidden = true)
    private String examFailReason;

    @ApiModelProperty(value="认证状态",hidden = true)
    private String entpAuthStateType;

    @ApiModelProperty(value="企业类型",hidden = true)
    private String entpType;

    @ApiModelProperty(value="省市县中文")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getEntpShortName() {
        return entpShortName;
    }

    public void setEntpShortName(String entpShortName) {
        this.entpShortName = entpShortName;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCtscc() {
        return ctscc;
    }

    public void setCtscc(String ctscc) {
        this.ctscc = ctscc;
    }

    public String getYyzzValidity() {
        return yyzzValidity;
    }

    public void setYyzzValidity(String yyzzValidity) {
        this.yyzzValidity = yyzzValidity;
    }

    public String getYyzzUrl() {
        return yyzzUrl;
    }

    public void setYyzzUrl(String yyzzUrl) {
        this.yyzzUrl = yyzzUrl;
    }

    public String getMtzUrl() {
        return mtzUrl;
    }

    public void setMtzUrl(String mtzUrl) {
        this.mtzUrl = mtzUrl;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonTel() {
        return legalPersonTel;
    }

    public void setLegalPersonTel(String legalPersonTel) {
        this.legalPersonTel = legalPersonTel;
    }

    public String getLegalPersonNum() {
        return legalPersonNum;
    }

    public void setLegalPersonNum(String legalPersonNum) {
        this.legalPersonNum = legalPersonNum;
    }

    public String getLegalPersonValidity() {
        return legalPersonValidity;
    }

    public void setLegalPersonValidity(String legalPersonValidity) {
        this.legalPersonValidity = legalPersonValidity;
    }

    public String getSfzZmUrl() {
        return sfzZmUrl;
    }

    public void setSfzZmUrl(String sfzZmUrl) {
        this.sfzZmUrl = sfzZmUrl;
    }

    public String getSfzFmUrl() {
        return sfzFmUrl;
    }

    public void setSfzFmUrl(String sfzFmUrl) {
        this.sfzFmUrl = sfzFmUrl;
    }

    public String getHoldSfzZmUrl() {
        return holdSfzZmUrl;
    }

    public void setHoldSfzZmUrl(String holdSfzZmUrl) {
        this.holdSfzZmUrl = holdSfzZmUrl;
    }

    public OffsetDateTime getAuthDate() {
        return authDate;
    }

    public void setAuthDate(OffsetDateTime authDate) {
        this.authDate = authDate;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getExamFailReason() {
        return examFailReason;
    }

    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getEntpType() {
        return entpType;
    }

    public void setEntpType(String entpType) {
        this.entpType = entpType;
    }
}
