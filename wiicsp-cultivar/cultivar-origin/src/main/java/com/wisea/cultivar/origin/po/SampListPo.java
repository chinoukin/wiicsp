package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.origin.vo.SampListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *样品列表PO
 * @author wzx
 *
 */
@ApiModel("样品列表PO")
public class SampListPo extends PagePo<SampListVo> {

	private static final long serialVersionUID = 2758180049918822899L;

	@ApiModelProperty(value = "产品名称或企业名称")
	private String name;
	@ApiModelProperty(value = "样品类别")
	private String sampCatgType;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "开始时间")
	private OffsetDateTime staDate; // 开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "结束时间")
	private OffsetDateTime endDate; // 结束时间
	@ApiModelProperty(value = "样品状态")
	private String sampStateType;
	@ApiModelProperty(value = "品鉴会ID")
	private String judgeMeetId;
	@ApiModelProperty(value = "采样人ID", hidden=true)
	private Long sampTakerId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSampCatgType() {
		return sampCatgType;
	}
	public void setSampCatgType(String sampCatgType) {
		this.sampCatgType = sampCatgType;
	}
	public OffsetDateTime getStaDate() {
		return staDate;
	}
	public void setStaDate(OffsetDateTime staDate) {
		this.staDate = staDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
	}
	public String getJudgeMeetId() {
		return judgeMeetId;
	}
	public void setJudgeMeetId(String judgeMeetId) {
		this.judgeMeetId = judgeMeetId;
	}
	public Long getSampTakerId() {
		return sampTakerId;
	}
	public void setSampTakerId(Long sampTakerId) {
		this.sampTakerId = sampTakerId;
	}


}
