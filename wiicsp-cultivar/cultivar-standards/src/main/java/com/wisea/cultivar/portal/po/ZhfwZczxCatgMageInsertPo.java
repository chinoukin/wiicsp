package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwZczxCatgMageInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwZczxCatgMageInsertPo {
    /**
     * pid
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "pid", allowableValues = "length:(,19]")
    private Long pid;

    /**
     * 父分类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "父分类名称", allowableValues = "mixLength:(,255]")
    private String pCatgName;

    /**
     * 分类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "分类名称", allowableValues = "mixLength:(,255]")
    private String catgName;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取父分类名称
     */
    public String getpCatgName() {
        return pCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName == null ? null : pCatgName.trim();
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
