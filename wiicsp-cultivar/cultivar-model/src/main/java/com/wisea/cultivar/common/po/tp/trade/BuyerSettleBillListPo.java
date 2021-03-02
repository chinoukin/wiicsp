package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerSettleBillListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("买家查询账期列表po")
public class BuyerSettleBillListPo extends PagePo<BuyerSettleBillListVo> {

	@ApiModelProperty(value = "近三个月0,三个月之前1")
	private String timeKey;

	@ApiModelProperty(value = "查询条件")
	private String searchKey;

	@ApiModelProperty(value = "结算单状态")
	private String settleBillStatueType;

	@ApiModelProperty(value = "订单的ID", hidden= true)
	private Long buyerId;

	@ApiModelProperty(value = "开始日期", hidden= true)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime startTime;

	@ApiModelProperty(value = "结束日期", hidden= true)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime endTime;

	public String getTimeKey() {
		return timeKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSettleBillStatueType() {
		return settleBillStatueType;
	}

	public void setSettleBillStatueType(String settleBillStatueType) {
		this.settleBillStatueType = settleBillStatueType;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public OffsetDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(OffsetDateTime endTime) {
		this.endTime = endTime;
	}
}
