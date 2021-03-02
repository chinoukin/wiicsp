package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.PlantationSensor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlantationSensorMapper extends CrudDao<PlantationSensor> {
    /**
     * @author jirg
     * @date 2020/7/2 17:34
     * @Description 根据种植园ID查询物联网传感器
     */
    PlantationSensor findByPlantationId(@Param("plantationId") Long plantationId);

    /**
     * @author jirg
     * @date 2020/7/7 16:10
     * @Description 根据种植园ID，删除种植园物联网设备
     */
    void deleteByPlantationId(@Param("plantationId") Long plantationId);
}
