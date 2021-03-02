package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className LtaRefundCommApplListVo
 * @date 2019/5/10 10:12
 * @Description 长期协议退货申请列表Vo
 */
@ApiModel("长期协议退货申请列表Vo")
public class LtaRefundCommApplListVo {
    @ApiModelProperty("退货退款申请ID")
    private Long id;
    @ApiModelProperty("服务单号")
    @ExcelField(title = "服务单号", sort = 0, width = 20)
    private String serNum;
    @ApiModelProperty("申请时间")
    @ExcelField(title = "申请时间", sort = 1, width = 20)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("订单编号")
    @ExcelField(title = "订单编号", sort = 2, width = 20)
    private String ordNum;
    @ApiModelProperty("合同编号")
    @ExcelField(title = "合同编号", sort = 3, width = 20)
    private String ltaContNumb;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("用户账号")
    @ExcelField(title = "用户账号", sort = 4, width = 20)
    private String buyerAccount;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家用户账号")
    private String sellerAccount;
    @ApiModelProperty("应退款金额")
    @ExcelField(title = "应退款金额", sort = 5, width = 20)
    private Double shouldRefundAmount;
    @ApiModelProperty("联系人")
    @ExcelField(title = "联系人", sort = 6, width = 20)
    private String custName;
    @ApiModelProperty("退货退款申请状态")
    @ExcelField(title = "退货退款申请状态", sort = 7, width = 20, dictType = "refund_comm_state")
    private String refundCommState;
    @ApiModelProperty("处理时间")
    @ExcelField(title = "处理时间", sort = 8, width = 20)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime examSerBillDate;
    @ApiModelProperty("结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime doneDate;
    @ApiModelProperty("处理方标志")
    private String handlerType;
    /***************** 后台字段 ****************/
    @ApiModelProperty("服务费")
    private Double platfCost;
    @ApiModelProperty("商家退款")
    private Double sellerRefund;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Double getShouldRefundAmount() {
        return shouldRefundAmount;
    }

    public void setShouldRefundAmount(Double shouldRefundAmount) {
        this.shouldRefundAmount = shouldRefundAmount;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getRefundCommState() {
        return refundCommState;
    }

    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState;
    }

    public OffsetDateTime getExamSerBillDate() {
        return examSerBillDate;
    }

    public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
        this.examSerBillDate = examSerBillDate;
    }

    public OffsetDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(OffsetDateTime doneDate) {
        this.doneDate = doneDate;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getSellerRefund() {
        return sellerRefund;
    }

    public void setSellerRefund(Double sellerRefund) {
        this.sellerRefund = sellerRefund;
    }
}
