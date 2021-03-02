package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.YhSerChargeMage;
import com.wisea.cultivar.common.po.tp.product.YhSerChargeMageGetPo;
import com.wisea.cultivar.common.po.tp.product.YhSerChargeMagePagePo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.product.YhSerChargeMageGetVo;
import com.wisea.cultivar.common.vo.tp.product.YhSerChargeMageListVo;

import java.util.List;

/**
 * yh_ser_charge_mage 表DAO
 * 优惠服务费管理
 * 2019/05/15 15:14:16
 */
public interface YhSerChargeMageMapper extends CrudDao<YhSerChargeMage> {

    /**
     * 优惠服务费重复性
     * @param yhSerChargeMage
     * @return
     */
    YhSerChargeMage checkSaveOrUpdateYhSerChargeMage(YhSerChargeMage yhSerChargeMage);

    /**
     * 优惠服务费详情
     * @param yhSerChargeMageGetPo
     * @return
     */
    YhSerChargeMageGetVo findById(YhSerChargeMageGetPo yhSerChargeMageGetPo);

    /**
     * 优惠服务费列表
     * @param yhSerChargeMagePagePo
     * @return
     */
    List<YhSerChargeMageListVo> findYhSerChargeList(YhSerChargeMagePagePo yhSerChargeMagePagePo);
}
