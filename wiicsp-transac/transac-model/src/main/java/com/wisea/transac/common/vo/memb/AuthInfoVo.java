package com.wisea.transac.common.vo.memb;

import com.wisea.cloud.common.entity.AuthInfo;

import io.swagger.annotations.ApiModelProperty;

public class AuthInfoVo extends AuthInfo{

	private static final long serialVersionUID = -3501094000461183908L;

	@ApiModelProperty(value="微信的openId")
	private String wechatOpenid;
	@ApiModelProperty(value="微信的unionid")
	private String unionId;

	public String getWechatOpenid() {
		return wechatOpenid;
	}
	public void setWechatOpenid(String wechatOpenid) {
		this.wechatOpenid = wechatOpenid;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

}
