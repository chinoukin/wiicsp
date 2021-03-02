package com.wisea.cultivar.common.vo.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakInfoVo
 * @date 2019/3/25 17:11
 * @Description 牦牛详细信息VO
 */
@ApiModel("牦牛详细信息VO")
public class OriYakInfoVo {
    @ApiModelProperty("牦牛档案ID")
    private Long id;
    @ApiModelProperty("入栏批次id")
    private Long batchId;
    @ApiModelProperty("入栏批次id")
    private String batchName;
    @ApiModelProperty("养殖场id")
    private Long farmId;
    @ApiModelProperty("养殖场名称")
    private String farmName;
    @ApiModelProperty("养殖栋id")
    private Long breedTungId;
    @ApiModelProperty("养殖栋名称")
    private String breedTungName;
    @ApiModelProperty("养殖栏id")
    private Long breedPenId;
    @ApiModelProperty("养殖栏名称")
    private String breedPenName;
    @ApiModelProperty("入栏日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime rlDate;
    @ApiModelProperty("来源id")
    private Long oriYakSourceId;
    @ApiModelProperty("来源名称")
    private String oriYakSourceName;
    @ApiModelProperty("牦牛图片url")
    private String yakPicUrl;
    @ApiModelProperty("耳标号")
    private String earLabel;
    @ApiModelProperty("体重")
    private Double weight;
    @ApiModelProperty("牦牛性别类型")
    private String yakSexType;
    @ApiModelProperty("牦牛出生日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime yakBirthDate;
    @ApiModelProperty("品种类型")
    private String brandType;
    @ApiModelProperty("牦牛状态")
    private String yakType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Long getBreedTungId() {
        return breedTungId;
    }

    public void setBreedTungId(Long breedTungId) {
        this.breedTungId = breedTungId;
    }

    public String getBreedTungName() {
        return breedTungName;
    }

    public void setBreedTungName(String breedTungName) {
        this.breedTungName = breedTungName;
    }

    public Long getBreedPenId() {
        return breedPenId;
    }

    public void setBreedPenId(Long breedPenId) {
        this.breedPenId = breedPenId;
    }

    public String getBreedPenName() {
        return breedPenName;
    }

    public void setBreedPenName(String breedPenName) {
        this.breedPenName = breedPenName;
    }

    public OffsetDateTime getRlDate() {
        return rlDate;
    }

    public void setRlDate(OffsetDateTime rlDate) {
        this.rlDate = rlDate;
    }

    public Long getOriYakSourceId() {
        return oriYakSourceId;
    }

    public void setOriYakSourceId(Long oriYakSourceId) {
        this.oriYakSourceId = oriYakSourceId;
    }

    public String getOriYakSourceName() {
        return oriYakSourceName;
    }

    public void setOriYakSourceName(String oriYakSourceName) {
        this.oriYakSourceName = oriYakSourceName;
    }

    public String getYakPicUrl() {
        return yakPicUrl;
    }

    public void setYakPicUrl(String yakPicUrl) {
        this.yakPicUrl = yakPicUrl;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getYakSexType() {
        return yakSexType;
    }

    public void setYakSexType(String yakSexType) {
        this.yakSexType = yakSexType;
    }

    public OffsetDateTime getYakBirthDate() {
        return yakBirthDate;
    }

    public void setYakBirthDate(OffsetDateTime yakBirthDate) {
        this.yakBirthDate = yakBirthDate;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getYakType() {
        return yakType;
    }

    public void setYakType(String yakType) {
        this.yakType = yakType;
    }
}
