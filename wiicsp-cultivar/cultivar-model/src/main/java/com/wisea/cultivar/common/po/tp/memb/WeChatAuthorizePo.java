package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户第一次授权参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年3月27日
 * @version 1.0
 */
@Api("用户第一次授权参数PO")
public class WeChatAuthorizePo {

	@ApiModelProperty(value="小程序临时登录CODE(必填)")
	@Check(test = { "required" })
	private String code;
	@ApiModelProperty(value="明文,加密数据(必填)")
	@Check(test = { "required" })
	private String encryptedData;
	@ApiModelProperty(value="加密算法的初始向量(必填)")
	@Check(test = { "required" })
	private String iv;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer flag = 0;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
