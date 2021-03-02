package com.wisea.cultivar.common.vo.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className InitLtaRefundCommApplVo
 * @date 2019/5/13 9:29
 * @Description 退货拒绝退款VO
 */
@ApiModel("退货拒绝退款VO")
public class InitLtaRefundCommApplVo {
    @ApiModelProperty("退货申请ID")
    private Long id;
    @ApiModelProperty("退货商品信息")
    private LtaOrdCommRelaVo orderCommRela;
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

    public LtaOrdCommRelaVo getOrderCommRela() {
        return orderCommRela;
    }

    public void setOrderCommRela(LtaOrdCommRelaVo orderCommRela) {
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
