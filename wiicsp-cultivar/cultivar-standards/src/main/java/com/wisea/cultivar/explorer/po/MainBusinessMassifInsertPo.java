package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MainBusinessMassifInsertPo
 * 2020/08/24 20:19:05
 */
public class MainBusinessMassifInsertPo {
    /**
     * 种植主体id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "种植主体id", allowableValues = "length:(,19]")
    private Long entpInfoMageId;

    /**
     * 地块名称
     */
    @Check(test = { "minLength", "maxLength" }, lengthRange = { 2, 200 })
    @ApiModelProperty(value = "地块名称")
    private String massifName;

    /**
     * 地块面积
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "地块面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double massifAcre;

    /**
     * 播种时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "播种时间")
    private OffsetDateTime bzDate;

    /**
     * 种植品种
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "种植品种", allowableValues = "mixLength:(,255]")
    private String commName;

    /**
     * 所在位置名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "所在位置名称", allowableValues = "mixLength:(,100]")
    private String location;

    /**
     * 坐标点表达式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "坐标点表达式", allowableValues = "mixLength:(,255]")
    private String coordPointExpres;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取种植主体id
     */
    public Long getEntpInfoMageId() {
        return entpInfoMageId;
    }

    /**
     * 设置种植主体id
     */
    public void setEntpInfoMageId(Long entpInfoMageId) {
        this.entpInfoMageId = entpInfoMageId;
    }

    /**
     * 获取地块名称
     */
    public String getMassifName() {
        return massifName;
    }

    /**
     * 设置地块名称
     */
    public void setMassifName(String massifName) {
        this.massifName = massifName == null ? null : massifName.trim();
    }

    /**
     * 获取地块面积
     */
    public Double getMassifAcre() {
        return massifAcre;
    }

    /**
     * 设置地块面积
     */
    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    /**
     * 获取播种时间
     */
    public OffsetDateTime getBzDate() {
        return bzDate;
    }

    /**
     * 设置播种时间
     */
    public void setBzDate(OffsetDateTime bzDate) {
        this.bzDate = bzDate;
    }

    /**
     * 获取种植品种
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置种植品种
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取所在位置名称
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所在位置名称
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取坐标点表达式
     */
    public String getCoordPointExpres() {
        return coordPointExpres;
    }

    /**
     * 设置坐标点表达式
     */
    public void setCoordPointExpres(String coordPointExpres) {
        this.coordPointExpres = coordPointExpres == null ? null : coordPointExpres.trim();
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
