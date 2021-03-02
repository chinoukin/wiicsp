package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * JyOrdMageListVo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageListVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "公司id")
    private Long entpId;
    @ApiModelProperty(value = "总分公司标志")
    private String mainSubEntpFlag;
    @ApiModelProperty(value = "供货商")
    @ExcelField(title = "供货商", sort = 1, fieldType = String.class)
    private String saleOrg;
    @ApiModelProperty(value = "订单类型")
    private String ordType;
    @ApiModelProperty(value = "订单编号")
    @ExcelField(title = "订单编号", sort = 2, fieldType = String.class)
    private String ordNum;
    @ApiModelProperty(value = "下单日期")
    @ExcelField(title = "下单日期", sort = 3, fieldType = OffsetDateTime.class)
    private OffsetDateTime djDate;
    @ApiModelProperty(value = "采购商")
    @ExcelField(title = "采购商", sort = 4, fieldType = String.class)
    private String cgsName;
    @ApiModelProperty(value = "部门")
    private String bm;
    @ApiModelProperty(value = "业务员")
    private String ywy;
    @ApiModelProperty(value = "币种")
    private String bz;
    @ApiModelProperty(value = "物料编码")
    @ExcelField(title = "物料编码", sort = 5, fieldType = String.class)
    private String wlCode;
    @ApiModelProperty(value = "物料名称")
    private String wlName;
    @ApiModelProperty("品类id")
    private Long categoryId;
    @ApiModelProperty(value = "物料分类")
    @ExcelField(title = "物料分类", sort = 6, fieldType = String.class)
    private String categoryName;
    @ApiModelProperty(value = "规格")
    @ExcelField(title = "规格", sort = 7, fieldType = String.class)
    private String form;
    @ApiModelProperty(value = "型号")
    @ExcelField(title = "型号", sort = 8, fieldType = String.class)
    private String spec;
    @ApiModelProperty(value = "主单位")
    @ExcelField(title = "主单位", sort = 9, fieldType = String.class)
    private String mainUnit;
    @ApiModelProperty(value = "主数量")
    @ExcelField(title = "主数量", sort = 10, fieldType = Double.class)
    private Double mainCt;
    @ApiModelProperty(value = "赠品")
    private String zp;
    @ApiModelProperty(value = "主含税净价")
    private Double zhsjj;
    @ApiModelProperty(value = "无税金额")
    private Double wsje;
    @ApiModelProperty(value = "价税合计")
    private Double jshe;
    @ApiModelProperty(value = "计划发货日期")
    private OffsetDateTime jhSendDate;
    @ApiModelProperty(value = "出库主数量")
    private Double zckSl;
    @ApiModelProperty(value = "签收主数量")
    private Double qszSl;
    @ApiModelProperty(value = "途损主数量")
    private Double tszSl;
    @ApiModelProperty(value = "待出库主数量")
    private Double dckzSl;
    @ApiModelProperty(value = "开票主数量")
    private Double kpzSl;
    @ApiModelProperty(value = "暂估应收主数量")
    private Double zgyszSl;
    @ApiModelProperty(value = "暂估应收金额")
    private Double zgysJe;
    @ApiModelProperty(value = "应收主数量")
    private Double yszSl;
    @ApiModelProperty(value = "应收金额")
    @ExcelField(title = "订单金额", sort = 11, fieldType = Double.class)
    private Double ysJe;
    @ApiModelProperty(value = "收款金额")
    private Double skJe;
    @ApiModelProperty(value = "应收余额")
    private Double ysYe;
    @ApiModelProperty(value = "成本结算主数量")
    private Double cbjszSl;
    @ApiModelProperty(value = "导入时间")
    @ExcelField(title = "导入时间", sort = 12, fieldType = OffsetDateTime.class)
    private OffsetDateTime drDate;
    @ApiModelProperty(value = "订单批次编号")
    private String ordPcNum;
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}
