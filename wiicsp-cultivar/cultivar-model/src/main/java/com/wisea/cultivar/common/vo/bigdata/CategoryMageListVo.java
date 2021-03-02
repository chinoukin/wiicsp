package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CategoryMageListVo
 * 2019/12/03 14:35:19
 */
public class CategoryMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称")
    @ExcelField(title = "品类名称",sort = 1)
    private String categoryName;

    /**
     * 品类图标
     */
    @ApiModelProperty(value = "品类图标")
    private String categoryUrl;

    /**
     * 关联物料数量
     */
    @ApiModelProperty(value = "关联物料数量")
    @ExcelField(title = "关联物料数量",sort = 2)
    private Integer glwlSl;

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
