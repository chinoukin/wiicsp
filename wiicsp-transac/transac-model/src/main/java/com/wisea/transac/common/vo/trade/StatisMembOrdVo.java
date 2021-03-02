package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("会员统计Vo")
public class StatisMembOrdVo {

    @ApiModelProperty(value="会员总数")
    private Integer membCount;
    @ApiModelProperty(value="有订单会员总数")
    private Integer membOrdCount;
    @ApiModelProperty(value="会员订单总数")
    private Integer ordCount;
    @ApiModelProperty(value="会员购物总金额")
    private Double ordAmount;
    @ApiModelProperty(value="每个会员订单数")
    private Double overOrdCount;
    @ApiModelProperty(value="每个会员购物金额")
    private Double overOrdAmount;

    public Integer getMembCount() {
        return membCount;
    }
    public void setMembCount(Integer membCount) {
        this.membCount = membCount;
    }
    public Integer getMembOrdCount() {
        return membOrdCount;
    }
    public void setMembOrdCount(Integer membOrdCount) {
        this.membOrdCount = membOrdCount;
    }
    public Integer getOrdCount() {
        return ordCount;
    }
    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }
    public Double getOrdAmount() {
        return ordAmount;
    }
    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }
    public Double getOverOrdCount() {
        return overOrdCount;
    }
    public void setOverOrdCount(Double overOrdCount) {
        this.overOrdCount = overOrdCount;
    }
    public Double getOverOrdAmount() {
        return overOrdAmount;
    }
    public void setOverOrdAmount(Double overOrdAmount) {
        this.overOrdAmount = overOrdAmount;
    }
}
