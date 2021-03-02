package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * pjcsmx_set 表实体
 * 评价参数模型设置
 * 2019/06/05 10:28:32
 */
public class PjcsmxSet extends DataLongEntity<PjcsmxSet> {
    private static final long serialVersionUID = 1L;

    /**
     * 评价参数id
     */
    @ApiModelProperty("评价参数id")
    private Long pjcsId;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 是否必填
     */
    private String ifRequ;

    /**
     * 搜索条件
     */
    private String ifSearch;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取评价参数id
     */
    public Long getPjcsId() {
        return pjcsId;
    }

    /**
     * 设置评价参数id
     */
    public void setPjcsId(Long pjcsId) {
        this.pjcsId = pjcsId;
    }

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
     * 获取是否必填
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否必填
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取搜索条件
     */
    public String getIfSearch() {
        return ifSearch;
    }

    /**
     * 设置搜索条件
     */
    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch == null ? null : ifSearch.trim();
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
