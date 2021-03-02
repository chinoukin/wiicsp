package com.wisea.transac.operation.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * TimTrtcHouseGetVo
 * 2020/08/07 17:16:38
 */
public class TimTrtcHouseGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 房间号
     */
    @ApiModelProperty(value = "房间号")
    private Integer houseNum;

    /**
     * 正在使用 0:否 1:是
     */
    @ApiModelProperty(value = "正在使用 0:否 1:是")
    private String onUse;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


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
     * 获取房间号
     */
    public Integer getHouseNum() {
        return houseNum;
    }

    /**
     * 设置房间号
     */
    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    /**
     * 获取正在使用 0:否 1:是
     */
    public String getOnUse() {
        return onUse;
    }

    /**
     * 设置正在使用 0:否 1:是
     */
    public void setOnUse(String onUse) {
        this.onUse = onUse == null ? null : onUse.trim();
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
}
