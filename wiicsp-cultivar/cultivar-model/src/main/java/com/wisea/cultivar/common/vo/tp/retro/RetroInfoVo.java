package com.wisea.cultivar.common.vo.tp.retro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className RetroInfoVo
 * @date 2019/12/21 10:35
 * @Description 查询追溯标签详细信息
 */
@ApiModel("查询追溯标签详细信息")
public class RetroInfoVo {
    @ApiModelProperty("追溯码")
    private String retroCode;
    @ApiModelProperty("批次号")
    private String retrospPcNum;
    @ApiModelProperty("追溯码已查询次数")
    private Integer queryCount;
    @ApiModelProperty("第一次查询时间")
    private OffsetDateTime firstQueryDate;
    @ApiModelProperty("第一次查询位置")
    private String firstQueryAddress;
    @ApiModelProperty("批次模板信息")
    private String currencyRetrospTemplate;
    @ApiModelProperty("产品名称")
    private String prdutName;

    public String getRetroCode() {
        return retroCode;
    }

    public void setRetroCode(String retroCode) {
        this.retroCode = retroCode;
    }

    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum;
    }

    public Integer getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    public OffsetDateTime getFirstQueryDate() {
        return firstQueryDate;
    }

    public void setFirstQueryDate(OffsetDateTime firstQueryDate) {
        this.firstQueryDate = firstQueryDate;
    }

    public String getFirstQueryAddress() {
        return firstQueryAddress;
    }

    public void setFirstQueryAddress(String firstQueryAddress) {
        this.firstQueryAddress = firstQueryAddress;
    }

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }
}
