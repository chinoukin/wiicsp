package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询意见反馈导出信息PO
 * @author wzx
 *
 */
@ApiModel("查询意见反馈导出信息PO")
public class WebOpinRetroaMagePo implements ExportPo{

	@ApiModelProperty(value = "(0:用户名1:姓名2:手机号3:主体名称)")
	private String key;
	@ApiModelProperty(value = "选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value = "状态 (handle_status[0:已处理1:未处理])")
	private String handleStatus;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "创建开始时间")
	private OffsetDateTime createStaDate; // 创建开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "创建结束时间")
	private OffsetDateTime createEndDate; // 创建结束时间

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

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public OffsetDateTime getCreateStaDate() {
		return createStaDate;
	}

	public void setCreateStaDate(OffsetDateTime createStaDate) {
		this.createStaDate = createStaDate;
	}

	public OffsetDateTime getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(OffsetDateTime createEndDate) {
		this.createEndDate = createEndDate;
	}

}
