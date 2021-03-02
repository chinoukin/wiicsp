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
@ApiModel("买家查询账期列表vo")
public class BuyerSettleBillListVo {

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

    @ApiModelProperty(value = "结算单金额")
    private Double totalMoney;

    @ApiModelProperty(value = "应结总额")
    private Double totalAllMoney;

    @ApiModelProperty(value = "滞纳金")
    private Double lateFee;

    @ApiModelProperty(value = "滞纳金比例")
    private Double lateFeeBl;

    @ApiModelProperty(value = "是否逾期")
    private String sfYqFlag;

    @ApiModelProperty(value = "已逾期天数")
    private long yuqiDay;

    @ApiModelProperty(value = "商家名称")
    private String entpName;

    @ApiModelProperty(value = "最晚付款日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime lastPayDate;

    @ApiModelProperty(value = "当前时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime nowTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSfYqFlag() {
		return sfYqFlag;
	}

	public void setSfYqFlag(String sfYqFlag) {
		this.sfYqFlag = sfYqFlag;
	}

	public long getYuqiDay() {
		return yuqiDay;
	}

	public void setYuqiDay(long yuqiDay) {
		this.yuqiDay = yuqiDay;
	}

	public Double getLateFee() {
		return lateFee;
	}

	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}

	public Double getLateFeeBl() {
		return lateFeeBl;
	}

	public void setLateFeeBl(Double lateFeeBl) {
		this.lateFeeBl = lateFeeBl;
	}

	public Double getTotalAllMoney() {
		return totalAllMoney;
	}

	public void setTotalAllMoney(Double totalAllMoney) {
		this.totalAllMoney = totalAllMoney;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
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

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
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
}
