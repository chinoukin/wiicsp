package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangs
 */
@ApiModel("Image picture Vo")
public class CommPictureInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品发布id")
    private Long commPubInfo;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="图片类型:1：视频、0：图）")
    private String commPictureType;

    @ApiModelProperty(value="主图类型（0：主图:1：细节图）")
    private String pictureTypeName;

    @ApiModelProperty(value = "店铺信息")
    private String shopCertName;

    @ApiModelProperty(value = "店铺图片信息")
    private String shopInfoUrl;

    public String getShopInfoUrl() {
        return shopInfoUrl;
    }

    public void setShopInfoUrl(String shopInfoUrl) {
        this.shopInfoUrl = shopInfoUrl;
    }

    public String getShopCertName() {
        return shopCertName;
    }

    public void setShopCertName(String shopCertName) {
        this.shopCertName = shopCertName;
    }

    public String getPictureTypeName() {
        return pictureTypeName;
    }

    public void setPictureTypeName(String pictureTypeName) {
        this.pictureTypeName = pictureTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommPubInfo() {
        return commPubInfo;
    }

    public void setCommPubInfo(Long commPubInfo) {
        this.commPubInfo = commPubInfo;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommPictureType() {
        return commPictureType;
    }

    public void setCommPictureType(String commPictureType) {
        this.commPictureType = commPictureType;
    }
}
