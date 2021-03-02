package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;

public class OrderInfoMiddleVo{
    /**
     * 头像
     */
    private String url;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 支付时间
     */
    private OffsetDateTime payDate;

    /**
     * 支付金额
     */
    private Double payAmount;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 商品总件数
     */
    private Integer commCt;

    /**
     * 收货地址
     */
    private String address;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public OffsetDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(OffsetDateTime payDate) {
        this.payDate = payDate;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getCommCt() {
        return commCt;
    }

    public void setCommCt(Integer commCt) {
        this.commCt = commCt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
