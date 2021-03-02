package com.wisea.transac.common.vo.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.LongSerializer;
import com.wisea.cloud.common.annotation.tree.*;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wangs
 */
public class CommMageTreeModelVo {

    /**
     * 商品(品类)id
     */
    @TreeId
    @ApiModelProperty(value = "品类id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 父节点ID
     */
    @TreePid
    @ApiModelProperty(value = "父节点ID")
    private Long pid;

    /**
     * 排序
     */
    @TreeSort
    @ApiModelProperty(value = "排序")
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

    /**
     * 树状等级
     */
    @TreeLevel
    @ApiModelProperty(value = "等级")
    private int level;

    /**
     * 父节点
     */
    @TreeParent
    @JsonIgnore
    private CommMageTreeVo parent;

    /**
     * 子节点
     */
    @TreeChildren
    @ApiModelProperty(value = "子节点")
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

    @JsonSerialize(using = LongSerializer.class)
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
