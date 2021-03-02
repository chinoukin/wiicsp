package com.wisea.cultivar.origin.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 样品图片Entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
public class SampPicture extends DataLongEntity<SampPicture> {
	/**
	 *
	 */
	private static final long serialVersionUID = 6084410909425490454L;

	private Long sampId;

	private String pictureType;

	private String url;

	private Integer sort;

	public Long getSampId() {
		return sampId;
	}

	public void setSampId(Long sampId) {
		this.sampId = sampId;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
