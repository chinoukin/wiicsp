package com.wisea.cultivar.common.po.tp;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 不需要查询的ID列表
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("不需要查询的ID列表PO")
public class NotNeedIdsPo {
    @ApiModelProperty("不需要查询的数据id列表")
    private List<Long> list;
    @ApiModelProperty(value="显示条数",hidden = true)
    private int num;

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
