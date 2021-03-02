package com.wisea.cultivar.common.vo.tp;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片
 * @author wzx
 *
 */
@ApiModel("图片VO")
public class SampImgListForSynVo implements Serializable{

	private static final long serialVersionUID = 2481999059811509052L;
	@ApiModelProperty("样品id")
	private Long sampId; //样品id
	@ApiModelProperty("图片")
	private String url; // 图片
	@ApiModelProperty(value="排序",hidden=true)
	private Integer sort;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "检测创建日期")
    private OffsetDateTime jcDate;

	public Long getSampId() {
		return sampId;
	}

	public void setSampId(Long sampId) {
		this.sampId = sampId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public OffsetDateTime getJcDate() {
		return jcDate;
	}

	public void setJcDate(OffsetDateTime jcDate) {
		this.jcDate = jcDate;
	}

}
