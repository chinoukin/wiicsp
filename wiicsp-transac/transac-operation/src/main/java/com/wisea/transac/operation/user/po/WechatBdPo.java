package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信账号绑定的PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年2月25日
 * @version 1.0
 */
@ApiModel("微信账号绑定的PO")
public class WechatBdPo {

	@ApiModelProperty(value="pendid(必填)")
	@Check(test = { "required" })
	private String openid;
	@ApiModelProperty(value="加密数据")
	@Check(test = { "required" })
	private String encryptedData;
	@ApiModelProperty(value="加密算法的初始向量")
	@Check(test = { "required" })
	private String iv;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer wechatType = 0;
	@ApiModelProperty(value="微信登录的临时CODE(需要重新获取sessionkey解密的情况传值)")
	private String code;

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
	public Integer getWechatType() {
		return wechatType;
	}
	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
