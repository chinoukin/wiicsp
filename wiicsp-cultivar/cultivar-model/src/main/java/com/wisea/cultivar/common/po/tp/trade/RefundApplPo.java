package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * RefundApplInsertPo
 * 2018/09/18 14:36:47
 */
public class RefundApplPo {

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "退款原因id(退货退款原因管理表id)")
    private Long refundReasonType;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "问题描述")
    private String refundDesc;

    /**
     * 获取订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

	/**
     * 获取退款原因id(退货退款原因管理表id)
     */
    public Long getRefundReasonType() {
        return refundReasonType;
    }

    /**
     * 设置退款原因id(退货退款原因管理表id)
     */
    public void setRefundReasonType(Long refundReasonType) {
        this.refundReasonType = refundReasonType;
    }

    /**
     * 获取问题描述
     */
    public String getRefundDesc() {
        return refundDesc;
    }

    /**
     * 设置问题描述
     */
    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc == null ? null : refundDesc.trim();
    }

}
