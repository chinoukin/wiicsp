package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * ord_comm_rela 表实体
 * 商品发布价格=结算价+运费+平台服务费
 * 2018/09/18 17:40:35
 */
public class OrdCommRela extends DataLongEntity<OrdCommRela> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 进货单id
     */
    private Long importBillId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单价
     */
    private Double price;

    /**
     * 商品货号
     */
    private String commArtNum;

    /**
     * 商品图片
     */
    private String commUrl;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 平台服务费
     */
    private Double platfCost;

    /**
     * 商品规格
     */
    private Double commSpec;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 优惠金额
     */
    private Double prefAmount;

    /**
     * 验收标准表达式
     */
    private String ysbzBds;

    /**
     * 商品等级
     */
    private String commLevelType;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getImportBillId() {
        return importBillId;
    }

    public void setImportBillId(Long importBillId) {
        this.importBillId = importBillId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getPrefAmount() {
        return prefAmount;
    }

    public void setPrefAmount(Double prefAmount) {
        this.prefAmount = prefAmount;
    }

    public String getYsbzBds() {
        return ysbzBds;
    }

    public void setYsbzBds(String ysbzBds) {
        this.ysbzBds = ysbzBds;
    }

    public String getCommLevelType() {
        return commLevelType;
    }

    public void setCommLevelType(String commLevelType) {
        this.commLevelType = commLevelType;
    }
}
