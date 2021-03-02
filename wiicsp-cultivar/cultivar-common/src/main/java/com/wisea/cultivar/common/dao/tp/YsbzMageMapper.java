package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.YsbzMage;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

/**
 * @Author ws
 * ysbz_mage 表DAO
 * 验收标准管理
 * 2019/09/04 18:27:24
 */
@Repository
public interface YsbzMageMapper extends CrudDao<YsbzMage> {

    /**
     * 查询验收标准信息
     * @return
     */
    YsbzMage getYsbzMage();
}
