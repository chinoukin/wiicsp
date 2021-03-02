package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 山系、树龄销售统计
 * @author yangtao
 *
 */
@ApiModel("山系、树龄销售统计")
public class MountainStatisVo {

	@ApiModelProperty("统计名称（山系或树龄）")
	private String staticsName;
	@ApiModelProperty("销售数量")
	private Double saleCount;
	@ApiModelProperty("数量比例")
	private Double countScale;
	@ApiModelProperty("销售金额")
	private Double saleNum;
	@ApiModelProperty("金额比例")
	private Double numScale;

	public String getStaticsName() {
		return staticsName;
	}
	public void setStaticsName(String staticsName) {
		this.staticsName = staticsName;
	}
	public Double getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(Double saleCount) {
		this.saleCount = saleCount;
	}
	public Double getCountScale() {
		return countScale;
	}
	public void setCountScale(Double countScale) {
		this.countScale = countScale;
	}
	public Double getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(Double saleNum) {
		this.saleNum = saleNum;
	}
	public Double getNumScale() {
		return numScale;
	}
	public void setNumScale(Double numScale) {
		this.numScale = numScale;
	}
}
