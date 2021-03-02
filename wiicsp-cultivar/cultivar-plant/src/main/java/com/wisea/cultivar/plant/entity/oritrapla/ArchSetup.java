package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 档案设置
 */
public class ArchSetup extends DataLongEntity<ArchSetup> {
	@ApiModelProperty(value="我的档案id")
    private Long mineArchId; //我的档案id
	@ApiModelProperty(value="是否设置档案对外展示名称")
    private String archEdNameFlag; //是否设置档案对外展示名称
	@ApiModelProperty(value="档案对外展示名称")
    private String archEdName; //档案对外展示名称
	@ApiModelProperty(value="是否设置地块对外展示名称")
    private String massifEdNameFlag; //是否设置地块对外展示名称
	@ApiModelProperty(value="地块对外展示名称")
    private String massifEdName; //地块对外展示名称
	@ApiModelProperty(value="是否对外展示作物品类/品种")
    private String cropEdFlag; //是否对外展示作物品类/品种
	@ApiModelProperty(value="是否对外展示种植面积")
    private String plantAcreEdFlag; //是否对外展示种植面积
	@ApiModelProperty(value="是否对外展示种植标准")
    private String plantStandEdFlag; //是否对外展示种植标准
	@ApiModelProperty(value="是否对外展示种植开始时间")
    private String plantStartEdFlag; //是否对外展示种植开始时间
	@ApiModelProperty(value="是否对外展示上市时间")
    private String listDateEdFlag; //是否对外展示上市时间
	@ApiModelProperty(value="是否对外展示检测信息")
    private String examInfoEdFlag; //是否对外展示检测信息
	@ApiModelProperty(value="展示检测信息类型")
    private String examInfoType; //展示检测信息类型

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public String getArchEdNameFlag() {
        return archEdNameFlag;
    }

    public void setArchEdNameFlag(String archEdNameFlag) {
        this.archEdNameFlag = archEdNameFlag;
    }

    public String getArchEdName() {
        return archEdName;
    }

    public void setArchEdName(String archEdName) {
        this.archEdName = archEdName;
    }

    public String getMassifEdNameFlag() {
        return massifEdNameFlag;
    }

    public void setMassifEdNameFlag(String massifEdNameFlag) {
        this.massifEdNameFlag = massifEdNameFlag;
    }

    public String getMassifEdName() {
        return massifEdName;
    }

    public void setMassifEdName(String massifEdName) {
        this.massifEdName = massifEdName;
    }

    public String getCropEdFlag() {
        return cropEdFlag;
    }

    public void setCropEdFlag(String cropEdFlag) {
        this.cropEdFlag = cropEdFlag;
    }

    public String getPlantAcreEdFlag() {
        return plantAcreEdFlag;
    }

    public void setPlantAcreEdFlag(String plantAcreEdFlag) {
        this.plantAcreEdFlag = plantAcreEdFlag;
    }

    public String getPlantStandEdFlag() {
        return plantStandEdFlag;
    }

    public void setPlantStandEdFlag(String plantStandEdFlag) {
        this.plantStandEdFlag = plantStandEdFlag;
    }

    public String getPlantStartEdFlag() {
        return plantStartEdFlag;
    }

    public void setPlantStartEdFlag(String plantStartEdFlag) {
        this.plantStartEdFlag = plantStartEdFlag;
    }

    public String getListDateEdFlag() {
        return listDateEdFlag;
    }

    public void setListDateEdFlag(String listDateEdFlag) {
        this.listDateEdFlag = listDateEdFlag;
    }

    public String getExamInfoEdFlag() {
        return examInfoEdFlag;
    }

    public void setExamInfoEdFlag(String examInfoEdFlag) {
        this.examInfoEdFlag = examInfoEdFlag;
    }

    public String getExamInfoType() {
        return examInfoType;
    }

    public void setExamInfoType(String examInfoType) {
        this.examInfoType = examInfoType;
    }
}
