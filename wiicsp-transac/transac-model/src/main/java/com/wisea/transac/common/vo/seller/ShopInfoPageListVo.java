package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("店铺分页查询Vo")
public class ShopInfoPageListVo {
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

    @ApiModelProperty("实时看货视频地址")
    private List<StallsVideoMageInfoVo> videoUrl;

    public List<StallsVideoMageInfoVo> getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(List<StallsVideoMageInfoVo> videoUrl) {
        this.videoUrl = videoUrl;
    }

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
