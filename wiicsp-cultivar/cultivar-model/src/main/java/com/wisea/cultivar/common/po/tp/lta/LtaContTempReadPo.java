package com.wisea.cultivar.common.po.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 拟定长协合同模版初期化PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月24日
 * @version 1.0
 */
@ApiModel("拟定长协合同模版初期化PO")
public class LtaContTempReadPo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="采购商ID")
	@Check(test = "required",requiredMsg = "采购商不能为空")
	private Long buyerId;

	@ApiModelProperty(value="支付方式")
	@Check(test = "required",requiredMsg = "支付方式不能为空")
	private String payMethType;

	@ApiModelProperty(value="供应商品不能为空")
	@Check(test = "required",requiredMsg = "供应商品不能为空")
	private String listName;

	@ApiModelProperty(value="合同编号")
	@Check(test = "required",requiredMsg = "合同编号不能为空")
	private String ltaContNum;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getPayMethType() {
		return payMethType;
	}

	public void setPayMethType(String payMethType) {
		this.payMethType = payMethType;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getLtaContNum() {
		return ltaContNum;
	}

	public void setLtaContNum(String ltaContNum) {
		this.ltaContNum = ltaContNum;
	}
}
