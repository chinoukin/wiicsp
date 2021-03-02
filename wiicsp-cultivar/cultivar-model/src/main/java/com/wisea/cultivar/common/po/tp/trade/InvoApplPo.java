package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请开票PO
 *
 * @author yangtao
 *
 */
@ApiModel("申请开票PO")
public class InvoApplPo {

    @ApiModelProperty("ID，订单开票时为订单id，账期结算单时为结算单id")
    @Check(test = "required")
    private Long ordId;
    @ApiModelProperty("发票ID")
    @Check(test = "required")
    private Long invoId;
    @ApiModelProperty(value = "收件人")
    private String receName;
    @ApiModelProperty(value = "所在地区省")
    private String addressProv;
    @ApiModelProperty(value = "所在地区市")
    private String addressCity;
    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    @ApiModelProperty(value = "手机号码")
    private String tel;

	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}
	public Long getInvoId() {
		return invoId;
	}
	public void setInvoId(Long invoId) {
		this.invoId = invoId;
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
