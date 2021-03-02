package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预定单的商品列表信息
 */
@ApiModel("预订单的商品列表信息")
public class BuyerPreOrderCommInfoVo {

	@ApiModelProperty("商家商品信息")
	private List<BuyerImportBillCommInfoListVo> importBillCommInfoList;

	@ApiModelProperty("收货地址信息")
	private DefaultAddressVo defaultAddress;

	@ApiModelProperty("发票信息")
	private DefaultInvoInfoVo defaultInvoInfo;

	@ApiModelProperty("不支持自提的商品")
	private List<BuyerNotSupportMsgListVo> notSelfMentionList;

	@ApiModelProperty("不支持账期支付的商品")
	private BuyerNotSupportListVo notAccountPay;

	@ApiModelProperty("商品类型，0大宗单品，1中小零批")
	private String commPubType;

	@ApiModelProperty("是否可以账期支付，0：否；1：是")
	private String canAccpay;

	@ApiModelProperty("是否可以分账期支付，0：否；1：是")
	private String canFjdpay;

	@ApiModelProperty(value = "服务器时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	private OffsetDateTime date;

	@ApiModelProperty("自提点信息")
	private List<SelfMentionAddressListVo> selfMentionAddressMage;

	public List<BuyerImportBillCommInfoListVo> getImportBillCommInfoList() {
		return importBillCommInfoList;
	}

	public void setImportBillCommInfoList(List<BuyerImportBillCommInfoListVo> importBillCommInfoList) {
		this.importBillCommInfoList = importBillCommInfoList;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public String getCanFjdpay() {
		return canFjdpay;
	}

	public void setCanFjdpay(String canFjdpay) {
		this.canFjdpay = canFjdpay;
	}

	public String getCanAccpay() {
		return canAccpay;
	}

	public void setCanAccpay(String canAccpay) {
		this.canAccpay = canAccpay;
	}

	public List<SelfMentionAddressListVo> getSelfMentionAddressMage() {
		return selfMentionAddressMage;
	}

	public void setSelfMentionAddressMage(List<SelfMentionAddressListVo> selfMentionAddressMage) {
		this.selfMentionAddressMage = selfMentionAddressMage;
	}

	public String getCommPubType() {
		return commPubType;
	}

	public void setCommPubType(String commPubType) {
		this.commPubType = commPubType;
	}

	public DefaultAddressVo getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(DefaultAddressVo defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public DefaultInvoInfoVo getDefaultInvoInfo() {
		return defaultInvoInfo;
	}

	public void setDefaultInvoInfo(DefaultInvoInfoVo defaultInvoInfo) {
		this.defaultInvoInfo = defaultInvoInfo;
	}

	public List<BuyerNotSupportMsgListVo> getNotSelfMentionList() {
		return notSelfMentionList;
	}

	public void setNotSelfMentionList(List<BuyerNotSupportMsgListVo> notSelfMentionList) {
		this.notSelfMentionList = notSelfMentionList;
	}

	public BuyerNotSupportListVo getNotAccountPay() {
		return notAccountPay;
	}

	public void setNotAccountPay(BuyerNotSupportListVo notAccountPay) {
		this.notAccountPay = notAccountPay;
	}
}

