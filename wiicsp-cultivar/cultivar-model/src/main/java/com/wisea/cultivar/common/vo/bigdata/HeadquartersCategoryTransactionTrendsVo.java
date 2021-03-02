package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersCategoryTransactionTrendsVo
 * @date 2019/12/6 14:26
 * @Description 国内/国外品类交易走势分析Vo
 */
@ApiModel(value = "国内/国外品类交易走势分析Vo")
public class HeadquartersCategoryTransactionTrendsVo {
    @ApiModelProperty("年份或月份")
    private String yearOrMonth;
    @ApiModelProperty("销售金额")
    private Double salesAmount;
    @ApiModelProperty("销售数量")
    private Double salesCount;

    public String getYearOrMonth() {
        return yearOrMonth;
    }

    public void setYearOrMonth(String yearOrMonth) {
        this.yearOrMonth = yearOrMonth;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Double getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Double salesCount) {
        this.salesCount = salesCount;
    }
}
