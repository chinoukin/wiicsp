package com.wisea.cultivar.common.po.tp.portal;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存水果指数信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("保存水果指数信息PO")
public class FruitsIndexSavePo {

	@ApiModelProperty(value="保存的水果指数信息列表")
	@Check(test = {"required"})
	private List<FruitsIndexInsPo> fruits;

	public List<FruitsIndexInsPo> getFruits() {
		return fruits;
	}

	public void setFruits(List<FruitsIndexInsPo> fruits) {
		this.fruits = fruits;
	}
}
