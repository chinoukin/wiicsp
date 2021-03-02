package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.ShopInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("店铺分页查询Po")
public class ShopInfoPageListPo extends PagePo<ShopInfoPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商户id")
    private Long merchantId;

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

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
