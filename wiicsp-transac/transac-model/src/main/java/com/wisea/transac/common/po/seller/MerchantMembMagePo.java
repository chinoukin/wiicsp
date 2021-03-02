package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户管理的添加处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月3日
 * @version 1.0
 */
@ApiModel("客户管理的添加处理PO")
public class MerchantMembMagePo {

    @ApiModelProperty(value="商户id(不填默认当前商户)")
    private Long merchantId;

    @ApiModelProperty(value="会员id")
    @Check(test = {"required"})
    private Long membId;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
