package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cultivar.common.entity.bigdata.OrdCommRelaTb;

public class OrdCommRelaTb extends DataLongEntity<OrdCommRelaTb> {
    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 销售分类
     */
    private String commSaleCatg;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 品种
     */
    private String varieties;

    /**
     * 品类
     */
    private String category;

    /**
     * 所属量纲
     */
    private String dimensionsType;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单价
     */
    private Double price;

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
     * 商品总金额
     */
    private Double commTotalPrice;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getCommSaleCatg() {
        return commSaleCatg;
    }

    public void setCommSaleCatg(String commSaleCatg) {
        this.commSaleCatg = commSaleCatg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
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

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
}