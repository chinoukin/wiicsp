package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.time.OffsetDateTime;

/**
 * logistics_map_info 表实体
 * 物流地图信息
 * 2019/12/02 11:02:14
 */
public class LogisticsMapInfo extends DataLongEntity<LogisticsMapInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @ExcelField(title = "订单编号",sort = 1,width = 20)
    private String ordNum;

    /**
     * 订单商品
     */
    @ExcelField(title = "订单商品",sort = 10,width = 20)
    private String ordComm;

    /**
     * 采购商
     */
    @ExcelField(title = "采购商",sort = 20,width = 10)
    private String cgsName;

    /**
     * 下单时间
     */
    @ExcelField(title = "下单时间",sort = 30,formate = "yyyy-MM-dd HH:mm:ss",width = 20)
    private OffsetDateTime ordDate;

    /**
     * 发货时间
     */
    @ExcelField(title = "发货时间",sort = 40,formate = "yyyy-MM-dd HH:mm:ss",width = 20)
    private OffsetDateTime sendCommDate;

    /**
     * 起点
     */
    @ExcelField(title = "起点",sort = 50,width = 20)
    private String qd;

    /**
     * 起点坐标
     */
    @ExcelField(title = "起点坐标",sort = 60,width = 20)
    private String qdZb;

    /**
     * 终点
     */
    @ExcelField(title = "终点",sort = 70,width = 20)
    private String zd;

    /**
     * 终点坐标
     */
    @ExcelField(title = "终点坐标",sort = 80,width = 20)
    private String zdZb;

    /**
     * 当前节点
     */
    @ExcelField(title = "当前节点",sort = 90,width = 20)
    private String dqjd;

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
}
