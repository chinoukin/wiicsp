package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 批量发货PO
 */
@ApiModel("批量发货PO")
public class BatchOrderDelivePo {
    @Check(test = "required", cascade = true)
    @ApiModelProperty("订单发货Po列表")
    private List<OrderDelivePo> orderDelivePos;

    public List<OrderDelivePo> getOrderDelivePos() {
        return orderDelivePos;
    }

    public void setOrderDelivePos(List<OrderDelivePo> orderDelivePos) {
        this.orderDelivePos = orderDelivePos;
    }
}
