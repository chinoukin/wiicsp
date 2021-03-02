package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.IndustryLayerArea;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaListPo;
import com.wisea.cultivar.explorer.po.IndustryLayerAreaPagePo;
import com.wisea.cultivar.explorer.vo.IndustryLayerAreaListVo;
import java.util.List;

/**
 * industry_layer_area 表DAO
 * 图层区域信息
 * 2020/08/11 13:21:46
 */
public interface IndustryLayerAreaMapper extends CrudDao<IndustryLayerArea> {
    /**
     * 分页查询
     */
    List<IndustryLayerAreaListVo> findPage(IndustryLayerAreaPagePo industryLayerAreaPagePo);

    /**
     * 列表查询
     */
    List<IndustryLayerAreaListVo> findList(IndustryLayerAreaListPo industryLayerAreaListPo);
}
