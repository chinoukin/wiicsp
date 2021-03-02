package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.WebMassifMageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询地块信息列表信息PO
 * @author wzx
 *
 */
@ApiModel("查询地块信息列表信息PO")
public class WebMassifMageListPo extends PagePo<WebMassifMageVo> implements ExportPo{

	private static final long serialVersionUID = -6632134527548363149L;
	@ApiModelProperty(value = "(0:地块名称1:主体名称2:创建人3:更新人)")
	private String key;
	@ApiModelProperty(value = "选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value = "地块类型")
	private String massifType;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "创建开始时间")
	private OffsetDateTime createStaDate; // 创建开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "创建结束时间")
	private OffsetDateTime createEndDate; // 创建结束时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "更新开始时间")
	private OffsetDateTime updateStaDate; // 创建开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "更新结束时间")
	private OffsetDateTime updateEndDate; // 创建结束时间

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

	public String getMassifType() {
		return massifType;
	}

	public void setMassifType(String massifType) {
		this.massifType = massifType;
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

	public OffsetDateTime getUpdateStaDate() {
		return updateStaDate;
	}

	public void setUpdateStaDate(OffsetDateTime updateStaDate) {
		this.updateStaDate = updateStaDate;
	}

	public OffsetDateTime getUpdateEndDate() {
		return updateEndDate;
	}

	public void setUpdateEndDate(OffsetDateTime updateEndDate) {
		this.updateEndDate = updateEndDate;
	}

}
