package com.wisea.cultivar.plant.po.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单独输入字符串的PO
 *
 *
 */
@ApiModel("单独输入字符串的PO")
public class StringPo {

	@ApiModelProperty(value="字符串",required=true)
	private String str;

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}
}
