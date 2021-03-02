package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PsCarJcInfoUpdatePo
 * 2019/12/02 11:02:15
 */
public class PsCarJcInfoUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分公司id", allowableValues = "length:(,19]")
    private Long subEntpId;

    /**
     * 车牌号
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "车牌号", allowableValues = "mixLength:(,100]")
    private String carNum;

    /**
     * 车辆类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
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
    @ApiModelProperty(value = "车厢温度")
    private Double cxwd;

    /**
     * 车辆状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "车辆状态", allowableValues = "mixLength:(,5]")
    private String carJcState;

    /**
     * 经度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "经度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jd;

    /**
     * 纬度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "纬度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wd;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
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
