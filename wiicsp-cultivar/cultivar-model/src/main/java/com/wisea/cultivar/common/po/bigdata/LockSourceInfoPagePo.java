package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.LockSourceInfoListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * LockSourceInfoPagePo
 * 2019/12/02 11:02:14
 */
public class LockSourceInfoPagePo extends PagePo<LockSourceInfoListVo> {
    @ApiModelProperty(value = "货源类型")
    private String sourceType;
    @ApiModelProperty(value = "品类名称")
    private String varitName;

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
}
