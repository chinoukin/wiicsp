package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

public class OrderInfoTbPo {
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("买家用户名")
    private String buyerUserName;
    @ApiModelProperty("卖家用户名")
    private String sellerUserName;
    @ApiModelProperty("商品总件数")
    private Integer commTotalCount;
    @ApiModelProperty("配送方式")
    private String sendZtType;
    @ApiModelProperty("订单来源")
    private String ordSource;
    @ApiModelProperty("买家头像url")
    private String buyerTxUrl;
    @ApiModelProperty("收货详细地址")
    private String address;
    @ApiModelProperty("自提地省")
    private String ztAddressProv;
    @ApiModelProperty("自提地市")
    private String ztAddressCity;
    @ApiModelProperty("商品总金额(商品发布价格)")
    private Double commTotalPrice;
    @ApiModelProperty("订单状态类型")
    private String orderStateType;
    @ApiModelProperty("支付订单日期")
    private OffsetDateTime payOrdDate;
    @ApiModelProperty("订单商品列表")
    private List<OrdCommRelaTbPo> ordCommRelaTbs;

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getBuyerUserName() {
        return buyerUserName;
    }

    public void setBuyerUserName(String buyerUserName) {
        this.buyerUserName = buyerUserName;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public void setSellerUserName(String sellerUserName) {
        this.sellerUserName = sellerUserName;
    }

    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public String getSendZtType() {
        return sendZtType;
    }

    public void setSendZtType(String sendZtType) {
        this.sendZtType = sendZtType;
    }

    public String getOrdSource() {
        return ordSource;
    }

    public void setOrdSource(String ordSource) {
        this.ordSource = ordSource;
    }

    public String getBuyerTxUrl() {
        return buyerTxUrl;
    }

    public void setBuyerTxUrl(String buyerTxUrl) {
        this.buyerTxUrl = buyerTxUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZtAddressProv() {
        return ztAddressProv;
    }

    public void setZtAddressProv(String ztAddressProv) {
        this.ztAddressProv = ztAddressProv;
    }

    public String getZtAddressCity() {
        return ztAddressCity;
    }

    public void setZtAddressCity(String ztAddressCity) {
        this.ztAddressCity = ztAddressCity;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public List<OrdCommRelaTbPo> getOrdCommRelaTbs() {
        return ordCommRelaTbs;
    }

    public void setOrdCommRelaTbs(List<OrdCommRelaTbPo> ordCommRelaTbs) {
        this.ordCommRelaTbs = ordCommRelaTbs;
    }
}
