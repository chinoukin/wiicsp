package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("商家（后台）查询订单列表VO")
public class MerchantOrderInfoListVo {
    @ApiModelProperty("订单ID")
    private Long id;

    @ApiModelProperty("订单编号")
    private String ordNum;

    @ApiModelProperty("提交时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime referOrdDate;

    @ApiModelProperty("买家用户ID")
    private Long buyerId;

    @ApiModelProperty("采购商账号")
    private String buyerAccount;

    @ApiModelProperty("采购商名称")
    private String buyerName;

    @ApiModelProperty("订单金额")
    private Double amountPayable;

    @ApiModelProperty("订单来源")
    private String sourceType;

    @ApiModelProperty("支付方式类型")
    private String payMethodType;

    @ApiModelProperty("订单状态类型")
    private String orderStateType;

    @ApiModelProperty("配送信息类型")
    private String deliveryInfoType;

    @ApiModelProperty("订单支付日期【注：如果支付类型为分阶段支付，并且支付日期（payOrdDate），并且订单状态为待支付，则展示 尾款未支付】")
    private OffsetDateTime payOrdDate;

    /*************** 后台使用字段 *************/
    @ApiModelProperty("商品发布类型(挂牌方式)")
    private String commPubType;
    @ApiModelProperty("供货方式类型")
    private String supplyModeType;
    @ApiModelProperty("卖家账号")
    private String sellerAccount;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("结算金额")
    private Double settlementAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
}
