package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户排行vo
 *
 * @author yangtao
 *
 */
@ApiModel("用户排行vo")
public class BuyerTopNumVo {

    @ApiModelProperty(value = "序号")
    private String sort;
    @ApiModelProperty(value = "用户账号")
    private String userName;
    @ApiModelProperty(value = "用户昵称/企业名称")
    private String buyerCompName;
    @ApiModelProperty(value = "订单数")
    private Double ordCount;
    @ApiModelProperty(value = "购物金额")
    private Double ordMoney;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuyerCompName() {
        return buyerCompName;
    }

    public void setBuyerCompName(String buyerCompName) {
        this.buyerCompName = buyerCompName;
    }

    public Double getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Double ordCount) {
        this.ordCount = ordCount;
    }

    public Double getOrdMoney() {
        return ordMoney;
    }

    public void setOrdMoney(Double ordMoney) {
        this.ordMoney = ordMoney;
    }
}
