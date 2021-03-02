package com.wisea.cultivar.standards.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.standards.entity.PlantingMethod;
import com.wisea.cultivar.standards.po.PlantingMethodListPo;
import com.wisea.cultivar.standards.po.PlantingMethodPagePo;
import com.wisea.cultivar.standards.vo.PlantingMethodListVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * planting_method 表DAO
 * 种植方法
 * 2020/07/24 11:21:45
 */

@Component
public interface PlantingMethodMapper extends CrudDao<PlantingMethod> {
    /**
     * 分页查询
     */
    List<PlantingMethodListVo> findPage(PlantingMethodPagePo plantingMethodPagePo);

    /**
     * 列表查询
     */
    List<PlantingMethodListVo> findList(PlantingMethodListPo plantingMethodListPo);

    Integer deleteAllPlatMethod(Long id);

    /**
     * 查询是否有关联标准的种植方法
     */
    List<PlantingMethodListVo> findPlantStandardMageId(PlantingMethodListPo plantingMethodListPo);
}
