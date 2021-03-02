package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.TradAreaMage;
import com.wisea.transac.common.po.system.StallsMageCount;
import com.wisea.transac.common.po.system.TradAreaMageListPo;
import com.wisea.transac.common.po.system.TradAreaMagePagePo;
import com.wisea.transac.common.vo.system.TradAreaMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * trad_area_mage 表DAO
 * 交易区管理
 * 2020/05/07 10:34:56
 */
@Mapper
@Repository
public interface TradAreaMageMapper extends CrudDao<TradAreaMage> {
    /**
     * 分页查询
     */
    List<TradAreaMageListVo> findPage(TradAreaMagePagePo tradAreaMagePagePo);

    /**
     * 列表查询
     */
    List<TradAreaMageListVo> findList(TradAreaMageListPo tradAreaMageListPo);

    /**
     * 按市场Id逻辑删除交易区
     * @param marketId
     */
    void deleteByMarketId(Long marketId);

    Integer countStallsByTradAreaId(Long tradAreaId);

    /**
     * 查询商品数量,根据档口id
     * @param stallsMageCount
     * @return
     */
    Long stallsMageIdCount(StallsMageCount stallsMageCount);
}
