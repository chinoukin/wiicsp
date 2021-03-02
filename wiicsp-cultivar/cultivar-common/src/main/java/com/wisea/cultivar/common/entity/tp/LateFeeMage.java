package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class LateFeeMage extends DataLongEntity<LateFeeMage> {
    /**
     * 滞纳金比例
     */
    @Check(test = "regex", regex = "^0$|^0\\.[0-9][0-9]?$", regexMsg = "滞纳金比例输入有误，小于1并保留两位小数")
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;

    public Double getLateFeeBl() {
        return lateFeeBl;
    }

    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }
}
