package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.common.vo.tp.trade.DefaultAddressVo;
import com.wisea.cultivar.common.vo.tp.trade.DefaultInvoInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.SelfMentionAddressListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预定单的商品列表信息
 */
@ApiModel("预订单的商品列表信息")
public class LtaBuyerPreOrderCommInfoVo {

	@ApiModelProperty("合同id")
	private Long contId;

	@ApiModelProperty("商家id")
	private Long sellerId;

	@ApiModelProperty("商家名称")
	private String commName;

	@ApiModelProperty("配送信息类型")
	private String deliveryInfoType;

	@ApiModelProperty("配送信息类型列表")
	private List<String> deliveryInfoList;

	@ApiModelProperty("收货地址信息")
	private DefaultAddressVo defaultAddress;

	@ApiModelProperty("发票信息")
	private DefaultInvoInfoVo defaultInvoInfo;

	@ApiModelProperty(value = "服务器时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	private OffsetDateTime date;

	@ApiModelProperty("自提点信息")
	private List<SelfMentionAddressListVo> selfMentionAddressMage;

	@ApiModelProperty(value="是否可以能开发票(nfkfp_type0:能1:不能)")
	private String nfkfpType;//是否可以能开发票(nfkfp_type0:能1:不能)
	@ApiModelProperty(value="发票内容")
	private String invoContent;// 发票内容
	@ApiModelProperty(value="发票类型,多个用逗号分隔（字典值invo_type）")
	private String invoType;// 发票类型（多个用逗号分隔）
	@ApiModelProperty(value="发票类型列表")
	private List<String> invoList;

	public Long getContId() {
		return contId;
	}

	public void setContId(Long contId) {
		this.contId = contId;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public List<String> getDeliveryInfoList() {
		return deliveryInfoList;
	}

	public void setDeliveryInfoList(List<String> deliveryInfoList) {
		this.deliveryInfoList = deliveryInfoList;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getDeliveryInfoType() {
		return deliveryInfoType;
	}

	public void setDeliveryInfoType(String deliveryInfoType) {
		this.deliveryInfoType = deliveryInfoType;
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

	public List<SelfMentionAddressListVo> getSelfMentionAddressMage() {
		return selfMentionAddressMage;
	}

	public void setSelfMentionAddressMage(List<SelfMentionAddressListVo> selfMentionAddressMage) {
		this.selfMentionAddressMage = selfMentionAddressMage;
	}

	public String getNfkfpType() {
		return nfkfpType;
	}

	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}

	public String getInvoContent() {
		return invoContent;
	}

	public void setInvoContent(String invoContent) {
		this.invoContent = invoContent;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public List<String> getInvoList() {
		return invoList;
	}

	public void setInvoList(List<String> invoList) {
		this.invoList = invoList;
	}
}
