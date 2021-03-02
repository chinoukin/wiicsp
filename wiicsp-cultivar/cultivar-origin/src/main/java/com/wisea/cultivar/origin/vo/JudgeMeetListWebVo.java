package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会管理列表
 *
 * @author wzx
 *
 */
@ApiModel("品鉴会管理列表VO")
public class JudgeMeetListWebVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value="品鉴会名称")
	private String judgeMeetName;
	@ApiModelProperty(value="主办单位")
	private String hostUnit;
	@ApiModelProperty(value="开始日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private OffsetDateTime startDate;//开始日期
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value="结束日期")
	private OffsetDateTime endDate;//结束日期
	@ApiModelProperty(value="开始时间")
	private String startTime;
	@ApiModelProperty(value="结束时间")
	private String endTime;
	@ApiModelProperty(value="地址")
	private String address;
	@ApiModelProperty(value="操作人")
	private String operator;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="操作时间")
	private OffsetDateTime operatDate;//操作时间

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJudgeMeetName() {
		return judgeMeetName;
	}
	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}
	public String getHostUnit() {
		return hostUnit;
	}
	public void setHostUnit(String hostUnit) {
		this.hostUnit = hostUnit;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public OffsetDateTime getOperatDate() {
		return operatDate;
	}
	public void setOperatDate(OffsetDateTime operatDate) {
		this.operatDate = operatDate;
	}


}
