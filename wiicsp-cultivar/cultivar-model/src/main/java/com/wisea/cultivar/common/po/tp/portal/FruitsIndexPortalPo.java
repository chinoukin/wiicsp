package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图标显示的传入参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("图标显示的传入参数PO")
public class FruitsIndexPortalPo {

	@ApiModelProperty(value="水果名称是否随机显示,默认不随机。(0:最近1:随机)")
	private String isRandom = "0";

	@ApiModelProperty(value="选择水果种数(默认4种)")
	private int number = 4;

	public String getIsRandom() {
		return isRandom;
	}

	public void setIsRandom(String isRandom) {
		this.isRandom = isRandom;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
