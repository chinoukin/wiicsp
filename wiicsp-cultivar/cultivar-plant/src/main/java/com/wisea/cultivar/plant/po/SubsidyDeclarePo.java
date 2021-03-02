package com.wisea.cultivar.plant.po;

import com.wisea.cultivar.plant.entity.BuySproutInfo;
import com.wisea.cultivar.plant.entity.CheckFile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("补助申报po")
public class SubsidyDeclarePo {

    @ApiModelProperty(value = "补助申报的id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long membId;



    @ApiModelProperty(value = "购苗信息")
    private List<BuySproutInfo> buySproutInfos;


    @ApiModelProperty(value = "验收材料")
    private List<CheckFile> checkFiles;


    @ApiModelProperty(value = "项目管理id")
    private Long itemMageId;

    @ApiModelProperty(value="申请金额")
    private Double applCapital;

    @ApiModelProperty(value="申报面积")
    private Double applMeasureArea;

    @ApiModelProperty(value="申请人类型")
    private String authType;

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

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BuySproutInfo> getBuySproutInfos() {
        return buySproutInfos;
    }

    public void setBuySproutInfos(List<BuySproutInfo> buySproutInfos) {
        this.buySproutInfos = buySproutInfos;
    }

    public List<CheckFile> getCheckFiles() {
        return checkFiles;
    }

    public void setCheckFiles(List<CheckFile> checkFiles) {
        this.checkFiles = checkFiles;
    }

    public Long getItemMageId() {
        return itemMageId;
    }

    public void setItemMageId(Long itemMageId) {
        this.itemMageId = itemMageId;
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

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
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

}
