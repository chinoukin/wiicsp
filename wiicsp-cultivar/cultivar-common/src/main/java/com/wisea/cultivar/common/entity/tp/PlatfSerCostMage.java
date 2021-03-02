package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * platf_ser_cost_mage 表实体
 * 包含：平台服务费，平台代理服务费
 * 2018/09/18 14:36:47
 */
public class PlatfSerCostMage extends DataLongEntity<PlatfSerCostMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 服务费类型
     */
    private String serCostType;

    /**
     * 服务费
     */
    private Double serCost;

    /**
     * 获取服务费类型
     */
    public String getSerCostType() {
        return serCostType;
    }

    /**
     * 设置服务费类型
     */
    public void setSerCostType(String serCostType) {
        this.serCostType = serCostType == null ? null : serCostType.trim();
    }

    /**
     * 获取服务费
     */
    public Double getSerCost() {
        return serCost;
    }

    /**
     * 设置服务费
     */
    public void setSerCost(Double serCost) {
        this.serCost = serCost;
    }
}
