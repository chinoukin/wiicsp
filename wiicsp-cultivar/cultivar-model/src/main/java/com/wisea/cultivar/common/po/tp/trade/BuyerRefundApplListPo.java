package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundApplListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家查询退款申请列表PO
 */
@ApiModel("买家查询退款申请列表PO")
public class BuyerRefundApplListPo extends PagePo<BuyerRefundApplListVo> {

    @ApiModelProperty("退款申请状态")
    private String refundApplStateType;
    @ApiModelProperty("开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("输入搜索内容")
    private String searchKey;
    @ApiModelProperty("日期查询(0三个月，1三个月之前)")
    private String timeKey;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty(value = "订单ids", hidden = true)
    private String ordIds;

	public String getRefundApplStateType() {
		return refundApplStateType;
	}
	public void setRefundApplStateType(String refundApplStateType) {
		this.refundApplStateType = refundApplStateType;
	}
	public OffsetDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
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
}
