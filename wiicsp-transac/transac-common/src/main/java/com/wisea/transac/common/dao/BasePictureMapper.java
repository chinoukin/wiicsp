package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.BasePicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BasePictureMapper extends CrudDao<BasePicture> {
    /**
     * @author jirg
     * @date 2020/6/30 17:10
     * @Description 根据基地ID删除基地图片
     */
    void delteByBaseId(@Param("baseId") Long baseId);
}
