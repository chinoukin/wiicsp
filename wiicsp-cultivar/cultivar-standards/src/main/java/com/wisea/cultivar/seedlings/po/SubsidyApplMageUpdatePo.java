package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * SubsidyApplMageUpdatePo
 * 2020/08/06 14:19:24
 */
public class SubsidyApplMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 会员id（登录种植APP的用户）
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id（登录种植APP的用户）", allowableValues = "length:(,19]")
    private Long membId;

    /**
     * 项目管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "项目管理id", allowableValues = "length:(,19]")
    private Long itemMageId;

    /**
     * 申请人类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "申请人类型", allowableValues = "mixLength:(,5]")
    private String authType;

    /**
     * 申请金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "申请金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double applCapital;

    /**
     * 申报面积
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "申报面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double applMeasureArea;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;

    /**
     * 补贴申请状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "补贴申请状态", allowableValues = "mixLength:(,5]")
    private String subsidyApplStateType;

    /**
     * 审核意见
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "审核意见", allowableValues = "mixLength:(,255]")
    private String examFailReason;

    /**
     * 个人/企业名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "个人/企业名称", allowableValues = "mixLength:(,100]")
    private String entpPersonalName;

    /**
     * 身份证号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "身份证号", allowableValues = "mixLength:(,30]")
    private String idCardNo;

    /**
     * 个人/企业收款账户
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "个人/企业收款账户", allowableValues = "mixLength:(,30]")
    private String colleAccount;

    /**
     * 基地地区
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "基地地区", allowableValues = "mixLength:(,255]")
    private String baseArea;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址", allowableValues = "mixLength:(,255]")
    private String address;

    /**
     * 统一社会信用代码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "统一社会信用代码", allowableValues = "mixLength:(,30]")
    private String ctscc;

    /**
     * 法人姓名
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "法人姓名", allowableValues = "mixLength:(,30]")
    private String legalPersonName;

    /**
     * 法人身份证号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "法人身份证号", allowableValues = "mixLength:(,30]")
    private String legalPersonNum;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系人", allowableValues = "mixLength:(,20]")
    private String conter;

    /**
     * 联系人手机号
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系人手机号", allowableValues = "mixLength:(,20]")
    private String contTel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id（登录种植APP的用户）
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id（登录种植APP的用户）
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取项目管理id
     */
    public Long getItemMageId() {
        return itemMageId;
    }

    /**
     * 设置项目管理id
     */
    public void setItemMageId(Long itemMageId) {
        this.itemMageId = itemMageId;
    }

    /**
     * 获取申请人类型
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 设置申请人类型
     */
    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    /**
     * 获取申请金额
     */
    public Double getApplCapital() {
        return applCapital;
    }

    /**
     * 设置申请金额
     */
    public void setApplCapital(Double applCapital) {
        this.applCapital = applCapital;
    }

    /**
     * 获取申报面积
     */
    public Double getApplMeasureArea() {
        return applMeasureArea;
    }

    /**
     * 设置申报面积
     */
    public void setApplMeasureArea(Double applMeasureArea) {
        this.applMeasureArea = applMeasureArea;
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取补贴申请状态
     */
    public String getSubsidyApplStateType() {
        return subsidyApplStateType;
    }

    /**
     * 设置补贴申请状态
     */
    public void setSubsidyApplStateType(String subsidyApplStateType) {
        this.subsidyApplStateType = subsidyApplStateType == null ? null : subsidyApplStateType.trim();
    }

    /**
     * 获取审核意见
     */
    public String getExamFailReason() {
        return examFailReason;
    }

    /**
     * 设置审核意见
     */
    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason == null ? null : examFailReason.trim();
    }

    /**
     * 获取个人/企业名称
     */
    public String getEntpPersonalName() {
        return entpPersonalName;
    }

    /**
     * 设置个人/企业名称
     */
    public void setEntpPersonalName(String entpPersonalName) {
        this.entpPersonalName = entpPersonalName == null ? null : entpPersonalName.trim();
    }

    /**
     * 获取身份证号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    /**
     * 获取个人/企业收款账户
     */
    public String getColleAccount() {
        return colleAccount;
    }

    /**
     * 设置个人/企业收款账户
     */
    public void setColleAccount(String colleAccount) {
        this.colleAccount = colleAccount == null ? null : colleAccount.trim();
    }

    /**
     * 获取基地地区
     */
    public String getBaseArea() {
        return baseArea;
    }

    /**
     * 设置基地地区
     */
    public void setBaseArea(String baseArea) {
        this.baseArea = baseArea == null ? null : baseArea.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取统一社会信用代码
     */
    public String getCtscc() {
        return ctscc;
    }

    /**
     * 设置统一社会信用代码
     */
    public void setCtscc(String ctscc) {
        this.ctscc = ctscc == null ? null : ctscc.trim();
    }

    /**
     * 获取法人姓名
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人姓名
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    /**
     * 获取法人身份证号
     */
    public String getLegalPersonNum() {
        return legalPersonNum;
    }

    /**
     * 设置法人身份证号
     */
    public void setLegalPersonNum(String legalPersonNum) {
        this.legalPersonNum = legalPersonNum == null ? null : legalPersonNum.trim();
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系人手机号
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系人手机号
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
