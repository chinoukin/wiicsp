package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商户APP登录后验证认证信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月12日
 * @version 1.0
 */
@ApiModel("商户APP登录后验证认证信息VO")
public class SellerAppEntpAuthInfoVo {

	@ApiModelProperty("企业ID")
	private Long id;
	@ApiModelProperty("企业会员ID")
	private Long membId;
	@ApiModelProperty("基地ID")
	private Long baseId;
	@ApiModelProperty("市场ID")
	private Long marketId;
	@ApiModelProperty(value="审核状态(0:待平台审核1:待银盛开户2:实名认证中3:审核通过4:审核未通过)")
	private String authStateType;
	@ApiModelProperty(value="审核不通过的原因")
	private String examFailReason;
	@ApiModelProperty(value="如果返回1提示用户重新登录(并且调用用户注销接口)")
	private String freshenLoginFlag;
	@ApiModelProperty(value="账期支付开通状态")
	private String apFlag;

	public String getAuthStateType() {
		return authStateType;
	}
	public void setAuthStateType(String authStateType) {
		this.authStateType = authStateType;
	}
	public String getExamFailReason() {
		return examFailReason;
	}
	public void setExamFailReason(String examFailReason) {
		this.examFailReason = examFailReason;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public Long getBaseId() {
		return baseId;
	}
	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}
	public Long getMarketId() {
		return marketId;
	}
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
	public String getFreshenLoginFlag() {
		return freshenLoginFlag;
	}
	public void setFreshenLoginFlag(String freshenLoginFlag) {
		this.freshenLoginFlag = freshenLoginFlag;
	}

	public String getApFlag() {
		return apFlag;
	}

	public void setApFlag(String apFlag) {
		this.apFlag = apFlag;
	}
}
