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
 * 新增修改用户菜单列表Vo
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月28日
 * @version 1.0
 */
@ApiModel("新增修改用户菜单列表Vo")
public class UpdUserMenuInitVo implements Serializable{

	private static final long serialVersionUID = 4128942350632805829L;

	@ApiModelProperty(value = "ID")
    @TreeId
    private String id;

    @TreePid
    @ApiModelProperty(hidden = true)
    private String parentId;

    @ApiModelProperty(value = "名称 ")
    private String name;

    @ApiModelProperty(hidden = true)
    @TreeSort
    private Integer sort;

    @ApiModelProperty(value = "是否为服务菜单项 0：否 1：是")
    private String isService;

    /** 树状等级 */
    @TreeLevel
    @ApiModelProperty(hidden = true)
    private int level;

    /** 父节点 */
    @TreeParent
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private UpdUserMenuInitVo parent;

    /** 子节点 */
    @TreeChildren
    @ApiModelProperty(value = "子菜单列表")
    private List<UpdUserMenuInitVo> children;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsService() {
		return isService;
	}

	public void setIsService(String isService) {
		this.isService = isService;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<UpdUserMenuInitVo> getChildren() {
		return children;
	}

	public void setChildren(List<UpdUserMenuInitVo> children) {
		this.children = children;
	}

	public UpdUserMenuInitVo getParent() {
		return parent;
	}

	public void setParent(UpdUserMenuInitVo parent) {
		this.parent = parent;
	}
}
