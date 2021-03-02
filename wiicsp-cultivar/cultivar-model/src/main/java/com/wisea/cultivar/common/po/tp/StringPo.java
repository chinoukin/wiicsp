package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 只传String类型参数的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月29日
 * @version 1.0
 */
@ApiModel("只传String类型参数的PO")
public class StringPo {
	@ApiModelProperty(value="String类型的参数 (必填)",required=true)
	@Check(test="required")
	private String keyStr;

	public String getKeyStr() {
		return keyStr;
	}

	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}

}
