package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoVo
 * @date 2019/7/19 15:06
 * @Description
 */
@ApiModel("基地详细信息VO")
public class BaseInfoVo {
    @ApiModelProperty("档案ID")
    private Long archBasicInfoId;
    @ApiModelProperty("地块ID")
    private Long massifId;
    @ApiModelProperty("地块名称")
    private String massifName;
    @ApiModelProperty("经度")
    private Double jd;
    @ApiModelProperty("维度")
    private Double wd;
    @ApiModelProperty("种植面积")
    private Double plantAcre;
    @ApiModelProperty("当前种植作物-品类")
    private String commName;
    @ApiModelProperty("当前种植作物-品种")
    private String commVariName;
    @ApiModelProperty("预计产量")
    private Double estOutput;
    @ApiModelProperty("种植开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("种植结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("是否有视频")
    private Boolean videoFlag =false;
    @ApiModelProperty("是否有传感器")
    private Boolean monitorFlag = false;

    public Boolean getVideoFlag() {
        return videoFlag;
    }

    public void setVideoFlag(Boolean videoFlag) {
        this.videoFlag = videoFlag;
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

    public Boolean getMonitorFlag() {
        return monitorFlag;
    }

    public void setMonitorFlag(Boolean monitorFlag) {
        this.monitorFlag = monitorFlag;
    }

    public Long getArchBasicInfoId() {
        return archBasicInfoId;
    }

    public void setArchBasicInfoId(Long archBasicInfoId) {
        this.archBasicInfoId = archBasicInfoId;
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

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVariName() {
        return commVariName;
    }

    public void setCommVariName(String commVariName) {
        this.commVariName = commVariName;
    }

    public Double getEstOutput() {
        return estOutput;
    }

    public void setEstOutput(Double estOutput) {
        this.estOutput = estOutput;
    }

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
}
