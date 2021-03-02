package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.EntpInfoMage;
import com.wisea.cultivar.explorer.po.EntpInfoMageListPo;
import com.wisea.cultivar.explorer.po.EntpInfoMagePagePo;
import com.wisea.cultivar.explorer.vo.EntpInfoMageListVo;
import com.wisea.cultivar.explorer.vo.PlantAreaAnalysisVo;

import java.util.List;

/**
 * entp_info_mage 表DAO
 * 企业信息维护
 * 2020/07/24 11:21:45
 */
public interface EntpInfoMageMapper extends CrudDao<EntpInfoMage> {
    /**
     * 分页查询
     */
    List<EntpInfoMageListVo> findPage(EntpInfoMagePagePo entpInfoMagePagePo);

    /**
     * 列表查询
     */
    List<EntpInfoMageListVo> findList(EntpInfoMageListPo entpInfoMageListPo);

    /**
     * @author jirg
     * @date 2020/9/3 17:20
     * @Description 油茶种植面积分析
     */
    PlantAreaAnalysisVo plantAreaAnalysis();
}
