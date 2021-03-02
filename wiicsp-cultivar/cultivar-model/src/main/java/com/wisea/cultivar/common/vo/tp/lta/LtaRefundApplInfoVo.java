package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className LtaRefundApplInfoVo
 * @date 2019/5/9 17:13
 * @Description
 */
public class LtaRefundApplInfoVo {
    @ApiModelProperty("服务单号")
    private String refundNum;
    @ApiModelProperty("申请状态")
    private String refundApplStateType;
    @ApiModelProperty("订单ID")
    private Long ltaOrdId;
    @ApiModelProperty("订单编号")
    private String ltaOrdNumb;
    @ApiModelProperty("合同编号")
    private Long ltaContId;
    @ApiModelProperty("合同编号")
    private String ltaContNumb;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("订单金额")
    private Double yfAmount;
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

    public Long getLtaOrdId() {
        return ltaOrdId;
    }

    public void setLtaOrdId(Long ltaOrdId) {
        this.ltaOrdId = ltaOrdId;
    }

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
    }

    public Long getLtaContId() {
        return ltaContId;
    }

    public void setLtaContId(Long ltaContId) {
        this.ltaContId = ltaContId;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
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

    public Double getYfAmount() {
        return yfAmount;
    }

    public void setYfAmount(Double yfAmount) {
        this.yfAmount = yfAmount;
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
