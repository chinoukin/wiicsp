package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/12/2 4:48 下午
 */
@ApiModel("物流管理基础页详情修改PO")
public class LogisticsBasePo implements Serializable {

    @ApiModelProperty("物流总件数")
    private Integer logisticsCount;

    @ApiModelProperty("预警总数")
    private Integer warningCount;

    @ApiModelProperty("车辆检测总数")
    private Integer carCount;

    @ApiModelProperty("各交通调用集合")
    @Check(test = "required",cascade = true)
    private List<JtgjdyfxListVo> trafficInvokeList;

    @ApiModelProperty("各物流对比集合")
    @Check(test = "required",cascade = true)
    private List<GwldbtListVo> logisticsContrastList;

    @ApiModelProperty("订单处理")
    @Check(test = "required")
    private ClOrdInfoListVo clOrdInfo;

    @ApiModelProperty("全国物流配送地址面积分布数据总数")
    private Integer nationalDistrCount;

    @ApiModelProperty("月配送单量趋势")
    @Check(test = "required",cascade = true)
    private List<MonthlyDistrTrendListVo> monthlyDistrTrendList;

    @ApiModelProperty("物流中转分析")
    @Check(test = "required",cascade = true)
    private List<LogisticsTransferAnalysisListVo> logisticsTransferAnalysisList;

    @ApiModelProperty("物流基础数据")
    @Check(test = "required",cascade = true)
    private List<LogisticsBasicDataListVo> logisticsBasicDataList;

    public List<LogisticsBasicDataListVo> getLogisticsBasicDataList() {
        return logisticsBasicDataList;
    }

    public void setLogisticsBasicDataList(List<LogisticsBasicDataListVo> logisticsBasicDataList) {
        this.logisticsBasicDataList = logisticsBasicDataList;
    }

    public List<MonthlyDistrTrendListVo> getMonthlyDistrTrendList() {
        return monthlyDistrTrendList;
    }

    public void setMonthlyDistrTrendList(List<MonthlyDistrTrendListVo> monthlyDistrTrendList) {
        this.monthlyDistrTrendList = monthlyDistrTrendList;
    }

    public List<LogisticsTransferAnalysisListVo> getLogisticsTransferAnalysisList() {
        return logisticsTransferAnalysisList;
    }

    public void setLogisticsTransferAnalysisList(List<LogisticsTransferAnalysisListVo> logisticsTransferAnalysisList) {
        this.logisticsTransferAnalysisList = logisticsTransferAnalysisList;
    }

    public Integer getNationalDistrCount() {
        return nationalDistrCount;
    }

    public void setNationalDistrCount(Integer nationalDistrCount) {
        this.nationalDistrCount = nationalDistrCount;
    }

    public Integer getLogisticsCount() {
        return logisticsCount;
    }

    public void setLogisticsCount(Integer logisticsCount) {
        this.logisticsCount = logisticsCount;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public List<JtgjdyfxListVo> getTrafficInvokeList() {
        return trafficInvokeList;
    }

    public void setTrafficInvokeList(List<JtgjdyfxListVo> trafficInvokeList) {
        this.trafficInvokeList = trafficInvokeList;
    }

    public List<GwldbtListVo> getLogisticsContrastList() {
        return logisticsContrastList;
    }

    public void setLogisticsContrastList(List<GwldbtListVo> logisticsContrastList) {
        this.logisticsContrastList = logisticsContrastList;
    }

    public ClOrdInfoListVo getClOrdInfo() {
        return clOrdInfo;
    }

    public void setClOrdInfo(ClOrdInfoListVo clOrdInfo) {
        this.clOrdInfo = clOrdInfo;
    }
}
