package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.MainBusinessMassif;
import com.wisea.cultivar.explorer.po.MainBusinessMassifListPo;
import com.wisea.cultivar.explorer.po.MainBusinessMassifPagePo;
import com.wisea.cultivar.explorer.vo.MainBusinessMassifListVo;
import java.util.List;

/**
 * main_business_massif 表DAO
 * 主体地块信息
 * 2020/08/24 20:19:05
 */
public interface MainBusinessMassifMapper extends CrudDao<MainBusinessMassif> {
    /**
     * 分页查询
     */
    List<MainBusinessMassifListVo> findPage(MainBusinessMassifPagePo mainBusinessMassifPagePo);

    /**
     * 列表查询
     */
    List<MainBusinessMassifListVo> findList(MainBusinessMassifListPo mainBusinessMassifListPo);

    void deleteEntpInfoId(Long id);
}
