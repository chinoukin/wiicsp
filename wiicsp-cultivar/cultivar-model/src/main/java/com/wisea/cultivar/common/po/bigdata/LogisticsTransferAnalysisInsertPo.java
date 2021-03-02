package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * LogisticsTransferAnalysisInsertPo
 * 2020/09/02 15:33:51
 */
public class LogisticsTransferAnalysisInsertPo {
    /**
     * 物流中转分析类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "物流中转分析类型", allowableValues = "mixLength:(,5]")
    private String logisticsTransferAnalysisType;

    /**
     * 数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double num;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取物流中转分析类型
     */
    public String getLogisticsTransferAnalysisType() {
        return logisticsTransferAnalysisType;
    }

    /**
     * 设置物流中转分析类型
     */
    public void setLogisticsTransferAnalysisType(String logisticsTransferAnalysisType) {
        this.logisticsTransferAnalysisType = logisticsTransferAnalysisType == null ? null : logisticsTransferAnalysisType.trim();
    }

    /**
     * 获取数量
     */
    public Double getNum() {
        return num;
    }

    /**
     * 设置数量
     */
    public void setNum(Double num) {
        this.num = num;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
