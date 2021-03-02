package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台分页查询资讯信息列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月28日
 * @version 1.0
 */
@ApiModel("后台分页查询资讯信息列表VO")
public class InformationMagePageListVo implements Serializable{

	private static final long serialVersionUID = -1586610751940361427L;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "所属分类（information_type 0:平台公告1:行业资讯2果链动态3价格行情）")
    private String informationType;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "消息摘要")
    private String informationDigest;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "是否显示（if_show 0:是1:否）")
    private String ifShow;

    @ApiModelProperty(value = "发布时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

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

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
