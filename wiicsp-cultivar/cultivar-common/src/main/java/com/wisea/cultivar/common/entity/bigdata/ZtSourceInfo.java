package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * zt_source_info 表实体
 * 在途货源信息
 * 2019/12/02 11:02:15
 */
public class ZtSourceInfo extends DataLongEntity<ZtSourceInfo> {
    @ExcelField(title = "货源类型", sort = 5)
    private String sourceType;
    @ExcelField(title = "品类名称", sort = 10)
    private String varitName;
    @ExcelField(title = "订单总数", sort = 15)
    private String ordZs;
    @ExcelField(title = "订单总量", sort = 20)
    private String ordZl;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getOrdZs() {
        return ordZs;
    }

    public void setOrdZs(String ordZs) {
        this.ordZs = ordZs;
    }

    public String getOrdZl() {
        return ordZl;
    }

    public void setOrdZl(String ordZl) {
        this.ordZl = ordZl;
    }
}
