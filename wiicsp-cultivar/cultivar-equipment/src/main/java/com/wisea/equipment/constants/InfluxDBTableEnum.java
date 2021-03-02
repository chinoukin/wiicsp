package com.wisea.equipment.constants;

/**
 * @author jirg
 * @version 1.0
 * @className InfluxDBMeasurement
 * @date 2020/7/13 17:00
 * @Description InfluxDB 表 枚举
 */
public enum InfluxDBTableEnum {
    METEOROLOGY_TABLE("meteorology_table", "气象数据表");

    private String table;
    private String description;

    InfluxDBTableEnum(String table, String description) {
        this.table = table;
        this.description = description;
    }

    public String table() {
        return table;
    }

    public String description() {
        return description;
    }
}
