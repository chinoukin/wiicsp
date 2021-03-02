package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * WljcInsertPo
 * 2019/12/02 11:02:15
 */
public class WljcInsertPo {
    /**
     * 车辆总数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "车辆总数", allowableValues = "length:(,10]")
    private Integer clzs;

    /**
     * 监控车辆数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "监控车辆数", allowableValues = "length:(,10]")
    private Integer jkcls;

    /**
     * 监控在途车辆数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "监控在途车辆数", allowableValues = "length:(,10]")
    private Integer ztcls;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取车辆总数
     */
    public Integer getClzs() {
        return clzs;
    }

    /**
     * 设置车辆总数
     */
    public void setClzs(Integer clzs) {
        this.clzs = clzs;
    }

    /**
     * 获取监控车辆数
     */
    public Integer getJkcls() {
        return jkcls;
    }

    /**
     * 设置监控车辆数
     */
    public void setJkcls(Integer jkcls) {
        this.jkcls = jkcls;
    }

    /**
     * 获取监控在途车辆数
     */
    public Integer getZtcls() {
        return ztcls;
    }

    /**
     * 设置监控在途车辆数
     */
    public void setZtcls(Integer ztcls) {
        this.ztcls = ztcls;
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
