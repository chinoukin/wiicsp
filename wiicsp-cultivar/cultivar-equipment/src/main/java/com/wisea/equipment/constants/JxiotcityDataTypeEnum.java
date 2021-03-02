package com.wisea.equipment.constants;

/**
 * 精讯设备数据类型
 * @author chengq
 * @date 2020/11/25 13:14
 */
public enum JxiotcityDataTypeEnum {
    JX1(DictConstants.EQU_DATE_TYPE_30),
    JX2(DictConstants.EQU_DATE_TYPE_31);

    JxiotcityDataTypeEnum(String dataType) {
        this.dataType = dataType;
    }

    private final String dataType;

    public String getDataType() {
        return dataType;
    }
}
