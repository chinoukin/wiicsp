package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageMonitorVo
 * @date 2019/2/25 17:34
 * @Description 设备监控Vo
 */
@ApiModel("设备监控Vo")
public class EquInfoMageMonitorVo {
    @ApiModelProperty("设备ID")
    private Long id;
    @ApiModelProperty("设备厂商id")
    private Long equEntpId;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("关联地块ID")
    private Long massifId;
    @ApiModelProperty("地块名称")
    private String massifName;
    @ApiModelProperty("地块面积")
    private Double massifAcre;
    @ApiModelProperty("种植面积")
    private Double plantAcre;
    @ApiModelProperty("正在种植")
    private String commNames;
    @ApiModelProperty("视频播放地址")
    private String bfUrl;
    @ApiModelProperty("封面图片Url")
    private String fmtpUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Double getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public String getCommNames() {
        return commNames;
    }

    public void setCommNames(String commNames) {
        this.commNames = commNames;
    }

    public String getBfUrl() {
        return bfUrl;
    }

    public void setBfUrl(String bfUrl) {
        this.bfUrl = bfUrl;
    }

    public String getFmtpUrl() {
        return fmtpUrl;
    }

    public void setFmtpUrl(String fmtpUrl) {
        this.fmtpUrl = fmtpUrl;
    }
}
