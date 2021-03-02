package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

public class BatchDetecResultPo {

	private Long sampId;// 样品id
	private boolean publicFlag = false;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime detecDate;// 检测时间
	// 0:不合格1：合格
    private String resultType;

	public Long getSampId() {
		return sampId;
	}
	public void setSampId(Long sampId) {
		this.sampId = sampId;
	}
	public boolean isPublicFlag() {
		return publicFlag;
	}
	public void setPublicFlag(boolean publicFlag) {
		this.publicFlag = publicFlag;
	}
	public OffsetDateTime getDetecDate() {
		return detecDate;
	}
	public void setDetecDate(OffsetDateTime detecDate) {
		this.detecDate = detecDate;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
}
