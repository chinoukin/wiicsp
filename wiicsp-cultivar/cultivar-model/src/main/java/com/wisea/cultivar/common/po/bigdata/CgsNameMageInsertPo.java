package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * CgsNameMageInsertPo
 * 2019/12/02 11:02:14
 */
public class CgsNameMageInsertPo {
    /**
     * 采购商名称
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "采购商名称", allowableValues = "mixLength:(,255]")
    private String cgsName;

    /**
     * 采购商简称
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "采购商简称", allowableValues = "mixLength:(,255]")
    private String cgsJc;

    /**
     * 采购商地址
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "采购商地址", allowableValues = "mixLength:(,255]")
    private String cgsAddress;

    /**
     * 成交金额
     */
    @Check(test = { "required","regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "成交金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double cjje;

    /**
     * 经度
     */
    @Check(test = { "required","regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "经度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jd;

    /**
     * 纬度
     */
    @Check(test = { "required","regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "纬度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wd;

    /**
     * 获取采购商名称
     */
    public String getCgsName() {
        return cgsName;
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
}
