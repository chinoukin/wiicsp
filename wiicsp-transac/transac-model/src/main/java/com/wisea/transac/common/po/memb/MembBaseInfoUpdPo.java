package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 会员基础信息修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月17日
 * @version 1.0
 */
@ApiModel("会员基础信息修改PO")
public class MembBaseInfoUpdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="会员ID(如果为空表示当前用户ID)")
    private Long id;
    @ApiModelProperty(value="昵称(同时修改聊天窗口显示的昵称,如果是空不修改)")
    private String petName;
    @ApiModelProperty(value="头像(同时修改聊天窗口显示的头像,如果是空不修改)")
    private String logoUrl;
    @ApiModelProperty(value="姓名(如果是空不修改，如果实名认证后不允许修改姓名)")
    private String contName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
}
