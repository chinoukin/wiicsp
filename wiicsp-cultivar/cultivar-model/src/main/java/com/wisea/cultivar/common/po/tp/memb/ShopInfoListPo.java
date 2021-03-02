package com.wisea.cultivar.common.po.tp.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 店铺信息列表查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月3日
 * @version 1.0
 */
@ApiModel("店铺信息列表查询PO")
public class ShopInfoListPo {

	@ApiModelProperty(value="店铺名称或者是登录用户名")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
