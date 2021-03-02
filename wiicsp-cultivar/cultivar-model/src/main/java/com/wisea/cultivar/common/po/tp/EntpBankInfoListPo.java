package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询银行卡信息列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月30日
 * @version 1.0
 */
@ApiModel("查询银行卡信息列表PO")
public class EntpBankInfoListPo {

	@ApiModelProperty(value="企业Id")
	private Long entpDataId;//企业id

	public Long getEntpDataId() {
		return entpDataId;
	}

	public void setEntpDataId(Long entpDataId) {
		this.entpDataId = entpDataId;
	}
}
