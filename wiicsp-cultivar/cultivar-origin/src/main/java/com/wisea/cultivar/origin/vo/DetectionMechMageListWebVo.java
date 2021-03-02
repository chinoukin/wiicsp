package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检测机构管理
 * @author wzx
 *
 */
@ApiModel("检测机构管理VO")
public class DetectionMechMageListWebVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty("机构编号")
	private String orgNum; // 机构编号
	@ApiModelProperty("机构名称")
	private String orgName; // 机构名称
	@ApiModelProperty("操作人")
    private String operator;//操作人
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
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
