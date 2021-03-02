package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("去支付详情页面vo")
public class TopayInfoVo {

    @ApiModelProperty(value="订单id")
    private Long ordId;
    @ApiModelProperty(value="账期支付（1，账期支付，空则没有账期支付, 2是账期金额不足）")
    private String payTypes;
    @ApiModelProperty(value="账期信息")
    private ApPayMageInfoVo apPayMage;
    @ApiModelProperty(value="商品总金额")
    private Double commTotalPrice;
    @ApiModelProperty(value="应付金额")
    private Double payableAmount;
    @ApiModelProperty(value="账期服务费金额")
    private Double zqSerCost;
    @ApiModelProperty(value="企业名称")
    private String entpName;

    public Long getOrdId() {
        return ordId;
    }
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }
    public String getPayTypes() {
        return payTypes;
    }
    public void setPayTypes(String payTypes) {
        this.payTypes = payTypes;
    }
    public ApPayMageInfoVo getApPayMage() {
        return apPayMage;
    }
    public void setApPayMage(ApPayMageInfoVo apPayMage) {
        this.apPayMage = apPayMage;
    }
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
    public Double getPayableAmount() {
        return payableAmount;
    }
    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }
    public Double getZqSerCost() {
        return zqSerCost;
    }
    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
