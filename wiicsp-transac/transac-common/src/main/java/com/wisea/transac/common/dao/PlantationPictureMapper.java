package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.PlantationPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlantationPictureMapper extends CrudDao<PlantationPicture> {
    void delByPlantationId(@Param("plantationId") Long plantationId);
}
