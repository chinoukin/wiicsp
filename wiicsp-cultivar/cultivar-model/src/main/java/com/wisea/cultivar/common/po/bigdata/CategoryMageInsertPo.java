package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * CategoryMageInsertPo
 * 2019/12/03 14:35:19
 */
public class CategoryMageInsertPo {
    /**
     * 品类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String categoryName;

    /**
     * 品类图标
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类图标", allowableValues = "mixLength:(,255]")
    private String categoryUrl;

    /**
     * 关联物料数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "关联物料数量", allowableValues = "length:(,10]")
    private Integer glwlSl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取品类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置品类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取品类图标
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     * 设置品类图标
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    /**
     * 获取关联物料数量
     */
    public Integer getGlwlSl() {
        return glwlSl;
    }

    /**
     * 设置关联物料数量
     */
    public void setGlwlSl(Integer glwlSl) {
        this.glwlSl = glwlSl;
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
