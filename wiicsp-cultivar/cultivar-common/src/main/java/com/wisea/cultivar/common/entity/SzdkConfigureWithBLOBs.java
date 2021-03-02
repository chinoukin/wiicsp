package com.wisea.cultivar.common.entity;

public class SzdkConfigureWithBLOBs extends SzdkConfigure {
    /**
     * 公司介绍
     */
    private String compIntroduce;

    /**
     * 买家注册协议
     */
    private String buyerRegistAgreement;

    /**
     * 商家注册协议
     */
    private String sellerRegistAgreement;

    public String getCompIntroduce() {
        return compIntroduce;
    }

    public void setCompIntroduce(String compIntroduce) {
        this.compIntroduce = compIntroduce;
    }

    public String getBuyerRegistAgreement() {
        return buyerRegistAgreement;
    }

    public void setBuyerRegistAgreement(String buyerRegistAgreement) {
        this.buyerRegistAgreement = buyerRegistAgreement;
    }

    public String getSellerRegistAgreement() {
        return sellerRegistAgreement;
    }

    public void setSellerRegistAgreement(String sellerRegistAgreement) {
        this.sellerRegistAgreement = sellerRegistAgreement;
    }
}
