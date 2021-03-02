package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersTransactionRankingVo
 * @date 2019/12/6 10:38
 * @Description 总部国内/国外单品交易排行Vo
 */
@ApiModel(value = "总部国内/国外单品交易排行Vo")
public class HeadquartersTransactionRankingVo {
    @ApiModelProperty("品类id")
    private Long categoryId;
    @ApiModelProperty(value = "品类名称")
    private String categoryName;
    @ApiModelProperty(value = "销售金额")
    private Double salesAmount;
    @ApiModelProperty(value = "销售数量")
    private Double salesCount;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Double getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Double salesCount) {
        this.salesCount = salesCount;
    }
}
