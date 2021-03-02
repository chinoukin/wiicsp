package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 单独修改水果价格的Po
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("单独修改水果价格的Po")
public class FruitsPriceupdPricePo {

	@ApiModelProperty("数据ID")
    @Check(test = "required")
    private Long id;

	@Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "单价")
    private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
