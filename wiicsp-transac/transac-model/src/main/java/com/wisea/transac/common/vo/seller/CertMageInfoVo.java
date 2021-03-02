package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("证书管理详细信息Vo")
public class CertMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="店铺id")
    private Long shopId;

    @ApiModelProperty(value="证书名称")
    private String certName;

    @ApiModelProperty(value="证书图片")
    private List<CertPicturePageListVo> pictures;

    public List<CertPicturePageListVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<CertPicturePageListVo> pictures) {
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
