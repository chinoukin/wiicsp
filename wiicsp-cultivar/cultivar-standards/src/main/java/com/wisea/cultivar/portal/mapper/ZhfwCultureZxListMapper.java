package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwCultureZxList;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureZxListPagePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureZxListListVo;
import java.util.List;

/**
 * zhfw_culture_zx_list 表DAO
 * 种植服文化资讯列表
 * 2020/08/24 20:28:13
 */
public interface ZhfwCultureZxListMapper extends CrudDao<ZhfwCultureZxList> {
    /**
     * 分页查询
     */
    List<ZhfwCultureZxListListVo> findPage(ZhfwCultureZxListPagePo zhfwCultureZxListPagePo);

    /**
     * 列表查询
     */
    List<ZhfwCultureZxListListVo> findList(ZhfwCultureZxListListPo zhfwCultureZxListListPo);
}
