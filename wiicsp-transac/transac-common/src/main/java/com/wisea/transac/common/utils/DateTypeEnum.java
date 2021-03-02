package com.wisea.transac.common.utils;

/**
 * @author jirg
 * @version 1.0
 * @className DateEnum
 * @date 2019/12/27 10:33
 * @Description
 */
public enum DateTypeEnum {
    importBill("进货单", "0"),
    orderInfo("订单", "1"),
    refundAppl("退款单", "2"),
    refundCommAppl("退货单", "3"),
    ordcCmmrela("订单商品", "4"),
    ordInvo("订单发票", "5"),
    settleBill("结算单", "6"),
    ;
    private String dateType; //数据类型
    private String value; //类型值

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    DateTypeEnum(String dateType, String value){
        this.dateType = dateType;
        this.value = value;
    }
}
