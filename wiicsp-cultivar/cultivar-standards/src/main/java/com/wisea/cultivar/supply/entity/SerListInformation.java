package com.wisea.cultivar.supply.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class SerListInformation extends DataLongEntity<SerListInformation> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 服务单id
     */
    private Long serListId;

    /**
     * 服务单状态类型
     */
    private String serListStateType;

    /**
     * 消息时间
     */
    private OffsetDateTime informationDate;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 是否已读
     */
    private String ifShow;

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
