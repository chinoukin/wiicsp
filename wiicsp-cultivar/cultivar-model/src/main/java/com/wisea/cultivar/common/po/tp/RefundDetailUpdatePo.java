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
 * RefundDetailUpdatePo
 * 2019/01/23 10:21:32
 */
public class RefundDetailUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 服务单号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "服务单号")
    private String serNum;

    /**
     * 订单编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 交易时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "交易时间")
    private OffsetDateTime tradeDate;

    /**
     * 申请金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "申请金额")
    private Double applAmount;

    /**
     * 退款方式
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "退款方式")
    private String refundModeType;

    /**
     * 退款金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "退款金额")
    private Double refundAmount;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取服务单号
     */
    public String getSerNum() {
        return serNum;
    }

    /**
     * 设置服务单号
     */
    public void setSerNum(String serNum) {
        this.serNum = serNum == null ? null : serNum.trim();
    }

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
     * 获取交易时间
     */
    public OffsetDateTime getTradeDate() {
        return tradeDate;
    }

    /**
     * 设置交易时间
     */
    public void setTradeDate(OffsetDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取申请金额
     */
    public Double getApplAmount() {
        return applAmount;
    }

    /**
     * 设置申请金额
     */
    public void setApplAmount(Double applAmount) {
        this.applAmount = applAmount;
    }

    /**
     * 获取退款方式
     */
    public String getRefundModeType() {
        return refundModeType;
    }

    /**
     * 设置退款方式
     */
    public void setRefundModeType(String refundModeType) {
        this.refundModeType = refundModeType == null ? null : refundModeType.trim();
    }

    /**
     * 获取退款金额
     */
    public Double getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     */
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
