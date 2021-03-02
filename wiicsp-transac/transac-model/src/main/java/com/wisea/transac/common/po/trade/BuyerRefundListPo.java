package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.BuyerRefundListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerRefundListPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表po")
public class BuyerRefundListPo extends PagePo<BuyerRefundListVo>{

    @ApiModelProperty(value = "退款申请状态类型")
    private String refundApplStateType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID", hidden = true)
    private Long buyerId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "采购员ID", hidden = true)
    private Long purchaseId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单ID", hidden = true)
    private Long orderId;
    @ApiModelProperty(value = "查询条件（商品名称，服务单号，订单编号，下单人）")
    private String searchKey;

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getRefundApplStateType() {
        return refundApplStateType;
    }
    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }
    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
