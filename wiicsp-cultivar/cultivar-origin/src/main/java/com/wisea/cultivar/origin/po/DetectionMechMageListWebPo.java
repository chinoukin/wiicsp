package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.origin.vo.DetectionMechMageListWebVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *检测机构管理PO
 * @author wzx
 *
 */
@ApiModel("检测机构管理PO")
public class DetectionMechMageListWebPo extends PagePo<DetectionMechMageListWebVo> {

	/**
	 *
	 */
	private static final long serialVersionUID = -3614039048980308901L;
	@ApiModelProperty(value = "(0:机构编号 1:机构名称)")
	private String key;
	@ApiModelProperty(value = "选择查询条件后输入的参数")
	private String value;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "开始时间")
	private OffsetDateTime staDate; // 开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "结束时间")
	private OffsetDateTime endDate; // 结束时间
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

}
