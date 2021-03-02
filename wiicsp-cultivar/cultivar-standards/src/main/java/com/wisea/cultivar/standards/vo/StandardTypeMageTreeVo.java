package com.wisea.cultivar.standards.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.tree.*;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * StandardTypeMageGetVo
 * 2020/07/24 11:21:45
 */
public class StandardTypeMageTreeVo {
    /**
     * id
     */
    @TreeId
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * pid
     */
    @TreePid
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
    @TreeSort
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
     * 等级
     */
    @TreeLevel
    private Integer level;
    @TreeParent
    @JsonIgnore
    private StandardTypeMageTreeVo parent;
    /**
     * 子类
     */
    @TreeChildren
    private List<StandardTypeMageTreeVo> children;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<StandardTypeMageTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<StandardTypeMageTreeVo> children) {
        this.children = children;
    }

    public StandardTypeMageTreeVo getParent() {
        return parent;
    }

    public void setParent(StandardTypeMageTreeVo parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "StandardTypeMageTreeVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", pName='" + pName + '\'' +
                ", standardTypeCode='" + standardTypeCode + '\'' +
                ", standardTypeName='" + standardTypeName + '\'' +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", level=" + level +
                ", children=" + children +
                '}';
    }
}
