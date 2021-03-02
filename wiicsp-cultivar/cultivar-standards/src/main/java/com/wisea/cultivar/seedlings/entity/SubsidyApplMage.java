package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * subsidy_appl_mage 表实体
 * 补贴申请管理
 * 2020/08/06 14:19:24
 */
public class SubsidyApplMage extends DataLongEntity<SubsidyApplMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id（登录种植APP的用户）
     */
    private Long membId;

    /**
     * 项目管理id
     */
    private Long itemMageId;

    /**
     * 申请人类型
     */
    private String authType;

 /**
     * 申请人账号
     */
    private String loginName;

    /**
     * 申请金额
     */
    private Double applCapital;

    /**
     * 申报面积
     */
    private Double applMeasureArea;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 补贴申请状态
     */
    private String subsidyApplStateType;

    /**
     * 审核意见
     */
    private String examFailReason;

    /**
     * 个人/企业名称
     */
    private String entpPersonalName;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 个人/企业收款账户
     */
    private String colleAccount;

    /**
     * 基地地区
     */
    private String baseArea;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 统一社会信用代码
     */
    private String ctscc;

    /**
     * 法人姓名
     */
    private String legalPersonName;

    /**
     * 法人身份证号
     */
    private String legalPersonNum;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     *
     * @mbg.generated
     */
    public SubsidyApplMage() {
        super();
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
}
