package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerImportBillCommSpecPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端加入进货单规格po")
public class BuyerImportBillCommSpecPo{

    @ApiModelProperty(value = "商品数量")
    @Check(test = "required")
    private int count;

    @ApiModelProperty(value = "商品价格")
    @Check(test = "required")
    private Double price;

    @ApiModelProperty(value = "商品规格")
    @Check(test = "required")
    private Double commSpec;

    @ApiModelProperty(value = "商品等级")
    @Check(test = "required")
    private String commLevelType;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCommSpec() {
		return commSpec;
	}

	public void setCommSpec(Double commSpec) {
		this.commSpec = commSpec;
	}

	public String getCommLevelType() {
		return commLevelType;
	}

	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}
}
