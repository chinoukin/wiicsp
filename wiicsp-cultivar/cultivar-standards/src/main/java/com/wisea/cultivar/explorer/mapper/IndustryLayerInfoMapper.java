package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.IndustryLayerInfo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoListPo;
import com.wisea.cultivar.explorer.po.IndustryLayerInfoPagePo;
import com.wisea.cultivar.explorer.vo.IndustryLayerInfoListVo;
import java.util.List;

/**
 * industry_layer_info 表DAO
 * 产业图层信息
 * 2020/08/11 13:21:46
 */
public interface IndustryLayerInfoMapper extends CrudDao<IndustryLayerInfo> {
    /**
     * 分页查询
     */
    List<IndustryLayerInfoListVo> findPage(IndustryLayerInfoPagePo industryLayerInfoPagePo);

    /**
     * 列表查询
     */
    List<IndustryLayerInfoListVo> findList(IndustryLayerInfoListPo industryLayerInfoListPo);
}
