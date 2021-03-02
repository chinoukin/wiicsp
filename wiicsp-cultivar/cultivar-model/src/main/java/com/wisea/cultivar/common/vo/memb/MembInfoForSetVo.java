package com.wisea.cultivar.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 小程序设置用户信息初期话VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月9日
 * @version 1.0
 */
@ApiModel("小程序设置用户信息初期话VO")
public class MembInfoForSetVo {

	@ApiModelProperty("ID")
	private Long id;
	@ApiModelProperty("头像")
	private String logoUrl;
	@ApiModelProperty("昵称")
	private String petName;
	@ApiModelProperty("绑定微信")
	private String bindWechat;
	@ApiModelProperty("注册手机号")
	private String registTel;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getBindWechat() {
		return bindWechat;
	}
	public void setBindWechat(String bindWechat) {
		this.bindWechat = bindWechat;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}
}
