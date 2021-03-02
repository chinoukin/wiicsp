package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class OriYakInfo extends DataLongEntity<OriYakInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 入栏批次id
     */
    private Long batchId;

    /**
     * 养殖栋id
     */
    private Long breedTungId;

    /**
     * 养殖场id
     */
    private Long farmId;

    /**
     * 来源id
     */
    private Long oriYakSourceId;

    /**
     * 牦牛图片url
     */
    private String yakPicUrl;

    /**
     * 耳标号
     */
    private String earLabel;

    /**
     * 体重
     */
    private Double weight;

    /**
     * 牦牛性别类型
     */
    private String yakSexType;

    /**
     * 牦牛出生日期
     */
    private OffsetDateTime yakBirthDate;

    /**
     * 品牌类型
     */
    private String brandType;

    /**
     * 养殖栏id
     */
    private Long breedPenId;

    /**
     * 入栏日期
     */
    private OffsetDateTime rlDate;

    /**
     * 牦牛状态
     */
    private String yakType;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getBreedTungId() {
        return breedTungId;
    }

    public void setBreedTungId(Long breedTungId) {
        this.breedTungId = breedTungId;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
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

    public Long getBreedPenId() {
        return breedPenId;
    }

    public void setBreedPenId(Long breedPenId) {
        this.breedPenId = breedPenId;
    }

    public OffsetDateTime getRlDate() {
        return rlDate;
    }

    public void setRlDate(OffsetDateTime rlDate) {
        this.rlDate = rlDate;
    }

    public String getYakType() {
        return yakType;
    }

    public void setYakType(String yakType) {
        this.yakType = yakType;
    }
}
