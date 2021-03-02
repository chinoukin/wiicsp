package com.wisea.cultivar.operation.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * TimTrtcHouseInsertPo
 * 2020/08/07 17:16:38
 */
public class TimTrtcHouseInsertPo {
    /**
     * 房间号
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "房间号", allowableValues = "length:(,10]")
    private Integer houseNum;

    /**
     * 正在使用 0:否 1:是
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "正在使用 0:否 1:是", allowableValues = "mixLength:(,1]")
    private String onUse;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

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
