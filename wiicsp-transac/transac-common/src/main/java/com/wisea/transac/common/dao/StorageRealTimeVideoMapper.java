package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.StorageRealTimeVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StorageRealTimeVideoMapper extends CrudDao<StorageRealTimeVideo> {
    /**
     * @author jirg
     * @date 2020/7/2 14:35
     * @Description 根据仓储ID删除仓储实时视频
     */
    void delByStorageId(@Param("storageId") Long storageId);

    List<StorageRealTimeVideo> findByStorageId(@Param("storageId") Long storageId);
}
