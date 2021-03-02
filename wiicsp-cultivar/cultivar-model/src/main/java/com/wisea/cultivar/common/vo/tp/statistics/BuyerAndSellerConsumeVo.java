package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 买卖家消费排行返回值
 * @author: wangs
 * @date :2018/11/30
 */
@ApiModel("买卖家消费排行返回值")
public class BuyerAndSellerConsumeVo {

    /**
     * 购买金额
     */
    @ApiModelProperty(value = "购买金额")
    private String purchaseAmount;

    /**
     * 订单数
     */
    @ApiModelProperty(value = "商品数")
    private String orderCount;

    /**
     * 会员账号
     */
    @ApiModelProperty(value = "会员账号")
    private String userName;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "企业名称")
    private String endpName;

    @ApiModelProperty(value = "订单数")
    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEndpName() {
        return endpName;
    }

    public void setEndpName(String endpName) {
        this.endpName = endpName;
    }
}
