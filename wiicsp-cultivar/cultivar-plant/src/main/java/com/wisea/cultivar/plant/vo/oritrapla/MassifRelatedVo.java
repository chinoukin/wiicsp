package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className MassifRelatedVo
 * @date 2020/8/14 16:26
 * @Description 地块关联列表【资源管理系统】使用
 */
@ApiModel("地块关联列表")
public class MassifRelatedVo {
    @ApiModelProperty("地块ID")
    private Long id;
    @ApiModelProperty("主体名称")
    private String orgName;
    @ApiModelProperty("地块名称")
    private String massifName;
    @ApiModelProperty("地块类型")
    private String massifType;
    @ApiModelProperty("地块面积")
    private Double massifAcre;
    @ApiModelProperty("地块经度")
    private Double jd; //地块纬度
    @ApiModelProperty("地块纬度")
    private Double wd; //地块纬度
    @ApiModelProperty("所在位置")
    private String location;

    @ApiModelProperty("物联网设备数量")
    private Integer equCount;
    @ApiModelProperty("视频设备数量")
    private Integer videoCount;
    @ApiModelProperty("档案数量")
    private Integer archCount;

    public Long getId() {
        return id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getMassifType() {
        return massifType;
    }

    public void setMassifType(String massifType) {
        this.massifType = massifType;
    }

    public Double getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEquCount() {
        return equCount;
    }

    public void setEquCount(Integer equCount) {
        this.equCount = equCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getArchCount() {
        return archCount;
    }

    public void setArchCount(Integer archCount) {
        this.archCount = archCount;
    }
}
