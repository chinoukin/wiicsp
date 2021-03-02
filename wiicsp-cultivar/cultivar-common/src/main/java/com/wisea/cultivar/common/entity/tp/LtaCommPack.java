package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LtaCommPack extends DataLongEntity<LtaCommPack> {
    /**
     * 长协商品信息id
     */
    private Long ltaCommRelaId;

    /**
     * 计量单位(计量单位管理表id)
     */
    private Long measUnitId;

    /**
     * 规格重量
     */
    private Double spec;

    /**
     * 包装说明
     */
    private String packInstr;

    public Long getLtaCommRelaId() {
        return ltaCommRelaId;
    }

    public void setLtaCommRelaId(Long ltaCommRelaId) {
        this.ltaCommRelaId = ltaCommRelaId;
    }

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }

    public Double getSpec() {
        return spec;
    }

    public void setSpec(Double spec) {
        this.spec = spec;
    }

    public String getPackInstr() {
        return packInstr;
    }

    public void setPackInstr(String packInstr) {
        this.packInstr = packInstr;
    }
}
