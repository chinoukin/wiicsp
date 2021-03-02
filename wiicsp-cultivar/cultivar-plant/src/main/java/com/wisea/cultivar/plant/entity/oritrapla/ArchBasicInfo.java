package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

/**
 * 档案基础信息
 */
public class ArchBasicInfo extends DataLongEntity<ArchBasicInfo> {
    private Long membId; //会员id
    private String archNum; //档案编号
    private Long massifId; //地块id
    private Long commId; //品类id
    private Long commVarietId; //品种id
    private Long plantingMethodId;//种植方法id
    private String plantType; //种植标准类型
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate; //开始日期
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate; //结束日期
    private Double plantAcre; //种植面积
    private Double estOutput; //预计产量
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime estListDate; //预计上市日期
    private String url; //图片url
    private String commVarietName;
    private String massifName;

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getPlantingMethodId() {
        return plantingMethodId;
    }

    public void setPlantingMethodId(Long plantingMethodId) {
        this.plantingMethodId = plantingMethodId;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
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

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public Double getEstOutput() {
        return estOutput;
    }

    public void setEstOutput(Double estOutput) {
        this.estOutput = estOutput;
    }

    public OffsetDateTime getEstListDate() {
        return estListDate;
    }

    public void setEstListDate(OffsetDateTime estListDate) {
        this.estListDate = estListDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
