package com.wisea.cultivar.origin.entity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 *  查询未检测的样品信息列表
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月6日
 * @version 1.0
 */
public class DeteYcmPojo {

	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	// 检测时间
    private OffsetDateTime detecDate;
    // 0:不合格1：合格
    private String resultType;
	private List<Map> picList = null;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Map> getPicList() {
		return picList;
	}
	public void setPicList(List<Map> picList) {
		this.picList = picList;
	}
	public OffsetDateTime getDetecDate() {
		return detecDate;
	}
	public void setDetecDate(OffsetDateTime detecDate) {
		this.detecDate = detecDate;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

}
