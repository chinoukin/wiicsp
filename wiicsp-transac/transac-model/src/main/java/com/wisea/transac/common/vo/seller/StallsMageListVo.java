package com.wisea.transac.common.vo.seller;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className StallsMageListVo
 * @date 2020/5/7 17:04
 * @Description 档口信息Vo
 */
@ApiModel("档口信息Vo")
public class StallsMageListVo extends LongIdPo {
    @ApiModelProperty("档口名称")
    private String stallsName;
    @ApiModelProperty("店铺id")
    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getStallsName() {
        return stallsName;
    }

    public void setStallsName(String stallsName) {
        this.stallsName = stallsName;
    }
}
