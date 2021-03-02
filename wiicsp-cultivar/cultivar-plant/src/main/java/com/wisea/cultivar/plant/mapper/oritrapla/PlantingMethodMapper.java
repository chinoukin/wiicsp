package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.PlantingMethod;
import com.wisea.cultivar.plant.po.oritrapla.PlantingMethodListPo;
import com.wisea.cultivar.plant.po.oritrapla.PlantingMethodPagePo;
import com.wisea.cultivar.plant.vo.oritrapla.PlantingMethodListVo;

import java.util.List;

/**
 * planting_method 表DAO
 * 种植方法
 * 2019/05/27 13:59:47
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface PlantingMethodMapper extends CrudDao<PlantingMethod> {
    List<PlantingMethodListVo> findPage(PlantingMethodPagePo plantingMethodPagePo);

    List<PlantingMethodListVo> findList(PlantingMethodListPo plantingMethodListPo);

    List<PlantingMethodListVo> plantMethodList(PlantingMethodPagePo po);
}
