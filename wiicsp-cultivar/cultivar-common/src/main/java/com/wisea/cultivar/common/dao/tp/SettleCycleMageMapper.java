package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.SettleCycleMage;
import com.wisea.cultivar.common.po.tp.SettleCycleMageListPo;
import com.wisea.cultivar.common.po.tp.SettleCycleMagePagePo;
import com.wisea.cultivar.common.vo.tp.SettleCycleMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * settle_cycle_mage 表DAO
 * 结算周期管理
 * 2018/10/13 09:47:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface SettleCycleMageMapper extends CrudDao<SettleCycleMage> {
    List<SettleCycleMageListVo> findPage(SettleCycleMagePagePo settleCycleMagePagePo);

    List<SettleCycleMageListVo> findList(SettleCycleMageListPo settleCycleMageListPo);

    /**
     * 查询当前周期，正常情况查出一个
     * @return
     */
    SettleCycleMageListVo findCurrentCycle();
}
