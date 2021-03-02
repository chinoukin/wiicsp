package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cultivar.common.entity.bigdata.OrderInfoTb;
import java.time.OffsetDateTime;

public class OrderInfoTb extends DataLongEntity<OrderInfoTb> {
    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 买家用户名
     */
    private String buyerUserName;

    /**
     * 卖家用户名
     */
    private String sellerUserName;

    /**
     * 商品总件数
     */
    private Integer commTotalCount;

    /**
     * 配送方式
     */
    private String sendZtType;

    /**
     * 订单来源
     */
    private String ordSource;

    /**
     * 买家头像url
     */
    private String buyerTxUrl;

    /**
     * 收货详细地址
     */
    private String address;

    /**
     * 自提地省
     */
    private String ztAddressProv;

    /**
     * 自提地市
     */
    private String ztAddressCity;

    /**
     * 商品总金额(商品发布价格)
     */
    private Double commTotalPrice;

    /**
     * 订单状态类型
     */
    private String orderStateType;

    /**
     * 支付订单日期
     */
    private OffsetDateTime payOrdDate;

    public String getOrdNum() {
        return ordNum;
    }

    public String getZtAddressCity() {
        return ztAddressCity;
    }

    public void setZtAddressCity(String ztAddressCity) {
        this.ztAddressCity = ztAddressCity;
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
}
