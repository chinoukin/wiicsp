package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.DemonsBaseMassif;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifPagePo;
import com.wisea.cultivar.explorer.vo.DemonsBaseMassifListVo;
import java.util.List;

/**
 * demons_base_massif 表DAO
 * 示范基地地块信息
 * 2020/08/11 13:21:46
 */
public interface DemonsBaseMassifMapper extends CrudDao<DemonsBaseMassif> {
    /**
     * 分页查询
     */
    List<DemonsBaseMassifListVo> findPage(DemonsBaseMassifPagePo demonsBaseMassifPagePo);

    /**
     * 列表查询
     */
    List<DemonsBaseMassifListVo> findList(DemonsBaseMassifListPo demonsBaseMassifListPo);
}
