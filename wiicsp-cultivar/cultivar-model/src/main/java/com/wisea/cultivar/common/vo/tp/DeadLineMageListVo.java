package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * DeadLineMageListVo
 * 2018/09/18 14:36:47
 */
public class DeadLineMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 期限类型
     */
    @ApiModelProperty(value = "期限类型，0表示支付期限，1表示确认收货期限")
    private String deadLineType;

    /**
     * 天数限制
     */
    @ApiModelProperty(value = "天数限制")
    private Integer limitDays;

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
     * 获取期限类型
     */
    public String getDeadLineType() {
        return deadLineType;
    }

    /**
     * 设置期限类型
     */
    public void setDeadLineType(String deadLineType) {
        this.deadLineType = deadLineType == null ? null : deadLineType.trim();
    }

    /**
     * 获取天数限制
     */
    public Integer getLimitDays() {
        return limitDays;
    }

    /**
     * 设置天数限制
     */
    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
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

    @Override
    public String toString() {
        return "DeadLineMageListVo{" +
                "id=" + id +
                ", deadLineType='" + deadLineType + '\'' +
                ", limitDays=" + limitDays +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
