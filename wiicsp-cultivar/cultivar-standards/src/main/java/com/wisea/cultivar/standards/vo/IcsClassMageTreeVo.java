package com.wisea.cultivar.standards.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.tree.*;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * IcsClassMageListVo
 * 2020/07/24 11:21:45
 */
public class IcsClassMageTreeVo {
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
    private String icsClassCode;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String icsClassName;

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
     * 级别
     */
    @TreeLevel
    private int level;
    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;
    /** 父节点 */
    @TreeParent
    @JsonIgnore
    private IcsClassMageTreeVo parent;
    /**
     * 子节点
     */
    @TreeChildren
    private List<IcsClassMageTreeVo> children;
    /**
     * 是否有子集
     */
    private boolean   state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<IcsClassMageTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<IcsClassMageTreeVo> children) {
        this.children = children;
    }

    public IcsClassMageTreeVo getParent() {
        return parent;
    }

    public void setParent(IcsClassMageTreeVo parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "IcsClassMageTreeVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", pName='" + pName + '\'' +
                ", icsClassCode='" + icsClassCode + '\'' +
                ", icsClassName='" + icsClassName + '\'' +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                ", level=" + level +
                ", delFlag='" + delFlag + '\'' +
                ", children=" + children +
                '}';
    }
}
