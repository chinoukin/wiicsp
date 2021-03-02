package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.StoragePicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StoragePictureMapper extends CrudDao<StoragePicture> {
    /**
     * @author jirg
     * @date 2020/7/2 14:32
     * @Description 根据仓储ID删除仓储图片
     */
    void delByStorageId(@Param("storageId") Long storageId);
}
