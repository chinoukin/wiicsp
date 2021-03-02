package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className OrdInvoListVo
 * @date 2019/4/24 16:09
 * @Description 订单发票列表Vo
 */
@ApiModel("订单发票列表Vo")
public class OrdInvoListVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty("订单id")
    private Long ordId;
    @ApiModelProperty("申请单号")
    private String applNum;
    @ApiModelProperty("买家账号")
    private String buyUserName;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("开票金额")
    private Double drawAmount;
    @ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("发票抬头")
    private String invoTitle;
    @ApiModelProperty(value = "申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("开票日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime drawDate;
    @ApiModelProperty("发票类别")
    private String invoCatgType;
    @ApiModelProperty(value = "发票状态")
    private String invoState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getApplNum() {
        return applNum;
    }

    public void setApplNum(String applNum) {
        this.applNum = applNum;
    }

    public String getBuyUserName() {
        return buyUserName;
    }

    public void setBuyUserName(String buyUserName) {
        this.buyUserName = buyUserName;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public OffsetDateTime getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(OffsetDateTime drawDate) {
        this.drawDate = drawDate;
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }
}
