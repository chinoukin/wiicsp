package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zhfw_culture_zx_reco 表实体
 * 种植服务文化资讯推荐
 * 2020/08/24 20:28:13
 */
public class ZhfwCultureZxReco extends DataLongEntity<ZhfwCultureZxReco> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植服文化资讯列表id
     */
    private Long zhfwCultureZxListId;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public ZhfwCultureZxReco() {
        super();
    }

    /**
     * 获取种植服文化资讯列表id
     */
    public Long getZhfwCultureZxListId() {
        return zhfwCultureZxListId;
    }

    /**
     * 设置种植服文化资讯列表id
     */
    public void setZhfwCultureZxListId(Long zhfwCultureZxListId) {
        this.zhfwCultureZxListId = zhfwCultureZxListId;
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
