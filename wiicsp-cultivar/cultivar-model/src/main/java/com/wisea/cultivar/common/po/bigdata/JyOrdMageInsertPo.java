package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * JyOrdMageInsertPo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageInsertPo {
    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分公司id", allowableValues = "length:(,19]")
    private Long subEntpId;

    /**
     * 供货商
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "供货商", allowableValues = "mixLength:(,255]")
    private String saleOrg;

    /**
     * 订单类型
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单类型", allowableValues = "mixLength:(,30]")
    private String ordType;

    /**
     * 订单编号
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单编号", allowableValues = "mixLength:(,255]")
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
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "采购商", allowableValues = "mixLength:(,255]")
    private String cgsName;

    /**
     * 部门
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "部门", allowableValues = "mixLength:(,255]")
    private String bm;

    /**
     * 业务员
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "业务员", allowableValues = "mixLength:(,30]")
    private String ywy;

    /**
     * 币种
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "币种", allowableValues = "mixLength:(,30]")
    private String bz;

    /**
     * 物料编码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "物料编码", allowableValues = "mixLength:(,30]")
    private String wlCode;

    /**
     * 物料名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物料名称", allowableValues = "mixLength:(,255]")
    private String wlName;

    /**
     * 规格
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "规格", allowableValues = "mixLength:(,30]")
    private String form;

    /**
     * 型号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "型号", allowableValues = "mixLength:(,30]")
    private String spec;

    /**
     * 主单位
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "主单位", allowableValues = "mixLength:(,30]")
    private String mainUnit;

    /**
     * 主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double mainCt;

    /**
     * 赠品
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "赠品", allowableValues = "mixLength:(,30]")
    private String zp;

    /**
     * 主含税净价
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "主含税净价", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zhsjj;

    /**
     * 无税金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "无税金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wsje;

    /**
     * 价税合计
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "价税合计", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
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
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "出库主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zckSl;

    /**
     * 签收主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "签收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double qszSl;

    /**
     * 途损主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "途损主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double tszSl;

    /**
     * 待出库主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "待出库主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double dckzSl;

    /**
     * 开票主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "开票主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double kpzSl;

    /**
     * 暂估应收主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "暂估应收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zgyszSl;

    /**
     * 暂估应收金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "暂估应收金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zgysJe;

    /**
     * 应收主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double yszSl;

    /**
     * 应收金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应收金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double ysJe;

    /**
     * 收款金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "收款金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double skJe;

    /**
     * 应收余额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应收余额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double ysYe;

    /**
     * 成本结算主数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "成本结算主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
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
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单批次编号", allowableValues = "mixLength:(,30]")
    private String ordPcNum;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

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
     * 获取供货商
     */
    public String getSaleOrg() {
        return saleOrg;
    }

    /**
     * 设置供货商
     */
    public void setSaleOrg(String saleOrg) {
        this.saleOrg = saleOrg == null ? null : saleOrg.trim();
    }

    /**
     * 获取订单类型
     */
    public String getOrdType() {
        return ordType;
    }

    /**
     * 设置订单类型
     */
    public void setOrdType(String ordType) {
        this.ordType = ordType == null ? null : ordType.trim();
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
     * 获取单据日期
     */
    public OffsetDateTime getDjDate() {
        return djDate;
    }

    /**
     * 设置单据日期
     */
    public void setDjDate(OffsetDateTime djDate) {
        this.djDate = djDate;
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
     * 获取部门
     */
    public String getBm() {
        return bm;
    }

    /**
     * 设置部门
     */
    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    /**
     * 获取业务员
     */
    public String getYwy() {
        return ywy;
    }

    /**
     * 设置业务员
     */
    public void setYwy(String ywy) {
        this.ywy = ywy == null ? null : ywy.trim();
    }

    /**
     * 获取币种
     */
    public String getBz() {
        return bz;
    }

    /**
     * 设置币种
     */
    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    /**
     * 获取物料编码
     */
    public String getWlCode() {
        return wlCode;
    }

    /**
     * 设置物料编码
     */
    public void setWlCode(String wlCode) {
        this.wlCode = wlCode == null ? null : wlCode.trim();
    }

    /**
     * 获取物料名称
     */
    public String getWlName() {
        return wlName;
    }

    /**
     * 设置物料名称
     */
    public void setWlName(String wlName) {
        this.wlName = wlName == null ? null : wlName.trim();
    }

    /**
     * 获取规格
     */
    public String getForm() {
        return form;
    }

    /**
     * 设置规格
     */
    public void setForm(String form) {
        this.form = form == null ? null : form.trim();
    }

    /**
     * 获取型号
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置型号
     */
    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    /**
     * 获取主单位
     */
    public String getMainUnit() {
        return mainUnit;
    }

    /**
     * 设置主单位
     */
    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit == null ? null : mainUnit.trim();
    }

    /**
     * 获取主数量
     */
    public Double getMainCt() {
        return mainCt;
    }

    /**
     * 设置主数量
     */
    public void setMainCt(Double mainCt) {
        this.mainCt = mainCt;
    }

    /**
     * 获取赠品
     */
    public String getZp() {
        return zp;
    }

    /**
     * 设置赠品
     */
    public void setZp(String zp) {
        this.zp = zp == null ? null : zp.trim();
    }

    /**
     * 获取主含税净价
     */
    public Double getZhsjj() {
        return zhsjj;
    }

    /**
     * 设置主含税净价
     */
    public void setZhsjj(Double zhsjj) {
        this.zhsjj = zhsjj;
    }

    /**
     * 获取无税金额
     */
    public Double getWsje() {
        return wsje;
    }

    /**
     * 设置无税金额
     */
    public void setWsje(Double wsje) {
        this.wsje = wsje;
    }

    /**
     * 获取价税合计
     */
    public Double getJshe() {
        return jshe;
    }

    /**
     * 设置价税合计
     */
    public void setJshe(Double jshe) {
        this.jshe = jshe;
    }

    /**
     * 获取计划发货日期
     */
    public OffsetDateTime getJhSendDate() {
        return jhSendDate;
    }

    /**
     * 设置计划发货日期
     */
    public void setJhSendDate(OffsetDateTime jhSendDate) {
        this.jhSendDate = jhSendDate;
    }

    /**
     * 获取出库主数量
     */
    public Double getZckSl() {
        return zckSl;
    }

    /**
     * 设置出库主数量
     */
    public void setZckSl(Double zckSl) {
        this.zckSl = zckSl;
    }

    /**
     * 获取签收主数量
     */
    public Double getQszSl() {
        return qszSl;
    }

    /**
     * 设置签收主数量
     */
    public void setQszSl(Double qszSl) {
        this.qszSl = qszSl;
    }

    /**
     * 获取途损主数量
     */
    public Double getTszSl() {
        return tszSl;
    }

    /**
     * 设置途损主数量
     */
    public void setTszSl(Double tszSl) {
        this.tszSl = tszSl;
    }

    /**
     * 获取待出库主数量
     */
    public Double getDckzSl() {
        return dckzSl;
    }

    /**
     * 设置待出库主数量
     */
    public void setDckzSl(Double dckzSl) {
        this.dckzSl = dckzSl;
    }

    /**
     * 获取开票主数量
     */
    public Double getKpzSl() {
        return kpzSl;
    }

    /**
     * 设置开票主数量
     */
    public void setKpzSl(Double kpzSl) {
        this.kpzSl = kpzSl;
    }

    /**
     * 获取暂估应收主数量
     */
    public Double getZgyszSl() {
        return zgyszSl;
    }

    /**
     * 设置暂估应收主数量
     */
    public void setZgyszSl(Double zgyszSl) {
        this.zgyszSl = zgyszSl;
    }

    /**
     * 获取暂估应收金额
     */
    public Double getZgysJe() {
        return zgysJe;
    }

    /**
     * 设置暂估应收金额
     */
    public void setZgysJe(Double zgysJe) {
        this.zgysJe = zgysJe;
    }

    /**
     * 获取应收主数量
     */
    public Double getYszSl() {
        return yszSl;
    }

    /**
     * 设置应收主数量
     */
    public void setYszSl(Double yszSl) {
        this.yszSl = yszSl;
    }

    /**
     * 获取应收金额
     */
    public Double getYsJe() {
        return ysJe;
    }

    /**
     * 设置应收金额
     */
    public void setYsJe(Double ysJe) {
        this.ysJe = ysJe;
    }

    /**
     * 获取收款金额
     */
    public Double getSkJe() {
        return skJe;
    }

    /**
     * 设置收款金额
     */
    public void setSkJe(Double skJe) {
        this.skJe = skJe;
    }

    /**
     * 获取应收余额
     */
    public Double getYsYe() {
        return ysYe;
    }

    /**
     * 设置应收余额
     */
    public void setYsYe(Double ysYe) {
        this.ysYe = ysYe;
    }

    /**
     * 获取成本结算主数量
     */
    public Double getCbjszSl() {
        return cbjszSl;
    }

    /**
     * 设置成本结算主数量
     */
    public void setCbjszSl(Double cbjszSl) {
        this.cbjszSl = cbjszSl;
    }

    /**
     * 获取导入时间
     */
    public OffsetDateTime getDrDate() {
        return drDate;
    }

    /**
     * 设置导入时间
     */
    public void setDrDate(OffsetDateTime drDate) {
        this.drDate = drDate;
    }

    /**
     * 获取订单批次编号
     */
    public String getOrdPcNum() {
        return ordPcNum;
    }

    /**
     * 设置订单批次编号
     */
    public void setOrdPcNum(String ordPcNum) {
        this.ordPcNum = ordPcNum == null ? null : ordPcNum.trim();
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
}
