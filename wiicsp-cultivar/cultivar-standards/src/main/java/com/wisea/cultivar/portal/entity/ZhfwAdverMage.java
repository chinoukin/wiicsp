package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zhfw_adver_mage 表实体
 * 种植服务广告管理
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverMage extends DataLongEntity<ZhfwAdverMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 广告位id
     */
    private Long adverSpaceId;

    /**
     * 广告名称
     */
    private String adverName;

    /**
     * 广告图片
     */
    private String adverImage;

    /**
     * 链接类型
     */
    private String linkType;

    /**
     * 链接地址
     */
    private String linkAddress;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 打开方式
     */
    private String openMode;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private String enableFlag;

    /**
     *
     * @mbg.generated
     */
    public ZhfwAdverMage() {
        super();
    }

    /**
     * 获取广告位id
     */
    public Long getAdverSpaceId() {
        return adverSpaceId;
    }

    /**
     * 设置广告位id
     */
    public void setAdverSpaceId(Long adverSpaceId) {
        this.adverSpaceId = adverSpaceId;
    }

    /**
     * 获取广告名称
     */
    public String getAdverName() {
        return adverName;
    }

    /**
     * 设置广告名称
     */
    public void setAdverName(String adverName) {
        this.adverName = adverName == null ? null : adverName.trim();
    }

    /**
     * 获取广告图片
     */
    public String getAdverImage() {
        return adverImage;
    }

    /**
     * 设置广告图片
     */
    public void setAdverImage(String adverImage) {
        this.adverImage = adverImage == null ? null : adverImage.trim();
    }

    /**
     * 获取链接类型
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * 设置链接类型
     */
    public void setLinkType(String linkType) {
        this.linkType = linkType == null ? null : linkType.trim();
    }

    /**
     * 获取链接地址
     */
    public String getLinkAddress() {
        return linkAddress;
    }

    /**
     * 设置链接地址
     */
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取打开方式
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * 设置打开方式
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置状态
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }
}
