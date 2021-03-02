package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OilTeaBrandMageUpdatePo
 * 2020/07/24 11:21:45
 */
public class OilTeaBrandMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 品牌名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 100 })
    @ApiModelProperty(value = "品牌名称", allowableValues = "mixLength:(2,100]")
    private String brandName;

    /**
     * 品牌编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "品牌编号", allowableValues = "mixLength:(,30]")
    private String brandNo;

    /**
     * 品牌图标
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品牌图标", allowableValues = "mixLength:(,255]")
    private String brandUrl;

    /**
     * 品牌介绍
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "品牌介绍", allowableValues = "mixLength:(,600]")
    private String brandIntroduce;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    @Check(test = { "required" })
    private OffsetDateTime applDate;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系人", allowableValues = "mixLength:(,20]")
    private String conter;

    /**
     * 联系方式
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系方式", allowableValues = "mixLength:(,20]")
    private String contTel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

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

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
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
