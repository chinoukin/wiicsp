package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LateFeeMage;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface LateFeeMageMapper extends CrudDao<LateFeeMage> {
    LateFeeMage getLateFeeMage();
}
