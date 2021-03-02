package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zx_tj_mage 表实体
 * 资讯推荐
 * 2019/08/29 17:45:19
 */
public class ZxTjMage extends DataLongEntity<ZxTjMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 资讯列表id
     */
    private Long zxListId;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取资讯列表id
     */
    public Long getZxListId() {
        return zxListId;
    }

    /**
     * 设置资讯列表id
     */
    public void setZxListId(Long zxListId) {
        this.zxListId = zxListId;
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
