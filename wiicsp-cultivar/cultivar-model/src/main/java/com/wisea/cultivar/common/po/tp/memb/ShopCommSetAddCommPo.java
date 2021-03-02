package com.wisea.cultivar.common.po.tp.memb;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 批量添加发布的商品信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("批量添加发布的商品信息PO")
public class ShopCommSetAddCommPo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "商品分类id")
	@Check(test="required",requiredMsg="商品分类ID不能为空")
	private Long commId;
	@ApiModelProperty(value = "商品列表")
	private List<ShopCommSetCommPo> pubCommList;

	public Long getCommId() {
		return commId;
	}
	public void setCommId(Long commId) {
		this.commId = commId;
	}
	public List<ShopCommSetCommPo> getPubCommList() {
		return pubCommList;
	}
	public void setPubCommList(List<ShopCommSetCommPo> pubCommList) {
		this.pubCommList = pubCommList;
	}
}
