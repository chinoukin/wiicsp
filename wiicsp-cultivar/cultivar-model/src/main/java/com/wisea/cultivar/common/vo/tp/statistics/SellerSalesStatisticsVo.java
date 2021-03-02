package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 卖家近几日销售统计
 */
@ApiModel("卖家近几日销售统计")
public class SellerSalesStatisticsVo {
    @ApiModelProperty("今日订单总数")
    private Integer orderCount;
    @ApiModelProperty("今日销售总额")
    private Double todayOrderAmountCount;
    @ApiModelProperty("昨日销售总额")
    private Double testerdayOrderAmountCount;
    @ApiModelProperty("近七天销售总额")
    private Double sevenDaysOrderAmountCount;

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Double getTodayOrderAmountCount() {
        return todayOrderAmountCount;
    }

    public void setTodayOrderAmountCount(Double todayOrderAmountCount) {
        this.todayOrderAmountCount = todayOrderAmountCount;
    }

    public Double getTesterdayOrderAmountCount() {
        return testerdayOrderAmountCount;
    }

    public void setTesterdayOrderAmountCount(Double testerdayOrderAmountCount) {
        this.testerdayOrderAmountCount = testerdayOrderAmountCount;
    }

    public Double getSevenDaysOrderAmountCount() {
        return sevenDaysOrderAmountCount;
    }

    public void setSevenDaysOrderAmountCount(Double sevenDaysOrderAmountCount) {
        this.sevenDaysOrderAmountCount = sevenDaysOrderAmountCount;
    }
}
