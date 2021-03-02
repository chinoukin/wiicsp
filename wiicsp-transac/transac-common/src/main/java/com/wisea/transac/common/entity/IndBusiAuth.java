package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class IndBusiAuth extends DataLongEntity<IndBusiAuth> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 企业简称
     */
    private String entpShortName;

    /**
     * 批发市场id
     */
    private Long wholeSaleMarketId;

    /**
     * 客户类型（企业商户、个体商户）
     */
    private String custType;

    /**
     * 注册地省
     */
    private String areaProv;

    /**
     * 注册地市
     */
    private String areaCity;

    /**
     * 注册地区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 统一社会信用代码
     */
    private String ctscc;

    /**
     * 营业执照有效期
     */
    private String yyzzValidity;

    /**
     * 营业执照url
     */
    private String yyzzUrl;

    /**
     * 门头照
     */
    private String mtzUrl;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 法人姓名
     */
    private String legalPersonName;

    /**
     * 法人手机号
     */
    private String legalPersonTel;

    /**
     * 法人身份证号
     */
    private String legalPersonNum;

    /**
     * 法人身份证有效期
     */
    private String legalPersonValidity;

    /**
     * 身份证正面url
     */
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
    private String sfzFmUrl;

    /**
     * 手持身份证照片
     */
    private String holdSfzZmUrl;

    /**
     * 认证时间
     */
    private OffsetDateTime authDate;

    /**
     * 审核状态
     */
    private String authStateType;

    /**
     * 审核未通过原因
     */
    private String examFailReason;

    /**
     * 认证状态
     */
    private String entpAuthStateType;

    /**
     * 个体工商户名称
     */
    private String indBusiName;

    /**
     * 经营者姓名
     */
    private String operatorName;

    /**
     * 企业类型
     */
    private String entpType;

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

    public String getIndBusiName() {
        return indBusiName;
    }

    public void setIndBusiName(String indBusiName) {
        this.indBusiName = indBusiName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEntpType() {
        return entpType;
    }

    public void setEntpType(String entpType) {
        this.entpType = entpType;
    }
}
