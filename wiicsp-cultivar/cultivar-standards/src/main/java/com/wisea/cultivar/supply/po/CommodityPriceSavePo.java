package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 保存价格
 * @author chengq
 * @date 2020/8/12 17:53
 */
public class CommodityPriceSavePo {

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", required = true)
    @NotNull(message = "商品id不能为空")
    private Long id;

    @ApiModelProperty(value = "商品价格", required = true)
    @NotNull(message = "请填写商品价格")
    @Size(min = 1, max = 3, message = "价格至少一个最多三个")
    private List<Double> prides;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Double> getPrides() {
        return prides;
    }

    public void setPrides(List<Double> prides) {
        this.prides = prides;
    }
}
