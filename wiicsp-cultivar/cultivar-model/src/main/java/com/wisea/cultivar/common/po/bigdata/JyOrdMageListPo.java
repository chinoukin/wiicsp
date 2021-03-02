package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * JyOrdMageListPo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "公司id")
    private Long entpId;

    /**
     * 总分公司标志
     */
    @ApiModelProperty(value = "总分公司标志")
    private String mainSubEntpFlag;

    /**
     * 供货商
     */
    @ApiModelProperty(value = "供货商")
    private String saleOrg;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    private String ordType;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 单据日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "单据日期")
    private OffsetDateTime djDate;

    /**
     * 采购商
     */
    @ApiModelProperty(value = "采购商")
    private String cgsName;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String bm;

    /**
     * 业务员
     */
    @ApiModelProperty(value = "业务员")
    private String ywy;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种")
    private String bz;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    private String wlCode;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String wlName;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private String form;

    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
    private String spec;

    /**
     * 主单位
     */
    @ApiModelProperty(value = "主单位")
    private String mainUnit;

    /**
     * 主数量
     */
    @ApiModelProperty(value = "主数量")
    private Double mainCt;

    /**
     * 赠品
     */
    @ApiModelProperty(value = "赠品")
    private String zp;

    /**
     * 主含税净价
     */
    @ApiModelProperty(value = "主含税净价")
    private Double zhsjj;

    /**
     * 无税金额
     */
    @ApiModelProperty(value = "无税金额")
    private Double wsje;

    /**
     * 价税合计
     */
    @ApiModelProperty(value = "价税合计")
    private Double jshe;

    /**
     * 计划发货日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "计划发货日期")
    private OffsetDateTime jhSendDate;

    /**
     * 出库主数量
     */
    @ApiModelProperty(value = "出库主数量")
    private Double zckSl;

    /**
     * 签收主数量
     */
    @ApiModelProperty(value = "签收主数量")
    private Double qszSl;

    /**
     * 途损主数量
     */
    @ApiModelProperty(value = "途损主数量")
    private Double tszSl;

    /**
     * 待出库主数量
     */
    @ApiModelProperty(value = "待出库主数量")
    private Double dckzSl;

    /**
     * 开票主数量
     */
    @ApiModelProperty(value = "开票主数量")
    private Double kpzSl;

    /**
     * 暂估应收主数量
     */
    @ApiModelProperty(value = "暂估应收主数量")
    private Double zgyszSl;

    /**
     * 暂估应收金额
     */
    @ApiModelProperty(value = "暂估应收金额")
    private Double zgysJe;

    /**
     * 应收主数量
     */
    @ApiModelProperty(value = "应收主数量")
    private Double yszSl;

    /**
     * 应收金额
     */
    @ApiModelProperty(value = "应收金额")
    private Double ysJe;

    /**
     * 收款金额
     */
    @ApiModelProperty(value = "收款金额")
    private Double skJe;

    /**
     * 应收余额
     */
    @ApiModelProperty(value = "应收余额")
    private Double ysYe;

    /**
     * 成本结算主数量
     */
    @ApiModelProperty(value = "成本结算主数量")
    private Double cbjszSl;

    /**
     * 导入时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "导入时间")
    private OffsetDateTime drDate;

    /**
     * 订单批次编号
     */
    @ApiModelProperty(value = "订单批次编号")
    private String ordPcNum;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntpId() {
        return entpId;
    }

    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    public String getMainSubEntpFlag() {
        return mainSubEntpFlag;
    }

    public void setMainSubEntpFlag(String mainSubEntpFlag) {
        this.mainSubEntpFlag = mainSubEntpFlag;
    }

    public String getSaleOrg() {
        return saleOrg;
    }

    public void setSaleOrg(String saleOrg) {
        this.saleOrg = saleOrg;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getDjDate() {
        return djDate;
    }

    public void setDjDate(OffsetDateTime djDate) {
        this.djDate = djDate;
    }

    public String getCgsName() {
        return cgsName;
    }

    public void setCgsName(String cgsName) {
        this.cgsName = cgsName;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getWlCode() {
        return wlCode;
    }

    public void setWlCode(String wlCode) {
        this.wlCode = wlCode;
    }

    public String getWlName() {
        return wlName;
    }

    public void setWlName(String wlName) {
        this.wlName = wlName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public Double getMainCt() {
        return mainCt;
    }

    public void setMainCt(Double mainCt) {
        this.mainCt = mainCt;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    public Double getZhsjj() {
        return zhsjj;
    }

    public void setZhsjj(Double zhsjj) {
        this.zhsjj = zhsjj;
    }

    public Double getWsje() {
        return wsje;
    }

    public void setWsje(Double wsje) {
        this.wsje = wsje;
    }

    public Double getJshe() {
        return jshe;
    }

    public void setJshe(Double jshe) {
        this.jshe = jshe;
    }

    public OffsetDateTime getJhSendDate() {
        return jhSendDate;
    }

    public void setJhSendDate(OffsetDateTime jhSendDate) {
        this.jhSendDate = jhSendDate;
    }

    public Double getZckSl() {
        return zckSl;
    }

    public void setZckSl(Double zckSl) {
        this.zckSl = zckSl;
    }

    public Double getQszSl() {
        return qszSl;
    }

    public void setQszSl(Double qszSl) {
        this.qszSl = qszSl;
    }

    public Double getTszSl() {
        return tszSl;
    }

    public void setTszSl(Double tszSl) {
        this.tszSl = tszSl;
    }

    public Double getDckzSl() {
        return dckzSl;
    }

    public void setDckzSl(Double dckzSl) {
        this.dckzSl = dckzSl;
    }

    public Double getKpzSl() {
        return kpzSl;
    }

    public void setKpzSl(Double kpzSl) {
        this.kpzSl = kpzSl;
    }

    public Double getZgyszSl() {
        return zgyszSl;
    }

    public void setZgyszSl(Double zgyszSl) {
        this.zgyszSl = zgyszSl;
    }

    public Double getZgysJe() {
        return zgysJe;
    }

    public void setZgysJe(Double zgysJe) {
        this.zgysJe = zgysJe;
    }

    public Double getYszSl() {
        return yszSl;
    }

    public void setYszSl(Double yszSl) {
        this.yszSl = yszSl;
    }

    public Double getYsJe() {
        return ysJe;
    }

    public void setYsJe(Double ysJe) {
        this.ysJe = ysJe;
    }

    public Double getSkJe() {
        return skJe;
    }

    public void setSkJe(Double skJe) {
        this.skJe = skJe;
    }

    public Double getYsYe() {
        return ysYe;
    }

    public void setYsYe(Double ysYe) {
        this.ysYe = ysYe;
    }

    public Double getCbjszSl() {
        return cbjszSl;
    }

    public void setCbjszSl(Double cbjszSl) {
        this.cbjszSl = cbjszSl;
    }

    public OffsetDateTime getDrDate() {
        return drDate;
    }

    public void setDrDate(OffsetDateTime drDate) {
        this.drDate = drDate;
    }

    public String getOrdPcNum() {
        return ordPcNum;
    }

    public void setOrdPcNum(String ordPcNum) {
        this.ordPcNum = ordPcNum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
