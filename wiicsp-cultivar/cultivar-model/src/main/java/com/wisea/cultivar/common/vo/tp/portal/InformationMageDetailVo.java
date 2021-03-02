package com.wisea.cultivar.common.vo.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取资讯详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("获取资讯详细信息VO")
public class InformationMageDetailVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "所属分类（0:平台公告1:行业资讯2果链动态3价格行情）")
    private String informationType;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "关键词")
    private String keywords;

    @ApiModelProperty(value = "消息摘要")
    private String informationDigest;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "详细内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "前一页ID")
    private Long preId;

    @ApiModelProperty(value = "前一页标题")
    private String preTitle;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "下一页ID")
    private Long nextId;

    @ApiModelProperty(value = "下一页标题")
    private String nextTitle;

    @ApiModelProperty(value = "行数",hidden=true)
    private int rowNum;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public Long getPreId() {
		return preId;
	}

	public void setPreId(Long preId) {
		this.preId = preId;
	}

	public String getPreTitle() {
		return preTitle;
	}

	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}

	public Long getNextId() {
		return nextId;
	}

	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}

	public String getNextTitle() {
		return nextTitle;
	}

	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
}
