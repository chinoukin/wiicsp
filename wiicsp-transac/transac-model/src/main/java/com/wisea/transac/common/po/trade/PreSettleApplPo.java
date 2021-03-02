package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdsPo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请开票PO
 *
 * @author yangtao
 *
 */
@ApiModel("买家提前结算PO")
public class PreSettleApplPo extends LongIdsPo{

    @ApiModelProperty("发票ID")
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
    private String consigneeTel;
    @ApiModelProperty(value = "备注")
    private String remake;

	public String getRemake() {
        return remake;
    }
    public void setRemake(String remake) {
        this.remake = remake;
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
    public String getConsigneeTel() {
        return consigneeTel;
    }
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }
}
