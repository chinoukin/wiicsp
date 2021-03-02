package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 会员品牌信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("会员品牌信息VO")
public class MembBrandInfoVo {

	@ApiModelProperty("会员品牌ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("会员品牌名称")
	private String brandName;
	@ApiModelProperty("会员品牌介绍")
	private String brandIntr;
	@ApiModelProperty("会员品牌首张图片")
	private String firstUrl;
	@ApiModelProperty("会员品牌照片列表")
	List<String> brandPicList = null;
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
	 * @return the firstUrl
	 */
	public String getFirstUrl() {
		return firstUrl;
	}
	/**
	 * @param firstUrl the firstUrl to set
	 */
	public void setFirstUrl(String firstUrl) {
		this.firstUrl = firstUrl;
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
}
