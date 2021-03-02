package com.wisea.cultivar.common.vo.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakInfoPageVo
 * @date 2019/3/22 17:26
 * @Description 牦牛档案分页PO
 */
@ApiModel("牦牛档案分页PO")
public class OriInfoPageVo {
    @ApiModelProperty("牦牛档案ID")
    private Long id;
    @ApiModelProperty("牦牛图片url")
    private String yakPicUrl;
    @ApiModelProperty("耳标号")
    private String earLabel;
    @ApiModelProperty("牦牛岁数")
    private Integer yakAge;
    @ApiModelProperty("体重")
    private Double weight;
    @ApiModelProperty("养殖场名称")
    private String farmName;
    @ApiModelProperty("养殖栋名称")
    private String breedTungName;
    @ApiModelProperty("养殖栏名称")
    private String breedPenName;
    @ApiModelProperty("入栏日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime rlDate;
    @ApiModelProperty("入栏批次")
    private String batchName;
    @ApiModelProperty("来源")
    private String yakSourceName;
    @ApiModelProperty("入栏多少天")
    private Integer rlDays;
    @ApiModelProperty("牦牛状态")
    private String yakType;
    @ApiModelProperty("养殖日志数量")
    private Integer breedLogNum;

    public Integer getBreedLogNum() {
        return breedLogNum;
    }

    public void setBreedLogNum(Integer breedLogNum) {
        this.breedLogNum = breedLogNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getYakAge() {
        return yakAge;
    }

    public void setYakAge(Integer yakAge) {
        this.yakAge = yakAge;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getBreedTungName() {
        return breedTungName;
    }

    public void setBreedTungName(String breedTungName) {
        this.breedTungName = breedTungName;
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

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getYakSourceName() {
        return yakSourceName;
    }

    public void setYakSourceName(String yakSourceName) {
        this.yakSourceName = yakSourceName;
    }

    public Integer getRlDays() {
        return rlDays;
    }

    public void setRlDays(Integer rlDays) {
        this.rlDays = rlDays;
    }

    public String getYakType() {
        return yakType;
    }

    public void setYakType(String yakType) {
        this.yakType = yakType;
    }
}
