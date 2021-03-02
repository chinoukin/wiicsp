package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 布依族介绍详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("布依族介绍详细信息VO")
public class ByzIntrodGetVo implements Serializable{
    /**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年8月31日
	 * @version 1.0
	 */
	private static final long serialVersionUID = 4784397745882853611L;

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
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
     * 获取图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取简介
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置简介
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
