package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的店铺新增或修改Po")
public class FollowMerchantPo {
    @ApiModelProperty(value="id",hidden = true)
    private Long id;

    @ApiModelProperty(value="会员id",hidden = true)
    private Long membId;

    @ApiModelProperty(value="店铺id")
    @Check(
            test = {"required"}
    )
    private Long shopId;

    @ApiModelProperty(value="标示",hidden = true)
    private String flag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
