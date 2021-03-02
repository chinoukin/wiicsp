package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 长协合同处理申请解除的初期化VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月10日
 * @version 1.0
 */
@ApiModel("长协合同处理申请解除的初期化VO")
public class LtaContOperateApplyInitVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "申请人")
	private String applicanter;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "申请时间")
	private OffsetDateTime appDate;//申请时间

	@ApiModelProperty(value = "合同终止原因")
	private String contEndReason;// 合同终止原因

	@ApiModelProperty(value = "排他字段")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicanter() {
		return applicanter;
	}

	public void setApplicanter(String applicanter) {
		this.applicanter = applicanter;
	}

	public OffsetDateTime getAppDate() {
		return appDate;
	}

	public void setAppDate(OffsetDateTime appDate) {
		this.appDate = appDate;
	}

	public String getContEndReason() {
		return contEndReason;
	}

	public void setContEndReason(String contEndReason) {
		this.contEndReason = contEndReason;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
