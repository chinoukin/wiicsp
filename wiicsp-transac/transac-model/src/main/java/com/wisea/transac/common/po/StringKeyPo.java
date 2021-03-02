package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字符串入参可以为空
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月27日
 * @version 1.0
 */
@ApiModel("字符串入参可以为空PO")
public class StringKeyPo {

	@ApiModelProperty("字符串")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
