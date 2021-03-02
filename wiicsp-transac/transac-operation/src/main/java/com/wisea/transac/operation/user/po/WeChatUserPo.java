package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信账号信息完善的处理
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@Api("微信账号信息完善的处理PO")
public class WeChatUserPo {

	@ApiModelProperty(value="opendid(必填)")
	@Check(test = { "required" })
	private String openid;
	@ApiModelProperty(value="手机号(如果有手机号直接填写,手机号加密的情况下不填)")
	private String mobile;
	@ApiModelProperty(value="加密数据(手机号为空的时候填写)")
	@Check(test = "logic", logic = "#isEmpty(#mobile) ? #isNotEmpty(#encryptedData) : true", logicMsg = "手机号为空的情况encryptedData是必填项目")
	private String encryptedData;
	@ApiModelProperty(value="加密算法的初始向量(手机号为空的时候填写)")
	@Check(test = "logic", logic = "#isEmpty(#mobile) ? #isNotEmpty(#iv) : true", logicMsg = "手机号为空的情况iv是必填项目")
	private String iv;
	@ApiModelProperty(value="头像地址")
	private String url;
	@ApiModelProperty(value="昵称")
	private String nickname;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer wechatType = 0;
	@ApiModelProperty("UnionId")
	@Check(test = "logic", logic = "'0'.equals(#isSaveUnionId)?#isEmpty(#unionId):#isNotEmpty(#unionId)", logicMsg = "保存unionid的情况unionid不能为空")
	private String unionId;
	@ApiModelProperty(value="是否需要绑定unionid(默认1:是0:否)")
	private String isSaveUnionId = "1";
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getWechatType() {
		return wechatType;
	}
	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getIsSaveUnionId() {
		return isSaveUnionId;
	}
	public void setIsSaveUnionId(String isSaveUnionId) {
		this.isSaveUnionId = isSaveUnionId;
	}
}
