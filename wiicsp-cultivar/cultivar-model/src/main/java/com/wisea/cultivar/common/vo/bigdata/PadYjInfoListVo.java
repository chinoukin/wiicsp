package com.wisea.cultivar.common.vo.bigdata;

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
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 档案id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "档案id")
    private Long archId;
    @ApiModelProperty(value = "基地名称")
    private String archName;
    @ApiModelProperty(value = "地块名称")
    private String massifName;
    /**
     * 设备ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "设备id")
    private Long equId;
    @ApiModelProperty(value = "设备名称")
    private String equName;
    /**
     * 持续时间
     */
    @ApiModelProperty(value = "持续时间，单位分钟")
    private Double cxsjTime;
    /**
     * 病虫害id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "病虫害id")
    private Long padId;

    /**
     * 记录时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "记录时间")
    private OffsetDateTime reportTime;

    /**
     * 病虫害名称
     */
    @ApiModelProperty(value = "病虫害名称")
    private String padName;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 备注
     */
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

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

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

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
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

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Double getCxsjTime() {
        return cxsjTime;
    }

    public void setCxsjTime(Double cxsjTime) {
        this.cxsjTime = cxsjTime;
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
     * 获取档案id
     */
    public Long getArchId() {
        return archId;
    }

    /**
     * 设置档案id
     */
    public void setArchId(Long archId) {
        this.archId = archId;
    }

    /**
     * 获取病虫害id
     */
    public Long getPadId() {
        return padId;
    }

    /**
     * 设置病虫害id
     */
    public void setPadId(Long padId) {
        this.padId = padId;
    }

    /**
     * 获取记录时间
     */
    public OffsetDateTime getReportTime() {
        return reportTime;
    }

    /**
     * 设置记录时间
     */
    public void setReportTime(OffsetDateTime reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取病虫害名称
     */
    public String getPadName() {
        return padName;
    }

    /**
     * 设置病虫害名称
     */
    public void setPadName(String padName) {
        this.padName = padName == null ? null : padName.trim();
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
