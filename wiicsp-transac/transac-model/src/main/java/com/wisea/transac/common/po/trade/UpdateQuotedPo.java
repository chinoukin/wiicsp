package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className UpdateQuotedPo
 * @date 2020/5/6 15:59
 * @Description
 */
@ApiModel("修改报价PO")
public class UpdateQuotedPo extends LongIdPo {
    @ApiModelProperty("订单商品ID")
    private Long ordCommRelaId;
    @ApiModelProperty("商品总重量")
    private Double commTotalWeight;
    @ApiModelProperty("单位重量单价")
    private Double unitWeightPrice;

    public Long getOrdCommRelaId() {
        return ordCommRelaId;
    }

    public void setOrdCommRelaId(Long ordCommRelaId) {
        this.ordCommRelaId = ordCommRelaId;
    }

    public Double getCommTotalWeight() {
        return commTotalWeight;
    }

    public void setCommTotalWeight(Double commTotalWeight) {
        this.commTotalWeight = commTotalWeight;
    }

    public Double getUnitWeightPrice() {
        return unitWeightPrice;
    }

    public void setUnitWeightPrice(Double unitWeightPrice) {
        this.unitWeightPrice = unitWeightPrice;
    }
}
