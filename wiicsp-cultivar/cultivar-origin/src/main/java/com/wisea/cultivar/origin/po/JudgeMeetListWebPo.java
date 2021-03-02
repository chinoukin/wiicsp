package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.origin.vo.JudgeMeetListWebVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *品鉴会管理列表PO
 * @author wzx
 *
 */
@ApiModel("品鉴会管理列表PO")
public class JudgeMeetListWebPo extends PagePo<JudgeMeetListWebVo> {
	/**
	 *
	 */
	private static final long serialVersionUID = 7058135920590270251L;
	@ApiModelProperty(value = "(0:品鉴会名称 1:主办单位)")
	private String key;
	@ApiModelProperty(value = "选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value="状态 （ 1 即将开始 2 正在进行 3 已结束）")
	private String jxtype;
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
	public String getJxtype() {
		return jxtype;
	}
	public void setJxtype(String jxtype) {
		this.jxtype = jxtype;
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
