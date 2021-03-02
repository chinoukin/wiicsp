package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * relation_iot_info 表实体
 * 关联物联网信息
 * 2020/08/11 13:21:46
 */
public class RelationIotInfo extends DataLongEntity<RelationIotInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 示范基地地块id
     */
    private Long demonsBaseMassifId;

    /**
     * 产地通地块id
     */
    private Long massifId;

    public RelationIotInfo() {
    }

    public RelationIotInfo(Long demonsBaseMassifId, Long massifId) {
        this.demonsBaseMassifId = demonsBaseMassifId;
        this.massifId = massifId;
    }

    public Long getDemonsBaseMassifId() {
        return demonsBaseMassifId;
    }

    public void setDemonsBaseMassifId(Long demonsBaseMassifId) {
        this.demonsBaseMassifId = demonsBaseMassifId;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }
}
