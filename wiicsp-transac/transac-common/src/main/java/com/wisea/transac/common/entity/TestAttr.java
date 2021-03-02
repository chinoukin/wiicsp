package com.wisea.transac.common.entity;

public class TestAttr {
    private String orderId;
    private TestAttr2 attr = new TestAttr2("2");

    public TestAttr(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public TestAttr2 getAttr() {
        return attr;
    }

    public void setAttr(TestAttr2 attr) {
        this.attr = attr;
    }

}
