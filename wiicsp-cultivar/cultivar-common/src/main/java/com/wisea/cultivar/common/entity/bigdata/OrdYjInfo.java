package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.time.OffsetDateTime;

/**
 * ord_yj_info 表实体
 * 订单预警信息
 * 2019/12/02 11:02:15
 */
public class OrdYjInfo extends DataLongEntity<OrdYjInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 指定到达时间
     */
    @ExcelField(title = "指定到达时间",sort = 1,formate = "yyyy-MM-dd HH:mm:ss",width = 30)
    private OffsetDateTime zdddDate;

    /**
     * 产地地址
     */
    @ExcelField(title = "产地地址",sort = 10,width = 10)
    private String placeOriginAddress;

    /**
     * 品类名称
     */
    @ExcelField(title = "品类名称",sort = 20,width = 20)
    private String varitName;

    /**
     * 预警类型
     */
    @ExcelField(title = "预警类型",sort = 30,width = 10)
    private String yjType;

    /**
     * 物流司机电话
     */
    @ExcelField(title = "物流司机电话",sort = 40,width = 20)
    private String logisticsDriverTel;

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

    @Override
    public String toString() {
        return "OrdYjInfo{" +
                "zdddDate=" + zdddDate +
                ", placeOriginAddress='" + placeOriginAddress + '\'' +
                ", varitName='" + varitName + '\'' +
                ", yjType='" + yjType + '\'' +
                ", logisticsDriverTel='" + logisticsDriverTel + '\'' +
                '}';
    }
}
