package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jszl_tj_mage 表实体
 * 资料推荐
 * 2019/08/29 17:45:19
 */
public class JszlTjMage extends DataLongEntity<JszlTjMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 技术资料列表id
     */
    private Long jszlListId;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取技术资料列表id
     */
    public Long getJszlListId() {
        return jszlListId;
    }

    /**
     * 设置技术资料列表id
     */
    public void setJszlListId(Long jszlListId) {
        this.jszlListId = jszlListId;
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
