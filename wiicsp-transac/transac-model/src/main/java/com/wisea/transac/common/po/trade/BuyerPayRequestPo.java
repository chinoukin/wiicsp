package com.wisea.transac.common.po.trade;

import javax.validation.constraints.NotNull;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家支付PO
 *
 * @author yangtao
 */
@ApiModel("买家端订单支付po")
public class BuyerPayRequestPo {

    @ApiModelProperty(value = "单个订单支付时是订单id，多个用逗号拼接；账期结算单时为账期id")
    @NotNull
    @Check(test = "required")
    private Long orderId;

    @ApiModelProperty(value = "是否账期支付，0：否  1：是")
    @NotNull
    private String ifSettlePay;

    /*
     * @ApiModelProperty(value = "支付类型，支付宝1，微信2，银联3")
     *
     * @NotNull private String payType;
     */

    @ApiModelProperty(value = "交易类型（5-亿企通网站支付，6-亿企通微信小程序支付）")
    @NotNull
    private String tranType;
    /**
     * 用户标识(当支付渠道为微信小程序支付时需要指定)
     */
    private String openid;

    /**
     * 支付金额（账期多次支付时必传）
     */
    @Check(test = "logic", logic = "'1'.equals(#ifSettlePay)?#isNotEmpty(#payAmount):true", logicMsg = "支付标识不能为空")
    private Double payAmount;

    @NotNull
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotNull Long orderId) {
        this.orderId = orderId;
    }

    /*
     * public String getPayType() { return payType; }
     *
     * public void setPayType(String payType) { this.payType = payType; }
     */

    public String getIfSettlePay() {
		return ifSettlePay;
	}

	public void setIfSettlePay(String ifSettlePay) {
		this.ifSettlePay = ifSettlePay;
	}

	public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }
}
