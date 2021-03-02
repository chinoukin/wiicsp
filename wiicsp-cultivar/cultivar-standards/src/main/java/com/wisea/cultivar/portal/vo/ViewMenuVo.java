package com.wisea.cultivar.portal.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.common.annotation.tree.TreeChildren;
import com.wisea.cloud.common.annotation.tree.TreeId;
import com.wisea.cloud.common.annotation.tree.TreeLevel;
import com.wisea.cloud.common.annotation.tree.TreeParent;
import com.wisea.cloud.common.annotation.tree.TreePid;
import com.wisea.cloud.common.annotation.tree.TreeSort;

import io.swagger.annotations.ApiModelProperty;

/**
 * 显示菜单Vo
 *
 * @author XuDL(Wisea)
 *
 *         2017年12月27日 下午3:22:12
 */
public class ViewMenuVo implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -4375427170504476052L;

    @ApiModelProperty(value = "ID")
    @TreeId
    private String id;

    @TreePid
    @ApiModelProperty(hidden = true)
    private String parentId;
    /* 类型 */
    @ApiModelProperty(value = "类型 ")
    private String type;

    @ApiModelProperty(value = "名称 ")
    private String name;

    @ApiModelProperty(value = "链接 ")
    private String href;

    @ApiModelProperty(value = "目标 mainFrame,_blank,_self,_parent,_top, _none(功能未开启),http://(接口服务器)")
    private String target;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    @TreeSort
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remarks;

    /** 树状等级 */
    @TreeLevel
    @ApiModelProperty(hidden = true)
    private int level;

    /** 父节点 */
    @TreeParent
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private ViewMenuVo parent;

    /** 子节点 */
    @TreeChildren
    @ApiModelProperty(value = "子菜单列表")
    private List<ViewMenuVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ViewMenuVo getParent() {
        return parent;
    }

    public void setParent(ViewMenuVo parent) {
        this.parent = parent;
    }

    public List<ViewMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<ViewMenuVo> children) {
        this.children = children;
    }

}
