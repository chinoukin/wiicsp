package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class SerListOpreateInfo extends DataLongEntity<SerListOpreateInfo> {
    /**
     * 服务单id
     */
    private Long serListId;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime opreatDate;

    /**
     * 操作内容
     */
    private String opreatContent;

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
    }
}
