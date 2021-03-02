package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询技术资料列表（技术资料详情中列表）
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("查询技术资料列表（技术资料详情中列表）PO")
public class JszlListPo {

	@ApiModelProperty(value="需要查询的数量")
	private int num;
	@ApiModelProperty(value = "所属分类")
    private Long jszlCatgId;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}
}
