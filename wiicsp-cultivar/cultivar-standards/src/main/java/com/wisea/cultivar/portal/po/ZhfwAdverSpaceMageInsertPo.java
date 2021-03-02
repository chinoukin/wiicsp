package com.wisea.cultivar.portal.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwAdverSpaceMageInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverSpaceMageInsertPo {
    /**
     * 广告位名称
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "广告位名称", allowableValues = "mixLength:(,5]")
    private String adverSpaceName;

    /**
     * 广告位类别
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "广告位类别", allowableValues = "mixLength:(,5]")
    private String adverSpaceType;

    /**
     * 宽度
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "宽度", allowableValues = "length:(,10]")
    private Integer weight;

    /**
     * 高度
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "高度", allowableValues = "length:(,10]")
    private Integer height;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "状态", allowableValues = "mixLength:(,5]")
    private String enableFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

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
