package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className TotalSalesVo
 * @date 2019/12/9 16:26
 * @Description 国内外销售总额Vo
 */
@ApiModel("国内外销售总额Vo")
public class TotalSalesVo {
    @ApiModelProperty("年份")
    private String year;
    @ApiModelProperty("销售总额")
    private Double totalSales;
    @ApiModelProperty("国内产地总销售额")
    private Double domesticTotalSales;
    @ApiModelProperty("国外进口总销售额")
    private Double foreignTotalSales;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Double getDomesticTotalSales() {
        return domesticTotalSales;
    }

    public void setDomesticTotalSales(Double domesticTotalSales) {
        this.domesticTotalSales = domesticTotalSales;
    }

    public Double getForeignTotalSales() {
        return foreignTotalSales;
    }

    public void setForeignTotalSales(Double foreignTotalSales) {
        this.foreignTotalSales = foreignTotalSales;
    }
}
