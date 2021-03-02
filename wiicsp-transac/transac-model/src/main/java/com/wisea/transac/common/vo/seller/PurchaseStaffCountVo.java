package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/5/14 10:24 上午
 */
@ApiModel("采购员人数统计VO")
public class PurchaseStaffCountVo {

    @ApiModelProperty("总人数")
    private Long totalCount;
    @ApiModelProperty("正常人数")
    private Long normalCount;
    @ApiModelProperty("禁用人数")
    private Long disableCount;

    public Long getDisableCount() {
        return disableCount;
    }

    public void setDisableCount(Long disableCount) {
        this.disableCount = disableCount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getNormalCount() {
        return normalCount;
    }

    public void setNormalCount(Long normalCount) {
        this.normalCount = normalCount;
    }
}
