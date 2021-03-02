package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseListVo
 * @date 2019/7/19 11:09
 * @Description 种植基地列表Vo
 */
@ApiModel("种植基地Vo")
public class BaseListVo {
    @ApiModelProperty("覆盖基地总数")
    private Integer baseCount;
    @ApiModelProperty("共占地面积")
    private Double massifAcreSum;
    @ApiModelProperty("供应品种总数")
    private Integer commVarietCount;
    @ApiModelProperty("基地信息列表")
    List<BaseVo> bases;

    public Integer getBaseCount() {
        return baseCount;
    }

    public void setBaseCount(Integer baseCount) {
        this.baseCount = baseCount;
    }

    public Double getMassifAcreSum() {
        return massifAcreSum;
    }

    public void setMassifAcreSum(Double massifAcreSum) {
        this.massifAcreSum = massifAcreSum;
    }

    public Integer getCommVarietCount() {
        return commVarietCount;
    }

    public void setCommVarietCount(Integer commVarietCount) {
        this.commVarietCount = commVarietCount;
    }

    public List<BaseVo> getBases() {
        return bases;
    }

    public void setBases(List<BaseVo> bases) {
        this.bases = bases;
    }
}
