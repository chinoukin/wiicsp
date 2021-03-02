package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.FollowShopMageListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModelProperty;

/**
 * FollowShopMageListPo
 * 2019/12/24 11:10:18
 */
public class FollowShopMageListPo extends PagePo<FollowShopMageListVo>{

    @ApiModelProperty(value = "搜索条件")
    private String seachkey;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id", hidden = true)
    private Long shopInfoMageId;

    public String getSeachkey() {
        return seachkey;
    }

    public void setSeachkey(String seachkey) {
        this.seachkey = seachkey;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
    }
}
