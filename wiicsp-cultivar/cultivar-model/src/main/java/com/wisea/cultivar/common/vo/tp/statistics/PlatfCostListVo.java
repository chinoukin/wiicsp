package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @Description: 后台服务费统计信息
 * @author: wangs
 * @date :2018/11/30
 */
@ApiModel("后台服务费统计信息")
public class PlatfCostListVo {

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private String date;

    /**
     * 订单数量
     */
    @ApiModelProperty(value = "订单数量")
    private String orderCount;

    /**
     * 已完成订单服务费金额
     */
    @ApiModelProperty(value = "已完成订单服务费金额")
    private String platfCost;

    /**
     * 退货退款服务单数量
     */
    @ApiModelProperty(value = "退货退款服务单数量")
    private String returnAndRefunds;

    /**
     * 退货退款服务费金额
     */
    @ApiModelProperty(value = "退货退款服务费金额")
    private String returnAndRefundsPlatfCost;

    /**
     * 服务费金额小计
     */
    @ApiModelProperty(value = "服务费金额小计")
    private String platfCostTotal;

    /**
     * 服务费总计
     */
    @ApiModelProperty(value = "服务费总计")
    private Integer total;

    /**
     * 服务费总计信息及最大最小值
     */
    @ApiModelProperty("服务费总计信息及最大值最小值")
    private Map<String, Object> statePlatMap;

    public Map<String, Object> getStatePlatMap() {
        return statePlatMap;
    }

    public void setStatePlatMap(Map<String, Object> statePlatMap) {
        this.statePlatMap = statePlatMap;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(String platfCost) {
        this.platfCost = platfCost;
    }

    public String getReturnAndRefunds() {
        return returnAndRefunds;
    }

    public void setReturnAndRefunds(String returnAndRefunds) {
        this.returnAndRefunds = returnAndRefunds;
    }

    public String getReturnAndRefundsPlatfCost() {
        return returnAndRefundsPlatfCost;
    }

    public void setReturnAndRefundsPlatfCost(String returnAndRefundsPlatfCost) {
        this.returnAndRefundsPlatfCost = returnAndRefundsPlatfCost;
    }

    public String getPlatfCostTotal() {
        return platfCostTotal;
    }

    public void setPlatfCostTotal(String platfCostTotal) {
        this.platfCostTotal = platfCostTotal;
    }
}
