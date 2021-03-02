package com.wisea.cultivar.common.vo.tp.lta;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家端去付款页面vo")
public class LtaBuyerTopayVo {

	@ApiModelProperty("结算支付类型")
    private String payMethodType;
	@ApiModelProperty("结算支付类型列表")
    private List<String> payMethodTypeList;
	@ApiModelProperty("可用额度")
    private Double availableCredit;
	@ApiModelProperty("授信状态（正常、冻结）")
    private String creditType;
	@ApiModelProperty("是否可以账期支付，0：否；1：是")
	private String canAccpay;

	public String getPayMethodType() {
		return payMethodType;
	}
	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
	public List<String> getPayMethodTypeList() {
		return payMethodTypeList;
	}
	public void setPayMethodTypeList(List<String> payMethodTypeList) {
		this.payMethodTypeList = payMethodTypeList;
	}
	public Double getAvailableCredit() {
		return availableCredit;
	}
	public void setAvailableCredit(Double availableCredit) {
		this.availableCredit = availableCredit;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCanAccpay() {
		return canAccpay;
	}
	public void setCanAccpay(String canAccpay) {
		this.canAccpay = canAccpay;
	}
}
