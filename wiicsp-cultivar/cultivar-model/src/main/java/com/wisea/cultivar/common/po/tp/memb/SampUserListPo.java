package com.wisea.cultivar.common.po.tp.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采样人员列表查询条件PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月29日
 * @version 1.0
 */
@ApiModel("采样人员列表查询条件PO")
public class SampUserListPo {
	@ApiModelProperty(value="帐号/联系电话/员工姓名")
	private String keyStr;

	public String getKeyStr() {
		return keyStr;
	}

	public void setKeyStr(String keyStr) {
		this.keyStr = keyStr;
	}

}
