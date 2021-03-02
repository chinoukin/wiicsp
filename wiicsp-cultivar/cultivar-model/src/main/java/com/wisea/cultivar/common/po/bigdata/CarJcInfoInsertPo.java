package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * CarJcInfoInsertPo
 * 2019/12/02 11:02:14
 */
public class CarJcInfoInsertPo {
    /**
     * 车牌号
     */
    @Check(test = { "maxLength","required" }, mixLength = 100)
    @ApiModelProperty(value = "车牌号", allowableValues = "mixLength:(,100]")
    private String carNum;

    /**
     * 车辆类型
     */
    @Check(test = { "maxLength","required" }, mixLength = 5)
    @ApiModelProperty(value = "车辆类型", allowableValues = "mixLength:(,5]")
    private String carType;

    /**
     * 行驶时间
     */
    @ApiModelProperty(value = "行驶时间")
    private String ssDate;

    /**
     * 车厢温度
     */
    @Check(test = { "regex","required" })
    @ApiModelProperty(value = "车厢温度")
    private Double cxwd;

    /**
     * 车辆状态
     */
    @Check(test = { "maxLength","required" }, mixLength = 5)
    @ApiModelProperty(value = "车辆状态", allowableValues = "mixLength:(,5]")
    private String carJcState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

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
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
