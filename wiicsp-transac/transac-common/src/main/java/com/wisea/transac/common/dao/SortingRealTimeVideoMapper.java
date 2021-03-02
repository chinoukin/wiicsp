package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SortingRealTimeVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SortingRealTimeVideoMapper extends CrudDao<SortingRealTimeVideo> {
    /**
     * @author jirg
     * @date 2020/7/2 10:33
     * @Description 根据分选工厂ID删除分选工厂实时视频
     */
    void delBySortingFactoryId(@Param("sortingFactoryId") Long sortingFactoryId);
}
