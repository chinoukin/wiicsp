package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单统计Vo")
public class StatisOrderVo {

    @ApiModelProperty(value="有效订单数")
    private Integer effOrdCount;
    @ApiModelProperty(value="有效订单总额")
    private Double effOrdAmount;
    @ApiModelProperty(value="无效订单数")
    private Integer notEffOrdCount;
    @ApiModelProperty(value="无效订单总额")
    private Double notEffOrdAmount;
    @ApiModelProperty(value="已完成订单数")
    private Integer overOrdCount;
    @ApiModelProperty(value="已完成订单总额")
    private Double overOrdAmount;
    @ApiModelProperty(value="订单总额")
    private Double totalOrdAmount;
    @ApiModelProperty(value="订单状态", hidden = true)
    private String orderStateType;
    @ApiModelProperty(value="下单人数", hidden = true)
    private Integer effMembCount;
    @ApiModelProperty(value="下单商品数量", hidden = true)
    private Integer effCommCount;

    public Integer getEffOrdCount() {
        return effOrdCount;
    }
    public void setEffOrdCount(Integer effOrdCount) {
        this.effOrdCount = effOrdCount;
    }
    public Double getEffOrdAmount() {
        return effOrdAmount;
    }
    public void setEffOrdAmount(Double effOrdAmount) {
        this.effOrdAmount = effOrdAmount;
    }
    public Integer getNotEffOrdCount() {
        return notEffOrdCount;
    }
    public void setNotEffOrdCount(Integer notEffOrdCount) {
        this.notEffOrdCount = notEffOrdCount;
    }
    public Double getNotEffOrdAmount() {
        return notEffOrdAmount;
    }
    public void setNotEffOrdAmount(Double notEffOrdAmount) {
        this.notEffOrdAmount = notEffOrdAmount;
    }
    public Integer getOverOrdCount() {
        return overOrdCount;
    }
    public void setOverOrdCount(Integer overOrdCount) {
        this.overOrdCount = overOrdCount;
    }
    public Double getOverOrdAmount() {
        return overOrdAmount;
    }
    public void setOverOrdAmount(Double overOrdAmount) {
        this.overOrdAmount = overOrdAmount;
    }
    public Double getTotalOrdAmount() {
        return totalOrdAmount;
    }
    public void setTotalOrdAmount(Double totalOrdAmount) {
        this.totalOrdAmount = totalOrdAmount;
    }
    public String getOrderStateType() {
        return orderStateType;
    }
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }
    public Integer getEffMembCount() {
        return effMembCount;
    }
    public void setEffMembCount(Integer effMembCount) {
        this.effMembCount = effMembCount;
    }
    public Integer getEffCommCount() {
        return effCommCount;
    }
    public void setEffCommCount(Integer effCommCount) {
        this.effCommCount = effCommCount;
    }
}
