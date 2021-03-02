package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModelProperty;

public class SellerMembMageAddVo {

	@ApiModelProperty("会员ID")
	private Long membId;
	@ApiModelProperty("商户ID")
	private Long merchantId;
	@ApiModelProperty("实人认证姓名")
	private String realName;
	@ApiModelProperty("实人认证身份证号")
	private String idCardNum;
	@ApiModelProperty("企业名称")
	private String entpName;
	@ApiModelProperty("企业简称")
	private String entpShortName;
	@ApiModelProperty(value="采购商ID",hidden = true)
	private Long purId;
	@ApiModelProperty(value="客户管理表ID",hidden = true)
	private Long merMembId;

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
	public String getEntpShortName() {
		return entpShortName;
	}
	public void setEntpShortName(String entpShortName) {
		this.entpShortName = entpShortName;
	}
	public Long getPurId() {
		return purId;
	}
	public void setPurId(Long purId) {
		this.purId = purId;
	}
	public Long getMerMembId() {
		return merMembId;
	}
	public void setMerMembId(Long merMembId) {
		this.merMembId = merMembId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

}
