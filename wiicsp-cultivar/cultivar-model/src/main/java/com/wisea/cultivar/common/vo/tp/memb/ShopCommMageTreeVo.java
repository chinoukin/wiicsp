package com.wisea.cultivar.common.vo.tp.memb;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.tree.TreeChildren;
import com.wisea.cloud.common.annotation.tree.TreeId;
import com.wisea.cloud.common.annotation.tree.TreeLevel;
import com.wisea.cloud.common.annotation.tree.TreeParent;
import com.wisea.cloud.common.annotation.tree.TreePid;
import com.wisea.cloud.common.annotation.tree.TreeSort;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页分类树形结构列表数据VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("首页分类树形结构列表数据VO")
public class ShopCommMageTreeVo  implements Serializable {

	private static final long serialVersionUID = -4783469475413278646L;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id")
    private Long shopInfoMageId;

    @TreeId
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品类id")
    private Long id;

    @TreePid
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "父节点ID")
    private Long pid;

    @ApiModelProperty(value = "父分类名称")
    private String pCommCatgName;

    @ApiModelProperty(value = "分类名称")
    private String commCatgName;

    @TreeSort
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value  = "状态(0:有效1:无效)默认有效")
    private String effeInvalState = "0"; //商品状态:有效、无效

    @TreeLevel
    @ApiModelProperty(value  = "等级")
    private int level; //树状等级

    @TreeParent
    @JsonIgnore
    private ShopCommMageTreeVo parent; //父节点

    @TreeChildren
    @ApiModelProperty(value  = "子节点")
    private List<ShopCommMageTreeVo> children; //子节点

    private Boolean open = false; //是否展开，默认false

	public Long getShopInfoMageId() {
		return shopInfoMageId;
	}

	public void setShopInfoMageId(Long shopInfoMageId) {
		this.shopInfoMageId = shopInfoMageId;
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

	public String getpCommCatgName() {
		return pCommCatgName;
	}

	public void setpCommCatgName(String pCommCatgName) {
		this.pCommCatgName = pCommCatgName;
	}

	public String getCommCatgName() {
		return commCatgName;
	}

	public void setCommCatgName(String commCatgName) {
		this.commCatgName = commCatgName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ShopCommMageTreeVo getParent() {
		return parent;
	}

	public void setParent(ShopCommMageTreeVo parent) {
		this.parent = parent;
	}

	public List<ShopCommMageTreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<ShopCommMageTreeVo> children) {
		this.children = children;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}
