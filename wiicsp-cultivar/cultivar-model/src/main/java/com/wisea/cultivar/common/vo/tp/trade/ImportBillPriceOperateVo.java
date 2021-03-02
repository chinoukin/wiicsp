package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *ImportBillPriceOperateVo
 * 2018/09/18 17:40:35
 */
@ApiModel("价格处理vo")
public class ImportBillPriceOperateVo {


    @ApiModelProperty(value = "同一个区间最小值")
    private int minCount;

    @ApiModelProperty(value = "同一个区间最大值")
    private int maxCount;

    @ApiModelProperty(value = "商品价格")
    private Double price;

    @ApiModelProperty(value = "序列号")
    private int inOrderCount;



	public int getMinCount() {
		return minCount;
	}

	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getInOrderCount() {
		return inOrderCount;
	}

	public void setInOrderCount(int inOrderCount) {
		this.inOrderCount = inOrderCount;
	}
}
