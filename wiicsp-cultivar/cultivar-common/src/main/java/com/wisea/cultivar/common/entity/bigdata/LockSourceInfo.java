package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * lock_source_info 表实体
 * 锁定货源信息
 * 2019/12/02 11:02:14
 */
public class LockSourceInfo extends DataLongEntity<LockSourceInfo> {
    @ExcelField(title = "货源类型", sort = 5)
    private String sourceType;
    @ExcelField(title = "产地地址", sort = 10)
    private String placeOriginAddress;
    @ExcelField(title = "品类名称", sort = 15)
    private String varitName;
    @ExcelField(title = "合约数量", sort = 20)
    private String hysl;
    @ExcelField(title = "预计货源", sort = 25)
    private String yjhy;
    @ExcelField(title = "剩余有效货源", sort = 30)
    private String syyxhy;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getPlaceOriginAddress() {
        return placeOriginAddress;
    }

    public void setPlaceOriginAddress(String placeOriginAddress) {
        this.placeOriginAddress = placeOriginAddress;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getHysl() {
        return hysl;
    }

    public void setHysl(String hysl) {
        this.hysl = hysl;
    }

    public String getYjhy() {
        return yjhy;
    }

    public void setYjhy(String yjhy) {
        this.yjhy = yjhy;
    }

    public String getSyyxhy() {
        return syyxhy;
    }

    public void setSyyxhy(String syyxhy) {
        this.syyxhy = syyxhy;
    }
}
