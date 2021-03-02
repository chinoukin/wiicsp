package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * FarmingStageUpdatePo
 * 2020/07/24 11:21:45
 */
public class FarmingStageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 农事周期id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "农事周期id", allowableValues = "length:(,19]")
    private Long farmingCycleId;

    /**
     * 农事类型字典id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "农事类型字典id", allowableValues = "length:(,19]")
    private Long farmWorkTypeId;

    /**
     * 开始天
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "开始天", allowableValues = "length:(,10]")
    private Integer startDays;

    /**
     * 结束天
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "结束天", allowableValues = "length:(,10]")
    private Integer endDays;

    /**
     * 农事要求
     */
    @Check(test = { "maxLength" }, mixLength = 500)
    @ApiModelProperty(value = "农事要求", allowableValues = "mixLength:(,500]")
    private String farmingRequire;

    /**
     * 视频地址
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "视频地址", allowableValues = "mixLength:(,200]")
    private String videoUrl;

    /**
     * 使用农资
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "使用农资", allowableValues = "mixLength:(,200]")
    private String usAgriculturalMaterials;

    /**
     * 周期间隔
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "周期间隔", allowableValues = "mixLength:(,10]")
    private String cycleInterval;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 500)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,500]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;


    @ApiModelProperty(value = "图片")
    private List<StagePictureUpdatePo> stagePictureUpdatePo;

    public List<StagePictureUpdatePo> getStagePictureUpdatePo() {
        return stagePictureUpdatePo;
    }

    public void setStagePictureUpdatePo(List<StagePictureUpdatePo> stagePictureUpdatePo) {
        this.stagePictureUpdatePo = stagePictureUpdatePo;
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
     * 获取农事周期id
     */
    public Long getFarmingCycleId() {
        return farmingCycleId;
    }

    /**
     * 设置农事周期id
     */
    public void setFarmingCycleId(Long farmingCycleId) {
        this.farmingCycleId = farmingCycleId;
    }

    /**
     * 获取农事类型字典id
     */
    public Long getFarmWorkTypeId() {
        return farmWorkTypeId;
    }

    /**
     * 设置农事类型字典id
     */
    public void setFarmWorkTypeId(Long farmWorkTypeId) {
        this.farmWorkTypeId = farmWorkTypeId;
    }

    /**
     * 获取开始天
     */
    public Integer getStartDays() {
        return startDays;
    }

    /**
     * 设置开始天
     */
    public void setStartDays(Integer startDays) {
        this.startDays = startDays;
    }

    /**
     * 获取结束天
     */
    public Integer getEndDays() {
        return endDays;
    }

    /**
     * 设置结束天
     */
    public void setEndDays(Integer endDays) {
        this.endDays = endDays;
    }

    /**
     * 获取农事要求
     */
    public String getFarmingRequire() {
        return farmingRequire;
    }

    /**
     * 设置农事要求
     */
    public void setFarmingRequire(String farmingRequire) {
        this.farmingRequire = farmingRequire == null ? null : farmingRequire.trim();
    }

    /**
     * 获取视频地址
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频地址
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 获取使用农资
     */
    public String getUsAgriculturalMaterials() {
        return usAgriculturalMaterials;
    }

    /**
     * 设置使用农资
     */
    public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
        this.usAgriculturalMaterials = usAgriculturalMaterials == null ? null : usAgriculturalMaterials.trim();
    }

    /**
     * 获取周期间隔
     */
    public String getCycleInterval() {
        return cycleInterval;
    }

    /**
     * 设置周期间隔
     */
    public void setCycleInterval(String cycleInterval) {
        this.cycleInterval = cycleInterval == null ? null : cycleInterval.trim();
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
