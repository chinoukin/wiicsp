package com.wisea.cultivar.common.vo.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.tree.*;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 后台返回商品信息
 * @author: wangs
 * @date :2018/1/30
 */
@ApiModel("商品(品类)返回值")
public class CommMageTreeVo implements Serializable {
    private static final long serialVersionUID = -2947104179578683371L;

    /**
     * 基础品类id
     */
    @ApiModelProperty(value = "品类id")
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
     * 商品(品类)名称
     */
    @ApiModelProperty(value = "商品(品类)名称")
    private String commCatgName;

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
    private CommMageTreeVo parent;

    /**
     * 子节点
     */
    @ApiModelProperty(value = "子节点")
    @TreeChildren
    private List<CommMageTreeVo> children;

    /**
     * 是否展开，默认false
     */
    private Boolean open;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CommMageTreeVo getParent() {
        return parent;
    }

    public void setParent(CommMageTreeVo parent) {
        this.parent = parent;
    }

    public List<CommMageTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<CommMageTreeVo> children) {
        this.children = children;
    }

    @JsonSerialize(using = IdSerializer.class)
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

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getLabel() {
        label = getCommCatgName();
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        value = getId().toString();
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Boolean getOpen() {
        open = false;
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
