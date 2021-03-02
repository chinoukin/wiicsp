package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.PadMage;
import com.wisea.cultivar.plant.po.oritrapla.HealthCheckPo;
import com.wisea.cultivar.plant.po.oritrapla.PadMageListPo;
import com.wisea.cultivar.plant.po.oritrapla.PadMagePagePo;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageGetVo;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageListVo;

import java.util.List;

/**
 * pad_mage 表DAO
 * 病虫害管理
 * 2019/08/21 09:13:45
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface PadMageMapper extends CrudDao<PadMage> {

    PadMageGetVo findById(Long id);

    /**
     * 健康检查，数据对比
     * @return
     */
    List<PadMageListVo> healthCheck(HealthCheckPo po);

    List<PadMageListVo> findPage(PadMagePagePo padMagePagePo);

    List<PadMageListVo> findList(PadMageListPo padMageListPo);

    void updateViewsByKey(Long id);
}
