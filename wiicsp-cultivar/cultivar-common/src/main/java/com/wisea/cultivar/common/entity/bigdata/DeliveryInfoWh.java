package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * delivery_info_wh 表实体
 * 配送信息维护
 * 2019/12/02 11:02:14
 */
public class DeliveryInfoWh extends DataLongEntity<DeliveryInfoWh> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司id
     */
    private Long subEntpId;

    /**
     * 待处理订单
     */
    private Integer dcl;

    /**
     * 打包中订单
     */
    private Integer dbz;

    /**
     * 配送中订单
     */
    private Integer psz;

    /**
     * 已签收订单
     */
    private Integer yqs;

    /**
     * 获取分公司id
     */
    public Long getSubEntpId() {
        return subEntpId;
    }

    /**
     * 设置分公司id
     */
    public void setSubEntpId(Long subEntpId) {
        this.subEntpId = subEntpId;
    }

    /**
     * 获取待处理订单
     */
    public Integer getDcl() {
        return dcl;
    }

    /**
     * 设置待处理订单
     */
    public void setDcl(Integer dcl) {
        this.dcl = dcl;
    }

    /**
     * 获取打包中订单
     */
    public Integer getDbz() {
        return dbz;
    }

    /**
     * 设置打包中订单
     */
    public void setDbz(Integer dbz) {
        this.dbz = dbz;
    }

    /**
     * 获取配送中订单
     */
    public Integer getPsz() {
        return psz;
    }

    /**
     * 设置配送中订单
     */
    public void setPsz(Integer psz) {
        this.psz = psz;
    }

    /**
     * 获取已签收订单
     */
    public Integer getYqs() {
        return yqs;
    }

    /**
     * 设置已签收订单
     */
    public void setYqs(Integer yqs) {
        this.yqs = yqs;
    }
}
