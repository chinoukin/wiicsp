package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * gp_pj_result 表实体
 * 果品评价结果
 * 2019/06/05 10:28:32
 */
public class GpPjResult extends DataLongEntity<GpPjResult> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 商品品种id
     */
    private Long commVarietId;

    /**
     * 商品产地省
     */
    private String commLocalProv;

    /**
     * 商品产地市
     */
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    private String commLocalCou;

    /**
     * 上市时间
     */
    private String ssDate;

    /**
     * 综合评价
     */
    private String compEval;

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品品种id
     */
    public Long getCommVarietId() {
        return commVarietId;
    }

    /**
     * 设置商品品种id
     */
    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    /**
     * 获取商品产地省
     */
    public String getCommLocalProv() {
        return commLocalProv;
    }

    /**
     * 设置商品产地省
     */
    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv == null ? null : commLocalProv.trim();
    }

    /**
     * 获取商品产地市
     */
    public String getCommLocalCity() {
        return commLocalCity;
    }

    /**
     * 设置商品产地市
     */
    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity == null ? null : commLocalCity.trim();
    }

    /**
     * 获取商品产地区县
     */
    public String getCommLocalCou() {
        return commLocalCou;
    }

    /**
     * 设置商品产地区县
     */
    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou == null ? null : commLocalCou.trim();
    }

    /**
     * 获取上市时间
     */
    public String getSsDate() {
        return ssDate;
    }

    /**
     * 设置上市时间
     */
    public void setSsDate(String ssDate) {
        this.ssDate = ssDate == null ? null : ssDate.trim();
    }

    /**
     * 获取综合评价
     */
    public String getCompEval() {
        return compEval;
    }

    /**
     * 设置综合评价
     */
    public void setCompEval(String compEval) {
        this.compEval = compEval == null ? null : compEval.trim();
    }
}
