package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className StatisticByBatchVo
 * @date 2019/3/25 10:28
 * @Description 牦牛按批次统计Vo
 */
@ApiModel("牦牛按批次统计Vo")
public class StatisticByBatchVo {
    @ApiModelProperty("批次ID")
    private Long batchId;
    @ApiModelProperty("批次名称")
    private String batchName;
    @ApiModelProperty("牦牛总数量")
    private Integer yakCount;
    @ApiModelProperty("在栏数量")
    private Integer zlCount;
    @ApiModelProperty("销售数量")
    private Integer xsCount;
    @ApiModelProperty("病死数量")
    private Integer dieCount;
    @ApiModelProperty("小于五岁的牦牛数量")
    private Integer beforeFiveAgeCount;
    @ApiModelProperty("五岁以上的牦牛数量")
    private Integer afterFiveAgeCount;
    @ApiModelProperty("公牛数量")
    private Integer bullCount;
    @ApiModelProperty("母牛数量")
    private Integer cowCount;
    @ApiModelProperty("养殖日志数量")
    private Integer breedLogNum;

    public Integer getBreedLogNum() {
        return breedLogNum;
    }

    public void setBreedLogNum(Integer breedLogNum) {
        this.breedLogNum = breedLogNum;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Integer getYakCount() {
        return yakCount;
    }

    public void setYakCount(Integer yakCount) {
        this.yakCount = yakCount;
    }

    public Integer getZlCount() {
        return zlCount;
    }

    public void setZlCount(Integer zlCount) {
        this.zlCount = zlCount;
    }

    public Integer getXsCount() {
        return xsCount;
    }

    public void setXsCount(Integer xsCount) {
        this.xsCount = xsCount;
    }

    public Integer getDieCount() {
        return dieCount;
    }

    public void setDieCount(Integer dieCount) {
        this.dieCount = dieCount;
    }

    public Integer getBeforeFiveAgeCount() {
        return beforeFiveAgeCount;
    }

    public void setBeforeFiveAgeCount(Integer beforeFiveAgeCount) {
        this.beforeFiveAgeCount = beforeFiveAgeCount;
    }

    public Integer getAfterFiveAgeCount() {
        return afterFiveAgeCount;
    }

    public void setAfterFiveAgeCount(Integer afterFiveAgeCount) {
        this.afterFiveAgeCount = afterFiveAgeCount;
    }

    public Integer getBullCount() {
        return bullCount;
    }

    public void setBullCount(Integer bullCount) {
        this.bullCount = bullCount;
    }

    public Integer getCowCount() {
        return cowCount;
    }

    public void setCowCount(Integer cowCount) {
        this.cowCount = cowCount;
    }
}
