package com.wisea.transac.operation.user.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.common.annotation.tree.TreeChildren;
import com.wisea.cloud.common.annotation.tree.TreeId;
import com.wisea.cloud.common.annotation.tree.TreeLevel;
import com.wisea.cloud.common.annotation.tree.TreeParent;
import com.wisea.cloud.common.annotation.tree.TreePid;
import com.wisea.cloud.common.annotation.tree.TreeSort;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单查询返回接口VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月24日
 * @version 1.0
 */
@ApiModel("菜单查询返回接口VO")
public class ViewMenuExtendsVo implements Serializable{

	private static final long serialVersionUID = 296429091039126880L;

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
    private ViewMenuExtendsVo parent;

    /** 子节点 */
    @TreeChildren
    @ApiModelProperty(value = "子菜单列表")
    private List<ViewMenuExtendsVo> children;

	@ApiModelProperty(value="是否拥有该菜单的权限(0:否1:是)")
	private String isActivate;

	public String getIsActivate() {
		return isActivate;
	}

	public void setIsActivate(String isActivate) {
		this.isActivate = isActivate;
	}

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ViewMenuExtendsVo getParent() {
		return parent;
	}

	public void setParent(ViewMenuExtendsVo parent) {
		this.parent = parent;
	}

	public List<ViewMenuExtendsVo> getChildren() {
		return children;
	}

	public void setChildren(List<ViewMenuExtendsVo> children) {
		this.children = children;
	}
}
