package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.time.OffsetDateTime;

/**
 * jy_ord_mage 表实体
 * 交易订单管理
 * 2019/12/02 11:02:14
 */
public class JyOrdMage extends DataLongEntity<JyOrdMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司id
     */
    private Long entpId;

    /**
     * 总分公司标志
     */
    private String mainSubEntpFlag;

    /**
     * 供货商
     */
    @ExcelField(title = "供货商", sort = 0, type = 2)
    private String saleOrg;

    /**
     * 订单类型
     */
    @ExcelField(title = "订单类型", sort = 1, type = 2)
    private String ordType;

    /**
     * 订单编号
     */
    @ExcelField(title = "订单编号", sort = 2, type = 2)
    private String ordNum;

    /**
     * 单据日期
     */
    @ExcelField(title = "单据日期", sort = 3, type = 2, formate = "yyyy-MM-dd")
    private OffsetDateTime djDate;

    /**
     * 采购商
     */
    @ExcelField(title = "采购商", sort = 4, type = 2)
    private String cgsName;

    /**
     * 部门
     */
    @ExcelField(title = "部门", sort = 5, type = 2)
    private String bm;

    /**
     * 业务员
     */
    @ExcelField(title = "业务员", sort = 6, type = 2)
    private String ywy;

    /**
     * 币种
     */
    @ExcelField(title = "币种", sort = 7, type = 2)
    private String bz;

    /**
     * 物料编码
     */
    @ExcelField(title = "物料编码", sort = 8, type = 2)
    private String wlCode;

    /**
     * 物料名称
     */
    @ExcelField(title = "物料名称", sort = 9, type = 2)
    private String wlName;

    /**
     * 品类id
     */
    private Long categoryId;

    /**
     * 物料分类
     */
    private String categoryName;

    /**
     * 规格
     */
    @ExcelField(title = "规格", sort = 10, type = 2)
    private String form;

    /**
     * 型号
     */
    @ExcelField(title = "型号", sort = 11, type = 2)
    private String spec;

    /**
     * 主单位
     */
    @ExcelField(title = "主单位", sort = 12, type = 2)
    private String mainUnit;

    /**
     * 主数量
     */
    @ExcelField(title = "主数量", sort = 13, type = 2)
    private Double mainCt;

    /**
     * 赠品
     */
    @ExcelField(title = "赠品", sort = 14, type = 2)
    private String zp;

    /**
     * 主含税净价
     */
    @ExcelField(title = "主含税净价", sort = 15, type = 2)
    private Double zhsjj;

    /**
     * 无税金额
     */
    @ExcelField(title = "无税金额", sort = 16, type = 2)
    private Double wsje;

    /**
     * 价税合计
     */
    @ExcelField(title = "价税合计", sort = 17, type = 2)
    private Double jshe;

    /**
     * 计划发货日期
     */
    @ExcelField(title = "计划发货日期", sort = 18, type = 2, formate = "yyyy-MM-dd")
    private OffsetDateTime jhSendDate;

    /**
     * 出库主数量
     */
    @ExcelField(title = "出库主数量", sort = 19, type = 2)
    private Double zckSl;

    /**
     * 签收主数量
     */
    @ExcelField(title = "签收主数量", sort = 20, type = 2)
    private Double qszSl;

    /**
     * 途损主数量
     */
    @ExcelField(title = "途损主数量", sort = 21, type = 2)
    private Double tszSl;

    /**
     * 待出库主数量
     */
    @ExcelField(title = "待出库主数量", sort = 22, type = 2)
    private Double dckzSl;

    /**
     * 开票主数量
     */
    @ExcelField(title = "开票主数量", sort = 23, type = 2)
    private Double kpzSl;

    /**
     * 暂估应收主数量
     */
    @ExcelField(title = "暂估应收主数量", sort = 24, type = 2)
    private Double zgyszSl;

    /**
     * 暂估应收金额
     */
    @ExcelField(title = "暂估应收金额", sort = 25, type = 2)
    private Double zgysJe;

    /**
     * 应收主数量
     */
    @ExcelField(title = "应收主数量", sort = 26, type = 2)
    private Double yszSl;

    /**
     * 应收金额
     */
    @ExcelField(title = "应收金额", sort = 27, type = 2)
    private Double ysJe;

    /**
     * 收款金额
     */
    @ExcelField(title = "收款金额", sort = 28, type = 2)
    private Double skJe;

    /**
     * 应收余额
     */
    @ExcelField(title = "应收余额", sort = 29, type = 2)
    private Double ysYe;

    /**
     * 成本结算主数量
     */
    @ExcelField(title = "成本结算主数量", sort = 30, type = 2)
    private Double cbjszSl;

    /**
     * 导入时间
     */
    private OffsetDateTime drDate;

    /**
     * 订单批次编号
     */
    private String ordPcNum;

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
}
