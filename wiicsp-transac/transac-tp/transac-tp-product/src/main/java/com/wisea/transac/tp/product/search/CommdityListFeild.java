package com.wisea.transac.tp.product.search;

/**
 * @Description: 商品Feild
 * @author: wangs
 * @date :2018/1/5
 */
public enum CommdityListFeild {

    /**
     * 商品id
     */
    Id("id"),

    /**
     * 会员id
     */
    MembId("membId"),
    /**
     * 商品ID
     */
    CommSaleSetId("commSaleSetId"),

    /**
     * 二级品类ID
     */
    CommSaleId("commSaleId"),

    /**
     * 商品销售设置名称
     */
    CommSaleCatgSetName("commSaleCatgSetName"),
    /**
     * 市场ID
     */
    WholeSaleMarketId("wholeSaleMarketId"),
    /**
     * 店铺ID
     */
    ShopId("shopId"),
    /**
     * 档口ID
     */
    StallsMageId("stallsMageId"),

    /**
     * 档口名称
     */
    StallsMageName("stallsMageName"),
    /**
     * 价格
     */
    WholePriceSection("wholePriceSection"),

    StartOrdCount("startOrdCount"),
    /**
     * 批发价格min
     */
    WholePriceSectionMin("wholePriceSectionMin"),

    /**
     * 最小价格
     */
    MinPrice("minPrice"),
    /**
     * 品种名称
     */
    CommVatrieName("commVatrieName"),
    /**
     * 商品名称
     */
    CommTitle("commTitle"),
    /**
     * 商品编号
     */
    CommNum("commNum"),
    /**
     * 地里位置
     */
    Location1("location1"),
    /**
     * 创建时间
     */
    CreateDate("createDate"),

    /**
     * 支持服务
     */
    SupportTypeId("supportTypeId"),

    /**
     * 基地
     */
    BaseId("baseId"),

    /**
     * 仓库
     */
    StorageId("storageId"),

    /**
     * 种植园
     */
    PlantationId("plantationId"),

    /**
     * 货品类型
     */
    GoodsType("goodsType"),

    /**
     * 标准件类型
     */
    YjdfFlag("yjdfFlag"),

    /**
     * 销量
     */
    SalesVolume("salesVolume"),

    /**
     * 最后成交时间
     */
    EndTradTime("endTradTime");

    private String value;

    public String getValue() {
        return this.value;
    }

    private CommdityListFeild(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
