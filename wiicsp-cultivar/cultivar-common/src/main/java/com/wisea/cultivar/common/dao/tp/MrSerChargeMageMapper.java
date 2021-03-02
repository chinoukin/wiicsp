package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.MrSerChargeMage;
import com.wisea.cultivar.common.po.tp.product.MrSerChargeMageGetPo;
import com.wisea.cultivar.common.po.tp.product.MrSerChargeMagePagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.MrSerChargeMageGetVo;
import com.wisea.cultivar.common.vo.tp.product.MrSerChargeMageListVo;

import java.util.List;

/**
 * mr_ser_charge_mage 表DAO
 * 默认服务费管理
 * 2019/05/15 15:14:16
 */
public interface MrSerChargeMageMapper extends CrudDao<MrSerChargeMage> {

    /**
     * 查询默认手续费的详情
     * @param mrSerChargeMageGetPo
     * @return
     */
    MrSerChargeMageGetVo findById(MrSerChargeMageGetPo mrSerChargeMageGetPo);

    /**
     * 重复性校验默认手续费
     * @param entity
     * @return
     */
    MrSerChargeMage checkSaveOrUpdateMrSerChargeMage(MrSerChargeMage entity);

    /**
     * 查询默认服务费列表
     * @param mrSerChargeMagePagePo
     * @return
     */
    List<MrSerChargeMageListVo> findSerChargeList(MrSerChargeMagePagePo mrSerChargeMagePagePo);
}
