package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZdInfoMageUpdatePo
 * 2019/12/02 11:02:15
 */
public class ZdInfoMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 采购商id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "采购商id", allowableValues = "length:(,19]")
    private Long cgsId;

    /**
     * 站点名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "站点名称", allowableValues = "mixLength:(,255]")
    private String zdName;

    /**
     * 站点地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "站点地址", allowableValues = "mixLength:(,255]")
    private String zdAddress;

    /**
     * 站点类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "站点类型", allowableValues = "mixLength:(,5]")
    private String zdType;

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
}
