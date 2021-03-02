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
 * RefundApplListPo
 * 2018/10/11 17:17:45
 */
public class RefundApplListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long orderId;

    /**
     * 退款金额
     */
    @ApiModelProperty(value = "退款金额")
    private Double refundAmount;

    /**
     * 退款原因id(退货退款原因管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "退款原因id(退货退款原因管理表id)")
    private Long refundReasonType;

    /**
     * 问题描述
     */
    @ApiModelProperty(value = "问题描述")
    private String refundDesc;

    /**
     * 退款编号
     */
    @ApiModelProperty(value = "退款编号")
    private String refundNum;

    /**
     * 退款申请状态类型
     */
    @ApiModelProperty(value = "退款申请状态类型")
    private String refundApplStateType;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;

    /**
     * 处理时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "处理时间")
    private OffsetDateTime handleDate;

    /**
     * 订单金额
     */
    @ApiModelProperty(value = "订单金额")
    private Double ordAmount;

    /**
     * 商家处理备注
     */
    @ApiModelProperty(value = "商家处理备注")
    private String sellerHandleRemarks;

    /**
     * 提出方标志
     */
    @ApiModelProperty(value = "提出方标志")
    private String buySellFlag;

    /**
     * 处理方类型
     */
    @ApiModelProperty(value = "处理方类型")
    private String handlerType;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
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
     * 获取订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
     * 获取退款原因id(退货退款原因管理表id)
     */
    public Long getRefundReasonType() {
        return refundReasonType;
    }

    /**
     * 设置退款原因id(退货退款原因管理表id)
     */
    public void setRefundReasonType(Long refundReasonType) {
        this.refundReasonType = refundReasonType;
    }

    /**
     * 获取问题描述
     */
    public String getRefundDesc() {
        return refundDesc;
    }

    /**
     * 设置问题描述
     */
    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc == null ? null : refundDesc.trim();
    }

    /**
     * 获取退款编号
     */
    public String getRefundNum() {
        return refundNum;
    }

    /**
     * 设置退款编号
     */
    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum == null ? null : refundNum.trim();
    }

    /**
     * 获取退款申请状态类型
     */
    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    /**
     * 设置退款申请状态类型
     */
    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType == null ? null : refundApplStateType.trim();
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取处理时间
     */
    public OffsetDateTime getHandleDate() {
        return handleDate;
    }

    /**
     * 设置处理时间
     */
    public void setHandleDate(OffsetDateTime handleDate) {
        this.handleDate = handleDate;
    }

    /**
     * 获取订单金额
     */
    public Double getOrdAmount() {
        return ordAmount;
    }

    /**
     * 设置订单金额
     */
    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }

    /**
     * 获取商家处理备注
     */
    public String getSellerHandleRemarks() {
        return sellerHandleRemarks;
    }

    /**
     * 设置商家处理备注
     */
    public void setSellerHandleRemarks(String sellerHandleRemarks) {
        this.sellerHandleRemarks = sellerHandleRemarks == null ? null : sellerHandleRemarks.trim();
    }

    /**
     * 获取提出方标志
     */
    public String getBuySellFlag() {
        return buySellFlag;
    }

    /**
     * 设置提出方标志
     */
    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag == null ? null : buySellFlag.trim();
    }

    /**
     * 获取处理方类型
     */
    public String getHandlerType() {
        return handlerType;
    }

    /**
     * 设置处理方类型
     */
    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType == null ? null : handlerType.trim();
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
