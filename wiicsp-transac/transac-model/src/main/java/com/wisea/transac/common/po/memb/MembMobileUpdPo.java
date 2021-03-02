package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台会员注册手机号的修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月13日
 * @version 1.0
 */
@ApiModel("后台会员注册手机号的修改PO")
public class MembMobileUpdPo {
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty(value="手机号码")
    @Check(test = {"required"})
    private String mobile;
    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
