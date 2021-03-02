package com.wisea.cultivar.common.po.tp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

public class SampListForSynPo implements Serializable{

	private static final long serialVersionUID = 761912156428799825L;

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "企业id")
	private Long compId;

	@ApiModelProperty(value = "未检测数据")
	private List<String> wjcList;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "检测数据最大日期")
	private OffsetDateTime maxDate;

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public List<String> getWjcList() {
		return wjcList;
	}

	public void setWjcList(List<String> wjcList) {
		this.wjcList = wjcList;
	}

	public OffsetDateTime getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(OffsetDateTime maxDate) {
		this.maxDate = maxDate;
	}

}
