package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * YjMageGetVo
 * 2019/08/23 10:49:05
 */
public class YjMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 预警手机
     */
    @ApiModelProperty(value = "预警手机")
    private String yjTel;

    /**
     * 短信推送标志
     */
    @ApiModelProperty(value = "短信推送标志")
    private String massgePushFlag;

    /**
     * 系统消息推送标志
     */
    @ApiModelProperty(value = "系统消息推送标志")
    private String massgeSysPushFlag;

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
     * 获取预警手机
     */
    public String getYjTel() {
        return yjTel;
    }

    /**
     * 设置预警手机
     */
    public void setYjTel(String yjTel) {
        this.yjTel = yjTel == null ? null : yjTel.trim();
    }

    /**
     * 获取短信推送标志
     */
    public String getMassgePushFlag() {
        return massgePushFlag;
    }

    /**
     * 设置短信推送标志
     */
    public void setMassgePushFlag(String massgePushFlag) {
        this.massgePushFlag = massgePushFlag == null ? null : massgePushFlag.trim();
    }

    /**
     * 获取系统消息推送标志
     */
    public String getMassgeSysPushFlag() {
        return massgeSysPushFlag;
    }

    /**
     * 设置系统消息推送标志
     */
    public void setMassgeSysPushFlag(String massgeSysPushFlag) {
        this.massgeSysPushFlag = massgeSysPushFlag == null ? null : massgeSysPushFlag.trim();
    }

}
