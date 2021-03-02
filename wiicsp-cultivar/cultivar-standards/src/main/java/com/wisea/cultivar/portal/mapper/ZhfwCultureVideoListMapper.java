package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwCultureVideoList;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwCultureVideoListPagePo;
import com.wisea.cultivar.portal.vo.ZhfwCultureVideoListListVo;
import java.util.List;

/**
 * zhfw_culture_video_list 表DAO
 * 种植服文化视频列表
 * 2020/08/24 20:28:13
 */
public interface ZhfwCultureVideoListMapper extends CrudDao<ZhfwCultureVideoList> {
    /**
     * 分页查询
     */
    List<ZhfwCultureVideoListListVo> findPage(ZhfwCultureVideoListPagePo zhfwCultureVideoListPagePo);

    /**
     * 列表查询
     */
    List<ZhfwCultureVideoListListVo> findList(ZhfwCultureVideoListListPo zhfwCultureVideoListListPo);
}
