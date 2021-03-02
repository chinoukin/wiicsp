package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证企业名称不能重复的PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月3日
 * @version 1.0
 */
@ApiModel("验证企业名称不能重复的PO")
public class CheckEntpNamePo {

	@ApiModelProperty(value="会员名称(不传默认是当前用户的会员ID)")
	private Long membId;
	@ApiModelProperty(value="企业名称")
	@Check(test = {"required"})
	private String entpName;
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getEntpName() {
		return entpName;
	}
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

}
