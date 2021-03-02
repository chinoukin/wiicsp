package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class DeadLineMage extends DataLongEntity<DeadLineMage> {
    /**
     * 期限类型
     */
    @ApiModelProperty("期限类型")
    private String deadLineType;

    /**
     * 时间限制
     */
    @ApiModelProperty("时间限制")
    private Integer limitDays;

    public String getDeadLineType() {
        return deadLineType;
    }

    public void setDeadLineType(String deadLineType) {
        this.deadLineType = deadLineType;
    }

    public Integer getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }
}
