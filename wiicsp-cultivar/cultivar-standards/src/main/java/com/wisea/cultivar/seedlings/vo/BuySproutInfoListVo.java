package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * BuySproutInfoListVo
 * 2020/08/06 14:19:24
 */
public class BuySproutInfoListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 补贴申请管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "补贴申请管理id")
    private Long subsidyApplMageId;

    /**
     * 服务单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "服务单id")
    private Long serListId;

    @ApiModelProperty(value = "服务单编号")
    private String serListNo;

    @ApiModelProperty(value = "定点种苗企业/种苗服务商")
    private String entpName;

    @ApiModelProperty(value = "种植户")
    private String plantName;

    @ApiModelProperty(value = "种苗名称")
    private String commTitle;

    @ApiModelProperty(value = "数量（株）")
    private Integer num;

    @ApiModelProperty(value = "金额")
    private Double totalPrice;

    @ApiModelProperty(value = "总计")
    private Double total;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "成立日期")
    private OffsetDateTime createDate;

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

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
     * 获取补贴申请管理id
     */
    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    /**
     * 设置补贴申请管理id
     */
    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    /**
     * 获取服务单id
     */
    public Long getSerListId() {
        return serListId;
    }

    /**
     * 设置服务单id
     */
    public void setSerListId(Long serListId) {
        this.serListId = serListId;
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
