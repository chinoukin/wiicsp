package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * JyOrdMageUpdatePo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageUpdatePo {
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    /*
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分公司id", allowableValues = "length:(,19]")
    private Long subEntpId;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "总分公司标志", allowableValues = "mixLength:(,1]")
    private String mainSubEntpFlag;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "供货商", allowableValues = "mixLength:(,255]")
    private String saleOrg;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单类型", allowableValues = "mixLength:(,30]")
    private String ordType;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单编号", allowableValues = "mixLength:(,255]")
    private String ordNum;
    @ApiModelProperty(value = "单据日期")
    private OffsetDateTime djDate;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "采购商", allowableValues = "mixLength:(,255]")
    private String cgsName;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "部门", allowableValues = "mixLength:(,255]")
    private String bm;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "业务员", allowableValues = "mixLength:(,30]")
    private String ywy;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "币种", allowableValues = "mixLength:(,30]")
    private String bz;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "物料编码", allowableValues = "mixLength:(,30]")
    private String wlCode;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物料名称", allowableValues = "mixLength:(,255]")
    private String wlName;
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "品类id", allowableValues = "length:(,19]")
    private Long categoryId;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物料分类", allowableValues = "mixLength:(,255]")
    private String categoryName;
    */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "规格", allowableValues = "mixLength:(,30]")
    private String form;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "型号", allowableValues = "mixLength:(,30]")
    private String spec;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "主单位", allowableValues = "mixLength:(,30]")
    private String mainUnit;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double mainCt;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "赠品", allowableValues = "mixLength:(,30]")
    private String zp;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "主含税净价", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zhsjj;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "无税金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wsje;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "价税合计", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jshe;
    @ApiModelProperty(value = "计划发货日期")
    private OffsetDateTime jhSendDate;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "出库主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zckSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "签收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double qszSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "途损主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double tszSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "待出库主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double dckzSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "开票主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double kpzSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "暂估应收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zgyszSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "暂估应收金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zgysJe;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "应收主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double yszSl;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "应收金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double ysJe;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "收款金额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double skJe;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "应收余额", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double ysYe;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$", nullSkip = true)
    @ApiModelProperty(value = "成本结算主数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double cbjszSl;
    /*
    @ApiModelProperty(value = "导入时间")
    private OffsetDateTime drDate;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单批次编号", allowableValues = "mixLength:(,30]")
    private String ordPcNum;
    */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /*
    public Long getSubEntpId() {
        return subEntpId;
    }

    public void setSubEntpId(Long subEntpId) {
        this.subEntpId = subEntpId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    */
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
    /*
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
    */
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
