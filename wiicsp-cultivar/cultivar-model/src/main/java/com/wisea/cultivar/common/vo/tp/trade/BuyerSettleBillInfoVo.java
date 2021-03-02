package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author yangtao
 *
 */
@ApiModel("买家查询账期详情vo")
public class BuyerSettleBillInfoVo {

	@ApiModelProperty(value = "账期id")
    private Long id;

    @ApiModelProperty(value = "卖方id")
    private Long sellerId;

    @ApiModelProperty(value = "买方id")
    private Long buyerId;

    @ApiModelProperty(value = "结算单号")
    private String settleBillNumb;

    @ApiModelProperty(value = "结算周期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime settleCycleStartDate;

    @ApiModelProperty(value = "结算周期结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime settleCycleEndDate;

    @ApiModelProperty(value = "账期类型")
    private String settleCycleType;

    @ApiModelProperty(value = "订单数")
    private Integer ordCount;

    @ApiModelProperty(value = "结算单状态")
    private String settleBillStatueType;

    @ApiModelProperty(value = "应结总额")
    private Double totalMoney;

    @ApiModelProperty(value = "采购商名称")
    private String buyerName;

    @ApiModelProperty(value = "最晚付款日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime lastPayDate;

    @ApiModelProperty(value = "当前时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime nowTime;

    @ApiModelProperty(value = "账单生成日")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime createDate;

    @ApiModelProperty(value = "商家结算总额")
    private String settleOrdCount;

    @ApiModelProperty(value = "服务单数")
    private String serverCount;

    @ApiModelProperty(value = "退款总额")
    private String serVerOrdCount;

    @ApiModelProperty(value = "可开票金额")
    private String invoMoneyCount;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getSettleBillNumb() {
		return settleBillNumb;
	}

	public void setSettleBillNumb(String settleBillNumb) {
		this.settleBillNumb = settleBillNumb;
	}

	public OffsetDateTime getSettleCycleStartDate() {
		return settleCycleStartDate;
	}

	public void setSettleCycleStartDate(OffsetDateTime settleCycleStartDate) {
		this.settleCycleStartDate = settleCycleStartDate;
	}

	public OffsetDateTime getSettleCycleEndDate() {
		return settleCycleEndDate;
	}

	public void setSettleCycleEndDate(OffsetDateTime settleCycleEndDate) {
		this.settleCycleEndDate = settleCycleEndDate;
	}

	public String getSettleCycleType() {
		return settleCycleType;
	}

	public void setSettleCycleType(String settleCycleType) {
		this.settleCycleType = settleCycleType;
	}

	public Integer getOrdCount() {
		return ordCount;
	}

	public void setOrdCount(Integer ordCount) {
		this.ordCount = ordCount;
	}

	public String getSettleBillStatueType() {
		return settleBillStatueType;
	}

	public void setSettleBillStatueType(String settleBillStatueType) {
		this.settleBillStatueType = settleBillStatueType;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public OffsetDateTime getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(OffsetDateTime lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	public OffsetDateTime getNowTime() {
		return nowTime;
	}

	public void setNowTime(OffsetDateTime nowTime) {
		this.nowTime = nowTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSettleOrdCount() {
		return settleOrdCount;
	}

	public void setSettleOrdCount(String settleOrdCount) {
		this.settleOrdCount = settleOrdCount;
	}

	public String getServerCount() {
		return serverCount;
	}

	public void setServerCount(String serverCount) {
		this.serverCount = serverCount;
	}

	public String getSerVerOrdCount() {
		return serVerOrdCount;
	}

	public void setSerVerOrdCount(String serVerOrdCount) {
		this.serVerOrdCount = serVerOrdCount;
	}

	public String getInvoMoneyCount() {
		return invoMoneyCount;
	}

	public void setInvoMoneyCount(String invoMoneyCount) {
		this.invoMoneyCount = invoMoneyCount;
	}
}
