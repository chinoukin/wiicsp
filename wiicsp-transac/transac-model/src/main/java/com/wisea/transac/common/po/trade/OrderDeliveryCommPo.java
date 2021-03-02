package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrderDeliveryCommPo
 * @date 2019/4/19 16:38
 * @Description 提货商品PO
 */
@ApiModel("提货商品PO")
public class OrderDeliveryCommPo {
    @ApiModelProperty("订单商品ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("提货件数")
    private Integer deliveryCount;
    @ApiModelProperty("提货数量")
    @Check(test = "required")
    private Double deliveryTotalWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(Integer deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public Double getDeliveryTotalWeight() {
        return deliveryTotalWeight;
    }

    public void setDeliveryTotalWeight(Double deliveryTotalWeight) {
        this.deliveryTotalWeight = deliveryTotalWeight;
    }
}
