package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MassifEquRela extends DataLongEntity<MassifEquRela> {
    /**
     * 设备id
     */
    private Long equId;

    /**
     * 地块id
     */
    private Long massifId;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }
}
