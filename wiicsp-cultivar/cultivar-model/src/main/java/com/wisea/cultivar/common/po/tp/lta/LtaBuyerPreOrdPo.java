package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangtao
 * ltaBuyerPreOrdPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端提交订单po")
public class LtaBuyerPreOrdPo {

	@ApiModelProperty(value = "订单商品")
	@Check(test = "required", cascade=true)
    private List<LtaBuyerPreOrdCommPo> ltaBuyerPreOrdCommPo;

    @ApiModelProperty(value = "买家留言")
    private String leaveMess;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "合同ID")
    @Check(test = "required")
    private Long contId;

    @ApiModelProperty(value = "配送信息类型")
	@Check(test = "required")
	private String deliveryInfoType;

    @ApiModelProperty(value = "发票ID")
	private Long invoId;

    @ApiModelProperty("最晚到货时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime latestArrivalDate;

    @ApiModelProperty(value = "收货地址的ID")
    @Check(test = "logic", logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressId):true", logicMsg = "配送信息id不能为空")
    private Long receAddressId;

    @ApiModelProperty(value = "提货地址信息id")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#selfMAddrMageId):true", logicMsg = "配送信息id不能为空")
	private Long selfMAddrMageId;

	@ApiModelProperty("提货人姓名")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeName):true", logicMsg = "提货人姓名不能为空")
	private String consigneeName;

	@ApiModelProperty("提货人手机号")
	@Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeTel):true", logicMsg = "提货人手机号不能为空")
	private String consigneeTel;

	public List<LtaBuyerPreOrdCommPo> getLtaBuyerPreOrdCommPo() {
		return ltaBuyerPreOrdCommPo;
	}

	public void setLtaBuyerPreOrdCommPo(List<LtaBuyerPreOrdCommPo> ltaBuyerPreOrdCommPo) {
		this.ltaBuyerPreOrdCommPo = ltaBuyerPreOrdCommPo;
	}

	public String getLeaveMess() {
		return leaveMess;
	}

	public void setLeaveMess(String leaveMess) {
		this.leaveMess = leaveMess;
	}

	public Long getContId() {
		return contId;
	}

	public void setContId(Long contId) {
		this.contId = contId;
	}

	public String getDeliveryInfoType() {
		return deliveryInfoType;
	}

	public void setDeliveryInfoType(String deliveryInfoType) {
		this.deliveryInfoType = deliveryInfoType;
	}

	public Long getInvoId() {
		return invoId;
	}

	public void setInvoId(Long invoId) {
		this.invoId = invoId;
	}

	public OffsetDateTime getLatestArrivalDate() {
		return latestArrivalDate;
	}

	public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
		this.latestArrivalDate = latestArrivalDate;
	}

	public Long getReceAddressId() {
		return receAddressId;
	}

	public void setReceAddressId(Long receAddressId) {
		this.receAddressId = receAddressId;
	}

	public Long getSelfMAddrMageId() {
		return selfMAddrMageId;
	}

	public void setSelfMAddrMageId(Long selfMAddrMageId) {
		this.selfMAddrMageId = selfMAddrMageId;
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
}
