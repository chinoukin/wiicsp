package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询账期发票Vo")
public class SettleBillInvoPageListVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="申请单号")
    private String applNum;
    @ApiModelProperty("买家ID")
    private String buyerId;
    @ApiModelProperty("买家名称")
    private String buyerName;
    @ApiModelProperty("买家账号")
    private String buyerAccount;
    @ApiModelProperty(value="结算单号")
    private String settleBillNumb;
    @ApiModelProperty(value="开票金额")
    private Double drawAmount;
    @ApiModelProperty("发票状态")
    private String invoState;
    @ApiModelProperty("验票异议状态")
    private String examInvoDissType;
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty("当前时间")
    private OffsetDateTime nowDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplNum() {
        return applNum;
    }

    public void setApplNum(String applNum) {
        this.applNum = applNum;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public String getExamInvoDissType() {
        return examInvoDissType;
    }

    public void setExamInvoDissType(String examInvoDissType) {
        this.examInvoDissType = examInvoDissType;
    }

    public OffsetDateTime getOpenBillDeadline() {
        return openBillDeadline;
    }

    public void setOpenBillDeadline(OffsetDateTime openBillDeadline) {
        this.openBillDeadline = openBillDeadline;
    }

    public OffsetDateTime getExamBillDeadline() {
        return examBillDeadline;
    }

    public void setExamBillDeadline(OffsetDateTime examBillDeadline) {
        this.examBillDeadline = examBillDeadline;
    }

    public OffsetDateTime getNowDate() {
        return OffsetDateTime.now();
    }

    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
    }
}
