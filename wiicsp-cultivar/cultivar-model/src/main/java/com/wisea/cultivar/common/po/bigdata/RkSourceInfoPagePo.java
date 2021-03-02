package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.RkSourceInfoListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * RkSourceInfoPagePo
 * 2019/12/02 11:02:15
 */
public class RkSourceInfoPagePo extends PagePo<RkSourceInfoListVo> {
    @ApiModelProperty(value = "货源类型")
    private String sourceType;
    @ApiModelProperty(value = "品类名称")
    private String varitName;
    @ApiModelProperty(value = "子公司名称")
    private String subEntpName;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getSubEntpName() {
        return subEntpName;
    }

    public void setSubEntpName(String subEntpName) {
        this.subEntpName = subEntpName;
    }
}
