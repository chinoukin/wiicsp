package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/14 16:59
 */
public class PriceUpdateVo {
    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private String num;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private Double price;

    /**
     * 单位
     */
    @ApiModelProperty("单位")
    private String unit;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public PriceUpdateVo() {
    }

    public PriceUpdateVo(Double price, String unit) {
        this.price = price;
        this.unit = unit;
    }
}
