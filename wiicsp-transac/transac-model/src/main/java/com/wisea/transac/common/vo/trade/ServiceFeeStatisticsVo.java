package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ServiceFeeStatisticsVo
 * @date 2020/5/25 15:56
 * @Description
 */
public class ServiceFeeStatisticsVo {
    @ApiModelProperty("服务费总金额")
    private Double platfCostTotal;
    @ApiModelProperty("服务费总金额")
    private Double platfCostCounr;
    @ApiModelProperty("折线图数据列表")
    private List<LineChartVo> lineCharts;
    @ApiModelProperty("每日服务费统计列表")
    private List<ServiceFeeDayVo> serviceFeeDayList;

    public Double getPlatfCostTotal() {
        return platfCostTotal;
    }

    public void setPlatfCostTotal(Double platfCostTotal) {
        this.platfCostTotal = platfCostTotal;
    }

    public Double getPlatfCostCounr() {
        return platfCostCounr;
    }

    public void setPlatfCostCounr(Double platfCostCounr) {
        this.platfCostCounr = platfCostCounr;
    }
}
