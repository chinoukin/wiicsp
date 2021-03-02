package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * car_jc_info 表实体
 * 车辆监测信息
 * 2019/12/02 11:02:14
 */
public class CarJcInfo extends DataLongEntity<CarJcInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
    @ExcelField(title = "车牌号", sort = 1,width = 20)
    private String carNum;

    /**
     * 车辆类型
     */
    @ExcelField(title = "车辆类型", sort = 10,width = 10)
    private String carType;

    /**
     * 行驶时间
     */
    @ExcelField(title = "行驶时间", sort = 20,width = 10)
    private String ssDate;

    /**
     * 车厢温度
     */
    @ExcelField(title = "车厢温度(℃)", sort = 30,width = 10)
    private Double cxwd;

    /**
     * 车辆状态
     */
    @ExcelField(title = "车辆状态", sort = 40,width = 10)
    private String carJcState;

    /**
     * 获取车牌号
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * 设置车牌号
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    /**
     * 获取车辆类型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置车辆类型
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    /**
     * 获取行驶时间
     */
    public String getSsDate() {
        return ssDate;
    }

    /**
     * 设置行驶时间
     */
    public void setSsDate(String ssDate) {
        this.ssDate = ssDate;
    }

    /**
     * 获取车厢温度
     */
    public Double getCxwd() {
        return cxwd;
    }

    /**
     * 设置车厢温度
     */
    public void setCxwd(Double cxwd) {
        this.cxwd = cxwd;
    }

    /**
     * 获取车辆状态
     */
    public String getCarJcState() {
        return carJcState;
    }

    /**
     * 设置车辆状态
     */
    public void setCarJcState(String carJcState) {
        this.carJcState = carJcState == null ? null : carJcState.trim();
    }
}
