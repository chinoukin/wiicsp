package com.wisea.cultivar.common.po.tp.trade;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交订单商品和发票PO
 */
@ApiModel("提交订单商品和发票PO")
public class OrderApplPo {

	@ApiModelProperty(value = "每个商家的商品List")
	@Check(test = "required")
	private List<BuyerToOrderPo> commpubList;
	@ApiModelProperty(value = "发票ID")
	private Long invoId;
	@ApiModelProperty(value = "备注")
	private String remarks;

	public Long getInvoId() {
		return invoId;
	}
	public void setInvoId(Long invoId) {
		this.invoId = invoId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<BuyerToOrderPo> getCommpubList() {
		return commpubList;
	}
	public void setCommpubList(List<BuyerToOrderPo> commpubList) {
		this.commpubList = commpubList;
	}
}
