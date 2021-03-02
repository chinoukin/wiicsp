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
 * 资料推荐列表显示VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("资料推荐列表显示VO")
public class JszlTjMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 技术资料列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "技术资料列表id")
    private Long jszlListId;
    /**
     * 技术资料分类名称
     */
    @ApiModelProperty(value = "技术资料分类名称")
    private String jszlCatgName;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String zy;

    /**
     * 信息来源
     */
    @ApiModelProperty(value = "信息来源")
    private String xxly;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)")
    private String ifRequ;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getJszlListId() {
		return jszlListId;
	}
	public void setJszlListId(Long jszlListId) {
		this.jszlListId = jszlListId;
	}
	public String getJszlCatgName() {
		return jszlCatgName;
	}
	public void setJszlCatgName(String jszlCatgName) {
		this.jszlCatgName = jszlCatgName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getXxly() {
		return xxly;
	}
	public void setXxly(String xxly) {
		this.xxly = xxly;
	}
	public OffsetDateTime getPubDate() {
		return pubDate;
	}
	public void setPubDate(OffsetDateTime pubDate) {
		this.pubDate = pubDate;
	}
	public String getIfRequ() {
		return ifRequ;
	}
	public void setIfRequ(String ifRequ) {
		this.ifRequ = ifRequ;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
