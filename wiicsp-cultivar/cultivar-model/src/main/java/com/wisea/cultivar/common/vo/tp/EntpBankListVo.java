package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询当前用户的银行列表以及相关信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月30日
 * @version 1.0
 */
@ApiModel("查询当前用户的银行列表以及相关信息VO")
public class EntpBankListVo {
	@ApiModelProperty(value = "会员ID")
	private Long membId;
	@ApiModelProperty(value = "商家ID")
	private Long entpDataId;
	@ApiModelProperty(value = "企业名称(审核通过的)")
	private String compName;
	@ApiModelProperty(value = "企业认证手机号")
	private String bdTel;
	@ApiModelProperty(value = "开户许可证编号")
	private String khxkzNum;// 开户许可证编号
	@ApiModelProperty(value = "开户许可证url")
	private String khxkzUrl;// 开户许可证url
	@ApiModelProperty(value = "企业银行卡号")
	private String entpBankNum;//企业银行卡号
	@ApiModelProperty(value = "开户名")
	private String khName;//开户名
	@ApiModelProperty(value = "开户行类型")
	private String openBankType;
	@ApiModelProperty(value = "开户行省")
	private String khProv;// 开户行省
	@ApiModelProperty(value = "开户行省")
	private String khCity;// 开户行市
	@ApiModelProperty(value = "开户行")
	private String openBank;// 开户行


	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public Long getEntpDataId() {
		return entpDataId;
	}
	public void setEntpDataId(Long entpDataId) {
		this.entpDataId = entpDataId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getBdTel() {
		return bdTel;
	}
	public void setBdTel(String bdTel) {
		this.bdTel = bdTel;
	}
	public String getKhxkzNum() {
		return khxkzNum;
	}
	public void setKhxkzNum(String khxkzNum) {
		this.khxkzNum = khxkzNum;
	}
	public String getKhxkzUrl() {
		return khxkzUrl;
	}
	public void setKhxkzUrl(String khxkzUrl) {
		this.khxkzUrl = khxkzUrl;
	}
	public String getEntpBankNum() {
		return entpBankNum;
	}
	public void setEntpBankNum(String entpBankNum) {
		this.entpBankNum = entpBankNum;
	}
	public String getKhName() {
		return khName;
	}
	public void setKhName(String khName) {
		this.khName = khName;
	}
	public String getOpenBankType() {
		return openBankType;
	}
	public void setOpenBankType(String openBankType) {
		this.openBankType = openBankType;
	}
	public String getKhProv() {
		return khProv;
	}
	public void setKhProv(String khProv) {
		this.khProv = khProv;
	}
	public String getKhCity() {
		return khCity;
	}
	public void setKhCity(String khCity) {
		this.khCity = khCity;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

}
