package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.FollowMerchantminiPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的店铺分页查询Po")
public class FollowMerchantminiPageListPo extends PagePo<FollowMerchantminiPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="店铺id")
    private Long shopId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
