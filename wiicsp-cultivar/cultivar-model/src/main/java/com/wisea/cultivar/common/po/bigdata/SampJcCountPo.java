package com.wisea.cultivar.common.po.bigdata;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 样品检测统计PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月12日
 * @version 1.0
 */
public class SampJcCountPo {

	@ApiModelProperty("开始时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime startDate;

	@ApiModelProperty("结束时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime endDate;
	@ApiModelProperty("数据类型(0:企业自检1:送检,空表示查询所有)")
	private String type;
	@ApiModelProperty(value="要查询的节点的父节点编码",hidden=true)
	private String parentCode;

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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
