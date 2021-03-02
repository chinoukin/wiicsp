package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * cgs_name_mage 表实体
 * 采购商名录管理
 * 2019/12/02 11:02:14
 */
public class CgsNameMage extends DataLongEntity<CgsNameMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 采购商名称
     */
    @ExcelField(title = "采购商名称", sort = 5)
    private String cgsName;

    /**
     * 采购商简称
     */
    @ExcelField(title = "采购商简称", sort = 10)
    private String cgsJc;

    /**
     * 采购商地址
     */
    @ExcelField(title = "采购商地址", sort = 15)
    private String cgsAddress;

    /**
     * 成交金额
     */
    @ExcelField(title = "成交金额", sort = 20, formate = ".##")
    private Double cjje;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    @ExcelField(title = "坐标点", sort = 25)
    private String zbd;

    /**
     * 是否已选
     */
    private String sfyxFlag;

    /**
     * 获取采购商名称
     */
    public String getCgsName() {
        return cgsName;
    }

    public String getZbd() {
        return zbd;
    }

    public void setZbd(String zbd) {
        this.zbd = zbd;
    }

    /**
     * 设置采购商名称
     */
    public void setCgsName(String cgsName) {
        this.cgsName = cgsName == null ? null : cgsName.trim();
    }

    /**
     * 获取采购商简称
     */
    public String getCgsJc() {
        return cgsJc;
    }

    /**
     * 设置采购商简称
     */
    public void setCgsJc(String cgsJc) {
        this.cgsJc = cgsJc == null ? null : cgsJc.trim();
    }

    /**
     * 获取采购商地址
     */
    public String getCgsAddress() {
        return cgsAddress;
    }

    /**
     * 设置采购商地址
     */
    public void setCgsAddress(String cgsAddress) {
        this.cgsAddress = cgsAddress == null ? null : cgsAddress.trim();
    }

    /**
     * 获取成交金额
     */
    public Double getCjje() {
        return cjje;
    }

    /**
     * 设置成交金额
     */
    public void setCjje(Double cjje) {
        this.cjje = cjje;
    }

    /**
     * 获取经度
     */
    public Double getJd() {
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
    }

    /**
     * 获取纬度
     */
    public Double getWd() {
        return wd;
    }

    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
    }

    /**
     * 获取是否已选
     */
    public String getSfyxFlag() {
        return sfyxFlag;
    }

    /**
     * 设置是否已选
     */
    public void setSfyxFlag(String sfyxFlag) {
        this.sfyxFlag = sfyxFlag == null ? null : sfyxFlag.trim();
    }
}
