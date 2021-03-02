package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预订单的收货地址信息
 * DefaultAddressVo
 * 2018/09/18 14:36:47
 */
public class DefaultAddressVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String receName;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String tel;

    /**
     * 收货地址省
     */
    @ApiModelProperty(value = "收货地址省")
    private String receAddressProv;

    /**
     * 收货地址市
     */
    @ApiModelProperty(value = "收货地址市")
    private String receAddressCity;

    /**
     * 收货地址区县
     */
    @ApiModelProperty(value = "收货地址区县")
    private String receAddressCou;

    /**
     * 收货地址街道
     */
    @ApiModelProperty(value = "收货地址街道")
    private String receAddressStreet;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String receAddressDetail;


    /**
     * 是否默认
     */
    @ApiModelProperty(value = "是否默认")
    private String defaultFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceName() {
		return receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getReceAddressProv() {
		return receAddressProv;
	}

	public void setReceAddressProv(String receAddressProv) {
		this.receAddressProv = receAddressProv;
	}

	public String getReceAddressCity() {
		return receAddressCity;
	}

	public void setReceAddressCity(String receAddressCity) {
		this.receAddressCity = receAddressCity;
	}

	public String getReceAddressCou() {
		return receAddressCou;
	}

	public void setReceAddressCou(String receAddressCou) {
		this.receAddressCou = receAddressCou;
	}

	public String getReceAddressStreet() {
		return receAddressStreet;
	}

	public void setReceAddressStreet(String receAddressStreet) {
		this.receAddressStreet = receAddressStreet;
	}

	public String getReceAddressDetail() {
		return receAddressDetail;
	}

	public void setReceAddressDetail(String receAddressDetail) {
		this.receAddressDetail = receAddressDetail;
	}

	public String getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
}
