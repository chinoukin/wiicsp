package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询ShopInfoVo")
public class ShopInfoPageListVo {
    @ApiModelProperty(value="服务商id")
    private Long membId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;

    @ApiModelProperty(value="店铺背景图")
    private String backGroundUrl;

    @ApiModelProperty(value="店铺介绍")
    private String shopSignature;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }

    public String getShopSignature() {
        return shopSignature;
    }

    public void setShopSignature(String shopSignature) {
        this.shopSignature = shopSignature;
    }
}
