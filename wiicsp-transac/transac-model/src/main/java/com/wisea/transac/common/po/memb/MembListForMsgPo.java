package com.wisea.transac.common.po.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发送消息查询会员列表信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年11月22日
 * @version 1.0
 */
@ApiModel("发送消息查询会员列表信息PO")
public class MembListForMsgPo {

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
