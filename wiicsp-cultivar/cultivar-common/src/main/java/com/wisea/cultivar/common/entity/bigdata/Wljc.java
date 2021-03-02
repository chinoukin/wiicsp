package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * wljc 表实体
 * 物流监测
 * 2019/12/02 11:02:15
 */
public class Wljc extends DataLongEntity<Wljc> {
    private static final long serialVersionUID = 1L;

    /**
     * 车辆总数
     */
    private Integer clzs;

    /**
     * 监控车辆数
     */
    private Integer jkcls;

    /**
     * 监控在途车辆数
     */
    private Integer ztcls;

    /**
     * 获取车辆总数
     */
    public Integer getClzs() {
        return clzs;
    }

    /**
     * 设置车辆总数
     */
    public void setClzs(Integer clzs) {
        this.clzs = clzs;
    }

    /**
     * 获取监控车辆数
     */
    public Integer getJkcls() {
        return jkcls;
    }

    /**
     * 设置监控车辆数
     */
    public void setJkcls(Integer jkcls) {
        this.jkcls = jkcls;
    }

    /**
     * 获取监控在途车辆数
     */
    public Integer getZtcls() {
        return ztcls;
    }

    /**
     * 设置监控在途车辆数
     */
    public void setZtcls(Integer ztcls) {
        this.ztcls = ztcls;
    }
}
