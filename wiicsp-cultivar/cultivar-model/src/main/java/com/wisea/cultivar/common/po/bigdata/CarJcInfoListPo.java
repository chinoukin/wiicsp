package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CarJcInfoListPo
 * 2019/12/02 11:02:14
 */
public class CarJcInfoListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carNum;

    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private String carType;

    /**
     * 行驶时间
     */
    @ApiModelProperty(value = "行驶时间")
    private String ssDate;

    /**
     * 车厢温度
     */
    @ApiModelProperty(value = "车厢温度")
    private Double cxwd;

    /**
     * 车辆状态
     */
    @ApiModelProperty(value = "车辆状态")
    private String carJcState;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
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
