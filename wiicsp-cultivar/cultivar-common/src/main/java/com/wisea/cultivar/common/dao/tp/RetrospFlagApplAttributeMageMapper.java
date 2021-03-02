package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.RetrospFlagApplAttributeMage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetrospFlagApplAttributeMageMapper extends CrudDao<RetrospFlagApplAttributeMage> {
    //根据申请ID查询属性列表
    List<RetrospFlagApplAttributeMage> findByApplId(@Param("id") Long id);
}
