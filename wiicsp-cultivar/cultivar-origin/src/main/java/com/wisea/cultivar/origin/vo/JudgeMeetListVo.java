package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会列表
 *
 * @author wzx
 *
 */
@ApiModel("品鉴会列表VO")
public class JudgeMeetListVo {
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
	@ApiModelProperty(value="状态 （ 1 即将开始 2 正在进行 3 已结束）")
	private String jxtype;
	@ApiModelProperty(value="参会样品数")
	private String amount;
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
	public String getJxtype() {
		return jxtype;
	}
	public void setJxtype(String jxtype) {
		this.jxtype = jxtype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
