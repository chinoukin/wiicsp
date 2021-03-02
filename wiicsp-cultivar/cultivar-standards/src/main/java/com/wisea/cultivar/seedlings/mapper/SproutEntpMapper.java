package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.SproutEntp;
import com.wisea.cultivar.seedlings.po.SproutEntpListPo;
import com.wisea.cultivar.seedlings.po.SproutEntpPagePo;
import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;
import com.wisea.cultivar.seedlings.vo.SproutEntpListVo;

import java.util.List;

/**
 * sprout_entp 表DAO
 * 定点种苗企业
 * 2020/08/06 14:19:24
 */
public interface SproutEntpMapper extends CrudDao<SproutEntp> {
    /**
     * 分页查询
     */
    List<SproutEntpListVo> findPage(SproutEntpPagePo sproutEntpPagePo);

    /**
     * 列表查询
     */
    List<SproutEntpListVo> findList(SproutEntpListPo sproutEntpListPo);

    /**
     * 定点采购企业种苗占比
     * @param id
     * @return
     */
    List<SeedlingsProVo> selectProvSeedlingById(Long id);
}
