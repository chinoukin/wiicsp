package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zhfw_brand_entp_reco 表实体
 * 种植服务品牌企业推荐
 * 2020/08/24 20:28:13
 */
public class ZhfwBrandEntpReco extends DataLongEntity<ZhfwBrandEntpReco> {
    private static final long serialVersionUID = 1L;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 宣传视频图片
     */
    private String url;

    /**
     * 企业logo
     */
    private String logoUrl;

    /**
     * 企业简介
     */
    private String entpIntro;

    /**
     * 企业平台店铺地址
     */
    private String shopUrl;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public ZhfwBrandEntpReco() {
        super();
    }

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
}
