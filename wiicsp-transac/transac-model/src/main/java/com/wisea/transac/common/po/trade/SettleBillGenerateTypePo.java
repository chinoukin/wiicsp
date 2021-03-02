package com.wisea.transac.common.po.trade;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillGenerateTypePo
 * @date 2020/5/14 10:12
 * @Description 修改订单结算单生成状态PO
 */
public class SettleBillGenerateTypePo {
    /**
     * 订单ID列表
     */
    private List<Long> ordIds;
    /**
     * 订单结算单生成状态 0 已生成 、1未生成
     */
    private String settleBillGenerateType;

    public List<Long> getOrdIds() {
        return ordIds;
    }

    public void setOrdIds(List<Long> ordIds) {
        this.ordIds = ordIds;
    }

    public String getSettleBillGenerateType() {
        return settleBillGenerateType;
    }

    public void setSettleBillGenerateType(String settleBillGenerateType) {
        this.settleBillGenerateType = settleBillGenerateType;
    }
}
