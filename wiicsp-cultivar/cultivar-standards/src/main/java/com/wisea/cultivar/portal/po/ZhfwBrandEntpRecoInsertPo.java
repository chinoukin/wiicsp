package com.wisea.cultivar.portal.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwBrandEntpRecoInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwBrandEntpRecoInsertPo {
    /**
     * 企业名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业名称", allowableValues = "mixLength:(,255]")
    private String entpName;

    /**
     * 宣传视频图片
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "宣传视频图片", allowableValues = "mixLength:(,255]")
    private String url;

    /**
     * 企业logo
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业logo", allowableValues = "mixLength:(,255]")
    private String logoUrl;

    /**
     * 企业简介
     */
    @Check(test = { "maxLength" }, mixLength = 400)
    @ApiModelProperty(value = "企业简介", allowableValues = "mixLength:(,400]")
    private String entpIntro;

    /**
     * 企业平台店铺地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业平台店铺地址", allowableValues = "mixLength:(,255]")
    private String shopUrl;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取宣传视频图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置宣传视频图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取企业logo
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置企业logo
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * 获取企业简介
     */
    public String getEntpIntro() {
        return entpIntro;
    }

    /**
     * 设置企业简介
     */
    public void setEntpIntro(String entpIntro) {
        this.entpIntro = entpIntro == null ? null : entpIntro.trim();
    }

    /**
     * 获取企业平台店铺地址
     */
    public String getShopUrl() {
        return shopUrl;
    }

    /**
     * 设置企业平台店铺地址
     */
    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl == null ? null : shopUrl.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
