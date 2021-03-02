package com.wisea.transac.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 图片信息
 * @author: wangs
 * @date :2020/5/7
 */
@ApiModel("图片信息")
public class CommPictureMagePo {

    /**
     * 商品发布id
     */
    @ApiModelProperty("商品发布id")
    private Long commPubId;

    /**
     * 排序
     */
    @ApiModelProperty("图片排序")
    private Integer sort;

    /**
     * 图片url
     */
    @ApiModelProperty("图片url")
    private String url;

    /**
     * 图片类型（主图、细节图）
     */
    @ApiModelProperty("图片类型 (0,主图,1,细节图,2,视频)")
    private String commPictureType;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
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
