package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * PadYjInfoListVo
 * 2019/08/23 11:17:19
 */
public class PadYjInfoListVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "档案id")
    private Long archId;
    @ApiModelProperty(value = "基地名称")
    private String archName;
    @ApiModelProperty(value = "地块名称")
    private String massifName;
    @ApiModelProperty(value = "设备id")
    private Long equId;
    @ApiModelProperty(value = "设备名称")
    private String equName;
    @ApiModelProperty(value = "持续时间，单位分钟")
    private Double cxsjTime;
    @ApiModelProperty(value = "病虫害id")
    private Long padId;
    @ApiModelProperty(value = "记录时间")
    private OffsetDateTime reportTime;
    @ApiModelProperty(value = "病虫害名称")
    private String padName;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty(value = "最高温度")
    private Double maxTemperature;
    @ApiModelProperty(value = "最低温度")
    private Double minTemperature;
    @ApiModelProperty(value = "最高湿度")
    private Double maxHumidity;
    @ApiModelProperty(value = "最低湿度")
    private Double minHumidity;
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getArchName() {
        return archName;
    }

    public void setArchName(String archName) {
        this.archName = archName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public Double getCxsjTime() {
        return cxsjTime;
    }

    public void setCxsjTime(Double cxsjTime) {
        this.cxsjTime = cxsjTime;
    }

    public Long getPadId() {
        return padId;
    }

    public void setPadId(Long padId) {
        this.padId = padId;
    }

    public OffsetDateTime getReportTime() {
        return reportTime;
    }

    public void setReportTime(OffsetDateTime reportTime) {
        this.reportTime = reportTime;
    }

    public String getPadName() {
        return padName;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(Double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public Double getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(Double minHumidity) {
        this.minHumidity = minHumidity;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
