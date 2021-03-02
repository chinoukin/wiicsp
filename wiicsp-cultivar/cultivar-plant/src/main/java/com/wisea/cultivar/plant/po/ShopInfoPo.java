package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改ShopInfoPo")
public class ShopInfoPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="服务商id")
    private Long membId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;

    @ApiModelProperty(value="店铺背景图")
    private String backGroundUrl;

    @ApiModelProperty(value="店铺介绍")
    private String shopSignature;

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
