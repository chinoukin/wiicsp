package com.wisea.cultivar.common.vo.tp.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预定单的商品列表信息
 */
@ApiModel("预订单的商品列表信息")
public class BuyerIfSentVo {

	@ApiModelProperty("邮费List")
	private List<Double> postageSum;

	public List<Double> getPostageSum() {
		return postageSum;
	}

	public void setPostageSum(List<Double> postageSum) {
		this.postageSum = postageSum;
	}
}

