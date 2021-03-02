package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OutstandingBillVo
 * @date 2020/5/19 14:37
 * @Description 未出账单Vo
 */
@ApiModel("未出账单Vo")
public class OutstandingBillVo {
    @ApiModelProperty("卖家ID")
    private Long sellerId;
    @ApiModelProperty("卖家名称")
    private String sellerName;
    @ApiModelProperty("买家ID")
    private Long buyerId;
    @ApiModelProperty("买家名称")
    private String buyerName;
    @ApiModelProperty("买家账号")
    private String buyerAccount;
    @ApiModelProperty("账期类型")
    private String settleCycleType;
    @ApiModelProperty("账单生成日类型")
    private String billDateType;
    @ApiModelProperty("未出账单金额")
    private Double settleAmount;
    @ApiModelProperty("订单数量")
    private Integer ordCount;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getBillDateType() {
        return billDateType;
    }

    public void setBillDateType(String billDateType) {
        this.billDateType = billDateType;
    }

    public Double getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Double settleAmount) {
        this.settleAmount = settleAmount;
    }

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }
}
