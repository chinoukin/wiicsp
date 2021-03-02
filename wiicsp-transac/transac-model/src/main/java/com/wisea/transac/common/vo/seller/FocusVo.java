package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注数量")
public class FocusVo {

    @ApiModelProperty(value="关注的商品数量")
    private Long fwCommSum;

    @ApiModelProperty(value="关注的商家")
    private Long fwMerchantSum;


    public Long getFwCommSum() {
        return fwCommSum;
    }

    public void setFwCommSum(Long fwCommSum) {
        this.fwCommSum = fwCommSum;
    }

    public Long getFwMerchantSum() {
        return fwMerchantSum;
    }

    public void setFwMerchantSum(Long fwMerchantSum) {
        this.fwMerchantSum = fwMerchantSum;
    }
}
