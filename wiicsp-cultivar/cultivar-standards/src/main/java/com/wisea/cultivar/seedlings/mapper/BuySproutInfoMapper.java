package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.BuySproutInfo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoListPo;
import com.wisea.cultivar.seedlings.po.BuySproutInfoPagePo;
import com.wisea.cultivar.seedlings.vo.BuySproutInfoListVo;
import com.wisea.cultivar.seedlings.vo.SeedlingsProVo;

import java.util.List;

/**
 * buy_sprout_info 表DAO
 * 购苗信息
 * 2020/08/06 14:19:24
 */
public interface BuySproutInfoMapper extends CrudDao<BuySproutInfo> {
    /**
     * 分页查询
     */
    List<BuySproutInfoListVo> findPage(BuySproutInfoPagePo buySproutInfoPagePo);

    /**
     * 列表查询
     */
    List<BuySproutInfoListVo> findList(BuySproutInfoListPo buySproutInfoListPo);

    List<SeedlingsProVo> selectPorSeedlingById(Long id);
}
