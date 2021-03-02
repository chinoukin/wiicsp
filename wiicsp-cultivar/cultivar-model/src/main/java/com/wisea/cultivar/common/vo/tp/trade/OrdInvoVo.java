package com.wisea.cultivar.common.vo.tp.trade;


import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单发票VO
 */
@ApiModel("订单发票VO")
public class OrdInvoVo {
	@ApiModelProperty("订单id")
    private Long id;
	@ApiModelProperty("订单id")
    private Long ordId;
	@ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("发票类别")
    private String invoCatgType;
	@ApiModelProperty("发票形式")
    private String invoForm;
	@ApiModelProperty("发票抬头")
    private String invoTitle;
	@ApiModelProperty("发票内容类型")
    private String invoContentType;
	@ApiModelProperty("纳税人识别号")
    private String taxIdentNum;
	@ApiModelProperty("注册地址")
    private String registAddress;
	@ApiModelProperty("注册电话")
    private String registTel;
	@ApiModelProperty("开户银行")
    private String bankName;
	@ApiModelProperty("银行账户")
    private String bankAccNum;
	@ApiModelProperty("是否默认")
    private String defaultFlag;
	@ApiModelProperty("收件人")
    private String receName;
	@ApiModelProperty("所在地区省")
    private String addressProv;
	@ApiModelProperty("所在地区市")
    private String addressCity;
	@ApiModelProperty("所在地区区县")
    private String addressCou;
	@ApiModelProperty("详细地址")
    private String addressDetail;
	@ApiModelProperty("邮编")
    private String zipCode;
	@ApiModelProperty("手机号码")
    private String tel;
	@ApiModelProperty("发票url地址")
    private String eleInvoUrl;
	@ApiModelProperty("发票url文件名")
    private String urlName;
	@ApiModelProperty("物流公司名称")
    private String logisticsCompName;
	@ApiModelProperty("物流单号")
    private String logisticsNum;
	@ApiModelProperty("申请单号")
    private String applNum;
	@ApiModelProperty("申请时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime invoApplDate;
	@ApiModelProperty("开票日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime drawDate;
	@ApiModelProperty("开票金额")
    private Double drawAmount;
	@ApiModelProperty("发票状态")
    private String invoState;
	@ApiModelProperty("作废备注")
    private String cancelRemarks;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoContentType() {
		return invoContentType;
	}

	public void setInvoContentType(String invoContentType) {
		this.invoContentType = invoContentType;
	}

	public String getLogisticsCompName() {
		return logisticsCompName;
	}

	public void setLogisticsCompName(String logisticsCompName) {
		this.logisticsCompName = logisticsCompName;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	public String getApplNum() {
		return applNum;
	}

	public void setApplNum(String applNum) {
		this.applNum = applNum;
	}

	public OffsetDateTime getInvoApplDate() {
		return invoApplDate;
	}

	public void setInvoApplDate(OffsetDateTime invoApplDate) {
		this.invoApplDate = invoApplDate;
	}

	public OffsetDateTime getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(OffsetDateTime drawDate) {
		this.drawDate = drawDate;
	}

	public Double getDrawAmount() {
		return drawAmount;
	}

	public void setDrawAmount(Double drawAmount) {
		this.drawAmount = drawAmount;
	}

	public String getInvoState() {
		return invoState;
	}

	public void setInvoState(String invoState) {
		this.invoState = invoState;
	}

	public String getCancelRemarks() {
		return cancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}

	public String getEleInvoUrl() {
		return eleInvoUrl;
	}

	public void setEleInvoUrl(String eleInvoUrl) {
		this.eleInvoUrl = eleInvoUrl;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	/**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取发票类型
     */
    public String getInvoType() {
        return invoType;
    }

    /**
     * 设置发票类型
     */
    public void setInvoType(String invoType) {
        this.invoType = invoType == null ? null : invoType.trim();
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    /**
     * 获取发票形式
     */
    public String getInvoForm() {
        return invoForm;
    }

    /**
     * 设置发票形式
     */
    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm == null ? null : invoForm.trim();
    }

    /**
     * 获取发票抬头
     */
    public String getInvoTitle() {
        return invoTitle;
    }

    /**
     * 设置发票抬头
     */
    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle == null ? null : invoTitle.trim();
    }

    /**
     * 获取纳税人识别号
     */
    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    /**
     * 设置纳税人识别号
     */
    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum == null ? null : taxIdentNum.trim();
    }

    /**
     * 获取注册地址
     */
    public String getRegistAddress() {
        return registAddress;
    }

    /**
     * 设置注册地址
     */
    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress == null ? null : registAddress.trim();
    }

    /**
     * 获取注册电话
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册电话
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行账户
     */
    public String getBankAccNum() {
        return bankAccNum;
    }

    /**
     * 设置银行账户
     */
    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum == null ? null : bankAccNum.trim();
    }

    /**
     * 获取是否默认
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否默认
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取收件人
     */
    public String getReceName() {
        return receName;
    }

    /**
     * 设置收件人
     */
    public void setReceName(String receName) {
        this.receName = receName == null ? null : receName.trim();
    }

    /**
     * 获取所在地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置所在地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取所在地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置所在地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取所在地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置所在地区区县
     */
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou == null ? null : addressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * 获取邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}
