package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 订单发货Po
 */
@ApiModel("订单发货Po")
public class OrderDelivePo {
    @Check(test = "required")
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("配送信息类型（0 商家配送 、1 买家自提）")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "配送信息类型有效值：0、1")
    private String deliveryInfoType;
    @ApiModelProperty("订单发货类型（0 物流配送 、1 商家送货）")
    @Check(test = "logic", logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#ordSendType):true", logicMsg = "订单发货类型【ordSendType】不能为空")
    private String ordSendType;

    /**买家自提**/
    @ApiModelProperty("自提时间")
    @Check(test = "logic", logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#ztDate):true", logicMsg = "自提时间【ztDate】不能为空")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime ztDate;
    @ApiModelProperty("操作备注")
    private String remarks;

    /**商家配送-物流配送**/
    @Check(test = "logic", logic = "'0'.equals(#ordSendType)?#isNotEmpty(#logisticsCompName):true", logicMsg = "物流公司名称【logisticsCompName】不能为空")
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @Check(test = "logic", logic = "'0'.equals(#ordSendType)?#isNotEmpty(#logisticsCompId):true", logicMsg = "物流公司Id【logisticsCompId】不能为空")
    @ApiModelProperty("物流公司Id")
    private Long logisticsCompId;
    @Check(test = "logic", logic = "'0'.equals(#ordSendType)?#isNotEmpty(#logisticsNum):true", logicMsg = "物流单号【logisticsNum】不能为空")
    @ApiModelProperty("物流单号")
    private String logisticsNum;

    /**商家配送-商家送货**/
    @ApiModelProperty("运送人")
    @Check(test = "logic", logic = "'1'.equals(#ordSendType)?#isNotEmpty(#sender):true", logicMsg = "运送人【sender】不能为空")
    private String sender;
    @ApiModelProperty("运送人联系电话")
    @Check(test = "logic", logic = "'1'.equals(#ordSendType)?#isNotEmpty(#senderTel):true", logicMsg = "运送人联系电话【senderTel】不能为空")
    private String senderTel;
    @ApiModelProperty("车船号")
    private String cchNum;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
    }

    public OffsetDateTime getZtDate() {
        return ztDate;
    }

    public void setZtDate(OffsetDateTime ztDate) {
        this.ztDate = ztDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
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
