package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * rk_source_info 表实体
 * 入库货源信息
 * 2019/12/02 11:02:15
 */
public class RkSourceInfo extends DataLongEntity<RkSourceInfo> {
    @ExcelField(title = "货源类型", sort = 5)
    private String sourceType;
    @ExcelField(title = "子公司名称", sort = 10)
    private String subEntpName;
    @ExcelField(title = "品类名称", sort = 15)
    private String varitName;
    @ExcelField(title = "总入库", sort = 20)
    private String zrk;
    @ExcelField(title = "当前库存", sort = 25)
    private String dqkc;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSubEntpName() {
        return subEntpName;
    }

    public void setSubEntpName(String subEntpName) {
        this.subEntpName = subEntpName;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getZrk() {
        return zrk;
    }

    public void setZrk(String zrk) {
        this.zrk = zrk;
    }

    public String getDqkc() {
        return dqkc;
    }

    public void setDqkc(String dqkc) {
        this.dqkc = dqkc;
    }
}
