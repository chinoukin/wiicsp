package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 订单数量统计VO
 */
@ApiModel("订单数量统计VO")
public class OrderCountStatisticsVo {
    @ApiModelProperty("本月订单数量")
    private Integer thisMonthOrderCount;
    @ApiModelProperty("上月订单数量")
    private Integer lastMonthOrderCount;
    @ApiModelProperty("本周订单数量")
    private Integer thisWeekOrderCount;
    @ApiModelProperty("上周订单数量")
    private Integer lastWeekOrderCount;
    @ApiModelProperty("环比上周")
    private Integer ringRatioLastWeek;
    @ApiModelProperty("环比上月")
    private Integer ringRatioLastMonth;
    @ApiModelProperty("图表数据")
    private List<ChartVo> orderCountCharts;


    public Integer getThisMonthOrderCount() {
        return thisMonthOrderCount;
    }

    public void setThisMonthOrderCount(Integer thisMonthOrderCount) {
        this.thisMonthOrderCount = thisMonthOrderCount;
    }

    public Integer getLastMonthOrderCount() {
        return lastMonthOrderCount;
    }

    public void setLastMonthOrderCount(Integer lastMonthOrderCount) {
        this.lastMonthOrderCount = lastMonthOrderCount;
    }

    public Integer getThisWeekOrderCount() {
        return thisWeekOrderCount;
    }

    public void setThisWeekOrderCount(Integer thisWeekOrderCount) {
        this.thisWeekOrderCount = thisWeekOrderCount;
    }

    public Integer getLastWeekOrderCount() {
        return lastWeekOrderCount;
    }

    public void setLastWeekOrderCount(Integer lastWeekOrderCount) {
        this.lastWeekOrderCount = lastWeekOrderCount;
    }

    public List<ChartVo> getOrderCountCharts() {
        return orderCountCharts;
    }

    public void setOrderCountCharts(List<ChartVo> orderCountCharts) {
        this.orderCountCharts = orderCountCharts;
    }

    public Integer getRingRatioLastWeek() {
        return ringRatioLastWeek;
    }

    public void setRingRatioLastWeek(Integer ringRatioLastWeek) {
        this.ringRatioLastWeek = ringRatioLastWeek;
    }

    public Integer getRingRatioLastMonth() {
        return ringRatioLastMonth;
    }

    public void setRingRatioLastMonth(Integer ringRatioLastMonth) {
        this.ringRatioLastMonth = ringRatioLastMonth;
    }
}
