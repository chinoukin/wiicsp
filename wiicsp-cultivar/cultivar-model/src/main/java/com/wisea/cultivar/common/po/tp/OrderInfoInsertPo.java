package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OrderInfoInsertPo
 * 2018/09/20 16:05:49
 */
public class OrderInfoInsertPo {
    /**
     * 订单编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 收货地址id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "收货地址id")
    private Long receAddressId;

    /**
     * 发票信息ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "发票信息ID")
    private Long invoId;

    /**
     * 配送时间类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "配送时间类型")
    private String distribDateType;

    /**
     * 支付方式类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "支付方式类型")
    private String payMethodType;

    /**
     * 商品总件数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "商品总件数")
    private Integer commTotalCount;

    /**
     * 商品总金额(商品发布价格)
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "商品总金额(商品发布价格)")
    private Double commTotalPrice;

    /**
     * 运费总金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "运费总金额")
    private Double commTotalFreight;

    /**
     * 平台服务费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "平台服务费")
    private Double platfCost;

    /**
     * 应付款金额（商品发布价+运费）
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应付款金额（商品发布价+运费）")
    private Double amountPayable;

    /**
     * 订单状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    /**
     * 买方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "买方ID")
    private Long buyerId;

    /**
     * 卖方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

    /**
     * 提交订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime referOrdDate;

    /**
     * 付款截止日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "付款截止日期")
    private OffsetDateTime payDeadDate;

    /**
     * 支付订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "支付订单日期")
    private OffsetDateTime payOrdDate;

    /**
     * 发货日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发货日期")
    private OffsetDateTime deliveDate;

    /**
     * 确认收货日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "确认收货日期")
    private OffsetDateTime confirmDate;

    /**
     * 确认收货截止日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "确认收货截止日期")
    private OffsetDateTime confirmDeadLineDate;

    /**
     * 评价日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "评价日期")
    private OffsetDateTime evalDate;

    /**
     * 延期收货原因
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "延期收货原因")
    private String delayReason;

    /**
     * 延期期限
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "延期期限")
    private Integer delayDate;

    /**
     * 物流公司名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 物流单号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "物流单号")
    private String logisticsNum;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取收货地址id
     */
    public Long getReceAddressId() {
        return receAddressId;
    }

    /**
     * 设置收货地址id
     */
    public void setReceAddressId(Long receAddressId) {
        this.receAddressId = receAddressId;
    }

    /**
     * 获取发票信息ID
     */
    public Long getInvoId() {
        return invoId;
    }

    /**
     * 设置发票信息ID
     */
    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

    /**
     * 获取配送时间类型
     */
    public String getDistribDateType() {
        return distribDateType;
    }

    /**
     * 设置配送时间类型
     */
    public void setDistribDateType(String distribDateType) {
        this.distribDateType = distribDateType == null ? null : distribDateType.trim();
    }

    /**
     * 获取支付方式类型
     */
    public String getPayMethodType() {
        return payMethodType;
    }

    /**
     * 设置支付方式类型
     */
    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType == null ? null : payMethodType.trim();
    }

    /**
     * 获取商品总件数
     */
    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    /**
     * 设置商品总件数
     */
    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    /**
     * 获取商品总金额(商品发布价格)
     */
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    /**
     * 设置商品总金额(商品发布价格)
     */
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    /**
     * 获取运费总金额
     */
    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    /**
     * 设置运费总金额
     */
    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    /**
     * 获取平台服务费
     */
    public Double getPlatfCost() {
        return platfCost;
    }

    /**
     * 设置平台服务费
     */
    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    /**
     * 获取应付款金额（商品发布价+运费）
     */
    public Double getAmountPayable() {
        return amountPayable;
    }

    /**
     * 设置应付款金额（商品发布价+运费）
     */
    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    /**
     * 获取订单状态类型
     */
    public String getOrderStateType() {
        return orderStateType;
    }

    /**
     * 设置订单状态类型
     */
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType == null ? null : orderStateType.trim();
    }

    /**
     * 获取买方ID
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买方ID
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取提交订单日期
     */
    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    /**
     * 设置提交订单日期
     */
    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    /**
     * 获取付款截止日期
     */
    public OffsetDateTime getPayDeadDate() {
        return payDeadDate;
    }

    /**
     * 设置付款截止日期
     */
    public void setPayDeadDate(OffsetDateTime payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    /**
     * 获取支付订单日期
     */
    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    /**
     * 设置支付订单日期
     */
    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    /**
     * 获取发货日期
     */
    public OffsetDateTime getDeliveDate() {
        return deliveDate;
    }

    /**
     * 设置发货日期
     */
    public void setDeliveDate(OffsetDateTime deliveDate) {
        this.deliveDate = deliveDate;
    }

    /**
     * 获取确认收货日期
     */
    public OffsetDateTime getConfirmDate() {
        return confirmDate;
    }

    /**
     * 设置确认收货日期
     */
    public void setConfirmDate(OffsetDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * 获取确认收货截止日期
     */
    public OffsetDateTime getConfirmDeadLineDate() {
        return confirmDeadLineDate;
    }

    /**
     * 设置确认收货截止日期
     */
    public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
        this.confirmDeadLineDate = confirmDeadLineDate;
    }

    /**
     * 获取评价日期
     */
    public OffsetDateTime getEvalDate() {
        return evalDate;
    }

    /**
     * 设置评价日期
     */
    public void setEvalDate(OffsetDateTime evalDate) {
        this.evalDate = evalDate;
    }

    /**
     * 获取延期收货原因
     */
    public String getDelayReason() {
        return delayReason;
    }

    /**
     * 设置延期收货原因
     */
    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason == null ? null : delayReason.trim();
    }

    /**
     * 获取延期期限
     */
    public Integer getDelayDate() {
        return delayDate;
    }

    /**
     * 设置延期期限
     */
    public void setDelayDate(Integer delayDate) {
        this.delayDate = delayDate;
    }

    /**
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取物流单号
     */
    public String getLogisticsNum() {
        return logisticsNum;
    }

    /**
     * 设置物流单号
     */
    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
