package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerUpdateCommPubInfoCountPo
 * 2018/09/18 17:40:35
 */
@ApiModel("修改进货单商品数量po")
public class BuyerUpdateCommPubInfoCountPo{

	@ApiModelProperty(value = "进货单的ID")
	@Check(test = "required")
	private Long id;

	@ApiModelProperty(value = "商品的数量")
	@Check(test = "required")
	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
