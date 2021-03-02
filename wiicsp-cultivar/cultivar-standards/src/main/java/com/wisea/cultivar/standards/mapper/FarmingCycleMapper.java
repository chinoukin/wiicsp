package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.FarmingCycle;
import com.wisea.cultivar.standards.po.FarmingCycleInsertPo;
import com.wisea.cultivar.standards.po.FarmingCycleListPo;
import com.wisea.cultivar.standards.po.FarmingCyclePagePo;
import com.wisea.cultivar.standards.vo.FarmingCycleListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * farming_cycle 表DAO
 * 农事周期
 * 2020/07/24 11:21:45
 */
@Component
public interface FarmingCycleMapper extends CrudDao<FarmingCycle> {
    /**
     * 分页查询
     */
    List<FarmingCycleListVo> findPage(FarmingCyclePagePo farmingCyclePagePo);

    /**
     * 列表查询
     */
    List<FarmingCycleListVo> findList(FarmingCycleListPo farmingCycleListPo);

    /**
     * 列表查询
     */
    List<FarmingCycleListVo> findByPlantingMethodIdList(FarmingCycleListPo farmingCycleListPo);

    /**
     * 删除详情
     */
    void deleteByFCId(FarmingCycleInsertPo farmingCycleInsertPo);

    List<FarmingCycle> getAllCycle(Long id);

    Integer deleteAllCycle(Long id);
}
