package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据银行名称编号和省市区编号查询支行列表
 *
 * @author wangh(wisea)
 *
 * @date 2019年1月23日
 * @version 1.0
 */
@ApiModel("根据银行名称编号和省市区编号查询支行列表PO")
public class BankInfoSearchPo {

	@ApiModelProperty(value="开户行编号")
    @Check(test = "required")
    private String headBankCode;
	@ApiModelProperty(value=" 开户省标号")
    @Check(test = "required")
    private String provinceCode;
	@ApiModelProperty(value=" 开户市编号")
    @Check(test = "required")
    private String cityCode;

	public String getHeadBankCode() {
		return headBankCode;
	}
	public void setHeadBankCode(String headBankCode) {
		this.headBankCode = headBankCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
