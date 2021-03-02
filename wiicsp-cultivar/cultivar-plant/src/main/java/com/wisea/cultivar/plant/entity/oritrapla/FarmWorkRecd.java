package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

/**
 * 农事记录
 */
public class FarmWorkRecd extends DataLongEntity<FarmWorkRecd> {
    private Long archId; //档案id
    private Long farmWorkTypeId; //农事类型id
    private String operatContent; //操作内容
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime operatDate; //操作时间
    private String videoUrl; //视频url
    private String usAgriculturalMaterials; //使用农资
    private String recordStatus; //记录状态

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public Long getFarmWorkTypeId() {
        return farmWorkTypeId;
    }

    public void setFarmWorkTypeId(Long farmWorkTypeId) {
        this.farmWorkTypeId = farmWorkTypeId;
    }

    public String getOperatContent() {
        return operatContent;
    }

    public void setOperatContent(String operatContent) {
        this.operatContent = operatContent;
    }

    public OffsetDateTime getOperatDate() {
        return operatDate;
    }

    public void setOperatDate(OffsetDateTime operatDate) {
        this.operatDate = operatDate;
    }

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getUsAgriculturalMaterials() {
		return usAgriculturalMaterials;
	}

	public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
		this.usAgriculturalMaterials = usAgriculturalMaterials;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
}
