package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

@ApiModel("EntpAuth详细信息Vo")
public class EntpAuthInfoVo {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="企业名称")
    private String entpName;

    @ApiModelProperty(value="统一社会信用代码")
    private String ctscc;

    @ApiModelProperty(value="营业执照开始有效期")
    private OffsetDateTime yyzzValidityStart;

    @ApiModelProperty(value="营业执照结束有效期")
    private OffsetDateTime yyzzValidityEnd;

    @ApiModelProperty(value="注册地省")
    private String areaProv;

    @ApiModelProperty(value="注册地市")
    private String areaCity;

    @ApiModelProperty(value="注册地区县")
    private String areaCou;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="联系人")
    private String conter;

    @ApiModelProperty(value="联系人手机号")
    private String contTel;

    @ApiModelProperty(value="营业执照url")
    private String yyzzUrl;

    @ApiModelProperty(value="法人姓名")
    private String legalPersonName;

    @ApiModelProperty(value="法人身份证号")
    private String legalPersonNum;

    @ApiModelProperty(value="法人身份证有效期")
    private String legalPersonValidity;

    @ApiModelProperty(value="身份证正面url")
    private String sfzZmUrl;

    @ApiModelProperty(value="身份证反面url")
    private String sfzFmUrl;

    @ApiModelProperty(value="手持身份证照片")
    private String holdSfzZmUrl;

    @ApiModelProperty(value="法人手机号")
    private String legalPersonTel;

    @ApiModelProperty(value="认证类型")
    private String authType;

    @ApiModelProperty(value="认证时间")
    private OffsetDateTime authDate;

    @ApiModelProperty(value="审核状态")
    private String authStateType;

    @ApiModelProperty(value="审核意见")
    private String examFailReason;

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

    public String getCtscc() {
        return ctscc;
    }

    public void setCtscc(String ctscc) {
        this.ctscc = ctscc;
    }

    public OffsetDateTime getYyzzValidityStart() {
        return yyzzValidityStart;
    }

    public void setYyzzValidityStart(OffsetDateTime yyzzValidityStart) {
        this.yyzzValidityStart = yyzzValidityStart;
    }

    public OffsetDateTime getYyzzValidityEnd() {
        return yyzzValidityEnd;
    }

    public void setYyzzValidityEnd(OffsetDateTime yyzzValidityEnd) {
        this.yyzzValidityEnd = yyzzValidityEnd;
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

    public String getYyzzUrl() {
        return yyzzUrl;
    }

    public void setYyzzUrl(String yyzzUrl) {
        this.yyzzUrl = yyzzUrl;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
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

    public String getLegalPersonTel() {
        return legalPersonTel;
    }

    public void setLegalPersonTel(String legalPersonTel) {
        this.legalPersonTel = legalPersonTel;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
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
}
