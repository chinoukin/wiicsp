package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * logistics_transfer_analysis 表实体
 * 物流中转分析
 * 2020/09/02 15:33:51
 */
public class LogisticsTransferAnalysis extends DataLongEntity<LogisticsTransferAnalysis> {
    private static final long serialVersionUID = 1L;

    /**
     * 物流中转分析类型
     */
    private String logisticsTransferAnalysisType;

    /**
     * 数量
     */
    private Double num;

    /**
     * 排序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public LogisticsTransferAnalysis() {
        super();
    }

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
}
