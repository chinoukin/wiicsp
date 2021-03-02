package com.wisea.cultivar.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("推荐企业传入参数")
public class RecommendSellerPo {

    @ApiModelProperty("传入品类id 如果茶油,茶籽/茶果,茶油副产品")
    private Long commId;

    @ApiModelProperty(value = "楼层中 品类id 的集合")
    private List<Long> commFloorId;

    @ApiModelProperty(value = "楼层中 品种id 的集合")
    private List<Long> commVaritFloorId;

    public List<Long> getCommFloorId() {
        return commFloorId;
    }

    public void setCommFloorId(List<Long> commFloorId) {
        this.commFloorId = commFloorId;
    }

    public List<Long> getCommVaritFloorId() {
        return commVaritFloorId;
    }

    public void setCommVaritFloorId(List<Long> commVaritFloorId) {
        this.commVaritFloorId = commVaritFloorId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
