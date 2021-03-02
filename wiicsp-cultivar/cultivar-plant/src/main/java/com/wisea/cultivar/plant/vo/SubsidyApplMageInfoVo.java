package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("SubsidyApplMage详细信息Vo")
public class SubsidyApplMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id（登录种植APP的用户）")
    private Long membId;

    @ApiModelProperty(value="项目管理id")
    private Long itemMageId;

    @ApiModelProperty(value="项目名称")
    private String  itemName;

    @ApiModelProperty(value="申请人类型")
    private String authType;

    @ApiModelProperty(value="申请金额")
    private Double applCapital;

    @ApiModelProperty(value="申报面积")
    private Double applMeasureArea;

    @ApiModelProperty(value="申请时间")
    private OffsetDateTime applDate;

    @ApiModelProperty(value="补贴申请状态")
    private String subsidyApplStateType;

    @ApiModelProperty(value="审核意见")
    private String examFailReason;

    @ApiModelProperty(value="个人/企业名称")
    private String entpPersonalName;

    @ApiModelProperty(value="身份证号")
    private String idCardNo;

    @ApiModelProperty(value="个人/企业收款账户")
    private String colleAccount;

    @ApiModelProperty(value="基地地区")
    private String baseArea;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="统一社会信用代码")
    private String ctscc;

    @ApiModelProperty(value="法人姓名")
    private String legalPersonName;

    @ApiModelProperty(value="法人身份证号")
    private String legalPersonNum;

    @ApiModelProperty(value="联系人")
    private String conter;

    @ApiModelProperty(value="联系人手机号")
    private String contTel;


    @ApiModelProperty(value="操作内容")
    private List<SubsidyExamRecdInfoVo> subsidyExamRecds;

    @ApiModelProperty(value="验收材料图片url")
    private List<String> url;

    @ApiModelProperty(value="购苗信息")
    private List<Long> serListId;

    @ApiModelProperty(value="采购记录")
    private List<SerListMagePageListVo> serListMagePageListVos;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Long> getSerListId() {
        return serListId;
    }

    public void setSerListId(List<Long> serListId) {
        this.serListId = serListId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getItemMageId() {
        return itemMageId;
    }

    public void setItemMageId(Long itemMageId) {
        this.itemMageId = itemMageId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public Double getApplCapital() {
        return applCapital;
    }

    public void setApplCapital(Double applCapital) {
        this.applCapital = applCapital;
    }

    public Double getApplMeasureArea() {
        return applMeasureArea;
    }

    public void setApplMeasureArea(Double applMeasureArea) {
        this.applMeasureArea = applMeasureArea;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getSubsidyApplStateType() {
        return subsidyApplStateType;
    }

    public void setSubsidyApplStateType(String subsidyApplStateType) {
        this.subsidyApplStateType = subsidyApplStateType;
    }

    public String getExamFailReason() {
        return examFailReason;
    }

    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason;
    }

    public String getEntpPersonalName() {
        return entpPersonalName;
    }

    public void setEntpPersonalName(String entpPersonalName) {
        this.entpPersonalName = entpPersonalName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getColleAccount() {
        return colleAccount;
    }

    public void setColleAccount(String colleAccount) {
        this.colleAccount = colleAccount;
    }

    public String getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(String baseArea) {
        this.baseArea = baseArea;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SubsidyExamRecdInfoVo> getSubsidyExamRecds() {
        return subsidyExamRecds;
    }

    public void setSubsidyExamRecds(List<SubsidyExamRecdInfoVo> subsidyExamRecds) {
        this.subsidyExamRecds = subsidyExamRecds;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<SerListMagePageListVo> getSerListMagePageListVos() {
        return serListMagePageListVos;
    }

    public void setSerListMagePageListVos(List<SerListMagePageListVo> serListMagePageListVos) {
        this.serListMagePageListVos = serListMagePageListVos;
    }
}
