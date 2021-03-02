package com.wisea.cultivar.explorer.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OilTeaBrandMageGetVo
 * 2020/07/24 11:21:45
 */
public class OilTeaBrandMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    /**
     * 品牌编号
     */
    @ApiModelProperty(value = "品牌编号")
    private String brandNo;

    /**
     * 品牌图标
     */
    @ApiModelProperty(value = "品牌图标")
    private String brandUrl;

    /**
     * 品牌介绍
     */
    @ApiModelProperty(value = "品牌介绍")
    private String brandIntroduce;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String conter;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String contTel;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty("申请时间")
    private String applDateStr;

    public void setApplDateStr(String applDateStr) {
        this.applDateStr = applDateStr;
    }

    public String getApplDateStr() {
        if(null != this.applDate){
            this.applDateStr = ConverterUtil.offsetDateTimeFormat(this.applDate, ConverterUtil.FORMATE_DATE_MLINE);
        }
        return applDateStr;
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
     * 获取品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取品牌编号
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * 设置品牌编号
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo == null ? null : brandNo.trim();
    }

    /**
     * 获取品牌图标
     */
    public String getBrandUrl() {
        return brandUrl;
    }

    /**
     * 设置品牌图标
     */
    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl == null ? null : brandUrl.trim();
    }

    /**
     * 获取品牌介绍
     */
    public String getBrandIntroduce() {
        return brandIntroduce;
    }

    /**
     * 设置品牌介绍
     */
    public void setBrandIntroduce(String brandIntroduce) {
        this.brandIntroduce = brandIntroduce == null ? null : brandIntroduce.trim();
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
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
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
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
