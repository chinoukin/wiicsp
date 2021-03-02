package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * YjMageUpdatePo
 * 2019/08/23 10:49:05
 */
public class YjMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 预警手机
     */
    @Check(test = "logic", logic = "'0'.equals(#massgePushFlag)?#isNotEmpty(#yjTel):true", logicMsg = "短信推送设置是0(是)的情况不能为空")
    @ApiModelProperty(value = "预警手机")
    private String yjTel;

    /**
     * 短信推送标志
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "短信推送标志只能为0或者1")
    @ApiModelProperty(value = "短信推送标志(massge_push_flag0:是1:否)")
    private String massgePushFlag;

    /**
     * 系统消息推送标志
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "系统消息推送标志只能为0或者1")
    @ApiModelProperty(value = "系统消息推送标志(massge_sys_push_flag0:是1:否)")
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
