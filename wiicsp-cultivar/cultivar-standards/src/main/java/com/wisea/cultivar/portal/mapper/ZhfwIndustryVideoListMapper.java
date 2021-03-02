package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwIndustryVideoList;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListListPo;
import com.wisea.cultivar.portal.po.ZhfwIndustryVideoListPagePo;
import com.wisea.cultivar.portal.vo.ZhfwIndustryVideoListListVo;
import java.util.List;

/**
 * zhfw_industry_video_list 表DAO
 * 种植服务产业视频列表
 * 2020/08/24 20:28:13
 */
public interface ZhfwIndustryVideoListMapper extends CrudDao<ZhfwIndustryVideoList> {
    /**
     * 分页查询
     */
    List<ZhfwIndustryVideoListListVo> findPage(ZhfwIndustryVideoListPagePo zhfwIndustryVideoListPagePo);

    /**
     * 列表查询
     */
    List<ZhfwIndustryVideoListListVo> findList(ZhfwIndustryVideoListListPo zhfwIndustryVideoListListPo);
}
