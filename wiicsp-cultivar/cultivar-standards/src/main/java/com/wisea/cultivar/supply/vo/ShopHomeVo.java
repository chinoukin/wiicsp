package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页商店信息
 * @author chengq
 * @date 2020/8/12 9:57
 */
public class ShopHomeVo {

    @ApiModelProperty("店铺id")
    private String shopId;

    /**
     * 店铺名称
     */
    @ApiModelProperty("店铺名称")
    private String shopName;

    /**
     * 主体类型
     */
    @ApiModelProperty("认证状态 0-企业 1-个人 3-未认证")
    private String authType;

    /**
     * 店铺背景图
     */
    @ApiModelProperty("店铺背景图")
    private String backGroundUrl;

    /**
     * 是否可以修改
     */
    @ApiModelProperty("是否可以修改名称 0-可以 1-不可以")
    private String isChange;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }

    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
