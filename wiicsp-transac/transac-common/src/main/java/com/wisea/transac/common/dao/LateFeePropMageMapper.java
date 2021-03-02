package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.LateFeePropMage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LateFeePropMageMapper extends CrudDao<LateFeePropMage> {
    LateFeePropMage getLateFeeMage();
}
