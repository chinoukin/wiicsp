package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * freight_formwork_mage 表实体
 * 运费模板管理
 * 2018/09/18 14:36:47
 */
public class FreightFormworkMage extends DataLongEntity<FreightFormworkMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 物流公司id
     */
    private Long logisticsCompId;

    /**
     * 模板名称
     */
    private String freightFormworkName;

    /**
     * 支持配送区域数量
     */
    private Integer suptDistribAreaCount;

    /**
     * 不支持配送区域数量
     */
    private Integer noDistribAreaCount;

    /**
     * 发货地
     **/
    private String deliveryPlace;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取物流公司id
     */
    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    /**
     * 设置物流公司id
     */
    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    /**
     * 获取模板名称
     */
    public String getFreightFormworkName() {
        return freightFormworkName;
    }

    /**
     * 设置模板名称
     */
    public void setFreightFormworkName(String freightFormworkName) {
        this.freightFormworkName = freightFormworkName == null ? null : freightFormworkName.trim();
    }

    /**
     * 获取支持配送区域数量
     */
    public Integer getSuptDistribAreaCount() {
        return suptDistribAreaCount;
    }

    /**
     * 设置支持配送区域数量
     */
    public void setSuptDistribAreaCount(Integer suptDistribAreaCount) {
        this.suptDistribAreaCount = suptDistribAreaCount;
    }

    /**
     * 获取不支持配送区域数量
     */
    public Integer getNoDistribAreaCount() {
        return noDistribAreaCount;
    }

    /**
     * 设置不支持配送区域数量
     */
    public void setNoDistribAreaCount(Integer noDistribAreaCount) {
        this.noDistribAreaCount = noDistribAreaCount;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
}
