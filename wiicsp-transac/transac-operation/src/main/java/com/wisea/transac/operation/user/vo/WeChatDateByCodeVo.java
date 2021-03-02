package com.wisea.transac.operation.user.vo;

/**
 * 通过code获取用户信息的返回结果接收
 *
 * @author wangh(wisea)
 *
 * @date 2020年3月4日
 * @version 1.0
 */
public class WeChatDateByCodeVo {

	private String errcode;
	private String errmsg;
	private String openid;
	private String unionid;
	private String sessionkey;

	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
}
