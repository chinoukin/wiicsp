package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家商品分类的添加或者修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("商家商品分类的添加或者修改PO")
public class ShopCommMageSavePo {

	@ApiModelProperty("商品分类ID-修改时为必须填写")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test="required",requiredMsg="店铺id不能为空")
    @ApiModelProperty(value = "店铺id")
    private Long shopInfoMageId;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test="required",requiredMsg="商品分类pid不能为空")
    @ApiModelProperty(value = "商品分类pid")
    private Long pid;

    @ApiModelProperty(value = "商品分类名称")
    @Check(test="required",requiredMsg="商品分类名称不能为空")
    private String commCatgName;

    @ApiModelProperty(value = "商品状态 (有效、无效)默认有效")
    private String effeInvalState = "0";

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "分类图标")
    private String catgIconUrl;

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "分类描述")
    private String catgRemarks;

	public Long getShopInfoMageId() {
		return shopInfoMageId;
	}

	public void setShopInfoMageId(Long shopInfoMageId) {
		this.shopInfoMageId = shopInfoMageId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
