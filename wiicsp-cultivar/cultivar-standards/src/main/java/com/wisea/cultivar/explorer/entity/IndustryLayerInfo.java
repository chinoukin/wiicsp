package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * industry_layer_info 表实体
 * 产业图层信息
 * 2020/08/11 13:21:46
 */
public class IndustryLayerInfo extends DataLongEntity<IndustryLayerInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 图层名称
     */
    private String industryLayerName;

    /**
     * 图层介绍
     */
    private String industryLayerIntroduce;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     *
     * @mbg.generated
     */
    public IndustryLayerInfo() {
        super();
    }

    /**
     * 获取图层名称
     */
    public String getIndustryLayerName() {
        return industryLayerName;
    }

    /**
     * 设置图层名称
     */
    public void setIndustryLayerName(String industryLayerName) {
        this.industryLayerName = industryLayerName == null ? null : industryLayerName.trim();
    }

    /**
     * 获取图层介绍
     */
    public String getIndustryLayerIntroduce() {
        return industryLayerIntroduce;
    }

    /**
     * 设置图层介绍
     */
    public void setIndustryLayerIntroduce(String industryLayerIntroduce) {
        this.industryLayerIntroduce = industryLayerIntroduce == null ? null : industryLayerIntroduce.trim();
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系人手机号
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系人手机号
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }
}
