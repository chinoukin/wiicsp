package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证用户名是否存在的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月25日
 * @version 1.0
 */
@ApiModel("验证用户名是否存在的PO")
public class MembCheckLoginNamePo {

	/**
     * 用户名
     */
    @ApiModelProperty(value="用户名称")
    @Check(test = "required")
    private String  loginName;
    /**
     * Id
     *
     */
    @ApiModelProperty(value="会员ID(修改用户名称的时候传入)")
    @JsonSerialize(using = IdSerializer.class)
    private Long membId;

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
