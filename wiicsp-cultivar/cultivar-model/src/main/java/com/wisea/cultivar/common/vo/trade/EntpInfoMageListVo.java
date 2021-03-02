package com.wisea.cultivar.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @ClassName: EntpInfoMageListVo
 * @Author: tgz
 * @Date: 2020/8/7 17:48
 */
public class EntpInfoMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String entpName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码")
    private String areaCode;

    /**
     * 企业类型
     */
    @ApiModelProperty(value = "企业类型")
    private String entpType;


    /**
     * 企业地址
     */
    @ApiModelProperty(value = "企业地址")
    private String entpAddress;

    /**
     * 企业介绍
     */
    @ApiModelProperty(value = "企业介绍")
    private String entpIntroduce;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getEntpType() {
        return entpType;
    }

    public void setEntpType(String entpType) {
        this.entpType = entpType;
    }

    public String getEntpAddress() {
        return entpAddress;
    }

    public void setEntpAddress(String entpAddress) {
        this.entpAddress = entpAddress;
    }

    public String getEntpIntroduce() {
        return entpIntroduce;
    }

    public void setEntpIntroduce(String entpIntroduce) {
        this.entpIntroduce = entpIntroduce;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }
}
