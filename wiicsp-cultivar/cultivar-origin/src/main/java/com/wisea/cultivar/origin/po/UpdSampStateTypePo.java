package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 确认上传PO
 * @author wzx
 *
 */
@ApiModel("确认上传PO")
public class UpdSampStateTypePo {
	@ApiModelProperty("样品ID")
	@Check(test = "required")
	private Long sampId;//样品id
	@ApiModelProperty("检测机构ID")
	private Long detectionMechId;//检测机构id
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="排他字段")
    private OffsetDateTime updateDate;//更新时间

	public Long getSampId() {
		return sampId;
	}

	public void setSampId(Long sampId) {
		this.sampId = sampId;
	}

	public Long getDetectionMechId() {
		return detectionMechId;
	}

	public void setDetectionMechId(Long detectionMechId) {
		this.detectionMechId = detectionMechId;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
