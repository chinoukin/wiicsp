package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zhfw_adver_space_mage 表实体
 * 种植服务广告位管理
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverSpaceMage extends DataLongEntity<ZhfwAdverSpaceMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 广告位名称
     */
    private String adverSpaceName;

    /**
     * 广告位类别
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
     * 状态
     */
    private String enableFlag;

    /**
     *
     * @mbg.generated
     */
    public ZhfwAdverSpaceMage() {
        super();
    }

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
     * 获取广告位类别
     */
    public String getAdverSpaceType() {
        return adverSpaceType;
    }

    /**
     * 设置广告位类别
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
