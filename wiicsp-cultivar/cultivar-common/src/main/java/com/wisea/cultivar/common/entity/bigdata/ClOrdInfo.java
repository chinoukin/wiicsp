package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * cl_ord_info 表实体
 * 处理订单详情
 * 2019/12/02 11:02:14
 */
public class ClOrdInfo extends DataLongEntity<ClOrdInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 待处理
     */
    private Integer dcl;

    /**
     * 打包中
     */
    private Integer dbz;

    /**
     * 在途中
     */
    private Integer ztz;

    /**
     * 已完成
     */
    private Integer ywc;

    /**
     * 获取待处理
     */
    public Integer getDcl() {
        return dcl;
    }

    /**
     * 设置待处理
     */
    public void setDcl(Integer dcl) {
        this.dcl = dcl;
    }

    /**
     * 获取打包中
     */
    public Integer getDbz() {
        return dbz;
    }

    /**
     * 设置打包中
     */
    public void setDbz(Integer dbz) {
        this.dbz = dbz;
    }

    /**
     * 获取在途中
     */
    public Integer getZtz() {
        return ztz;
    }

    /**
     * 设置在途中
     */
    public void setZtz(Integer ztz) {
        this.ztz = ztz;
    }

    /**
     * 获取已完成
     */
    public Integer getYwc() {
        return ywc;
    }

    /**
     * 设置已完成
     */
    public void setYwc(Integer ywc) {
        this.ywc = ywc;
    }
}
