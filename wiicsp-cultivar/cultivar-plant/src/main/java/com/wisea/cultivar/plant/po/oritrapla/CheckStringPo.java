package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单独输入字符串的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("单独输入字符串的PO")
public class CheckStringPo {

	@ApiModelProperty(value="字符串(必填)",required=true)
	@Check(test="required")
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
