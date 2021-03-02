package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * adver_mage 表实体
 * 广告管理
 * 2019/05/28 16:20:20
 */
public class AdverMage extends DataLongEntity<AdverMage> {
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
     * 链接类型（无操作、链接地址、具体商品）
     */
    private String linkType;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态（启用、停用）
     */
    private String enableFlag;

    /**
     * 链接地址
     */
    private String linkAddress;

    /**
     * 打开方式
     */
    private String openMode;

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
     * 获取链接类型（无操作、链接地址、具体商品）
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * 设置链接类型（无操作、链接地址、具体商品）
     */
    public void setLinkType(String linkType) {
        this.linkType = linkType == null ? null : linkType.trim();
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
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
     * 获取状态（启用、停用）
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置状态（启用、停用）
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getOpenMode() {
		return openMode;
	}

	public void setOpenMode(String openMode) {
		this.openMode = openMode;
	}
}
