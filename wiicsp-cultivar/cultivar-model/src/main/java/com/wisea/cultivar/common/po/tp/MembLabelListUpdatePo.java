package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增或者修改会员标签的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月12日
 * @version 1.0
 */
@ApiModel("新增或者修改会员标签的PO")
public class MembLabelListUpdatePo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @Check(test = {"required", "liveable"}, liveable = {"0", "1","2", "3","4"}, liveableMsg = "标签类别只能为0-4")
    @ApiModelProperty(value = "标签类别(0:企业证书1:认证企业2:检测证书3:品鉴证书4:检疫证书)")
    private String labelCatgType;

    @Check(test = "logic", logic = "'0'.equals(#labelCatgType)?#isNotEmpty(#certType):true", logicMsg = "标签类别是0:企业证书的情况certType不为空")
    @ApiModelProperty(value = "证书类型(0:安全证书1:产地联盟)")
    private String certType;

    @Check(test = { "required","maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "已激活标识")
    private String alredyActUrl;

    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "未激活标识")
    private String notActUrl;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "标签说明")
    private String labelDesc;

    @Check(test = { "maxLength" }, length = 10)
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
