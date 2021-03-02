package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class ImportBill extends DataLongEntity<ImportBill> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 采购员工id
     */
    private Long purchaseStaffId;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 商品规格
     */
    private String commSpec;

    /**
     * 价格表达式
     */
    private String price;

    /**
     * 加入时间
     */
    private OffsetDateTime joinTime;

    /**
     * 等级规格报价id
     */
    private Long levelSpecQuoteId;

    /**
     * 等级规格版本号
     */
    private String levelSpecQuoteVersionNum;

    /**
     * 商品版本号
     */
    private String commVersionNum;

    /**
     * 净重
     */
    private Double netWeight;

    /**
     * 交易模式类型
     */
    private String transType;
    /**
     * 计量单位
     */
    private String measUnit;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getPurchaseStaffId() {
        return purchaseStaffId;
    }

    public void setPurchaseStaffId(Long purchaseStaffId) {
        this.purchaseStaffId = purchaseStaffId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OffsetDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(OffsetDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }

    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }

    public String getLevelSpecQuoteVersionNum() {
        return levelSpecQuoteVersionNum;
    }

    public void setLevelSpecQuoteVersionNum(String levelSpecQuoteVersionNum) {
        this.levelSpecQuoteVersionNum = levelSpecQuoteVersionNum;
    }

    public String getCommVersionNum() {
        return commVersionNum;
    }

    public void setCommVersionNum(String commVersionNum) {
        this.commVersionNum = commVersionNum;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public String getMeasUnit() {
        return measUnit;
    }

    public void setMeasUnit(String measUnit) {
        this.measUnit = measUnit;
    }
}
