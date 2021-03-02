package com.wisea.transac.common.entity;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * TIM通知模板
 *
 * @author XuDL(Wisea)
 *
 *         2020年4月29日 下午5:24:05
 */
public class TIMNoticeTpl {
    @ApiModelProperty(value = "通知类型")
    @Check(test = "required")
    private String type;
    @ApiModelProperty(value = "标题")
    @Check(test = "required")
    private String title;
    @ApiModelProperty(value = "摘要或描述")
    private String desc;
    @ApiModelProperty(value = "内容")
    private String content;

    public TIMNoticeTpl(String type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public TIMNoticeTpl(String type, String title, String desc, String content) {
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
