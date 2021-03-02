package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class RealPersonAuth extends DataLongEntity<RealPersonAuth> {
    /**
     * 会员id
     */
    @ApiModelProperty(value="会员id")
    private Long membId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value="真实姓名")
    private String realName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idCardNum;

    /**
     * 联系电话
     */
    @ApiModelProperty(value="联系电话")
    private String contTel;

    /**
     * 身份证正面url
     */
    @ApiModelProperty(value="身份证正面url")
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
    @ApiModelProperty(value="身份证反面url")
    private String sfzFmUrl;

    /**
     * 认证时间
     */
    @ApiModelProperty(value="认证时间")
    private OffsetDateTime authDate;

    /**
     * 认证状态
     */
    @ApiModelProperty(value="认证状态")
    private String entpAuthStateType;

    /**
     * 审核状态
     */
    @ApiModelProperty(value="审核状态")
    private String authStateType;

    /**
     * 认证类型
     */
    @ApiModelProperty(value="认证类型")
    private String authType;

    /**
     * 审核意见
     */
    @ApiModelProperty(value="审核意见")
    private String examFailReason;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
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

    public OffsetDateTime getAuthDate() {
        return authDate;
    }

    public void setAuthDate(OffsetDateTime authDate) {
        this.authDate = authDate;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getExamFailReason() {
        return examFailReason;
    }

    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason;
    }
}
