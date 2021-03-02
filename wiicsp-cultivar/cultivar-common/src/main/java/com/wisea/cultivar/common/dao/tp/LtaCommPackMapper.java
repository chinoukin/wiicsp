package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LtaCommPack;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

public interface LtaCommPackMapper extends CrudDao<LtaCommPack> {

    /**
     * 根据长协发布商品id删除包装规格信息
     * @param id
     */
    void delByLtaCommRelaId(Long id);

    void updateLtaCommPackDelFlag(long id);
}
