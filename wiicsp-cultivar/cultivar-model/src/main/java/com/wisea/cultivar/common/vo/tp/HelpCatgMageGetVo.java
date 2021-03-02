package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * HelpCatgMageGetVo
 * 2018/10/29 10:29:10
 */
public class HelpCatgMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String num;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String catgName;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示")
    private String defaultFlag;

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
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取分类名称
     */
    public String getCatgName() {
        return catgName;
    }

    /**
     * 设置分类名称
     */
    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
    }

    /**
     * 获取是否显示
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否显示
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
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
