package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 退款申请详细信息
 */
@ApiModel("退款申请详细信息")
public class RefundApplInfoVo {
    @ApiModelProperty("服务单号")
    private String refundNum;
    @ApiModelProperty("申请状态")
    private String refundApplStateType;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("订单ID")
    private Long ordId;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("订单金额")
    private Double amountPayable;
    @ApiModelProperty("退款金额")
    private Double refundAmount;
    @ApiModelProperty("退款原因")
    private String refundReasonType;
    @ApiModelProperty("问题描述")
    private String refundDesc;
    @ApiModelProperty("处理人员")
    private String updateBy;
    @ApiModelProperty("处理时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime handleDate;
    @ApiModelProperty("商家处理备注")
    private String sellerHandleRemarks;
    @ApiModelProperty("备注")
    private String remarks;

    /**新增字段**/
    @ApiModelProperty("订单支付类型")
    private String payMethodType;

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
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

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReasonType() {
        return refundReasonType;
    }

    public void setRefundReasonType(String refundReasonType) {
        this.refundReasonType = refundReasonType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public OffsetDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(OffsetDateTime handleDate) {
        this.handleDate = handleDate;
    }

    public String getSellerHandleRemarks() {
        return sellerHandleRemarks;
    }

    public void setSellerHandleRemarks(String sellerHandleRemarks) {
        this.sellerHandleRemarks = sellerHandleRemarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }
}
