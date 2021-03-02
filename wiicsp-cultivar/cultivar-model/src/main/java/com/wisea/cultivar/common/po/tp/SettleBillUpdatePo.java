package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * SettleBillUpdatePo
 * 2018/10/12 11:07:31
 */
public class SettleBillUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商家id")
    private Long entpId;

    /**
     * 结算单号
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "结算单号")
    private String settleBillNumb;

    /**
     * 结算周期
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "结算周期")
    private String settleCycle;

    /**
     * 商家名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "商家名称")
    private String entpName;

    /**
     * 本期商家收入
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "本期商家收入")
    private Double entpIncome;

    /**
     * 本期平台垫付
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "本期平台垫付")
    private Double platfAdvan;

    /**
     * 应结总额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应结总额")
    private Double totalMoney;

    /**
     * 最晚付款日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "最晚付款日期")
    private OffsetDateTime lastPayDate;

    /**
     * 结算单状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "结算单状态")
    private String settleBillStatueType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记")
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
     * 获取商家id
     */
    public Long getEntpId() {
        return entpId;
    }

    /**
     * 设置商家id
     */
    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    /**
     * 获取结算单号
     */
    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    /**
     * 设置结算单号
     */
    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb == null ? null : settleBillNumb.trim();
    }

    /**
     * 获取结算周期
     */
    public String getSettleCycle() {
        return settleCycle;
    }

    /**
     * 设置结算周期
     */
    public void setSettleCycle(String settleCycle) {
        this.settleCycle = settleCycle == null ? null : settleCycle.trim();
    }

    /**
     * 获取商家名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置商家名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取本期商家收入
     */
    public Double getEntpIncome() {
        return entpIncome;
    }

    /**
     * 设置本期商家收入
     */
    public void setEntpIncome(Double entpIncome) {
        this.entpIncome = entpIncome;
    }

    /**
     * 获取本期平台垫付
     */
    public Double getPlatfAdvan() {
        return platfAdvan;
    }

    /**
     * 设置本期平台垫付
     */
    public void setPlatfAdvan(Double platfAdvan) {
        this.platfAdvan = platfAdvan;
    }

    /**
     * 获取应结总额
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * 设置应结总额
     */
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 获取最晚付款日期
     */
    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    /**
     * 设置最晚付款日期
     */
    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    /**
     * 获取结算单状态
     */
    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    /**
     * 设置结算单状态
     */
    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType == null ? null : settleBillStatueType.trim();
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
