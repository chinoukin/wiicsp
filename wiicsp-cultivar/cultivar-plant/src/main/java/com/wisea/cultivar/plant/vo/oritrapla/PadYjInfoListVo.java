package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
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
}
