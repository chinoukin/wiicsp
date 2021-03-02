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
 * @className LtaRefundApplListVo
 * @date 2019/5/9 16:35
 * @Description 长期协议退款列表Vo
 */
@ApiModel("长期协议退款列表Vo")
public class LtaRefundApplListVo {
    @ApiModelProperty("退款申请ID")
    private Long id;
    @ApiModelProperty("服务单号")
    @ExcelField(title = "服务单号", sort = 0, width = 20)
    private String refundNum;
    @ApiModelProperty("申请时间")
    @ExcelField(title = "申请时间", sort = 1, width = 20)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("订单编号")
    @ExcelField(title = "订单编号", sort = 2, width = 20)
    private String ltaOrdNumb;
    @ApiModelProperty("合同编号")
    @ExcelField(title = "合同编号", sort = 3, width = 20)
    private String ltaContNumb;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("用户账号")
    @ExcelField(title = "用户账号", sort = 4, width = 20)
    private String buyerAccount;
    @ApiModelProperty("退款金额")
    @ExcelField(title = "退款金额", sort = 5, width = 20)
    private Double refundAmount;
    @ApiModelProperty("退款申请状态")
    @ExcelField(title = "退款申请状态", sort = 6, width = 20, dictType = "refund_appl_state_type")
    private String refundApplStateType;
    @ApiModelProperty("处理时间")
    @ExcelField(title = "处理时间", sort = 7, width = 20)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime handleDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
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

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }

    public OffsetDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(OffsetDateTime handleDate) {
        this.handleDate = handleDate;
    }
}
