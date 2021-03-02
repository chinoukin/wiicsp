package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询退款列表Vo")
public class RefundApplPageListVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="服务单号")
    private String refundNum;
    @ApiModelProperty(value="申请时间")
    private OffsetDateTime applDate;
    @ApiModelProperty(value="订单编号")
    private String ordNum;
    @ApiModelProperty("卖家ID")
    private String sellerId;
    @ApiModelProperty("卖家账号")
    private String sellerAccount;
    @ApiModelProperty("买家ID")
    private String buyerId;
    @ApiModelProperty("买家账号")
    private String buyerAccount;
    @ApiModelProperty(value="退款金额")
    private Double refundAmount;
    @ApiModelProperty(value="退款申请状态类型")
    private String refundApplStateType;
    @ApiModelProperty("退货商品图片")
    private String commUrl;
    @ApiModelProperty("退货商品种类个数")
    private Integer commKindCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
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

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public Integer getCommKindCount() {
        return commKindCount;
    }

    public void setCommKindCount(Integer commKindCount) {
        this.commKindCount = commKindCount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
