package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ServiceFeeDayVo
 * @date 2020/5/25 16:05
 * @Description
 */
public class ServiceFeeDayVo {
    @ApiModelProperty("日期")
    private String dayOfMonth;
    @ApiModelProperty("商家数量")
    private Integer sellerCount;
    @ApiModelProperty("采购商数量")
    private Integer buyerCount;
    @ApiModelProperty("商家数量")
    private Integer platfCostCount;
    @ApiModelProperty("服务费金额")
    private Double platfCostTotal;

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getSellerCount() {
        return sellerCount;
    }

    public void setSellerCount(Integer sellerCount) {
        this.sellerCount = sellerCount;
    }

    public Integer getBuyerCount() {
        return buyerCount;
    }

    public void setBuyerCount(Integer buyerCount) {
        this.buyerCount = buyerCount;
    }

    public Integer getPlatfCostCount() {
        return platfCostCount;
    }

    public void setPlatfCostCount(Integer platfCostCount) {
        this.platfCostCount = platfCostCount;
    }

    public Double getPlatfCostTotal() {
        return platfCostTotal;
    }

    public void setPlatfCostTotal(Double platfCostTotal) {
        this.platfCostTotal = platfCostTotal;
    }
}
