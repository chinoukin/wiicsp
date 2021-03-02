package com.wisea.cultivar.common.vo.tp;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员标签详细信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月12日
 * @version 1.0
 */
@ApiModel("会员标签详细信息的PO")
public class MembLabelListGetVo implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = 7300273119757849737L;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "标签类别(0:企业证书1:认证企业)")
    private String labelCatgType;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @ApiModelProperty(value = "证书类型(0:安全证书1:产地联盟)")
    private String certType;

    @ApiModelProperty(value = "已激活标识")
    private String alredyActUrl;

    @ApiModelProperty(value = "未激活标识")
    private String notActUrl;

    @ApiModelProperty(value = "标签说明")
    private String labelDesc;

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelCatgType() {
        return labelCatgType;
    }

    public void setLabelCatgType(String labelCatgType) {
        this.labelCatgType = labelCatgType == null ? null : labelCatgType.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getAlredyActUrl() {
        return alredyActUrl;
    }

    public void setAlredyActUrl(String alredyActUrl) {
        this.alredyActUrl = alredyActUrl == null ? null : alredyActUrl.trim();
    }

    public String getNotActUrl() {
        return notActUrl;
    }

    public void setNotActUrl(String notActUrl) {
        this.notActUrl = notActUrl == null ? null : notActUrl.trim();
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
}
