package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货退款申请列表VO
 */
@ApiModel("退货退款申请列表VO")
public class RefundCommApplListVo {
    @ApiModelProperty("退货退款申请ID")
    private Long id;
    @ApiModelProperty("服务单号")
    private String serNum;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("用户账号")
    private String buyerAccount;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家用户账号")
    private String sellerAccount;
    @ApiModelProperty("申请退款金额")
    private Double commTotalAmount;
    @ApiModelProperty("异议类型")
    private String examDissType;
    @ApiModelProperty("联系人")
    private String custName;
    @ApiModelProperty("退货退款申请状态")
    private String refundCommState;
    @ApiModelProperty("退货退款申请状态名称描述")
    private String label;
    @ApiModelProperty("处理时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime examSerBillDate;
    @ApiModelProperty("结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime doneDate;
    @ApiModelProperty("处理方标志")
    private String handlerType;
    /***************** 后台字段 ****************/
    @ApiModelProperty("服务费")
    private Double platfCost;

    @ApiModelProperty("商家退款")
    private Double sellerRefund;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Double getCommTotalAmount() {
        return commTotalAmount;
    }

    public void setCommTotalAmount(Double commTotalAmount) {
        this.commTotalAmount = commTotalAmount;
    }

    public String getExamDissType() {
        return examDissType;
    }

    public void setExamDissType(String examDissType) {
        this.examDissType = examDissType;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getRefundCommState() {
        return refundCommState;
    }

    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState;
    }

    public OffsetDateTime getExamSerBillDate() {
        return examSerBillDate;
    }

    public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
        this.examSerBillDate = examSerBillDate;
    }

    public OffsetDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(OffsetDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getSellerRefund() {
        return sellerRefund;
    }

    public void setSellerRefund(Double sellerRefund) {
        this.sellerRefund = sellerRefund;
    }
}
