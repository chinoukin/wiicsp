package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单独修改水果指数的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("单独修改水果指数的PO")
public class FruitsIndexPriceIndexPo {

	@ApiModelProperty("数据ID")
    @Check(test = "required")
    private Long id;

	@Check(test = {"required","regex"}, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "价格指数")
    private Double priceIndex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPriceIndex() {
		return priceIndex;
	}

	public void setPriceIndex(Double priceIndex) {
		this.priceIndex = priceIndex;
	}

}
