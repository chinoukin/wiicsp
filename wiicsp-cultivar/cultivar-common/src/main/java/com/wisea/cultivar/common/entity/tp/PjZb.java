package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * pj_zb 表实体
 * 评价指标
 * 2019/06/06 10:29:52
 */
public class PjZb extends DataLongEntity<PjZb> {
    private static final long serialVersionUID = 1L;

    /**
     * 评价结果id
     */
    private Long pjJgId;

    /**
     * 评价参数id
     */
    private Long pjCsId;

    /**
     * 评价指标
     */
    private String pjZb;

    /**
     * 指标值
     */
    private String pjVal;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取评价结果id
     */
    public Long getPjJgId() {
        return pjJgId;
    }

    /**
     * 设置评价结果id
     */
    public void setPjJgId(Long pjJgId) {
        this.pjJgId = pjJgId;
    }

    /**
     * 获取评价参数id
     */
    public Long getPjCsId() {
        return pjCsId;
    }

    /**
     * 设置评价参数id
     */
    public void setPjCsId(Long pjCsId) {
        this.pjCsId = pjCsId;
    }

    /**
     * 获取评价指标
     */
    public String getPjZb() {
        return pjZb;
    }

    /**
     * 设置评价指标
     */
    public void setPjZb(String pjZb) {
        this.pjZb = pjZb == null ? null : pjZb.trim();
    }

    /**
     * 获取指标值
     */
    public String getPjVal() {
        return pjVal;
    }

    /**
     * 设置指标值
     */
    public void setPjVal(String pjVal) {
        this.pjVal = pjVal == null ? null : pjVal.trim();
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
