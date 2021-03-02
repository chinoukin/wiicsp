package com.wisea.transac.tp.product.search;

/**
 * ElasticSearch 对应的索引类型
 * @author: wangs
 * @date :2018/1/12
 */
public enum SearchType {

    /** 买家商品列表 */
    CommdityList ("commdityList"),

    /** 热销词 */
    HotKeyWords ("hotKeyWords");

    private String value;

    public String getValue(){
        return this.value;
    }

    private SearchType(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
