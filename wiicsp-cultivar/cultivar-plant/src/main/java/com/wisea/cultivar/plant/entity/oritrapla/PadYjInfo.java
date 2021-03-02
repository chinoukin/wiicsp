package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * pad_yj_info 表实体
 * 病虫害预警信息
 * 2019/08/23 11:17:19
 */
public class PadYjInfo extends DataLongEntity<PadYjInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 档案id
     */
    private Long archId;
    /**
     * 设备ID
     */
    private Long equId;
    /**
     * 持续时间
     */
    private Double cxsjTime;

    /**
     * 病虫害id
     */
    private Long padId;

    /**
     * 记录时间
     */
    private OffsetDateTime reportTime;

    /**
     * 病虫害名称
     */
    private String padName;

    /**
     * 内容
     */
    private String content;

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
}
