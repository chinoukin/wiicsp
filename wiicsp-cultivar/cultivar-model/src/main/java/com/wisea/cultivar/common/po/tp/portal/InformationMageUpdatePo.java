package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存资讯信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月28日
 * @version 1.0
 */
@ApiModel("保存资讯信息的PO")
public class InformationMageUpdatePo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增的情况不传值)")
    private Long id;

    @Check(test = {"required","maxLength"}, mixLength = 4)
    @ApiModelProperty(value = "所属分类（0:平台公告1:行业资讯2果链动态3价格行情）")
    private String informationType;

    @Check(test = {"required","maxLength"}, mixLength = 90)
    @ApiModelProperty(value = "标题")
    private String title;

    @Check(test = {"required","maxLength"}, mixLength = 250)
    @ApiModelProperty(value = "关键词")
    private String keywords;

    @Check(test = { "maxLength" }, mixLength = 250)
    @ApiModelProperty(value = "消息摘要")
    private String informationDigest;

    @Check(test = { "maxLength" }, mixLength = 250)
    @ApiModelProperty(value = "图片")
    private String image;

    @Check(test = {"required","maxLength"}, mixLength = 4)
    @ApiModelProperty(value = "是否显示（0:是1:否）")
    private String ifShow;

    @ApiModelProperty(value = "详细内容")
    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getInformationDigest() {
		return informationDigest;
	}

	public void setInformationDigest(String informationDigest) {
		this.informationDigest = informationDigest;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIfShow() {
		return ifShow;
	}

	public void setIfShow(String ifShow) {
		this.ifShow = ifShow;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
