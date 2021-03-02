package com.wisea.cultivar.common.vo.tp.portal;

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
 *  首页分类树形结构列表数据VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月31日
 * @version 1.0
 */
@ApiModel("首页分类树形结构列表数据VO")
public class HpCatgTreeModelVo{

	@TreeId
	@ApiModelProperty(value = "品类id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id; //商品(品类)id

	@TreePid
    @ApiModelProperty(value = "父节点ID")
    private Long pid; //父节点ID

    @ApiModelProperty(value  = "父分类名称")
    private String parentCatgName;

    @ApiModelProperty(value  = "分类名称")
    private String catgName;

    @TreeSort
    @ApiModelProperty(value  = "排序")
    private Integer sort; //排序

    @ApiModelProperty(value  = "分类图标")
    private String catgIconUrl;

    @ApiModelProperty(value  = "关键词")
    private String keyWord;

    @ApiModelProperty(value  = "分类描述")
    private String catgRemarks;

    @ApiModelProperty(value  = "状态(0:启用1:停用)")
    private String enableFlag; //商品状态:有效、无效

    @ApiModelProperty("是否默认显示(0:是1:否)")
	private String ifShow;

    @TreeLevel
    @ApiModelProperty(value  = "等级")
    private int level; //树状等级

    @TreeParent
    @JsonIgnore
    private HpCatgTreeModelVo parent; //父节点

    @TreeChildren
    @ApiModelProperty(value  = "子节点")
    private List<HpCatgTreeModelVo> children; //子节点

    private Boolean open = false; //是否展开，默认false

    @JsonSerialize(using = IdSerializer.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getParentCatgName() {
		return parentCatgName;
	}

	public void setParentCatgName(String parentCatgName) {
		this.parentCatgName = parentCatgName;
	}

	public String getCatgIconUrl() {
		return catgIconUrl;
	}

	public void setCatgIconUrl(String catgIconUrl) {
		this.catgIconUrl = catgIconUrl;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getCatgRemarks() {
		return catgRemarks;
	}

	public void setCatgRemarks(String catgRemarks) {
		this.catgRemarks = catgRemarks;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getIfShow() {
		return ifShow;
	}

	public void setIfShow(String ifShow) {
		this.ifShow = ifShow;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public HpCatgTreeModelVo getParent() {
		return parent;
	}

	public void setParent(HpCatgTreeModelVo parent) {
		this.parent = parent;
	}

	public List<HpCatgTreeModelVo> getChildren() {
		return children;
	}

	public void setChildren(List<HpCatgTreeModelVo> children) {
		this.children = children;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
}
