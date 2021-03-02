package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页分类的添加或者修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月31日
 * @version 1.0
 */
@ApiModel("首页分类的添加或者修改PO")
public class HpCatgSavePo {

	@ApiModelProperty("商品ID-修改时为必须填写")
    private Long id;

    @Check(test = "required", requiredMsg = "商品分类pid不能为空")
    @ApiModelProperty(value = "商品分类pid")
    private Long pid;

    @Check(test = "required", requiredMsg = "商品分类名称不能为空")
    @ApiModelProperty(value = "商品分类名称")
    private String catgName;

    @Check(test = "required", requiredMsg = "分类排序不能为空")
    @ApiModelProperty("分类排序")
    private Integer sort;

    @ApiModelProperty("分类图标")
    private String catgIconUrl;

    @ApiModelProperty("关键词")
    private String keyWord;

    @ApiModelProperty("分类描述")
    private String catgRemarks;

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "是否显示在首页 (0:是1:否)")
    private String ifShow;

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "状态(0:启用1:停用)")
    private String enableFlag;

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

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

	public String getIfShow() {
		return ifShow;
	}

	public void setIfShow(String ifShow) {
		this.ifShow = ifShow;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}


}
