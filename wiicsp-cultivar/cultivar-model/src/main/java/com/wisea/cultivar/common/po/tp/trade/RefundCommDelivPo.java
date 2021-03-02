package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家端商品发货PO
 */
@ApiModel("买家端商品发货PO")
public class RefundCommDelivPo {

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "退货id")
    private Long id;
    @ApiModelProperty("物流公司名称")
    @Check(test = "logic", logic = "'0'.equals(#buyerSendType)?#isNotEmpty(#logisticsCompName):true", logicMsg = "物流公司名称不能为空")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    @Check(test = "logic", logic = "'0'.equals(#buyerSendType)?#isNotEmpty(#logisticsNum):true", logicMsg = "物流单号不能为空")
    private String logisticsNum;
    @ApiModelProperty("是否修改标识，0：新填写发货信息；1：修改发货信息")
    private String ifUpdFlag;
    @ApiModelProperty("买家发货类型(O：物流配送，1：自行配送)")
    @Check(test = "required")
    private String buyerSendType;
    @ApiModelProperty("运送人")
    @Check(test = "logic", logic = "'1'.equals(#buyerSendType)?#isNotEmpty(#sender):true", logicMsg = "运送人不能为空")
    private String sender;
    @ApiModelProperty("运送人联系电话")
    @Check(test = "logic", logic = "'1'.equals(#senderTel)?#isNotEmpty(#logisticsNum):true", logicMsg = "运送人联系电话不能为空")
    private String senderTel;
    @ApiModelProperty("车船号")
    private String cchNum;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getIfUpdFlag() {
		return ifUpdFlag;
	}
	public void setIfUpdFlag(String ifUpdFlag) {
		this.ifUpdFlag = ifUpdFlag;
	}
	public String getBuyerSendType() {
		return buyerSendType;
	}
	public void setBuyerSendType(String buyerSendType) {
		this.buyerSendType = buyerSendType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderTel() {
		return senderTel;
	}
	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}
	public String getCchNum() {
		return cchNum;
	}
	public void setCchNum(String cchNum) {
		this.cchNum = cchNum;
	}
}
