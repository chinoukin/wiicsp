package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 管理员今日统计Vo
 */
@ApiModel("管理员今日统计Vo")
public class AdminTodayStatisticsVo {
    @ApiModelProperty("订单总数")
    private Integer totalOrders;
    @ApiModelProperty("销售总额")
    private Double totalSales;
    @ApiModelProperty("今日订单总数")
    private Integer totalOrdersToday;
    @ApiModelProperty("今日销售总额")
    private Double totalSalesToday;

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getTotalOrdersToday() {
        return totalOrdersToday;
    }

    public void setTotalOrdersToday(Integer totalOrdersToday) {
        this.totalOrdersToday = totalOrdersToday;
    }

    public Double getTotalSalesToday() {
        return totalSalesToday;
    }

    public void setTotalSalesToday(Double totalSalesToday) {
        this.totalSalesToday = totalSalesToday;
    }
}
