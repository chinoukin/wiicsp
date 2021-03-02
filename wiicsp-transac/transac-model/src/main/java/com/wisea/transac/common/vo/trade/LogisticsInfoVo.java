package com.wisea.transac.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 订单追踪VO
 */
@ApiModel("订单追踪VO")
public class LogisticsInfoVo {
    @ApiModelProperty("发货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime deliveDate;
    @ApiModelProperty("订单发货类型")
    private String ordSendType;
    /*****物流配送****/
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流公司编码")
    private String logisticsCompCode;
    @ApiModelProperty("物流单号")
    private String logisticsNum;
    @ApiModelProperty("收件人手机号")
    private String consigneePhone;
    /*****商家配送****/
    @ApiModelProperty("运送人")
    private String sender;
    @ApiModelProperty("运送人联系电话")
    private String senderTel;
    @ApiModelProperty("车船号")
    private String cchNum;

    public OffsetDateTime getDeliveDate() {
        return deliveDate;
    }

    public void setDeliveDate(OffsetDateTime deliveDate) {
        this.deliveDate = deliveDate;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
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
