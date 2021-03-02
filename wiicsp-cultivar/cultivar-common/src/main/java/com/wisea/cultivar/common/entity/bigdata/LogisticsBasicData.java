package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * logistics_basic_data 表实体
 * 物流基础数据
 * 2020/09/03 10:24:52
 */
public class LogisticsBasicData extends DataLongEntity<LogisticsBasicData> {
    private static final long serialVersionUID = 1L;

    /**
     * 物流基础数据类型
     */
    private String logisticsBasicDataType;

    /**
     * 数量
     */
    private Double num;

    /**
     * 排序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public LogisticsBasicData() {
        super();
    }

    /**
     * 获取物流基础数据类型
     */
    public String getLogisticsBasicDataType() {
        return logisticsBasicDataType;
    }

    /**
     * 设置物流基础数据类型
     */
    public void setLogisticsBasicDataType(String logisticsBasicDataType) {
        this.logisticsBasicDataType = logisticsBasicDataType == null ? null : logisticsBasicDataType.trim();
    }

    /**
     * 获取数量
     */
    public Double getNum() {
        return num;
    }

    /**
     * 设置数量
     */
    public void setNum(Double num) {
        this.num = num;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
