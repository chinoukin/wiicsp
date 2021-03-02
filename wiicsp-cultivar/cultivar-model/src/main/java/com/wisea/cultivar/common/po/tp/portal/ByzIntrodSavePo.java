package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 布依族介绍保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("布依族介绍保存PO")
public class ByzIntrodSavePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增为空,修改的时候必须填写)")
    private Long id;

    /**
     * 图片
     */
    @Check(test = { "maxLength","required" }, mixLength = 255)
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 简介
     */
    @Check(test = { "maxLength","required" }, mixLength = 255)
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
