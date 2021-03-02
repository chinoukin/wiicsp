package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:38
 * @Description 已选牦牛信息
 **/
public class OriSelYakInfo extends DataLongEntity<OriSelYakInfo> {
    /**
     * 销售出栏id
     */
    private Long saleClId;

    /**
     * 牦牛id
     */
    private Long oriYakId;

    /**
     * 耳标号
     */
    private String earLabel;

    public Long getSaleClId() {
        return saleClId;
    }

    public void setSaleClId(Long saleClId) {
        this.saleClId = saleClId;
    }

    public Long getOriYakId() {
        return oriYakId;
    }

    public void setOriYakId(Long oriYakId) {
        this.oriYakId = oriYakId;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }
}
