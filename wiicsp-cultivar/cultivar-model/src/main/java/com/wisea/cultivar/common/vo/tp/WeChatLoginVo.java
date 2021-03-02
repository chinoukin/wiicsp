package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信登录返回的用户基本信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@Api("微信登录返回的用户基本信息VO")
public class WeChatLoginVo {

	@ApiModelProperty(value="用户id")
	private Long id;
	@ApiModelProperty(value="openid")
	private String openid;
	@ApiModelProperty(value="json")
	private String json;
	@ApiModelProperty(value="accessToken")
	private String accessToken;
	@ApiModelProperty(value="tokenType")
	private String tokenType;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}
