package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.BaseCertPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseCertPictureMapper extends CrudDao<BaseCertPicture> {
    /**
     * @author jirg
     * @date 2020/7/1 10:30
     * @Description 根据证书ID删除图片
     */
    void delByBaseCertId(@Param("baseCertId") Long baseCertId);
}
