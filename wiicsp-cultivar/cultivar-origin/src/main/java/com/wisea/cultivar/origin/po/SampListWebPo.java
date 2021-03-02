package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.origin.vo.SampListWebVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *检测信息管理PO
 * @author wzx
 *
 */
@ApiModel("检测信息管理PO")
public class SampListWebPo extends PagePo<SampListWebVo> {

	/**
	 *
	 */
	private static final long serialVersionUID = -1651839854872974081L;
	@ApiModelProperty(value = "(0:样品名称 1:企业名称)")
	private String key;
	@ApiModelProperty(value = "选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value = "样品状态")
	private String sampStateType;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "开始时间")
	private OffsetDateTime staDate; // 开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "结束时间")
	private OffsetDateTime endDate; // 结束时间
	@ApiModelProperty(value = "品鉴会ID")
	private String judgeMeetId;
	@ApiModelProperty(value = "企业ID",hidden=true)
	private Long compId;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
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
	public String getJudgeMeetId() {
		return judgeMeetId;
	}
	public void setJudgeMeetId(String judgeMeetId) {
		this.judgeMeetId = judgeMeetId;
	}
	public Long getCompId() {
		return compId;
	}
	public void setCompId(Long compId) {
		this.compId = compId;
	}

}
