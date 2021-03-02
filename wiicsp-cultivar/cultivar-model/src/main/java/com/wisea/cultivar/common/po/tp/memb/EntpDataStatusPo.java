package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询当前用户的商家资料信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月10日
 * @version 1.0
 */
@ApiModel("查询当前用户的商家资料信息PO")
public class EntpDataStatusPo {

	@ApiModelProperty(value="0:获取最新的商家资料信息(审核中-通过-驳回)1:获取已经认证的最新的资料信息")
	@Check(test="liveable", liveable={"0","1"})
    private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
