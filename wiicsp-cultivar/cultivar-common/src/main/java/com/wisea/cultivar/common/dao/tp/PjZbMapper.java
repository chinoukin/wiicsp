package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PjZb;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

/**
 * pj_zb 表DAO
 * 评价指标
 * 2019/06/06 10:29:52
 */
@Repository
public interface PjZbMapper extends CrudDao<PjZb> {

    /**
     * 根据评价结果id删除评价指标
     * @param id
     */
    void delByPjzbResultId(Long id);

}
