package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/6/22
 * projectName:  oritrapla
 * remark:  档案流转Vo
 */
@ApiModel("档案流转Vo")
public class ArchInfoCirculationVo {
    @ApiModelProperty("档案ID")
    private Long archId;
    @ApiModelProperty("档案编号")
    private String archNum;
    @ApiModelProperty("品类名称")
    private String commName; //只显示第三级
    @ApiModelProperty("品种名称")
    private String commVarietName;
    @ApiModelProperty("种植面积")
    private Double plantAcre;
    @ApiModelProperty("种植开始时间")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("种植结束时间")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("预计产量")
    private Double estOutput;
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    @ApiModelProperty("预计上市日期")
    private OffsetDateTime estListDate;
    @ApiModelProperty("档案流转列表")
    private List<ArchInfoVo> mineArchs;

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
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

    public List<ArchInfoVo> getMineArchs() {
        return mineArchs;
    }

    public void setMineArchs(List<ArchInfoVo> mineArchs) {
        this.mineArchs = mineArchs;
    }
}
