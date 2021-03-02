package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrdCommRefundRelaVo
 * @date 2020/5/9 16:23
 * @Description 退款商品信息vo
 */
@ApiModel("退款商品信息")
public class OrdCommRefundRelaVo {
    @ApiModelProperty("退货商品图片")
    private String commUrl;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("单价")
    private Double price;
    @ApiModelProperty("商量规格")
    private String commSpec;
    @ApiModelProperty("退货重量")
    private Double refundWeight;
    @ApiModelProperty("退货数量")
    private Integer count;
    @ApiModelProperty("计量单位名称")
    private String measUnitName;
    @ApiModelProperty("计量单位所属量纲类型")
    private String dimensionsType;
    @ApiModelProperty("商品金额小计")
    private Double totalCommAmount;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public Double getRefundWeight() {
        return refundWeight;
    }

    public void setRefundWeight(Double refundWeight) {
        this.refundWeight = refundWeight;
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

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }

    public Double getTotalCommAmount() {
        return totalCommAmount;
    }

    public void setTotalCommAmount(Double totalCommAmount) {
        this.totalCommAmount = totalCommAmount;
    }
}
