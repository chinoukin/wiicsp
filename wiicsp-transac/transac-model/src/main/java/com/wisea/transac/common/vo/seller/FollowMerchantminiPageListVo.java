package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的店铺分页查询Vo")
public class FollowMerchantminiPageListVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺背景图")
    private String backGroundUrl;

    @ApiModelProperty(value = "店铺介绍")
    private String shopSignature;

    @ApiModelProperty(value = "企业认证状态")
    private String entpAuth;

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

    public String getEntpAuth() {
        return entpAuth;
    }

    public void setEntpAuth(String entpAuth) {
        this.entpAuth = entpAuth;
    }
}
