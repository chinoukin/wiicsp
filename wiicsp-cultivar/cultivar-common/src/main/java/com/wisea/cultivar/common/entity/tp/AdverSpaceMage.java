package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * adver_space_mage 表实体
 * 广告位管理
 * 2019/05/28 16:20:20
 */
public class AdverSpaceMage extends DataLongEntity<AdverSpaceMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 广告位名称
     */
    private String adverSpaceName;

    /**
     * 广告位类别（PC幻灯、WAP幻灯、PC图片）
     */
    private String adverSpaceType;

    /**
     * 宽度
     */
    private Integer weight;

    /**
     * 高度
     */
    private Integer height;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态（启用、停用）
     */
    private String enableFlag;

    /**
     * 获取广告位名称
     */
    public String getAdverSpaceName() {
        return adverSpaceName;
    }

    /**
     * 设置广告位名称
     */
    public void setAdverSpaceName(String adverSpaceName) {
        this.adverSpaceName = adverSpaceName == null ? null : adverSpaceName.trim();
    }

    /**
     * 获取广告位类别（PC幻灯、WAP幻灯、PC图片）
     */
    public String getAdverSpaceType() {
        return adverSpaceType;
    }

    /**
     * 设置广告位类别（PC幻灯、WAP幻灯、PC图片）
     */
    public void setAdverSpaceType(String adverSpaceType) {
        this.adverSpaceType = adverSpaceType == null ? null : adverSpaceType.trim();
    }

    /**
     * 获取宽度
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置宽度
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取高度
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置高度
     */
    public void setHeight(Integer height) {
        this.height = height;
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
}
