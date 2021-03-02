package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jtgjdyfx 表实体
 * 交通工具调用分析
 * 2019/12/02 11:02:14
 */
public class Jtgjdyfx extends DataLongEntity<Jtgjdyfx> {
    private static final long serialVersionUID = 1L;

    /**
     * 交通工具名称
     */
    private String jtgjmc;

    /**
     * 流通数量
     */
    private Double ltsl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取交通工具名称
     */
    public String getJtgjmc() {
        return jtgjmc;
    }

    /**
     * 设置交通工具名称
     */
    public void setJtgjmc(String jtgjmc) {
        this.jtgjmc = jtgjmc == null ? null : jtgjmc.trim();
    }

    /**
     * 获取流通数量
     */
    public Double getLtsl() {
        return ltsl;
    }

    /**
     * 设置流通数量
     */
    public void setLtsl(Double ltsl) {
        this.ltsl = ltsl;
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
