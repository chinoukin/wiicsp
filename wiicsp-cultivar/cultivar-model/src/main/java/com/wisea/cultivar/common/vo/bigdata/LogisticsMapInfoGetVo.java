package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * LogisticsMapInfoGetVo
 * 2019/12/02 11:02:14
 */
public class LogisticsMapInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 订单商品
     */
    @ApiModelProperty(value = "订单商品")
    private String ordComm;

    /**
     * 采购商
     */
    @ApiModelProperty(value = "采购商")
    private String cgsName;

    /**
     * 下单时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "下单时间")
    private OffsetDateTime ordDate;

    /**
     * 发货时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发货时间")
    private OffsetDateTime sendCommDate;

    /**
     * 起点
     */
    @ApiModelProperty(value = "起点")
    private String qd;

    /**
     * 起点坐标
     */
    @ApiModelProperty(value = "起点坐标")
    private String qdZb;

    /**
     * 终点
     */
    @ApiModelProperty(value = "终点")
    private String zd;

    /**
     * 终点坐标
     */
    @ApiModelProperty(value = "终点坐标")
    private String zdZb;

    /**
     * 当前节点
     */
    @ApiModelProperty(value = "当前节点")
    private String dqjd;

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
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取订单商品
     */
    public String getOrdComm() {
        return ordComm;
    }

    /**
     * 设置订单商品
     */
    public void setOrdComm(String ordComm) {
        this.ordComm = ordComm == null ? null : ordComm.trim();
    }

    /**
     * 获取采购商
     */
    public String getCgsName() {
        return cgsName;
    }

    /**
     * 设置采购商
     */
    public void setCgsName(String cgsName) {
        this.cgsName = cgsName == null ? null : cgsName.trim();
    }

    /**
     * 获取下单时间
     */
    public OffsetDateTime getOrdDate() {
        return ordDate;
    }

    /**
     * 设置下单时间
     */
    public void setOrdDate(OffsetDateTime ordDate) {
        this.ordDate = ordDate;
    }

    /**
     * 获取发货时间
     */
    public OffsetDateTime getSendCommDate() {
        return sendCommDate;
    }

    /**
     * 设置发货时间
     */
    public void setSendCommDate(OffsetDateTime sendCommDate) {
        this.sendCommDate = sendCommDate;
    }

    /**
     * 获取起点
     */
    public String getQd() {
        return qd;
    }

    /**
     * 设置起点
     */
    public void setQd(String qd) {
        this.qd = qd == null ? null : qd.trim();
    }

    /**
     * 获取起点坐标
     */
    public String getQdZb() {
        return qdZb;
    }

    /**
     * 设置起点坐标
     */
    public void setQdZb(String qdZb) {
        this.qdZb = qdZb == null ? null : qdZb.trim();
    }

    /**
     * 获取终点
     */
    public String getZd() {
        return zd;
    }

    /**
     * 设置终点
     */
    public void setZd(String zd) {
        this.zd = zd == null ? null : zd.trim();
    }

    /**
     * 获取终点坐标
     */
    public String getZdZb() {
        return zdZb;
    }

    /**
     * 设置终点坐标
     */
    public void setZdZb(String zdZb) {
        this.zdZb = zdZb == null ? null : zdZb.trim();
    }

    /**
     * 获取当前节点
     */
    public String getDqjd() {
        return dqjd;
    }

    /**
     * 设置当前节点
     */
    public void setDqjd(String dqjd) {
        this.dqjd = dqjd == null ? null : dqjd.trim();
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
