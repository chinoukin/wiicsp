package com.wisea.cultivar.common.vo.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 平台端合同列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月23日
 * @version 1.0
 */
@ApiModel("平台端合同列表信息VO")
public class LtaContPlatListVo extends LtaContInfoListVo{

	@ApiModelProperty(value="采购商名称")
	private String buyerUserName;

	@ApiModelProperty(value="供应商名称")
	private String sellerUserName;

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}
}
