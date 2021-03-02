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
 * 通知信息管理列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("通知信息管理列表信息VO")
public class TzInfoMageListVo implements Serializable{

	private static final long serialVersionUID = 7588634618870505025L;

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取发布时间
     */
    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    /**
     * 设置发布时间
     */
    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
