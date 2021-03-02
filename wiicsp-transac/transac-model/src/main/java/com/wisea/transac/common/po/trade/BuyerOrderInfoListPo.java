package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.BuyerOrderInfoListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表po")
public class BuyerOrderInfoListPo extends PagePo<BuyerOrderInfoListVo>{

    @ApiModelProperty(value = "订单状态类型(多状态可拼串，如 1,2,3)")
    private String orderStateType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID", hidden = true)
    private Long buyerId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID", hidden = true)
    private Long purchaseId;
    @ApiModelProperty(value = "订单ids")
    private String ordIds;
    @ApiModelProperty(value = "查询条件（商品名称，商家名称，商家档口，订单编号，下单人）")
    private String searchKey;
    @ApiModelProperty(value = "交易模式类型")
    private String transType;

    public String getOrderStateType() {
        return orderStateType;
    }
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }
    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getOrdIds() {
        return ordIds;
    }
    public void setOrdIds(String ordIds) {
        this.ordIds = ordIds;
    }
    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
