package com.wisea.cultivar.plant.po.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 品牌信息保存的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("品牌信息保存的PO")
public class BrandInfoPo {

	@ApiModelProperty(value="品牌ID(新增为空，更新必填)")
	private Long id = null;
	@ApiModelProperty(value="品牌名称",required=true)
	@Check(test="required")
	private String brandName;
	@ApiModelProperty(value="品牌介绍",required=true)
	@Check(test="required")
	private String brandIntr;
	@ApiModelProperty(value="品牌图片",required=true)
	@Check(test="required")
	private List<String> brandPicList = Lists.newArrayList();
	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * @return the brandIntr
	 */
	public String getBrandIntr() {
		return brandIntr;
	}
	/**
	 * @param brandIntr the brandIntr to set
	 */
	public void setBrandIntr(String brandIntr) {
		this.brandIntr = brandIntr;
	}
	/**
	 * @return the brandPicList
	 */
	public List<String> getBrandPicList() {
		return brandPicList;
	}
	/**
	 * @param brandPicList the brandPicList to set
	 */
	public void setBrandPicList(List<String> brandPicList) {
		this.brandPicList = brandPicList;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
