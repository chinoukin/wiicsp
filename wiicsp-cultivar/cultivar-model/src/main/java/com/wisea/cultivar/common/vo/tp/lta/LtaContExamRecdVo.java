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
 * 长协合同操作信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月8日
 * @version 1.0
 */
@ApiModel("长协合同操作信息VO")
public class LtaContExamRecdVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="ID")
	private Long id;

	@ApiModelProperty(value="处理人")
	private String operator;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="时间")
	private OffsetDateTime operatDate;

	@ApiModelProperty(value="处理内容")
	private String operatorContent;

	@ApiModelProperty(value="操作原因")
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getOperatorContent() {
		return operatorContent;
	}

	public void setOperatorContent(String operatorContent) {
		this.operatorContent = operatorContent;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
