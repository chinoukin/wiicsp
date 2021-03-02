package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/1 11:26 上午
 */
@ApiModel("基地详情页统计信息Vo")
public class BaseStatVo {

    @ApiModelProperty("工厂数量")
    private Integer sfCount;
    @ApiModelProperty("工厂总面积")
    private Double sfArea;
    @ApiModelProperty("仓库数量")
    private Integer siCount;
    @ApiModelProperty("仓库总面积")
    private Double siArea;
    @ApiModelProperty("种植园数量")
    private Integer piCount;
    @ApiModelProperty("种植园总面积")
    private Double piArea;

    @ApiModelProperty("优势单品数量")
    private Integer spiCount;
    @ApiModelProperty("仓储现货总量")
    private Double siTotal;
    @ApiModelProperty("果园产量")
    private Double piTotal;


    public Integer getSpiCount() {
        return spiCount;
    }

    public void setSpiCount(Integer spiCount) {
        this.spiCount = spiCount;
    }

    public Double getSiTotal() {
        return siTotal;
    }

    public void setSiTotal(Double siTotal) {
        this.siTotal = siTotal;
    }

    public Double getPiTotal() {
        return piTotal;
    }

    public void setPiTotal(Double piTotal) {
        this.piTotal = piTotal;
    }

    public Integer getSfCount() {
        return sfCount;
    }

    public void setSfCount(Integer sfCount) {
        this.sfCount = sfCount;
    }

    public Double getSfArea() {
        return sfArea;
    }

    public void setSfArea(Double sfArea) {
        this.sfArea = sfArea;
    }

    public Integer getSiCount() {
        return siCount;
    }

    public void setSiCount(Integer siCount) {
        this.siCount = siCount;
    }

    public Double getSiArea() {
        return siArea;
    }

    public void setSiArea(Double siArea) {
        this.siArea = siArea;
    }

    public Integer getPiCount() {
        return piCount;
    }

    public void setPiCount(Integer piCount) {
        this.piCount = piCount;
    }

    public Double getPiArea() {
        return piArea;
    }

    public void setPiArea(Double piArea) {
        this.piArea = piArea;
    }
}
