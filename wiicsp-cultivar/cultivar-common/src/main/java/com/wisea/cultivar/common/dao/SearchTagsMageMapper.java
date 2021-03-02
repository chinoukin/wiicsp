package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.SearchTagsMage;
import com.wisea.cultivar.common.po.SearchTagsMageListPo;
import com.wisea.cultivar.common.po.SearchTagsMagePagePo;
import com.wisea.cultivar.common.vo.SearchTagsMageListVo;


import java.util.List;

/**
 * search_tags_mage 表DAO
 * 搜索标签设置
 * 2020/08/04 09:36:59
 */
public interface SearchTagsMageMapper extends CrudDao<SearchTagsMage> {
    /**
     * 分页查询
     */
    List<SearchTagsMageListVo> findPage(SearchTagsMagePagePo searchTagsMagePagePo);

    /**
     * 列表查询
     */
    List<SearchTagsMageListVo> findList(SearchTagsMageListPo searchTagsMageListPo);
}
