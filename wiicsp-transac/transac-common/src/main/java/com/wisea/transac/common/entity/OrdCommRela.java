package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class OrdCommRela extends DataLongEntity<OrdCommRela> {
    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 等级规格报价id
     */
    private Long levelSpecQuoteId;

    /**
     * 进货单id
     */
    private Long importBillId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单价
     */
    private Double price;

    /**
     * 商品货号
     */
    private String commArtNum;

    /**
     * 商品图片
     */
    private String commUrl;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 商品规格
     */
    private String commSpec;

    /**
     * 所属量纲类型
     */
    private String dimensionsType;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 商品总重量
     */
    private Double commTotalWeight;

    /**
     * 单位重量单价
     */
    private Double unitWeightPrice;

    /**
     * 服务费
     */
    private Double platfCost;
    /**
     * 净重
     */
    private Double netWeight;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }

    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }

    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }

    public Long getImportBillId() {
        return importBillId;
    }

    public void setImportBillId(Long importBillId) {
        this.importBillId = importBillId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getCommTotalWeight() {
        return commTotalWeight;
    }

    public void setCommTotalWeight(Double commTotalWeight) {
        this.commTotalWeight = commTotalWeight;
    }

    public Double getUnitWeightPrice() {
        return unitWeightPrice;
    }

    public void setUnitWeightPrice(Double unitWeightPrice) {
        this.unitWeightPrice = unitWeightPrice;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }
}
