package com.wisea.transac.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 返回当前服务器时间
 * @author: wangs
 * @date :2020/6/1
 */
@ApiModel("返回当前服务器时间")
public class CommodityCurrentVo {

    @ApiModelProperty("当前服务器时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime currentServerTime;

    public OffsetDateTime getCurrentServerTime() {
        return currentServerTime;
    }

    public void setCurrentServerTime(OffsetDateTime currentServerTime) {
        this.currentServerTime = currentServerTime;
    }
}
