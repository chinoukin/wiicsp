package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerGeneratingOrderPo
 * 2018/09/18 17:40:35
 */
@ApiModel("提交生成订单po")
public class BuyerGeneratingOrderPo{

	@ApiModelProperty(value = "每个商家的商品id")
	@Check(test = "required")
	private List<OrderApplPo> commpubListIds;

	@ApiModelProperty(value = "收货地址的ID")
	@Check(test = "logic", logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressId):true", logicMsg = "配送信息id不能为空")
	private Long receAddressId;

	@ApiModelProperty(value = "商品总金额")
	private Double payMonet;

	@ApiModelProperty(value = "配送时间类型")
	//@Check(test = "required")
	private String distribDateType;

	@ApiModelProperty("最晚到货时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime latestArrivalDate;

	@ApiModelProperty(value = "配送信息类型")
	@Check(test = "required")
	private String deliveryInfoType;

	@ApiModelProperty(value = "支付方式类型")
	@Check(test = "required")
	private String payMethodType;

	@ApiModelProperty("商品类型，0大宗单品，1中小零批")
	@Check(test = "required")
	private String commPubType;

	@ApiModelProperty(value = "提货地址信息id")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#selfMAddrMageId):true", logicMsg = "配送信息id不能为空")
	private Long selfMAddrMageId;

	@ApiModelProperty("提货人姓名")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeName):true", logicMsg = "提货人姓名不能为空")
	private String consigneeName;

	@ApiModelProperty("提货人手机号")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeTel):true", logicMsg = "提货人手机号不能为空")
	private String consigneeTel;


	public List<OrderApplPo> getCommpubListIds() {
		return commpubListIds;
	}

	public void setCommpubListIds(List<OrderApplPo> commpubListIds) {
		this.commpubListIds = commpubListIds;
	}

	public Double getPayMonet() {
		return payMonet;
	}

	public void setPayMonet(Double payMonet) {
		this.payMonet = payMonet;
	}

	public OffsetDateTime getLatestArrivalDate() {
		return latestArrivalDate;
	}

	public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
		this.latestArrivalDate = latestArrivalDate;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getDeliveryInfoType() {
		return deliveryInfoType;
	}

	public void setDeliveryInfoType(String deliveryInfoType) {
		this.deliveryInfoType = deliveryInfoType;
	}

	public Long getSelfMAddrMageId() {
		return selfMAddrMageId;
	}

	public void setSelfMAddrMageId(Long selfMAddrMageId) {
		this.selfMAddrMageId = selfMAddrMageId;
	}

	public String getCommPubType() {
		return commPubType;
	}

	public void setCommPubType(String commPubType) {
		this.commPubType = commPubType;
	}

	public Long getReceAddressId() {
		return receAddressId;
	}

	public void setReceAddressId(Long receAddressId) {
		this.receAddressId = receAddressId;
	}

	public String getDistribDateType() {
		return distribDateType;
	}

	public void setDistribDateType(String distribDateType) {
		this.distribDateType = distribDateType;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
}
