package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("商家查询订单列表VO")
public class MerchantOrderInfoListVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提交时间")
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("采购商账号")
    private String buyerAccount;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家账号")
    private String sellerAccount;
    @ApiModelProperty("支付方式类型")
    private String payMethodType;
    @ApiModelProperty("订单状态类型")
    private String orderStateType;
    @ApiModelProperty("应付款金额(订单总金额)")
    private Double payableAmount;
    @ApiModelProperty("商品总金额")
    private Double commTotalPrice;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("商家应收金额")
    private Double sellerReceivableAmount;
    @ApiModelProperty("商品总件数")
    private Integer commTotalCount;
    @ApiModelProperty("订单商品列表")
    private List<OrdCommRelaVo> ordCommRelas;

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

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getSellerReceivableAmount() {
        return sellerReceivableAmount;
    }

    public void setSellerReceivableAmount(Double sellerReceivableAmount) {
        this.sellerReceivableAmount = sellerReceivableAmount;
    }

    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public List<OrdCommRelaVo> getOrdCommRelas() {
        return ordCommRelas;
    }

    public void setOrdCommRelas(List<OrdCommRelaVo> ordCommRelas) {
        this.ordCommRelas = ordCommRelas;
    }
}
