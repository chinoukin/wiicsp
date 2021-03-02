package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author Administrator
 *
 */
public class BuyerSalesRankPo {

	/**
	 * 分公司id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "分公司id")
	private Long subEntpId;

	@ApiModelProperty(value = "查询条件（0:年、1:月）")
	private String flag;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "查询条件的值(传当前时间)")
	private OffsetDateTime val;

	@ApiModelProperty(value = "月份",hidden=true)
	private String month;

	@ApiModelProperty(value = "分析条件（0:目标完成度分析、1:累计销售额分析）")
	private String analysis;

	public Long getSubEntpId() {
		return subEntpId;
	}

	public void setSubEntpId(Long subEntpId) {
		this.subEntpId = subEntpId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public OffsetDateTime getVal() {
		return val;
	}

	public void setVal(OffsetDateTime val) {
		this.val = val;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

}
