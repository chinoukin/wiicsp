package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * js_ser_cost_mage 表实体
 * 技术服务费管理
 * 2019/05/15 15:14:16
 */
public class JsSerCostMage extends DataLongEntity<JsSerCostMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 服务费比例
     */
    private Double serCost;

    /**
     * 获取服务费比例
     */
    public Double getSerCost() {
        return serCost;
    }

    /**
     * 设置服务费比例
     */
    public void setSerCost(Double serCost) {
        this.serCost = serCost;
    }
}
