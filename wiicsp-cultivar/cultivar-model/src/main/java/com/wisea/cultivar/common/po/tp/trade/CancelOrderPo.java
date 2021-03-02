package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 取消订单PO
 */
@ApiModel("取消订单PO")
public class CancelOrderPo {
    @Check(test = "required")
    @ApiModelProperty("订单ID")
    private Long id;
    @Check(test = "required")
    @ApiModelProperty("订单取消原因ID")
    private Long ordCancelReasonId;
    @ApiModelProperty("操作备注")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdCancelReasonId() {
        return ordCancelReasonId;
    }

    public void setOrdCancelReasonId(Long ordCancelReasonId) {
        this.ordCancelReasonId = ordCancelReasonId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
