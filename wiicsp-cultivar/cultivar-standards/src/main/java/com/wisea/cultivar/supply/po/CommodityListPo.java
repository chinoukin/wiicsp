package com.wisea.cultivar.supply.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.supply.vo.ShopCommodityVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品列表
 * @author chengq
 * @date 2020/8/12 17:53
 */
public class CommodityListPo extends PagePo<ShopCommodityVo> {

    /**
     * 商品状态
     */
    @ApiModelProperty(value = "商品状态 0-销售中 1-草稿 2-待审核 3-已下架 4-被驳回 不传-全部")
    private String stateType;

    @ApiModelProperty("商品名称/编号")
    private String codeName;

    /**
     * 服务商id
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public Long membId;

    public CommodityListPo() {
    }

    public CommodityListPo(String stateType) {
        this.stateType = stateType;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
