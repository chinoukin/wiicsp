package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询SerListInformationVo")
public class SerListInformationPageListVo {

    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="服务单id")
    private Long serListId;

    @ApiModelProperty(value="服务单状态类型")
    private String serListStateType;

    @ApiModelProperty(value="消息时间")
    private OffsetDateTime informationDate;

    @ApiModelProperty(value="消息内容")
    private String content;

    @ApiModelProperty(value="是否已读")
    private String ifShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public OffsetDateTime getInformationDate() {
        return informationDate;
    }

    public void setInformationDate(OffsetDateTime informationDate) {
        this.informationDate = informationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIfShow() {
        return ifShow;
    }

    public void setIfShow(String ifShow) {
        this.ifShow = ifShow;
    }
}
