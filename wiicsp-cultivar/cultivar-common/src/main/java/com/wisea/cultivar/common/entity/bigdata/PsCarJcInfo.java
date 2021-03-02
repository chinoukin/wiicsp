package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * ps_car_jc_info 表实体
 * 配送车辆监测信息
 * 2019/12/02 11:02:15
 */
public class PsCarJcInfo extends DataLongEntity<PsCarJcInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司id
     */
    private Long subEntpId;

    /**
     * 车牌号
     */
    @ExcelField(title = "车牌号",sort = 1)
    private String carNum;

    /**
     * 车辆类型
     */
    @ExcelField(title = "车辆类型",sort = 2)
    private String carType;

    /**
     * 行驶时间
     */
    @ExcelField(title = "行驶时间",sort = 3)
    private String ssDate;

    /**
     * 车厢温度
     */
    @ExcelField(title = "车厢温度",sort = 4)
    private Double cxwd;

    /**
     * 车辆状态
     */
    @ExcelField(title = "车辆状态",sort = 5)
    private String carJcState;

    /**
     * 坐标点
     */
    @ExcelField(title = "坐标点",sort = 6)
    private String coordinate;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

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

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

}
