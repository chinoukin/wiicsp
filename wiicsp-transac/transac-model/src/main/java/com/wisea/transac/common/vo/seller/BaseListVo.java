package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/2 3:04 下午
 */
@ApiModel("国内基地省份列表")
public class BaseListVo {

    @ApiModelProperty("省code")
    private String areaProv;
    @ApiModelProperty("省名称")
    private String areaProvName;
    @ApiModelProperty("基地数量")
    private Integer count;

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
