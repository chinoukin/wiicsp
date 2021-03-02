package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

public class BuyerSalesRankVo {

	@ApiModelProperty(value = "采购商")
	private String cgsName;
	@ApiModelProperty(value = "应收金额")
	private Double ysJe;
	public String getCgsName() {
		return cgsName;
	}
	public void setCgsName(String cgsName) {
		this.cgsName = cgsName;
	}
	public Double getYsJe() {
		return ysJe;
	}
	public void setYsJe(Double ysJe) {
		this.ysJe = ysJe;
	}

}
