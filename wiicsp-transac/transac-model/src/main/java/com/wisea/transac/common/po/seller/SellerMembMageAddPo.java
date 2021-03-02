package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商户APP添加会员处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月3日
 * @version 1.0
 */
@ApiModel("商户APP添加会员处理PO")
public class SellerMembMageAddPo {

	@ApiModelProperty(value="商户ID如果不传值默认是当前用户的")
	private Long merchantId;

	@ApiModelProperty(value="用户名/注册手机号/企业名称")
	@Check(test = {"required"})
	private String key;
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}
