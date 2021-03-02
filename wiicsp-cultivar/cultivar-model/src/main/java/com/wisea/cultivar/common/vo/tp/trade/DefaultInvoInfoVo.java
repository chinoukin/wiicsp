package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * invo_info 表实体
 * 发票信息
 * 2018/09/18 14:36:47
 */
public class DefaultInvoInfoVo{

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 发票类型
     */
	@ApiModelProperty(value = "发票类型")
    private String invoType;

    /**
     * 发票抬头
     */
	@ApiModelProperty(value = "发票抬头")
    private String invoTitle;

    /**
     * 纳税人识别号
     */
	@ApiModelProperty(value = "纳税人识别号")
    private String taxIdentNum;

    /**
     * 注册地址
     */
	@ApiModelProperty(value = "注册地址")
    private String registAddress;

    /**
     * 注册电话
     */
	@ApiModelProperty(value = "注册电话")
    private String registTel;

    /**
     * 开户银行
     */
	@ApiModelProperty(value = "开户银行")
    private String bankName;

    /**
     * 银行账户
     */
	@ApiModelProperty(value = "银行账户")
    private String bankAccNum;


    /**
     * 收件人
     */
	@ApiModelProperty(value = "收件人")
    private String receName;

    /**
     * 所在地区省
     */
	@ApiModelProperty(value = "所在地区省")
    private String addressProv;

    /**
     * 所在地区市
     */
	@ApiModelProperty(value = "所在地区市")
    private String addressCity;

    /**
     * 所在地区区县
     */
	@ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
	@ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 邮编
     */
	@ApiModelProperty(value = "邮编")
    private String zipCode;

	@ApiModelProperty(value = "手机号码")
    private String tel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public String getInvoTitle() {
		return invoTitle;
	}

	public void setInvoTitle(String invoTitle) {
		this.invoTitle = invoTitle;
	}

	public String getTaxIdentNum() {
		return taxIdentNum;
	}

	public void setTaxIdentNum(String taxIdentNum) {
		this.taxIdentNum = taxIdentNum;
	}

	public String getRegistAddress() {
		return registAddress;
	}

	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccNum() {
		return bankAccNum;
	}

	public void setBankAccNum(String bankAccNum) {
		this.bankAccNum = bankAccNum;
	}

	public String getReceName() {
		return receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public String getAddressProv() {
		return addressProv;
	}

	public void setAddressProv(String addressProv) {
		this.addressProv = addressProv;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCou() {
		return addressCou;
	}

	public void setAddressCou(String addressCou) {
		this.addressCou = addressCou;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
