package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author jirg
 * @version 1.0
 * @className TotalOrderSales
 * @date 2019/12/9 15:48
 * @Description 国内外订单销售总额Vo
 */
@ApiModel(value = "国内外订单销售总额Vo")
public class TotalOrderSalesVo implements Serializable {

    @ApiModelProperty("年份")
    private String year;
    @ApiModelProperty("国内订单销售总额")
    private Double domesticTotalOrderSales;
    @ApiModelProperty("国外订单销售总额")
    private Double foreignTotalOrderSales;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getDomesticTotalOrderSales() {
        return domesticTotalOrderSales;
    }

    public void setDomesticTotalOrderSales(Double domesticTotalOrderSales) {
        this.domesticTotalOrderSales = domesticTotalOrderSales;
    }

    public Double getForeignTotalOrderSales() {
        return foreignTotalOrderSales;
    }

    public void setForeignTotalOrderSales(Double foreignTotalOrderSales) {
        this.foreignTotalOrderSales = foreignTotalOrderSales;
    }
}
