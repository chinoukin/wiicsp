package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("ShopInfo详细信息Vo")
public class ShopInfoInfoVo {
    @ApiModelProperty(value="店铺id")
    private Long id;

    @ApiModelProperty(value="服务商id")
    private Long membId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;

    @ApiModelProperty(value="店铺背景图")
    private String backGroundUrl;

    @ApiModelProperty(value="店铺介绍")
    private String shopSignature;

    @ApiModelProperty(value = "证书信息")
    private List<CertMageInfoVo> certMageInfoVoList;

    @ApiModelProperty(value = "关注id 存在就是关注过")
    private Long membAttentionId;

    public Long getMembAttentionId() {
        return membAttentionId;
    }

    public void setMembAttentionId(Long membAttentionId) {
        this.membAttentionId = membAttentionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CertMageInfoVo> getCertMageInfoVoList() {
        return certMageInfoVoList;
    }

    public void setCertMageInfoVoList(List<CertMageInfoVo> certMageInfoVoList) {
        this.certMageInfoVoList = certMageInfoVoList;
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
