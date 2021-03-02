package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * DemonsBaseMassifInsertPo
 * 2020/08/11 13:21:46
 */
public class DemonsBaseMassifInsertPo {
    /**
     * 示范基地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "示范基地id", allowableValues = "length:(,19]")
    private Long demonsBaseId;

    /**
     * 地块名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 200 })
    @ApiModelProperty(value = "地块名称")
    private String massifName;

    /**
     * 所在位置名称
     */
    @Check(test = { "required","maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "所在位置名称", allowableValues = "mixLength:(,100]")
    private String location;

    /**
     * 地块面积
     */
    @Check(test = { "required","regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "地块面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double massifAcre;

    /**
     * 种植品种
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "种植品种", allowableValues = "mixLength:(,255]")
    private String commName;

    /**
     * 播种时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "播种时间")
    private OffsetDateTime bzDate;

    /**
     * 坐标点表达式
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "坐标点表达式")
    private String coordPointExpres;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 物联网设备ID
     */
    @ApiModelProperty(value = "物联网设备ID")
    private List<Long>  equipmentIds;

    public List<Long> getEquipmentIds() {
        return equipmentIds;
    }

    public void setEquipmentIds(List<Long> equipmentIds) {
        this.equipmentIds = equipmentIds;
    }

    /**
     * 获取示范基地id
     */
    public Long getDemonsBaseId() {
        return demonsBaseId;
    }

    /**
     * 设置示范基地id
     */
    public void setDemonsBaseId(Long demonsBaseId) {
        this.demonsBaseId = demonsBaseId;
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
