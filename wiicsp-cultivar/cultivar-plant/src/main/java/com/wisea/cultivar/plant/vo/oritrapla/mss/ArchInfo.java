package com.wisea.cultivar.plant.vo.oritrapla.mss;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className ArchInfo
 * @date 2020/9/3 9:31
 * @Description
 */
public class ArchInfo {
    @ApiModelProperty("档案ID")
    private Long id;
    @ApiModelProperty(value="地块名称")
    private String massifName;
    @ApiModelProperty(value="种植面积")
    private Double plantAcre;
    @ApiModelProperty(value="品类id")
    private Long commId;
    @ApiModelProperty(value="品类名称")
    private String commName;
    @ApiModelProperty(value="品种id")
    private Long commVarietId;
    @ApiModelProperty(value="品种名称")
    private String variName;
    @ApiModelProperty(value="种植标准类型")
    private String plantType;
    @ApiModelProperty(value="种植开始日期")
    private OffsetDateTime startDate;
    @ApiModelProperty(value="种植结束日期")
    private OffsetDateTime endDate;

    public Long getId() {
        return id;
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

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getVariName() {
        return variName;
    }

    public void setVariName(String variName) {
        this.variName = variName;
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
}
