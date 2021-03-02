package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * pad_mage 表实体
 * 病虫害管理
 * 2019/08/21 09:13:45
 */
public class PadMage extends DataLongEntity<PadMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 病虫害名称
     */
    private String padName;

    /**
     * 病虫害图片
     */
    private String padUrl;

    /**
     * 病虫害类型
     */
    private String padType;

    /**
     * 病虫害损失率
     */
    private Double padSsl;

    /**
     * 病原
     */
    private String pathogeny;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 发病条件
     */
    private String pathogenicConditions;

    /**
     * 农业防治
     */
    private String agrControl;

    /**
     * 物理防治
     */
    private String phyControl;

    /**
     * 生物防治
     */
    private String biologyControl;

    /**
     * 化学防治
     */
    private String chemistryControl;

    /**
     * 有机防治
     */
    private String organicControl;

    /**
     * 易患月份
     */
    private String vulnerableMonths;

    /**
     * 最高温度
     */
    private Double maxTemperature;

    /**
     * 最低温度
     */
    private Double minTemperature;

    /**
     * 最高湿度
     */
    private Double maxHumidity;

    /**
     * 最低湿度
     */
    private Double minHumidity;

    /**
     * 爆发时间
     */
    private Double bfTime;


    /**
     * 浏览数
     */
    private Integer views;

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取病虫害名称
     */
    public String getPadName() {
        return padName;
    }

    /**
     * 设置病虫害名称
     */
    public void setPadName(String padName) {
        this.padName = padName == null ? null : padName.trim();
    }

    /**
     * 获取病虫害图片
     */
    public String getPadUrl() {
        return padUrl;
    }

    /**
     * 设置病虫害图片
     */
    public void setPadUrl(String padUrl) {
        this.padUrl = padUrl == null ? null : padUrl.trim();
    }

    /**
     * 获取病虫害类型
     */
    public String getPadType() {
        return padType;
    }

    /**
     * 设置病虫害类型
     */
    public void setPadType(String padType) {
        this.padType = padType == null ? null : padType.trim();
    }

    /**
     * 获取病虫害损失率
     */
    public Double getPadSsl() {
        return padSsl;
    }

    /**
     * 设置病虫害损失率
     */
    public void setPadSsl(Double padSsl) {
        this.padSsl = padSsl;
    }

    /**
     * 获取病原
     */
    public String getPathogeny() {
        return pathogeny;
    }

    /**
     * 设置病原
     */
    public void setPathogeny(String pathogeny) {
        this.pathogeny = pathogeny == null ? null : pathogeny.trim();
    }

    /**
     * 获取症状
     */
    public String getSymptom() {
        return symptom;
    }

    /**
     * 设置症状
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    /**
     * 获取发病条件
     */
    public String getPathogenicConditions() {
        return pathogenicConditions;
    }

    /**
     * 设置发病条件
     */
    public void setPathogenicConditions(String pathogenicConditions) {
        this.pathogenicConditions = pathogenicConditions == null ? null : pathogenicConditions.trim();
    }

    /**
     * 获取农业防治
     */
    public String getAgrControl() {
        return agrControl;
    }

    /**
     * 设置农业防治
     */
    public void setAgrControl(String agrControl) {
        this.agrControl = agrControl == null ? null : agrControl.trim();
    }

    /**
     * 获取物理防治
     */
    public String getPhyControl() {
        return phyControl;
    }

    /**
     * 设置物理防治
     */
    public void setPhyControl(String phyControl) {
        this.phyControl = phyControl == null ? null : phyControl.trim();
    }

    /**
     * 获取生物防治
     */
    public String getBiologyControl() {
        return biologyControl;
    }

    /**
     * 设置生物防治
     */
    public void setBiologyControl(String biologyControl) {
        this.biologyControl = biologyControl == null ? null : biologyControl.trim();
    }

    /**
     * 获取化学防治
     */
    public String getChemistryControl() {
        return chemistryControl;
    }

    /**
     * 设置化学防治
     */
    public void setChemistryControl(String chemistryControl) {
        this.chemistryControl = chemistryControl == null ? null : chemistryControl.trim();
    }

    /**
     * 获取有机防治
     */
    public String getOrganicControl() {
        return organicControl;
    }

    /**
     * 设置有机防治
     */
    public void setOrganicControl(String organicControl) {
        this.organicControl = organicControl == null ? null : organicControl.trim();
    }

    /**
     * 获取易患月份
     */
    public String getVulnerableMonths() {
        return vulnerableMonths;
    }

    /**
     * 设置易患月份
     */
    public void setVulnerableMonths(String vulnerableMonths) {
        this.vulnerableMonths = vulnerableMonths == null ? null : vulnerableMonths.trim();
    }

    /**
     * 获取最高温度
     */
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * 设置最高温度
     */
    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * 获取最低温度
     */
    public Double getMinTemperature() {
        return minTemperature;
    }

    /**
     * 设置最低温度
     */
    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * 获取最高湿度
     */
    public Double getMaxHumidity() {
        return maxHumidity;
    }

    /**
     * 设置最高湿度
     */
    public void setMaxHumidity(Double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    /**
     * 获取最低湿度
     */
    public Double getMinHumidity() {
        return minHumidity;
    }

    /**
     * 设置最低湿度
     */
    public void setMinHumidity(Double minHumidity) {
        this.minHumidity = minHumidity;
    }

    /**
     * 获取爆发时间
     */
    public Double getBfTime() {
        return bfTime;
    }

    /**
     * 设置爆发时间
     */
    public void setBfTime(Double bfTime) {
        this.bfTime = bfTime;
    }

}
