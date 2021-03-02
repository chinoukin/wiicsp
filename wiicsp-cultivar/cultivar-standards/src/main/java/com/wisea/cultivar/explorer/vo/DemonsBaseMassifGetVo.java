package com.wisea.cultivar.explorer.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * DemonsBaseMassifGetVo
 * 2020/08/11 13:21:46
 */
public class DemonsBaseMassifGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 示范基地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "示范基地id")
    private Long demonsBaseId;

    /**
     * 地块名称
     */
    @ApiModelProperty(value = "地块名称")
    private String massifName;

    /**
     * 所在位置名称
     */
    @ApiModelProperty(value = "所在位置名称")
    private String location;

    /**
     * 地块面积
     */
    @ApiModelProperty(value = "地块面积")
    private Double massifAcre;

    /**
     * 种植品种
     */
    @ApiModelProperty(value = "种植品种")
    private String commName;

    /**
     * 播种时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "播种时间")
    private OffsetDateTime bzDate;

    /**
     * 播种时间字符串
     */
    @ApiModelProperty(value = "播种时间字符串")
    private String bzDateStr;

    /**
     * 区域数量
     */
    @ApiModelProperty(value = "区域数量")
    private Integer areaNum;

    /**
     * 地块关联的物联网设备ID集合
     */
    @ApiModelProperty(value = "地块关联的物联网设备ID集合")
    private List<Long> areaId;

    public Integer getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(Integer areaNum) {
        this.areaNum = areaNum;
    }

    public List<Long> getAreaId() {
        return areaId;
    }

    public void setAreaId(List<Long> areaId) {
        this.areaId = areaId;
    }

    public String getBzDateStr() {
        if(null != this.bzDate){
            this.bzDateStr = ConverterUtil.offsetDateTimeFormat(this.bzDate, ConverterUtil.FORMATE_DATE_MLINE);
        }
        return bzDateStr;
    }

    public void setBzDateStr(String bzDateStr) {
        this.bzDateStr = bzDateStr;
    }

    /**
     * 坐标点表达式
     */
    @ApiModelProperty(value = "坐标点表达式")
    private String coordPointExpres;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 默认的坐标点为册亨县的坐标点 105.81241, 24.983338
     */
    @ApiModelProperty(value = "默认的坐标点为册亨县的坐标点")
    private String defaultCoordPointExpres = "{\"lng\":105.81241,\"lat\":24.983338}";

    public String getDefaultCoordPointExpres() {
        return defaultCoordPointExpres;
    }

    public void setDefaultCoordPointExpres(String defaultCoordPointExpres) {
        this.defaultCoordPointExpres = defaultCoordPointExpres;
    }

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
}
