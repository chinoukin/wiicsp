package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.StorageSensor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageSensorMapper extends CrudDao<StorageSensor> {
    /**
     * @author jirg
     * @date 2020/7/2 14:43
     * @Description 根据仓储ID查询仓储物联网传感器
     */
    StorageSensor findByStorageId(@Param("storageId") Long storageId);

    /**
     * @author jirg
     * @date 2020/7/7 14:42
     * @Description 根据仓储ID，删除仓储物联网设备
     */
    void deleteByStorageId(@Param("storageId") Long storageId);
}
