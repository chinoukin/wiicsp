package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className YesterdayStatisticsVo
 * @date 2020/5/25 14:17
 * @Description 首页昨日交易统计Vo
 */
@ApiModel("首页昨日交易统计")
public class YesterdayStatisticsVo {
    @ApiModelProperty("昨日订单量")
    private Integer yesterdayOrdCount;
    @ApiModelProperty("昨日销售额")
    private Double yesterdaySales;
    @ApiModelProperty("昨日退单量")
    private Integer yesterdayRefundCount;
    @ApiModelProperty("昨日退款额")
    private Integer yesterdayRefund;

    public Integer getYesterdayOrdCount() {
        return yesterdayOrdCount;
    }

    public void setYesterdayOrdCount(Integer yesterdayOrdCount) {
        this.yesterdayOrdCount = yesterdayOrdCount;
    }

    public Double getYesterdaySales() {
        return yesterdaySales;
    }

    public void setYesterdaySales(Double yesterdaySales) {
        this.yesterdaySales = yesterdaySales;
    }

    public Integer getYesterdayRefundCount() {
        return yesterdayRefundCount;
    }

    public void setYesterdayRefundCount(Integer yesterdayRefundCount) {
        this.yesterdayRefundCount = yesterdayRefundCount;
    }

    public Integer getYesterdayRefund() {
        return yesterdayRefund;
    }

    public void setYesterdayRefund(Integer yesterdayRefund) {
        this.yesterdayRefund = yesterdayRefund;
    }
}
