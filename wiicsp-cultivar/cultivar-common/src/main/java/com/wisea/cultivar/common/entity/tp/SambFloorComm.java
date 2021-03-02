package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * samb_floor_comm 表实体
 * 中小零批页楼层商品关系
 * 2019/05/28 16:20:20
 */
public class SambFloorComm extends DataLongEntity<SambFloorComm> {
    private static final long serialVersionUID = 1L;

       /**
     * 中小零批页楼层id
     */
    private Long sambFloorId;

    /**
     * 商品分类
     */
    private Long commId;

    /**
     * 商品品种
     */
    private Long commVarietId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取中小零批页楼层id
     */
    public Long getSambFloorId() {
        return sambFloorId;
    }

    /**
     * 设置中小零批页楼层id
     */
    public void setSambFloorId(Long sambFloorId) {
        this.sambFloorId = sambFloorId;
    }

    /**
     * 获取商品分类
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品分类
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品品种
     */
    public Long getCommVarietId() {
        return commVarietId;
    }

    /**
     * 设置商品品种
     */
    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
