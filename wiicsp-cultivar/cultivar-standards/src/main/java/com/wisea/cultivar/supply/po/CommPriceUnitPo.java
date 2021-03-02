package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 商品价格
 * @author chengq
 * @date 2020/8/13 15:25
 */
public class CommPriceUnitPo {

    /**
     * 计量单位
     */
    @ApiModelProperty("计量单位id")
    @NotNull(message = "请选择计量单位")
    private Long unitId;

    @NotNull(message = "请填写商品价格")
    @Size(min = 1, max = 3, message = "价格至少一个最多三个")
    private List<CommPricePo> prices;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public List<CommPricePo> getPrices() {
        return prices;
    }

    public void setPrices(List<CommPricePo> prices) {
        this.prices = prices;
    }

    public CommPriceUnitPo() {
    }

    public CommPriceUnitPo(Long unitId, List<CommPricePo> prices) {
        this.unitId = unitId;
        this.prices = prices;
    }
}
