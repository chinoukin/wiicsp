package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrdCommRelaVo
 * @date 2020/4/30 14:02
 * @Description 订单商品Vo
 */
@ApiModel("订单商品vo")
public class OrdCommRelaVo {
    @ApiModelProperty("订单商品ID")
    private Long id;
    @ApiModelProperty("商品发布ID")
    private Long commPubId;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("购买数量")
    private Integer count;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private String commSpec;
    @ApiModelProperty("商品图片")
    private String commUrl;
    @ApiModelProperty("所属量纲类型")
    private String dimensionsType;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("净重")
    private Double netWeight;
    @ApiModelProperty("商品总重量")
    private Double commTotalWeight;
    @ApiModelProperty("单位重量单价")
    private Double unitWeightPrice;
    @ApiModelProperty("商品单价小计")
    private Double priceCount;
    @ApiModelProperty("退款申请ID，如果不为空，说明订单有退款")
    private Long refundApplId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
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

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
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

    public Double getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Double priceCount) {
        this.priceCount = priceCount;
    }

    public Long getRefundApplId() {
        return refundApplId;
    }

    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }
}
