package com.wisea.cultivar.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @ClassName: SerListMageListVo
 * @Author: tgz
 * @Date: 2020/8/4 21:57
 */
@ApiModel("商家查询订单列表VO")
public class SerListMageListVo {

        @ApiModelProperty("服务单ID")
        private Long id;
        @ApiModelProperty("服务单编号")
        private String serListNo;
        @ApiModelProperty("预约时间")
        private OffsetDateTime subscribeDate;
        @ApiModelProperty("客户账号")
        private String buyerAccount;
        @ApiModelProperty("服务商账号")
        private String sellerAccount;
        @ApiModelProperty("订单状态类型")
        private String serListStateType;
        @ApiModelProperty("订单状态类型值")
        private String serListStateTypeValue;
        @ApiModelProperty("应付款金额(订单总金额)")
        private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public OffsetDateTime getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(OffsetDateTime subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public String getSerListStateTypeValue() {
        return serListStateTypeValue;
    }

    public void setSerListStateTypeValue(String serListStateTypeValue) {
        this.serListStateTypeValue = serListStateTypeValue;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
