package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

public class XsAnalysisVo {

	 @ApiModelProperty(value = "日期")
	 private String yearMonth;
	 @ApiModelProperty(value = "每月销售额")
	 private Double ysJe;
	 @ApiModelProperty(value = "同比上年销售额")
	 private Double latYsJe;

	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Double getYsJe() {
		return ysJe;
	}
	public void setYsJe(Double ysJe) {
		this.ysJe = ysJe;
	}
	public Double getLatYsJe() {
		return latYsJe;
	}
	public void setLatYsJe(Double latYsJe) {
		this.latYsJe = latYsJe;
	}





}
