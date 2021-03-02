package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SortingFactoryPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SortingFactoryPictureMapper extends CrudDao<SortingFactoryPicture> {
    /**
     * @author jirg
     * @date 2020/7/2 10:30
     * @Description 根据分选工厂ID删除分选工厂图片
     */
    void delBySortingFactoryId(@Param("sortingFactoryId") Long sortingFactoryId);
}
