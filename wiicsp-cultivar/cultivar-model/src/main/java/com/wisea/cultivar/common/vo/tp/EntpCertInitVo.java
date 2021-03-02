package com.wisea.cultivar.common.vo.tp;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * EntpCertMageListVo
 * 2018/10/09 16:37:34
 */
public class EntpCertInitVo {

	/**
     * 会员标签Id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员标签Id")
	private Long membLabelId;
    @ApiModelProperty(value = "会员标签名称")
    private String labelName;
    @ApiModelProperty(value = "已经上传的会员标签证书")
	private List<EntpCertMageListVo> entpCerList;


	public Long getMembLabelId() {
		return membLabelId;
	}
	public void setMembLabelId(Long membLabelId) {
		this.membLabelId = membLabelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public List<EntpCertMageListVo> getEntpCerList() {
		return entpCerList;
	}
	public void setEntpCerList(List<EntpCertMageListVo> entpCerList) {
		this.entpCerList = entpCerList;
	}
}
