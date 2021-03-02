package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.FarmingCycle;
import com.wisea.cultivar.standards.entity.FarmingStage;
import com.wisea.cultivar.standards.po.FarmingStageListPo;
import com.wisea.cultivar.standards.po.FarmingStagePagePo;
import com.wisea.cultivar.standards.vo.FarmingStageListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * farming_stage 表DAO
 * 农事阶段
 * 2020/07/24 11:21:45
 */
@Component
public interface FarmingStageMapper extends CrudDao<FarmingStage> {
    /**
     * 分页查询
     */
    List<FarmingStageListVo> findPage(FarmingStagePagePo farmingStagePagePo);

    /**
     * 列表查询
     */
    List<FarmingStageListVo> findList(FarmingStageListPo farmingStageListPo);

    /**
     * 列表查询
     */
    List<FarmingStageListVo> findFarmingCycleIdList(FarmingStageListPo farmingStageListPo);

    List<FarmingStage> getAllStage(List<FarmingCycle> allCycle);

    Integer deleteAll(List<FarmingCycle> allCycle);
}
