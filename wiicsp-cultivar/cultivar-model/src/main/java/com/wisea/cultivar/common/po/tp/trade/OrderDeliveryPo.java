package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className OrderDeliveryPo
 * @date 2019/4/19 16:36
 * @Description 订单提货PO
 */
@ApiModel("订单提货PO")
public class OrderDeliveryPo {
    @ApiModelProperty("订单ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("提货商品列表")
    @Check(test = "required", cascade = true)
    private List<OrderDeliveryCommPo> orderComms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDeliveryCommPo> getOrderComms() {
        return orderComms;
    }

    public void setOrderComms(List<OrderDeliveryCommPo> orderComms) {
        this.orderComms = orderComms;
    }
}
