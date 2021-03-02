package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @version 1.0
 * @className KdniaoQueryPo
 * @since 2019-03-08 16:02
 */
@ApiModel(value = "快递鸟即时查询参数")
public class KdniaoQueryPo {


    /**
     * OrderCode :
     * ShipperCode : ANE
     * LogisticCode : 210001633605
     */
    @ApiModelProperty("订单编号")
    private String orderCode;

    @ApiModelProperty(value = "快递公司编码",required = true)
    @Check(test = "required")
    private String shipperCode;

    @ApiModelProperty(value = "物流单号",required = true)
    @Check(test = "required")
    private String logisticCode;

    @ApiModelProperty(value = "手机后四位（寄件人或收件人）顺丰快递必传",required = true)
    private String customerName;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
