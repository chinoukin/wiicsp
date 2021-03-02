package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.product.SambFloorListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 中小零批楼层列表页面传入参数
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("中小零批楼层列表页面传入参数")
public class SambFloorPagePo extends PagePo<SambFloorListVo> {

    @ApiModelProperty("楼层名称")
    private String floorName;

    @ApiModelProperty("状态")
    private String enableFlag;

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }
}
