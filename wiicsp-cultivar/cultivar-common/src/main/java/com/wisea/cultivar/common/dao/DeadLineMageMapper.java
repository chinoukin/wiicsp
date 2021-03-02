package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.DeadLineMage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbDeadLineMageMapper")
public interface DeadLineMageMapper extends CrudDao<DeadLineMage> {
    /**
     * 查询所有期限设置
     * @return
     */
    List<DeadLineMage> findAll();

    /**
     * 删除所有期限设置
     * @return
     */
    void deleteAll();

    /**
     * 根据期限类型查询
     * @param deadLineType
     * @return
     */
    List<DeadLineMage> findByDeadLineType(String deadLineType);
}
