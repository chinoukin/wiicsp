package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家订单列表日期下拉选VO
 */
@ApiModel("买家订单列表日期下拉选VO")
public class TimeSearchVo {

	@ApiModelProperty("查询条件")
    private String key;
	@ApiModelProperty("值")
    private String value;

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
}
