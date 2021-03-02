package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SubEntpMbInfoMageUpdatePo
 * 2019/12/02 11:02:15
 */
public class SubEntpMbInfoMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分公司id", allowableValues = "length:(,19]")
    private Long subEntpId;

    /**
     * 年份
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "年份", allowableValues = "mixLength:(,10]")
    private String yearType;

    /**
     * 年目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "年目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double nMbsj;

    /**
     * 一月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "一月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double oneMbsj;

    /**
     * 二月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "二月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double twoMbsj;

    /**
     * 三月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "三月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double threeMbsj;

    /**
     * 四月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "四月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double fourMbsj;

    /**
     * 五月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "五月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double fiveMbsj;

    /**
     * 六月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "六月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double sixMbsj;

    /**
     * 七月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "七月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double sevenMbsj;

    /**
     * 八月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "八月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double eightMbsj;

    /**
     * 九月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "九月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double nineMbsj;

    /**
     * 十月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "十月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double tenMbsj;

    /**
     * 十一月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "十一月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double elevenMbsj;

    /**
     * 十二月目标数据
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "十二月目标数据", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double twelveMbsj;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分公司id
     */
    public Long getSubEntpId() {
        return subEntpId;
    }

    /**
     * 设置分公司id
     */
    public void setSubEntpId(Long subEntpId) {
        this.subEntpId = subEntpId;
    }

    /**
     * 获取年份
     */
    public String getYearType() {
        return yearType;
    }

    /**
     * 设置年份
     */
    public void setYearType(String yearType) {
        this.yearType = yearType == null ? null : yearType.trim();
    }

    /**
     * 获取年目标数据
     */
    public Double getnMbsj() {
        return nMbsj;
    }

    /**
     * 设置年目标数据
     */
    public void setnMbsj(Double nMbsj) {
        this.nMbsj = nMbsj;
    }

    /**
     * 获取一月目标数据
     */
    public Double getOneMbsj() {
        return oneMbsj;
    }

    /**
     * 设置一月目标数据
     */
    public void setOneMbsj(Double oneMbsj) {
        this.oneMbsj = oneMbsj;
    }

    /**
     * 获取二月目标数据
     */
    public Double getTwoMbsj() {
        return twoMbsj;
    }

    /**
     * 设置二月目标数据
     */
    public void setTwoMbsj(Double twoMbsj) {
        this.twoMbsj = twoMbsj;
    }

    /**
     * 获取三月目标数据
     */
    public Double getThreeMbsj() {
        return threeMbsj;
    }

    /**
     * 设置三月目标数据
     */
    public void setThreeMbsj(Double threeMbsj) {
        this.threeMbsj = threeMbsj;
    }

    /**
     * 获取四月目标数据
     */
    public Double getFourMbsj() {
        return fourMbsj;
    }

    /**
     * 设置四月目标数据
     */
    public void setFourMbsj(Double fourMbsj) {
        this.fourMbsj = fourMbsj;
    }

    /**
     * 获取五月目标数据
     */
    public Double getFiveMbsj() {
        return fiveMbsj;
    }

    /**
     * 设置五月目标数据
     */
    public void setFiveMbsj(Double fiveMbsj) {
        this.fiveMbsj = fiveMbsj;
    }

    /**
     * 获取六月目标数据
     */
    public Double getSixMbsj() {
        return sixMbsj;
    }

    /**
     * 设置六月目标数据
     */
    public void setSixMbsj(Double sixMbsj) {
        this.sixMbsj = sixMbsj;
    }

    /**
     * 获取七月目标数据
     */
    public Double getSevenMbsj() {
        return sevenMbsj;
    }

    /**
     * 设置七月目标数据
     */
    public void setSevenMbsj(Double sevenMbsj) {
        this.sevenMbsj = sevenMbsj;
    }

    /**
     * 获取八月目标数据
     */
    public Double getEightMbsj() {
        return eightMbsj;
    }

    /**
     * 设置八月目标数据
     */
    public void setEightMbsj(Double eightMbsj) {
        this.eightMbsj = eightMbsj;
    }

    /**
     * 获取九月目标数据
     */
    public Double getNineMbsj() {
        return nineMbsj;
    }

    /**
     * 设置九月目标数据
     */
    public void setNineMbsj(Double nineMbsj) {
        this.nineMbsj = nineMbsj;
    }

    /**
     * 获取十月目标数据
     */
    public Double getTenMbsj() {
        return tenMbsj;
    }

    /**
     * 设置十月目标数据
     */
    public void setTenMbsj(Double tenMbsj) {
        this.tenMbsj = tenMbsj;
    }

    /**
     * 获取十一月目标数据
     */
    public Double getElevenMbsj() {
        return elevenMbsj;
    }

    /**
     * 设置十一月目标数据
     */
    public void setElevenMbsj(Double elevenMbsj) {
        this.elevenMbsj = elevenMbsj;
    }

    /**
     * 获取十二月目标数据
     */
    public Double getTwelveMbsj() {
        return twelveMbsj;
    }

    /**
     * 设置十二月目标数据
     */
    public void setTwelveMbsj(Double twelveMbsj) {
        this.twelveMbsj = twelveMbsj;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
