package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/10/14 10:02 上午
 */
@ApiModel("检查结果统计")
public class SampJcCount {


    /**
     * gross : 0
     * passCount : 0
     * passPercent : 0
     * sampAreaCode :
     * sampTown :
     */
    @ApiModelProperty("采样总数")
    private Integer gross;
    @ApiModelProperty("合格数")
    private Integer passCount;
    @ApiModelProperty("合格率")
    private Double passPercent;
    @ApiModelProperty("样品地区编码")
    private String sampAreaCode;
    @ApiModelProperty("镇名称")
    private String sampTown;
    @ApiModelProperty("产品名称")
    private String productName = "香蕉";

    public SampJcCount() {
    }

    public SampJcCount(Integer gross, Integer passCount, Double passPercent, String sampAreaCode, String sampTown, String productName) {
        this.gross = gross;
        this.passCount = passCount;
        this.passPercent = passPercent;
        this.sampAreaCode = sampAreaCode;
        this.sampTown = sampTown;
        this.productName = productName;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public Double getPassPercent() {
        return passPercent;
    }

    public void setPassPercent(Double passPercent) {
        this.passPercent = passPercent;
    }

    public String getSampAreaCode() {
        return sampAreaCode;
    }

    public void setSampAreaCode(String sampAreaCode) {
        this.sampAreaCode = sampAreaCode;
    }

    public String getSampTown() {
        return sampTown;
    }

    public void setSampTown(String sampTown) {
        this.sampTown = sampTown;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
