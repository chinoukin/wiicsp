package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundCommApplListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家端查询退货退款申请列表PO
 */
@ApiModel("买家端查询退货退款申请列表PO")
public class BuyerRefundCommApplListPo extends PagePo<BuyerRefundCommApplListVo> {

    @ApiModelProperty("退货退款申请状态")
    private String refundCommState;
    @ApiModelProperty("输入搜索内容")
    private String searchKey;
    @ApiModelProperty("日期查询（0是三个月，1是三个月之前）")
    private String timeKey;
    @ApiModelProperty("开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("买家ID")
    private Long buyerId;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("账期结算单ID（账期结算单详情查询退货列表是传入）")
    private Long settleId;
    @ApiModelProperty("卖家账期结算单查询时输入搜索内容")
    private String quereKey;

	public String getRefundCommState() {
		return refundCommState;
	}
	public void setRefundCommState(String refundCommState) {
		this.refundCommState = refundCommState;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getQuereKey() {
		return quereKey;
	}
	public void setQuereKey(String quereKey) {
		this.quereKey = quereKey;
	}
	public String getTimeKey() {
		return timeKey;
	}
	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
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
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getSettleId() {
		return settleId;
	}
	public void setSettleId(Long settleId) {
		this.settleId = settleId;
	}
}
