package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardTypeMageListPo
 * 2020/07/24 11:21:45
 */
public class StandardTypeMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * pid
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "pid")
    private Long pid;

    /**
     * 父分类名称
     */
    @ApiModelProperty(value = "父分类名称")
    private String pName;

    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码")
    private String standardTypeCode;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String standardTypeName;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

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
    public String getStandardTypeCode() {
        return standardTypeCode;
    }

    /**
     * 设置分类编码
     */
    public void setStandardTypeCode(String standardTypeCode) {
        this.standardTypeCode = standardTypeCode == null ? null : standardTypeCode.trim();
    }

    /**
     * 获取分类名称
     */
    public String getStandardTypeName() {
        return standardTypeName;
    }

    /**
     * 设置分类名称
     */
    public void setStandardTypeName(String standardTypeName) {
        this.standardTypeName = standardTypeName == null ? null : standardTypeName.trim();
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
