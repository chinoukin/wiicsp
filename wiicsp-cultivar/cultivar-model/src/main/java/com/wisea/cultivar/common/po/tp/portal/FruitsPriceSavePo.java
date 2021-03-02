package com.wisea.cultivar.common.po.tp.portal;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * 保存水果价格信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("保存水果价格信息PO")
public class FruitsPriceSavePo {

	private List<FruitsPriceInsPo> fruitsPrice;

	public List<FruitsPriceInsPo> getFruitsPrice() {
		return fruitsPrice;
	}

	public void setFruitsPrice(List<FruitsPriceInsPo> fruitsPrice) {
		this.fruitsPrice = fruitsPrice;
	}
}
