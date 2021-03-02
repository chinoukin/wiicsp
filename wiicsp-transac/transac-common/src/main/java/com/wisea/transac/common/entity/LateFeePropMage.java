package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;

public class LateFeePropMage extends DataLongEntity<LateFeePropMage> {
    /**
     * 账期滞纳金比例上限
     */
    @Check(test = "required")
    private Double overdueLateFeeProp;

    public Double getOverdueLateFeeProp() {
        return overdueLateFeeProp;
    }

    public void setOverdueLateFeeProp(Double overdueLateFeeProp) {
        this.overdueLateFeeProp = overdueLateFeeProp;
    }
}
