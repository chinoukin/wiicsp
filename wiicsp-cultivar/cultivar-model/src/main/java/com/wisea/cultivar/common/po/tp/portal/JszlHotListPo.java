package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询热门技术资料信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("查询热门技术资料信息PO")
public class JszlHotListPo {

	@ApiModelProperty(value="需要查询的数量")
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
