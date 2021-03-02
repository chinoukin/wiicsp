package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货拒绝退款VO
 */
@ApiModel("退货拒绝退款VO")
public class InitRefundCommApplVo {
    @ApiModelProperty("退货申请ID")
    private Long id;
    @ApiModelProperty("退货商品信息")
    private OrderCommRelaVo orderCommRela;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家联系人")
    private String buyerCustName;
    @ApiModelProperty("买家联系方式")
    private String buyerTel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderCommRelaVo getOrderCommRela() {
        return orderCommRela;
    }

    public void setOrderCommRela(OrderCommRelaVo orderCommRela) {
        this.orderCommRela = orderCommRela;
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

    public String getBuyerCustName() {
        return buyerCustName;
    }

    public void setBuyerCustName(String buyerCustName) {
        this.buyerCustName = buyerCustName;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }
}
