package com.wisea.cultivar.common.po.tp.portal;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询推荐技术资料信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("查询推荐技术资料信息PO")
public class JszlTjListPo {

	@ApiModelProperty(value="需要查询的数量")
	private int num;
	@ApiModelProperty(value="不查询的ID",hidden=true)
	private List<Long> list;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Long> getList() {
		return list;
	}

	public void setList(List<Long> list) {
		this.list = list;
	}
}
