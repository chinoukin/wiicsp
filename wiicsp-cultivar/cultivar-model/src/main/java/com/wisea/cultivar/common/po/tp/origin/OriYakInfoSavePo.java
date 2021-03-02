package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakInfoSavePo
 * @date 2019/3/25 14:19
 * @Description 保存或修改牦牛档案PO
 */
@ApiModel("保存或修改牦牛档案PO")
public class OriYakInfoSavePo {
    @ApiModelProperty("牦牛档案ID，修改时非空")
    private Long id;
    @ApiModelProperty("入栏批次id")
    @Check(test = "required")
    private Long batchId;
    @ApiModelProperty("养殖场id")
    @Check(test = "required")
    private Long farmId;
    @ApiModelProperty("养殖栏id")
    @Check(test = "required")
    private Long breedPenId;
    @ApiModelProperty("养殖栋id")
    @Check(test = "required")
    private Long breedTungId;
    @ApiModelProperty("来源id")
    @Check(test = "required")
    private Long oriYakSourceId;
    @ApiModelProperty("牦牛图片url")
    @Check(test = "required")
    private String yakPicUrl;
    @ApiModelProperty("耳标号")
    @Check(test = "required")
    private String earLabel;
    @ApiModelProperty("体重")
    @Check(test = "required")
    private Double weight;
    @ApiModelProperty("牦牛性别类型")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "牦牛性别类型只能是0、1")
    private String yakSexType;
    @ApiModelProperty("牦牛出生日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Check(test = "required")
    private OffsetDateTime yakBirthDate;
    @ApiModelProperty("品牌类型")
    @Check(test = "required")
    private String brandType;
    @ApiModelProperty("入栏日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Check(test = "required")
    private OffsetDateTime rlDate;

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

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public Long getBreedPenId() {
        return breedPenId;
    }

    public void setBreedPenId(Long breedPenId) {
        this.breedPenId = breedPenId;
    }

    public Long getBreedTungId() {
        return breedTungId;
    }

    public void setBreedTungId(Long breedTungId) {
        this.breedTungId = breedTungId;
    }

    public Long getOriYakSourceId() {
        return oriYakSourceId;
    }

    public void setOriYakSourceId(Long oriYakSourceId) {
        this.oriYakSourceId = oriYakSourceId;
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

    public OffsetDateTime getRlDate() {
        return rlDate;
    }

    public void setRlDate(OffsetDateTime rlDate) {
        this.rlDate = rlDate;
    }
}
