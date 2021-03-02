package com.wisea.transac.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家端服务单列表商品信息vo")
public class BuyerRefundCommRelaVo {

    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "商品图片")
    private String commUrl;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单商品id")
    private Long ordCommRelaId;
    @ApiModelProperty("商品发布ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long commPubId;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private String commSpec;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("净重")
    private Double netWeight;
    @ApiModelProperty("商品总重量")
    private Double commTotalWeight;
    @ApiModelProperty("单位重量单价")
    private Double unitWeightPrice;

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getCommUrl() {
        return commUrl;
    }
    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }
    public Long getOrdCommRelaId() {
        return ordCommRelaId;
    }
    public void setOrdCommRelaId(Long ordCommRelaId) {
        this.ordCommRelaId = ordCommRelaId;
    }
    public Long getCommPubId() {
        return commPubId;
    }
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }
    public String getCommName() {
        return commName;
    }
    public void setCommName(String commName) {
        this.commName = commName;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getNetWeight() {
        return netWeight;
    }
    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
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
}
