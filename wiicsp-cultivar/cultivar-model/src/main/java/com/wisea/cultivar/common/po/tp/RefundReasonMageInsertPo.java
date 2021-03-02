package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * RefundReasonMageInsertPo
 * 2018/09/18 14:36:47
 */
public class RefundReasonMageInsertPo {
    /**
     * 序号
     */
    @Check(test = { "maxLength","required"}, mixLength = 32)
    @ApiModelProperty(value = "序号")
    private String serialNum;

    /**
     * 退款原因
     */
    @Check(test = { "maxLength" ,"required"}, mixLength = 100)
    @ApiModelProperty(value = "退款原因")
    private String refundReason;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取序号
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序号
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * 获取退款原因
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * 设置退款原因
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
