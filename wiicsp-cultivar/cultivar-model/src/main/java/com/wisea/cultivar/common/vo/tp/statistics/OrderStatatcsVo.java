package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * 订单统计vo
 *
 * @author yangtao
 *
 */
public class OrderStatatcsVo {

    @ApiModelProperty("维度（后台数据，前台无需关注）")
    private String wd;

    @ApiModelProperty("订单总数（后台数据，前台无需关注）")
    private Integer ordCount;

    @ApiModelProperty("订单总额（后台数据，前台无需关注）")
    private Double ordMoney;

    @ApiModelProperty("有效订单总数")
    private Integer validCommRelaCount;

    @ApiModelProperty("有效订单总额")
    private Double validOrderAmount;

    @ApiModelProperty("无效订单总数")
    private Integer invalidCommRelaCount;

    @ApiModelProperty("无效订单总额")
    private Double invalidOrderAmount;

    @ApiModelProperty("已成交订单总数")
    private Integer totalCount;

    @ApiModelProperty("已成交订单总额")
    private Double totalAmount;

    @ApiModelProperty("销售总额")
    private Double totalAllAmount;

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }

    public Double getOrdMoney() {
        return ordMoney;
    }

    public void setOrdMoney(Double ordMoney) {
        this.ordMoney = ordMoney;
    }

    public Integer getInvalidCommRelaCount() {
        return invalidCommRelaCount;
    }

    public void setInvalidCommRelaCount(Integer invalidCommRelaCount) {
        this.invalidCommRelaCount = invalidCommRelaCount;
    }

    public Double getInvalidOrderAmount() {
        return invalidOrderAmount;
    }

    public void setInvalidOrderAmount(Double invalidOrderAmount) {
        this.invalidOrderAmount = invalidOrderAmount;
    }

    public Integer getValidCommRelaCount() {
        return validCommRelaCount;
    }

    public void setValidCommRelaCount(Integer validCommRelaCount) {
        this.validCommRelaCount = validCommRelaCount;
    }

    public Double getValidOrderAmount() {
        return validOrderAmount;
    }

    public void setValidOrderAmount(Double validOrderAmount) {
        this.validOrderAmount = validOrderAmount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAllAmount() {
        return totalAllAmount;
    }

    public void setTotalAllAmount(Double totalAllAmount) {
        this.totalAllAmount = totalAllAmount;
    }
}
