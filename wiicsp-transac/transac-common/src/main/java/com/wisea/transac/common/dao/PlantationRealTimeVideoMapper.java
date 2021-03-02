package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.PlantationRealTimeVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlantationRealTimeVideoMapper extends CrudDao<PlantationRealTimeVideo> {
    /**
     * @author jirg
     * @date 2020/7/2 17:40
     * @Description 根据种植园ID删除种植园实时视频
     */
    void delByPlantationId(@Param("plantationId") Long plantationId);
}
