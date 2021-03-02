package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * zd_info_mage 表实体
 * 站点信息管理
 * 2019/12/02 11:02:15
 */
public class ZdInfoMage extends DataLongEntity<ZdInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 采购商id
     */
    private Long cgsId;

    /**
     * 站点名称
     */
    @ExcelField(title = "站点名称", sort = 5)
    private String zdName;

    /**
     * 站点地址
     */
    @ExcelField(title = "站点地址", sort = 10)
    private String zdAddress;

    /**
     * 站点类型
     */
    @ExcelField(title = "站点类型（大仓点/采购点）", sort = 15)
    private String zdType;

    @ExcelField(title = "坐标点", sort = 20)
    private String zbd;

    /**
     * 站点金额
     */
    private Double zdAmount;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    /**
     * 是否已选
     */
    private String sfyxFlag;

    /**
     * 获取采购商id
     */
    public Long getCgsId() {
        return cgsId;
    }

    /**
     * 设置采购商id
     */
    public void setCgsId(Long cgsId) {
        this.cgsId = cgsId;
    }

    public Double getZdAmount() {
        return zdAmount;
    }

    public void setZdAmount(Double zdAmount) {
        this.zdAmount = zdAmount;
    }

    /**
     * 获取站点名称
     */
    public String getZdName() {
        return zdName;
    }

    /**
     * 设置站点名称
     */
    public void setZdName(String zdName) {
        this.zdName = zdName == null ? null : zdName.trim();
    }

    public String getZbd() {
        return zbd;
    }

    public void setZbd(String zbd) {
        this.zbd = zbd;
    }

    /**
     * 获取站点地址
     */
    public String getZdAddress() {
        return zdAddress;
    }

    /**
     * 设置站点地址
     */
    public void setZdAddress(String zdAddress) {
        this.zdAddress = zdAddress == null ? null : zdAddress.trim();
    }

    /**
     * 获取站点类型
     */
    public String getZdType() {
        return zdType;
    }

    /**
     * 设置站点类型
     */
    public void setZdType(String zdType) {
        this.zdType = zdType == null ? null : zdType.trim();
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
