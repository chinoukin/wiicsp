package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.YmsjwhCyFp;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * ymsjwh_cy_fp 表DAO
 * 页面数据产业及扶贫
 * 2019/08/29 17:45:19
 */
public interface YmsjwhCyFpMapper extends CrudDao<YmsjwhCyFp> {
    /**
     * 查询没有删除的
     * @return
     */
    YmsjwhCyFp findOneNotDel();

    /**
     * 查询所有的
     * @return
     */
    List<YmsjwhCyFp> findAll();
}
