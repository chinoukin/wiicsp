package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * abroad_mage 表实体
 * 国外产地管理
 * 2019/04/25 10:57:26
 */
public class AbroadMage extends DataLongEntity<AbroadMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 产地名称
     */
    private String abroadCdName;

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

    /**
     * 获取产地名称
     */
    public String getAbroadCdName() {
        return abroadCdName;
    }

    /**
     * 设置产地名称
     */
    public void setAbroadCdName(String abroadCdName) {
        this.abroadCdName = abroadCdName == null ? null : abroadCdName.trim();
    }
}
