package com.wisea.cultivar.infomanage.po;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class KnowledgeBaseMageStatus extends DataLongEntity<KnowledgeBaseMageStatus> {
    @Check(test = "required")
    @ApiModelProperty(value = "主键id")
    private Long id;
    @Check(test = "required")
    @ApiModelProperty(value = "是否显示")
    private String ifShow;

    //更新时间
    private OffsetDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
