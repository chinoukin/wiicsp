package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className JydzReloadAccumulatePo
 * @date 2019/12/2 15:33
 * @Description
 */
public class JydzReloadAccumulatePo {
    @ApiModelProperty("数据ID")
    @Check(test = {"required"})
    private Long id;
    @ApiModelProperty("产地类型")
    @Check(test = {"required"})
    private String placeOriginType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceOriginType() {
        return placeOriginType;
    }

    public void setPlaceOriginType(String placeOriginType) {
        this.placeOriginType = placeOriginType;
    }
}
