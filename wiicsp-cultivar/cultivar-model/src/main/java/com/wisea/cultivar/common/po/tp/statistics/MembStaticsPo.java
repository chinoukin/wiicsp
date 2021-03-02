package com.wisea.cultivar.common.po.tp.statistics;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员统计po
 * @author yangtao
 *
 */
@ApiModel("会员统计po")
public class MembStaticsPo {

	@ApiModelProperty(value = "查询日期类型 0：按月，1：按年")
	@Check(test = "required", requiredMsg = "查询日期类型不能为空")
	private String timekey;
	@ApiModelProperty(value = "查询日期（按月格式“2018—12”，按年格式“2018”）日期格式")
	@Check(test = "required", requiredMsg = "查询日期不能为空")
	private String querDate;
	@ApiModelProperty(value = "开始时间", hidden = true)
    private OffsetDateTime timeStart;
    @ApiModelProperty(value = "结束时间", hidden = true)
    private OffsetDateTime timeEnd;
    @ApiModelProperty(value = "分段标准", hidden = true)
	private Double payAmount;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID", hidden = true)
    private Long sellerId;

	public String getTimekey() {
		return timekey;
	}
	public void setTimekey(String timekey) {
		this.timekey = timekey;
	}
	public String getQuerDate() {
		return querDate;
	}
	public void setQuerDate(String querDate) {
		this.querDate = querDate;
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
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
