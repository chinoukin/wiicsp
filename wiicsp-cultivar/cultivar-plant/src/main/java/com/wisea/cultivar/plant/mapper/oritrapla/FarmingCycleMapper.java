package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmingCycle;
import com.wisea.cultivar.plant.po.oritrapla.FarmingCycleListPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmingCyclePagePo;
import com.wisea.cultivar.plant.vo.oritrapla.FarmingCyclInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.FarmingCycleListVo;

import java.util.List;

/**
 * farming_cycle 表DAO
 * 农事周期
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface FarmingCycleMapper extends CrudDao<FarmingCycle> {
    List<FarmingCycleListVo> findPage(FarmingCyclePagePo farmingCyclePagePo);

    List<FarmingCycleListVo> findList(FarmingCycleListPo farmingCycleListPo);

    @Override
    int batchInsert(List<FarmingCycle> farmingCycle);

    List<FarmingCycle> getAllCycle(Long id);

    Integer deleteAllCycle(Long id);

    /**
     * 农事周期详细信息
     * @param id
     * @return
     */
    List<FarmingCyclInfoVo> selCycAndStageByMethod(Long id);
}
