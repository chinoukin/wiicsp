package com.wisea.transac.common.vo.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.tree.*;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/8
 */
public class SalesReleaseSetListVo {

    /**
     * 销售分类id
     */
    @ApiModelProperty(value = "销售分类id")
    @JsonSerialize(using = IdSerializer.class)
    @TreeId
    private Long id;

    /**
     * 父节点ID
     */
    @ApiModelProperty(value = "父节点ID")
    @TreePid
    private Long pid;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TreeSort
    private Integer sort;

    /**
     * 销售品类名称
     */
    @ApiModelProperty(value = "销售品类名称")
    private String catgName;

    /**
     * 商品状态:有效、无效
     */
    @ApiModelProperty(value = "状态")
    private String effeInvalState;

    @ApiModelProperty(value = "label")
    private String label;

    @ApiModelProperty(value = "value")
    private String value;

    /**
     * 树状等级
     */
    @ApiModelProperty(value = "等级")
    @TreeLevel
    private int level;

    /**
     * 父节点
     */
    @JsonIgnore
    @TreeParent
    private SalesClassificationListVo parent;

    /**
     * 子节点
     */
    @ApiModelProperty(value = "子节点")
    @TreeChildren
    private List<SalesReleaseSetListVo> children;

    /**
     * 是否展开，默认false
     */
    private Boolean open;

    private String name;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SalesClassificationListVo getParent() {
        return parent;
    }

    public void setParent(SalesClassificationListVo parent) {
        this.parent = parent;
    }

    public List<SalesReleaseSetListVo> getChildren() {
        return children;
    }

    public void setChildren(List<SalesReleaseSetListVo> children) {
        this.children = children;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
