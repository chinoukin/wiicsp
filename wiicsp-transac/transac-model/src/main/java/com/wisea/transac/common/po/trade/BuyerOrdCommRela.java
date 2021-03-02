package com.wisea.transac.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单列表的订单商品
 */
@ApiModel("订单商品")
public class BuyerOrdCommRela {

	@ApiModelProperty("订单id")
    private Long ordId;

	@ApiModelProperty("数量")
    private Integer count;

	@ApiModelProperty("单价")
    private Double price;

	@ApiModelProperty("商品名称")
    private String commName;

	@ApiModelProperty("订单商品id")
    private Long ordCommId;

	@ApiModelProperty("商品发布id")
    private Long commPubId;

	@ApiModelProperty("商品图片")
    private String commUrl;

	@ApiModelProperty(value = "所属量纲类型")
    private String dimensionsType;

    @ApiModelProperty("商品总重量")
    private Double commTotalWeight;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private String commSpec;
    @ApiModelProperty("单位重量单价")
    private Double unitWeightPrice;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getOrdCommId() {
        return ordCommId;
    }

    public void setOrdCommId(Long ordCommId) {
        this.ordCommId = ordCommId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public Double getCommTotalWeight() {
        return commTotalWeight;
    }

    public void setCommTotalWeight(Double commTotalWeight) {
        this.commTotalWeight = commTotalWeight;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public Double getUnitWeightPrice() {
        return unitWeightPrice;
    }

    public void setUnitWeightPrice(Double unitWeightPrice) {
        this.unitWeightPrice = unitWeightPrice;
    }
}
