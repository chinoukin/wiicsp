package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 销售金额统计VO
 */
@ApiModel("销售金额统计VO")
public class OrderAmounStatisticsVo {
    @ApiModelProperty("本月订单数量")
    private Double thisMonthOrderAmoun;
    @ApiModelProperty("上月订单数量")
    private Double lastMonthOrderAmoun;
    @ApiModelProperty("本周订单数量")
    private Double thisWeekOrderAmoun;
    @ApiModelProperty("上周订单数量")
    private Double lastWeekOrderAmoun;
    @ApiModelProperty("环比上周")
    private Integer ringRatioLastWeek;
    @ApiModelProperty("环比上月")
    private Integer ringRatioLastMonth;

    @ApiModelProperty("图表数据")
    private List<ChartVo> orderAmounCharts;

    public Double getThisMonthOrderAmoun() {
        return thisMonthOrderAmoun;
    }

    public void setThisMonthOrderAmoun(Double thisMonthOrderAmoun) {
        this.thisMonthOrderAmoun = thisMonthOrderAmoun;
    }

    public Double getLastMonthOrderAmoun() {
        return lastMonthOrderAmoun;
    }

    public void setLastMonthOrderAmoun(Double lastMonthOrderAmoun) {
        this.lastMonthOrderAmoun = lastMonthOrderAmoun;
    }

    public Double getThisWeekOrderAmoun() {
        return thisWeekOrderAmoun;
    }

    public void setThisWeekOrderAmoun(Double thisWeekOrderAmoun) {
        this.thisWeekOrderAmoun = thisWeekOrderAmoun;
    }

    public Double getLastWeekOrderAmoun() {
        return lastWeekOrderAmoun;
    }

    public void setLastWeekOrderAmoun(Double lastWeekOrderAmoun) {
        this.lastWeekOrderAmoun = lastWeekOrderAmoun;
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

    public List<ChartVo> getOrderAmounCharts() {
        return orderAmounCharts;
    }

    public void setOrderAmounCharts(List<ChartVo> orderAmounCharts) {
        this.orderAmounCharts = orderAmounCharts;
    }
}
