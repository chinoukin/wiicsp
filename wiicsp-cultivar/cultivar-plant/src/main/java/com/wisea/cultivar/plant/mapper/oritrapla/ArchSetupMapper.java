package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.ArchSetup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArchSetupMapper extends CrudDao<ArchSetup> {
    /**
     * 根据我的档案ID查询我的档案设置
     * @param mineArchId
     * @return
     */
    ArchSetup findByMineArchId(Long mineArchId);
}
