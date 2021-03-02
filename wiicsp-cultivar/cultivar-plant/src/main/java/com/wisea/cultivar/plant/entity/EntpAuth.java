package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class EntpAuth extends DataLongEntity<EntpAuth> {
    /**
     * 会员id
     */
    @ApiModelProperty("会员id")
    private Long membId;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String entpName;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty("统一社会信用代码")
    private String ctscc;

    /**
     * 营业执照开始有效期
     */
    @ApiModelProperty("营业执照开始有效期")
    private OffsetDateTime yyzzValidityStart;

    /**
     * 营业执照结束有效期
     */
    @ApiModelProperty("营业执照结束有效期")
    private OffsetDateTime yyzzValidityEnd;

    /**
     * 注册地省
     */
    @ApiModelProperty("注册地省")
    private String areaProv;

    /**
     * 注册地市
     */
    @ApiModelProperty("注册地市")
    private String areaCity;

    /**
     * 注册地区县
     */
    @ApiModelProperty("注册地区县")
    private String areaCou;

    /**
     * 注册地省
     */
    @ApiModelProperty("注册地省名称")
    private String areaProvName;

    /**
     * 注册地市
     */
    @ApiModelProperty("注册地市名称")
    private String areaCityName;

    /**
     * 注册地区县
     */
    @ApiModelProperty("注册地区县名称")
    private String areaCouName;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String conter;

    /**
     * 联系人手机号
     */
    @ApiModelProperty("联系人手机号")
    private String contTel;

    /**
     * 营业执照url
     */
    @ApiModelProperty("营业执照url")
    private String yyzzUrl;

    /**
     * 法人姓名
     */
    @ApiModelProperty("法人姓名")
    private String legalPersonName;

    /**
     * 法人身份证号
     */
    @ApiModelProperty("法人身份证号")
    private String legalPersonNum;

    /**
     * 法人身份证有效期
     */
    @ApiModelProperty("法人身份证有效期")
    private String legalPersonValidity;

    /**
     * 身份证正面url
     */
    @ApiModelProperty("身份证正面url")
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
    @ApiModelProperty("身份证反面url")
    private String sfzFmUrl;

    /**
     * 手持身份证照片
     */
    @ApiModelProperty("手持身份证照片")
    private String holdSfzZmUrl;

    /**
     * 法人手机号
     */
    @ApiModelProperty("法人手机号")
    private String legalPersonTel;

    /**
     * 认证类型
     */
    @ApiModelProperty("认证类型")
    private String authType;

    /**
     * 认证时间
     */
    @ApiModelProperty("认证时间")
    private OffsetDateTime authDate;

    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String authStateType;

    /**
     * 审核意见
     */
    @ApiModelProperty("审核意见")
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

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }
}
