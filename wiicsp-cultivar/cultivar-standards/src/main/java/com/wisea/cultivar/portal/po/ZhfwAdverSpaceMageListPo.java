package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwAdverSpaceMageListPo
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverSpaceMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 广告位名称
     */
    @ApiModelProperty(value = "广告位名称")
    private String adverSpaceName;

    /**
     * 广告位类别
     */
    @ApiModelProperty(value = "广告位类别")
    private String adverSpaceType;

    /**
     * 宽度
     */
    @ApiModelProperty(value = "宽度")
    private Integer weight;

    /**
     * 高度
     */
    @ApiModelProperty(value = "高度")
    private Integer height;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String enableFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
