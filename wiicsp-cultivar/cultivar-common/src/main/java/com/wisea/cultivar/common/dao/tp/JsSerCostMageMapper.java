package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.JsSerCostMage;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * js_ser_cost_mage 表DAO
 * 技术服务费管理
 * 2019/05/15 15:14:16
 */
public interface JsSerCostMageMapper extends CrudDao<JsSerCostMage> {

    /**
     * 查询技术服务费
     * @return
     */
    JsSerCostMage findJsSerCostMage();
}
