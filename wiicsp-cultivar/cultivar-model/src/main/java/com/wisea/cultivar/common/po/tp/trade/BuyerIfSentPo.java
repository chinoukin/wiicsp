package com.wisea.cultivar.common.po.tp.trade;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cultivar.common.po.tp.FreightFormworkMagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 是否在配送范围内Po
 */
@ApiModel("预订单的商品列表信息Po")
public class BuyerIfSentPo {

	@ApiModelProperty("一个商家的商品列表")
	@Check(test = "required")
	private List<com.wisea.cultivar.common.po.tp.FreightFormworkMagePo> FreightFormworkMagePo;
	@ApiModelProperty("地址id")
	@Check(test = "required")
	private Long addressId;

	public List<FreightFormworkMagePo> getFreightFormworkMagePo() {
		return FreightFormworkMagePo;
	}

	public void setFreightFormworkMagePo(List<FreightFormworkMagePo> freightFormworkMagePo) {
		FreightFormworkMagePo = freightFormworkMagePo;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
}

