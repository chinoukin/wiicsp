package com.wisea.cultivar.supply.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存店铺信息
 * @author chengq
 * @date 2020/8/13 9:32
 */
public class ShopInfoSavePo {

    /**
     * 店铺名称
     */
    @Check(test = { "required", "maxLength" }, length = 20, lengthMsg = "店铺名称不能超过20字", requiredMsg = "店铺名称不能为空")
    @ApiModelProperty(value = "店铺名称", required = true)
    private String shopName;

    /**
     * 店铺背景图
     */
    @ApiModelProperty("店铺背景图")
    private String backGroundUrl;

    /**
     * 服务商id
     */
    @JsonIgnore
    @ApiModelProperty(value = "服务商id", hidden = true)
    private Long membId;

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

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
