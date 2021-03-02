package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.OilTeaBrandMage;
import com.wisea.cultivar.explorer.po.OilTeaBrandMageListPo;
import com.wisea.cultivar.explorer.po.OilTeaBrandMagePagePo;
import com.wisea.cultivar.explorer.vo.OilTeaBrandMageListVo;

import java.util.List;

/**
 * oil_tea_brand_mage 表DAO
 * 茶油品牌信息维护
 * 2020/07/24 11:21:45
 */
public interface OilTeaBrandMageMapper extends CrudDao<OilTeaBrandMage> {
    /**
     * 分页查询
     */
    List<OilTeaBrandMageListVo> findPage(OilTeaBrandMagePagePo oilTeaBrandMagePagePo);

    /**
     * 列表查询
     */
    List<OilTeaBrandMageListVo> findList(OilTeaBrandMageListPo oilTeaBrandMageListPo);
}
