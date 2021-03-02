package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * national_distr_statistics 表实体
 * 全国配送统计
 * 2020/09/02 15:16:31
 */
public class NationalDistrStatistics extends DataLongEntity<NationalDistrStatistics> {
    private static final long serialVersionUID = 1L;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 配送件数
     */
    private Integer num;

    /**
     *
     * @mbg.generated
     */
    public NationalDistrStatistics() {
        super();
    }

    /**
     * 获取城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取配送件数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置配送件数
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}
