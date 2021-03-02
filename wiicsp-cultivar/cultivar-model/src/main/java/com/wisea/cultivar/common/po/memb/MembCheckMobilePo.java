package com.wisea.cultivar.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证手机号是否存在的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月25日
 * @version 1.0
 */
@ApiModel("验证手机号是否存在的PO")
public class MembCheckMobilePo {

	/**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    @Check(test = "required")
    private String  mobile;
    /**
     * Id
     *
     */
    @ApiModelProperty(value="会员ID(修改手机号的时候传入,排除自身)")
    @JsonSerialize(using = IdSerializer.class)
    private Long membId;

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}

}
