package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 组装商品价格及成交金额
 * @author: wangs
 * @date :2020/5/11
 */
public class AssembyPriceVo {

    @ApiModelProperty("成交金额")
    private Double transactionAmount;

    @ApiModelProperty("销量")
    private Double salesVolumeTotal;

    @ApiModelProperty("库存量")
    private Integer avaiSupplyCountTotal;

    @ApiModelProperty("价格区间")
    private String priceRang;

    @ApiModelProperty("计量单位id")
    private List<Long> measUnitIds;

    public Integer getAvaiSupplyCountTotal() {
        return avaiSupplyCountTotal;
    }

    public void setAvaiSupplyCountTotal(Integer avaiSupplyCountTotal) {
        this.avaiSupplyCountTotal = avaiSupplyCountTotal;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Double getSalesVolumeTotal() {
        return salesVolumeTotal;
    }

    public void setSalesVolumeTotal(Double salesVolumeTotal) {
        this.salesVolumeTotal = salesVolumeTotal;
    }

    public String getPriceRang() {
        return priceRang;
    }

    public void setPriceRang(String priceRang) {
        this.priceRang = priceRang;
    }

    public void setMeasUnitIds(List<Long> measUnitIds) {
        this.measUnitIds = measUnitIds;
    }

    public List<Long> getMeasUnitIds() {
        return measUnitIds;
    }
}
