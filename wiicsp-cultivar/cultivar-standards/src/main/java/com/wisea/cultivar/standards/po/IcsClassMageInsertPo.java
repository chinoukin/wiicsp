package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * IcsClassMageInsertPo
 * 2020/07/24 11:21:45
 */
public class IcsClassMageInsertPo {
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
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "父分类名称", allowableValues = "mixLength:(,30]")
    private String pName;

    /**
     * 分类编码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "分类编码", allowableValues = "mixLength:(,30]")
    private String icsClassCode;

    /**
     * 分类名称
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "分类名称", allowableValues = "mixLength:(,30]")
    private String icsClassName;

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
    public String getpName() {
        return pName;
    }

    /**
     * 设置父分类名称
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * 获取分类编码
     */
    public String getIcsClassCode() {
        return icsClassCode;
    }

    /**
     * 设置分类编码
     */
    public void setIcsClassCode(String icsClassCode) {
        this.icsClassCode = icsClassCode == null ? null : icsClassCode.trim();
    }

    /**
     * 获取分类名称
     */
    public String getIcsClassName() {
        return icsClassName;
    }

    /**
     * 设置分类名称
     */
    public void setIcsClassName(String icsClassName) {
        this.icsClassName = icsClassName == null ? null : icsClassName.trim();
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
