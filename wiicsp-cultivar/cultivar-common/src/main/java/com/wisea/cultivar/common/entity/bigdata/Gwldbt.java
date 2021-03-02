package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * gwldbt 表实体
 * 各物流对比图
 * 2019/12/02 11:02:14
 */
public class Gwldbt extends DataLongEntity<Gwldbt> {
    private static final long serialVersionUID = 1L;

    /**
     * 物流名称
     */
    private String wlname;

    /**
     * 物流流通件数
     */
    private Double wlltjs;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取物流名称
     */
    public String getWlname() {
        return wlname;
    }

    /**
     * 设置物流名称
     */
    public void setWlname(String wlname) {
        this.wlname = wlname == null ? null : wlname.trim();
    }

    /**
     * 获取物流流通件数
     */
    public Double getWlltjs() {
        return wlltjs;
    }

    /**
     * 设置物流流通件数
     */
    public void setWlltjs(Double wlltjs) {
        this.wlltjs = wlltjs;
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
