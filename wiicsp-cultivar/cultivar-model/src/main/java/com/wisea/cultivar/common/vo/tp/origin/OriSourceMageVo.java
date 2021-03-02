package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakSourceMageVo
 * @date 2019/3/26 10:46
 * @Description 牛源牧场详细信息VO
 */
@ApiModel("牛源牧场详细信息VO")
public class OriSourceMageVo extends OriSourceMagePageVo {
    @ApiModelProperty("联系地区省名称")
    private String areaProvName;
    @ApiModelProperty("联系地区市名称")
    private String areaCityName;
    @ApiModelProperty("联系地区区县名称")
    private String areaCouName;
    @ApiModelProperty("简介")
    private String content;

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
