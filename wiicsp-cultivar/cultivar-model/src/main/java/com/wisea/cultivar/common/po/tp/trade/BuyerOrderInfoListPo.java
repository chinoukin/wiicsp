package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerOrderInfoListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表po")
public class BuyerOrderInfoListPo extends PagePo<BuyerOrderInfoListVo>{

    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID", hidden = true)
    private Long buyerId;
    @ApiModelProperty(value = "订单ids")
    private String ordIds;
    @ApiModelProperty(value = "查询条件（商品名称，商品编号，订单编号）")
    private String searchKey;
    @ApiModelProperty(value = "订单id")
    private Long id;
    @ApiModelProperty(value = "日期查询条件(订单列表时，传日期下拉选的值；售后列表时，近三个月传0，三个月之前传1；小程序不传)")
    private String timeKey;
    @ApiModelProperty(value = "开始时间", hidden = true)
    private OffsetDateTime timeStart;
    @ApiModelProperty(value = "结束时间", hidden = true)
    private OffsetDateTime timeEnd;
    @ApiModelProperty(value = "支付方式类型")
    private String payMethodType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getTimeKey() {
		return timeKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public OffsetDateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(OffsetDateTime timeStart) {
		this.timeStart = timeStart;
	}

	public OffsetDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(OffsetDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
}
