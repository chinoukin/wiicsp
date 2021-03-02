package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * OrdYjInfoListVo
 * 2019/12/02 11:02:15
 */
public class OrdYjInfoListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 指定到达时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "指定到达时间")
    private OffsetDateTime zdddDate;

    /**
     * 产地地址
     */
    @ApiModelProperty(value = "产地地址")
    private String placeOriginAddress;

    /**
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称")
    private String varitName;

    /**
     * 预警类型
     */
    @ApiModelProperty(value = "预警类型")
    private String yjType;

    /**
     * 物流司机电话
     */
    @ApiModelProperty(value = "物流司机电话")
    private String logisticsDriverTel;

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
     * 获取指定到达时间
     */
    public OffsetDateTime getZdddDate() {
        return zdddDate;
    }

    /**
     * 设置指定到达时间
     */
    public void setZdddDate(OffsetDateTime zdddDate) {
        this.zdddDate = zdddDate;
    }

    /**
     * 获取产地地址
     */
    public String getPlaceOriginAddress() {
        return placeOriginAddress;
    }

    /**
     * 设置产地地址
     */
    public void setPlaceOriginAddress(String placeOriginAddress) {
        this.placeOriginAddress = placeOriginAddress == null ? null : placeOriginAddress.trim();
    }

    /**
     * 获取品类名称
     */
    public String getVaritName() {
        return varitName;
    }

    /**
     * 设置品类名称
     */
    public void setVaritName(String varitName) {
        this.varitName = varitName == null ? null : varitName.trim();
    }

    /**
     * 获取预警类型
     */
    public String getYjType() {
        return yjType;
    }

    /**
     * 设置预警类型
     */
    public void setYjType(String yjType) {
        this.yjType = yjType == null ? null : yjType.trim();
    }

    /**
     * 获取物流司机电话
     */
    public String getLogisticsDriverTel() {
        return logisticsDriverTel;
    }

    /**
     * 设置物流司机电话
     */
    public void setLogisticsDriverTel(String logisticsDriverTel) {
        this.logisticsDriverTel = logisticsDriverTel == null ? null : logisticsDriverTel.trim();
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
