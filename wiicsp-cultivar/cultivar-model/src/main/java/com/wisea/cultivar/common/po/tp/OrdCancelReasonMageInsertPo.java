package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrdCancelReasonMageInsertPo
 * 2018/10/10 14:42:38
 */
public class OrdCancelReasonMageInsertPo {
    /**
     * 编号
     */
    @Check(test = { "maxLength","required" }, mixLength = 10)
    @ApiModelProperty(value = "编号")
    private String num;

    /**
     * 订单取消原因
     */
    @Check(test = { "maxLength","required" }, mixLength = 100)
    @ApiModelProperty(value = "订单取消原因")
    private String ordCancelReason;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取订单取消原因
     */
    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    /**
     * 设置订单取消原因
     */
    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason == null ? null : ordCancelReason.trim();
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
