package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifListVo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MainBusinessMassifPagePo
 * 2020/08/24 20:19:05
 */
public class MainBusinessMassifPagePo extends PagePo<MainBusinessMassifListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植主体id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植主体id")
    private Long entpInfoMageId;

    /**
     * 地块名称
     */
    @ApiModelProperty(value = "地块名称")
    private String massifName;

    /**
     * 地块面积
     */
    @ApiModelProperty(value = "地块面积")
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
    @ApiModelProperty(value = "种植品种")
    private String commName;

    /**
     * 所在位置名称
     */
    @ApiModelProperty(value = "所在位置名称")
    private String location;

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
