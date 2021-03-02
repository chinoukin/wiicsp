package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * HelpListMageListVo
 * 2018/10/29 15:34:52
 */
public class HelpMenuListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 帮助分类id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "帮助分类id")
    private Long catgId;

    @ApiModelProperty(value = "分类名称")
    private String catgName;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String helpNum;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 分类编号
     */
    @ApiModelProperty(value = "分类编号")
    private String catgNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getHelpNum() {
        return helpNum;
    }

    public void setHelpNum(String helpNum) {
        this.helpNum = helpNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatgNum() {
        return catgNum;
    }

    public void setCatgNum(String catgNum) {
        this.catgNum = catgNum;
    }
}
