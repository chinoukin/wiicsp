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
 * @className LtaOrderListVo
 * @date 2019/5/7 14:44
 * @Description 长期协议卖家/后台订单列表Vo
 */
@ApiModel("长期协议卖家/后台订单列表Vo")
public class LtaOrderListVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("合同编号")
    @ExcelField(title = "合同编号", sort = 0, width = 20)
    private String ltaContNumb;
    @ApiModelProperty("订单编号")
    @ExcelField(title = "订单编号", sort = 1, width = 20)
    private String ltaOrdNumb;
    @ApiModelProperty("下单时间")
    @ExcelField(title = "下单时间", sort = 2, width = 20)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime buyerOrdDate;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("采购商账号")
    @ExcelField(title = "采购商账号", sort = 3, width = 20)
    private String buyerAccount;
    @ApiModelProperty("采购商名称")
    @ExcelField(title = "采购商名称", sort = 4, width = 20)
    private String buyerName;
    @ApiModelProperty("订单金额")
    @ExcelField(title = "订单金额", sort = 5, width = 20)
    private Double yfAmount;
    @ApiModelProperty("支付方式类型")
    @ExcelField(title = "支付方式类型", sort = 6, width = 20, dictType = "pay_method_type")
    private String payMethodType;
    @ApiModelProperty("订单状态类型")
    @ExcelField(title = "订单状态类型", sort = 7, width = 20, dictType = "order_state_type")
    private String orderStateType;
    @ApiModelProperty("订单来源")
    private String sourceType;
    @ApiModelProperty("订单发货类型")
    private String ordSendType;
    @ApiModelProperty("配送信息类型")
    private String deliveryInfoType;
    @ApiModelProperty("物流公司ID")
    private Long logisticsCompId;
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流单号（注：deliveryInfoType为0并且orderStateType为0时列表显示物流追踪按钮）")
    private String logisticsNum;


    /*************** 后台使用字段 *************/
    @ApiModelProperty("卖家账号")
    private String sellerAccount;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("结算金额")
    private Double settlementAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
    }

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
    }

    public OffsetDateTime getBuyerOrdDate() {
        return buyerOrdDate;
    }

    public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
        this.buyerOrdDate = buyerOrdDate;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Double getYfAmount() {
        return yfAmount;
    }

    public void setYfAmount(Double yfAmount) {
        this.yfAmount = yfAmount;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
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

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
}
