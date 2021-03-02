package com.wisea.cultivar.standards.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.common.annotation.tree.*;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * ChinaStandardTypeMageGetVo
 * 2020/07/24 11:21:45
 */
public class ChinaStandardTypeMageTreeVo implements Serializable {
    /**
     * id
     */
    @TreeId
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * pid
     */
    @TreePid
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

    @TreeLevel
    private int level;

    /** 父节点 */
    @TreeParent
    @JsonIgnore
    private ChinaStandardTypeMageTreeVo parent;

    /** 子节点 */
    @TreeChildren
    private List<ChinaStandardTypeMageTreeVo> children;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getStandardTypeCode() {
        return standardTypeCode;
    }

    public void setStandardTypeCode(String standardTypeCode) {
        this.standardTypeCode = standardTypeCode;
    }

    public String getStandardTypeName() {
        return standardTypeName;
    }

    public void setStandardTypeName(String standardTypeName) {
        this.standardTypeName = standardTypeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ChinaStandardTypeMageTreeVo getParent() {
        return parent;
    }

    public void setParent(ChinaStandardTypeMageTreeVo parent) {
        this.parent = parent;
    }

    public List<ChinaStandardTypeMageTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ChinaStandardTypeMageTreeVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ChinaStandardTypeMageTreeVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", pName='" + pName + '\'' +
                ", standardTypeCode='" + standardTypeCode + '\'' +
                ", standardTypeName='" + standardTypeName + '\'' +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }
}
