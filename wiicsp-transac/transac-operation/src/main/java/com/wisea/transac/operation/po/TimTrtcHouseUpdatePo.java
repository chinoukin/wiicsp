package com.wisea.transac.operation.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * TimTrtcHouseUpdatePo 2020/08/07 17:16:38
 */
public class TimTrtcHouseUpdatePo {

    /**
     * 房间号
     */
    @Check(test = { "required", "maxLength" }, length = 9)
    @ApiModelProperty(value = "房间号", allowEmptyValue = false, allowableValues = "length:(,9]")
    private Integer houseNum;

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

}
