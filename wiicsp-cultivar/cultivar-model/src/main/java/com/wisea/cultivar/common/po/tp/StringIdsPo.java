package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 只传String类型参数的PO
 *
 * @author yangtao
 *
 * @version 1.0
 */
@ApiModel("只传String类型参数的PO")
public class StringIdsPo {
	@ApiModelProperty(value="String类型的id,多个id用逗号分隔",required=true)
	@Check(test="required")
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
