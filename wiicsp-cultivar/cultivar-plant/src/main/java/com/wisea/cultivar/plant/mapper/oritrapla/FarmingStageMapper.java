package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.FarmingCycle;
import com.wisea.cultivar.plant.entity.oritrapla.FarmingStage;
import com.wisea.cultivar.plant.po.oritrapla.FarmingStageListPo;
import com.wisea.cultivar.plant.po.oritrapla.FarmingStagePagePo;
import com.wisea.cultivar.plant.vo.oritrapla.FarmingStageListVo;

import java.util.List;

/**
 * farming_stage 表DAO
 * 农事阶段
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface FarmingStageMapper extends CrudDao<FarmingStage> {
    List<FarmingStageListVo> findPage(FarmingStagePagePo farmingStagePagePo);

    List<FarmingStageListVo> findList(FarmingStageListPo farmingStageListPo);

    @Override
    int batchInsert(List<FarmingStage> var1);

    Integer deleteAll(List<FarmingCycle> allCycle);

    List<FarmingStage> getStageByCycleId(Long id);

    List<FarmingStage> getAllStage(List<FarmingCycle> allCycle);
}
