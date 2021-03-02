package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("采购商/供应商排名Vo")
public class CgsOrderVo {

    @ApiModelProperty(value="采购商/供应商电话")
    private String registTel;
    @ApiModelProperty(value="采购商/供应商名称")
    private String loginName;
    @ApiModelProperty(value="采购商/供应商名称")
    private String entpName;
    @ApiModelProperty(value="会员购物总金额")
    private Double ordAmount;
    @ApiModelProperty(value="会员有效订单总数")
    private Integer ordCount;

    public String getRegistTel() {
        return registTel;
    }
    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public Double getOrdAmount() {
        return ordAmount;
    }
    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }
    public Integer getOrdCount() {
        return ordCount;
    }
    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }
}
