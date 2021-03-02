package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerDeleManyImportBillPo
 * 2018/09/18 17:40:35
 */
@ApiModel("批量删除进货单商品po")
public class BuyerDeleManyImportBillPo{

	@ApiModelProperty(value = "商品IDs,id 以  , 分隔")
	@Check(test = "required")
	private String commpubIds;

	public String getCommpubIds() {
		return commpubIds;
	}

	public void setCommpubIds(String commpubIds) {
		this.commpubIds = commpubIds;
	}
}
