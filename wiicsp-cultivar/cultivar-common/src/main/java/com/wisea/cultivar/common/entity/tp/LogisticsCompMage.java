package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * logistics_comp_mage 表实体
 * 物流公司管理
 * 2018/09/18 14:36:47
 */
public class LogisticsCompMage extends DataLongEntity<LogisticsCompMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 物流公司名称
     */
    private String logisticsCompName;

    /**
     * 代码
     */
    private String logisticsCompCode;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取代码
     */
    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    /**
     * 设置代码
     */
    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode == null ? null : logisticsCompCode.trim();
    }
}
