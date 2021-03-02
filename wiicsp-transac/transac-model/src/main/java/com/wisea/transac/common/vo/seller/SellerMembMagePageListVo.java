package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家APP端会员管理VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月2日
 * @version 1.0
 */
@ApiModel("商家APP端会员管理VO")
public class SellerMembMagePageListVo{

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("商户ID")
	private Long merchantId;

	@ApiModelProperty("会员ID")
	private Long membId;

	@ApiModelProperty("用户名")
	private String loginName;

	@ApiModelProperty("注册手机号")
	private String registTel;

	@ApiModelProperty("帐号头像")
	private String logoUrl;

	@ApiModelProperty("已经认证的会员类型(0:企业1:个体户2:个人)")
	private String membType;

	@ApiModelProperty("个人认证真实姓名")
	private String realName;

	@ApiModelProperty("个人认证身份证号")
	private String idCardNum;

	@ApiModelProperty("企业名称")
	private String entpName;

	@ApiModelProperty("订单数量")
	private int ordNum;

	@ApiModelProperty("交易金额")
	private Double tradVolume;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}
	public int getOrdNum() {
		return ordNum;
	}

	public void setOrdNum(int ordNum) {
		this.ordNum = ordNum;
	}

	public Double getTradVolume() {
		return tradVolume;
	}

	public void setTradVolume(Double tradVolume) {
		this.tradVolume = tradVolume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
}
