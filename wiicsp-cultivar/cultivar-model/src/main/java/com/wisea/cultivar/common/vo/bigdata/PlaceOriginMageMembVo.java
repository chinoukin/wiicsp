package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginMageGetVo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMageMembVo {

    @ApiModelProperty(value = "基地类型")
    private String statKey;

    @ApiModelProperty(value = "基地数量")
    private Integer statCount;

    public String getStatKey() {
        return statKey;
    }

    public void setStatKey(String statKey) {
        this.statKey = statKey;
    }

    public Integer getStatCount() {
        return statCount;
    }

    public void setStatCount(Integer statCount) {
        this.statCount = statCount;
    }


}
