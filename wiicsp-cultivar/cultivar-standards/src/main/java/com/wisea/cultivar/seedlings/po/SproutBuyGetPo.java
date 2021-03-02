package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SproutCatalogMageGetPo
 * 2020/08/06 14:19:24
 */
public class SproutBuyGetPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="品种id")
    private Long varietiesId;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="种植户id")
    private Long buyId;

    public Long getVarietiesId() {
        return varietiesId;
    }

    public void setVarietiesId(Long varietiesId) {
        this.varietiesId = varietiesId;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }
}
