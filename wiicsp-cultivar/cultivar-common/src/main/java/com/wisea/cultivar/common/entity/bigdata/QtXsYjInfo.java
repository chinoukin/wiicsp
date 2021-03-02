package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.time.OffsetDateTime;

/**
 * qt_xs_yj_info 表实体
 * 24小时预警信息
 * 2019/12/02 11:02:15
 */
public class QtXsYjInfo extends DataLongEntity<QtXsYjInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司id
     */
    private Long subEntpId;

    /**
     * 指定到达时间
     */
    @ExcelField(title = "指定到达时间",sort = 1,formate = "yyyy-MM-dd")
    private OffsetDateTime zdddDate;

    /**
     * 产地地址
     */
    @ExcelField(title = "产地地址",sort = 2)
    private String placeOriginAddress;

    /**
     * 品类名称
     */
    @ExcelField(title = "品类名称",sort = 3)
    private String varitName;

    /**
     * 预警类型
     */
    @ExcelField(title = "预警类型",sort = 4)
    private String yjType;

    /**
     * 物流司机电话
     */
    @ExcelField(title = "物流司机电话",sort = 5)
    private String logisticsDriverTel;

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
     * 获取指定到达时间
     */
    public OffsetDateTime getZdddDate() {
        return zdddDate;
    }

    /**
     * 设置指定到达时间
     */
    public void setZdddDate(OffsetDateTime zdddDate) {
        this.zdddDate = zdddDate;
    }

    /**
     * 获取产地地址
     */
    public String getPlaceOriginAddress() {
        return placeOriginAddress;
    }

    /**
     * 设置产地地址
     */
    public void setPlaceOriginAddress(String placeOriginAddress) {
        this.placeOriginAddress = placeOriginAddress == null ? null : placeOriginAddress.trim();
    }

    /**
     * 获取品类名称
     */
    public String getVaritName() {
        return varitName;
    }

    /**
     * 设置品类名称
     */
    public void setVaritName(String varitName) {
        this.varitName = varitName == null ? null : varitName.trim();
    }

    /**
     * 获取预警类型
     */
    public String getYjType() {
        return yjType;
    }

    /**
     * 设置预警类型
     */
    public void setYjType(String yjType) {
        this.yjType = yjType == null ? null : yjType.trim();
    }

    /**
     * 获取物流司机电话
     */
    public String getLogisticsDriverTel() {
        return logisticsDriverTel;
    }

    /**
     * 设置物流司机电话
     */
    public void setLogisticsDriverTel(String logisticsDriverTel) {
        this.logisticsDriverTel = logisticsDriverTel == null ? null : logisticsDriverTel.trim();
    }
}
