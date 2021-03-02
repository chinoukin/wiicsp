package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LogisticsCompMage extends DataLongEntity<LogisticsCompMage> {
    /**
     * 物流公司名称
     */
    private String logisticsCompName;

    /**
     * 代码
     */
    private String logisticsCompCode;

    /**
     * 联系电话
     */
    private String tel;

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
