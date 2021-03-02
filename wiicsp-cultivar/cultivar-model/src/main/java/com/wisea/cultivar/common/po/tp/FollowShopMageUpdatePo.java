package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FollowShopMageUpdatePo
 * 2019/12/24 11:10:18
 */
public class FollowShopMageUpdatePo {

    /**
     * 店铺id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "店铺id")
    private Long shopInfoMageId;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;

    @ApiModelProperty(value = "取消、关注店铺  0：关注，1取消")
    @Check(test = "required")
    private String gzFlag;

    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getGzFlag() {
        return gzFlag;
    }

    public void setGzFlag(String gzFlag) {
        this.gzFlag = gzFlag;
    }
}
